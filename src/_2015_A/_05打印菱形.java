package _2015_A;
/*
 * �������εı߳����ڿ���̨�ϴ�ӡ��һ����������
Ϊ�˱��ڱȶԿո����ǰѿո��þ����档
���߳�Ϊ8ʱ������Ϊ��
.......*
......*.*
.....*...*
....*.....*
...*.......*
..*.........*
.*...........*
*.............*
.*...........*
..*.........*
...*.......*
....*.....*
.....*...*
......*.*
.......*

����ĳ���ʵ����������ܣ����뷨�е���֡�
����ϸ�������룬����д���߲���ȱʧ�Ĵ��롣

public class A
{
    public static void f(int n)
    {
        String s = "*";
        for(int i=0; i<2*n-3; i++) s += ".";
        s += "*";
    
        String s1 = s + "\n";
        String s2 = "";
        
        for(int i=0; i<n-1; i++){
            //System.out.println("=>"+s);
            s = "." + _____________________________________ + "*";  //���
            s1 = s + "\n" + s1;
            s2 += s + "\n";
        }
        System.out.println(s1+s2);        
    }
    
    public static void main(String[] args)
    {
        f(8);
    }
}
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88044052
 */
public class _05��ӡ���� {
	    public static void f(int n)
	    {
	        String s = "*";
	        for(int i=0; i<2*n-3; i++) s += ".";
	        s += "*";
	    
	        String s1 = s + "\n";
	        String s2 = "";
	        
	        for(int i=0; i<n-1; i++){
	            //System.out.println("=>"+s);
	            s = "." + s.substring(0,s.length()-3) + "*";  //���
	            s1 = s + "\n" + s1;
	            s2 += s + "\n";
	        }
	        System.out.println(s1+s2);        
	    }
	    
	    public static void main(String[] args)
	    {
	        f(8);
	}
}
