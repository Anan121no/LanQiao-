package _2016_B;
/*
 *   B      DEF
A + --- + ------- = 10
     C      GHI    
�������ʾ�����⣬���Բμ���ͼ1.jpg����   
�����ʽ��A~I����1~9�����֣���ͬ����ĸ����ͬ�����֡�
���磺
6+8/3+952/714 ����һ�ֽⷨ��
5+3/1+972/486 ����һ�ֽⷨ��
�����ʽһ���ж����ֽⷨ��
ע�⣺���ύӦ���Ǹ���������Ҫ��д�κζ�������ݻ�˵�������֡�
A + B/C + D/E = 10 --> A*C*E + B*E + D*C = 10*C*E���������ܻ��и�����������ת��
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/87976244
 */
public class _03����ʽ {
	public static void main(String[] args) {
	dfs(0);
	System.out.println(ans);
}

static int[] a = new int[] {1,2,3,4,5,6,7,8,9};
static int ans=0;
static void dfs(int m) {
	if(m>=9) {
		//a[0]+a[1]/a[2]+a[3]a[4]a[5]/(a[6]a[7]a[8]) = 10 
		//--> A + B/C + D/E = 10 --> A*C*E + B*E + D*C = 10*C*E
		int A = a[0];
		int B = a[1];
		int C = a[2];
		int D = 100*a[3]+10*a[4]+a[5];
		int E = 100*a[6]+10*a[7]+a[8];

		
		if(A*C*E + B*E +D*C == 10*C*E) {
			ans++;
			for(int i=0;i<9;i++)
				System.out.print(a[i]+" ");
			System.out.println();
		}
		return;
	}
	
	for(int i=m;i<9;i++) {
		swap(m,i);
		dfs(m+1);
		swap(m,i);
	}
}
static void swap(int i, int j) {
	int t = a[i];
	a[i] = a[j];
	a[j] = t;
}
}
