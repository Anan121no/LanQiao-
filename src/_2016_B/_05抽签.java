package _2016_B;
/*
 * X����Ҫ�ɳ�һ��5����ɵĹ۲���ǰ��W�ǡ�
���У�
A���������ɳ�4�ˡ�
B���������ɳ�2�ˡ�
C���������ɳ�2�ˡ�
....

��ô��������W�ǵĹ۲��Ż��ж����ֹ���Ĳ�ͬ����أ�

����ĳ�������������⡣
����a[] �м���ÿ�����ҿ����ɳ����������
����ִ�н��Ϊ��
DEFFF
CEFFF
CDFFF
CDEFF
CCFFF
CCEFF
CCDFF
CCDEF
BEFFF
BDFFF
BDEFF
BCFFF
BCEFF
BCDFF
BCDEF
....
(����ʡ�ԣ��ܹ�101��)
��ϸ�Ķ����룬��д���߲���ȱ�ٵ����ݡ�
public class A
{
    public static void f(int[] a, int k, int n, String s)
    {
        if(k==a.length){ 
            if(n==0) System.out.println(s);
            return;
        }
        
        String s2 = s;
        for(int i=0; i<=a[k]; i++){
            _____________________________;   //���λ��
            s2 += (char)(k+'A');
        }
    }
    
    public static void main(String[] args)
    {
        int[] a = {4,2,2,1,1,3};
        
        f(a,0,5,"");
    }
}
ע�⣺��Ҫ��д�κ��������ݻ�˵�������֡�
��:f(a, k+1, n-i, s2),�ݹ飬�Եݹ���Ϥ�ľ�֪��Ҫ��f(x,x,x,x),�ٿ����ݹ���ڣ�����Զ���д����
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _05��ǩ {
	public static void f(int[] a, int k, int n, String s)
    {
        if(k==a.length){ 
            if(n==0) System.out.println(s);
            return;
        }
        
        String s2 = s;
        for(int i=0; i<=a[k]; i++){
            f(a, k+1, n-i, s2);;   //���λ��
            s2 += (char)(k+'A');
        }
    }
    
    public static void main(String[] args)
    {
        int[] a = {4,2,2,1,1,3};
        
        f(a,0,5,"");
    }
}
