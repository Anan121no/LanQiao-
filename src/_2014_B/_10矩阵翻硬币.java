package _2014_B;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*
 * ��������
����С���Ȱ�Ӳ�Ұڳ���һ�� n �� m �еľ���

�������С����ÿһ��Ӳ�ҷֱ����һ�� Q ������

�����Ե�x�е�y�е�Ӳ�ҽ��� Q �����Ķ��壺�����е� i*x �У��� j*y �е�Ӳ�ҽ��з�ת��

��������i��jΪ����ʹ�������е����������кź��кŶ��Ǵ�1��ʼ��

������С��������Ӳ�Ҷ�������һ�� Q ��������������һ���漣��������Ӳ�Ҿ�Ϊ���泯�ϡ�

����С����֪���ʼ�ж���öӲ���Ƿ��泯�ϵġ����ǣ��������ĺ�����СMѰ�������

����������СM����С����ֻ��Ҫ������Ӳ���ٽ���һ��Q���������ɻָ����ʼ��״̬��Ȼ��С����������Ը������������С��ϣ������������õķ���������������𰸡�
�����ʽ
�����������ݰ���һ�У����������� n m���������Ŀ������
�����ʽ
�������һ������������ʾ�ʼ�ж���öӲ���Ƿ��泯�ϵġ�
��������
2 3
�������
1
���ݹ�ģ��Լ��
��������10%�����ݣ�n��m <= 10^3��
��������20%�����ݣ�n��m <= 10^7��
��������40%�����ݣ�n��m <= 10^15��
��������10%�����ݣ�n��m <= 10^1000��10��1000�η�����

��������������������������������
��Ȩ����������ΪCSDN������xian�ơ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_29215513/article/details/79370265
 */
public class _10����Ӳ�� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		String s1 = in.next();
		String s2 = in.next();
		System.out.println(sqrt(s1).multiply(sqrt(s2)));
	}

	private static BigInteger sqrt(String s) {
		// TODO Auto-generated method stub
		int length = s.length();
		int len = 0;
		if((length&1)!=1)
			len  = length/2;
		else 
			len = length/2+1;
		char[] sArr = new char[len];
		Arrays.fill(sArr, '0');
		BigInteger target = new BigInteger(s);
		for (int pos = 0; pos < len; pos++) {
			for (char c = '1'; c <= '9'; c++) {
				sArr[pos] = c;
			BigInteger pow = new BigInteger(String.valueOf(sArr)).pow(2) ;
			if (pow.compareTo(target)==1) {
				sArr[pos]-=1;
				break;
			}
			}
		}
		return new BigInteger(String.valueOf(sArr));
	}
}
