package _2016_C;
/*
 * �����һ����������ÿһλ��ƽ��������ͣ��õ�һ���µ���������
���²���������������ͬ���Ĵ���
���һ������ᷢ�֣����ܿ�ʼȡ����ʲô���֣�
���������������1����������ͬһ��ѭ��Ȧ��
��д�����ѭ��Ȧ�������Ǹ����֡�
����д��������֡�
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ��������
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108925934
 */
public class _03ƽ����Ȧ {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			f(i,0,0);
		}
	}

	private static void f(int n,int c,double max) {
		// TODO Auto-generated method stub
		if (n==1) {
			return;
		}
		if(c==10) {
			System.out.println(max);
			return;
		}
		double a;
		a = Math.pow(n%10, 2)+Math.pow(n/10%10, 2)+Math.pow(n/100, 2);
		max = max>a?max:a;
		f((int)a,c+1,max);
	}
}
