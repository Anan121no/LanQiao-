package _2020_C1;

import java.math.BigInteger;

/*
 * 7 �� 1 ���ǽ����գ��� 1921 �굽 2020 �꣬�й��������Ѿ������й�����
�߹��� 99 �ꡣ
����㣺7 2020 7^{2020}7 
2020
  mod 1921������ A mod B ��ʾ A ���� B ��������
���ύ
����һ���������⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ��
���������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�
480
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _01ָ������ {
	public static void main(String[] args) {
		BigInteger n;
		n = new BigInteger("7").pow(2020).mod(new BigInteger("1921"));
		System.out.println(n);
	}
}
