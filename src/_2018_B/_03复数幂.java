package _2018_B;
import java.math.BigInteger;

/*
 * ��iΪ������λ����������������n��(2+3i)^n ��ʵ�����鲿����������
�� (2+3i)^123456 ���ڶ��٣� ��(2+3i)��123456���ݣ�������ֺܴ�Ҫ��ȷ��ʾ��

��д�� ��ʵ�����鲿i�� ����ʽ��ʵ�����鲿���������������ÿ�ѧ��������ʾ�����м��κεط������ӿո�ʵ��Ϊ��ʱǰ�治�����š�(2+3i)^2 д��: -5+12i��
(2+3i)^5 ��д��: 122-597i

ע�⣺��Ҫ�ύ����һ�����Ӵ�ĸ�������Ҫ��д�κζ������ݡ�

����˼·
���� ��BigInteger�Ŀ���
Ȼ����� ������������� ���忴����
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _03������ {
	static BigInteger A=new BigInteger("2");
	static BigInteger B=new BigInteger("3");
	static BigInteger a=new BigInteger("2");
	static BigInteger b=new BigInteger("3");
	static BigInteger ta=new BigInteger("0");
	static BigInteger tb=new BigInteger("0");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<123456;i++){//���г˷���ʱ���������ֻ��Ҫ����i-1��
			ta=A.multiply(a).subtract(B.multiply(b));//Aa-Bb
			tb=A.multiply(b).add(b.multiply(a));//Ab+ba
			A=ta;
			B=tb;
		}
		System.out.print(A);
		//���жϸ����ǲ���Ϊ0
		if(B.compareTo(BigInteger.ZERO)>0)//��0��
			System.out.print("+");
		System.out.print(B);
		System.out.println("i");//�����ı�־
	}
}
