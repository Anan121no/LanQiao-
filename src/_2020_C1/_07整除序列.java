package _2020_C1;

import java.util.Scanner;

/*
 * ��һ�����У����еĵ�һ������ n�������ÿ������ǰһ�������� 2������
�����������ֵΪ�������
�����ʽ
����һ�а���һ������ n��
�����ʽ
���һ�У�����������������ڵ�����֮����һ���ո�ָ�����ʾ�𰸡�
��������1
Input��
20
Output��
20 10 5 2 1
1
2
3
4
5
����������ģ��Լ��
���� 80% ������������1 �� n �� 109��
������������������1 �� n �� 1018��
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _07�������� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		System.out.print(n+" ");
		while (n/2>0) {
			n=n/2;
			System.out.print(n+" ");
		}
	}
}
