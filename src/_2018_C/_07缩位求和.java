package _2018_C;

import java.util.Scanner;

/*
 * �ڵ��Ӽ�����ռ���ǰ�����Ǿ�����һ�����Եķ������������������Ƿ���ȷ��
���磺248 * 15 = 3720
�ѳ����ͱ������ֱ���λ��ͣ�����Ƕ�λ������λ��ͣ�ֱ����1λ������
2 + 4 + 8 = 14 ==> 1 + 4 = 5;
1 + 5 = 6
5 * 6
�������λ���Ϊ 3
5 * 6 �Ľ����λ�����3���ϣ�˵����ȷ�Ŀ����Ժܴ󣡣��������ų�����

����дһ����������򣬶Ը������ַ�����λ���

��ԴԼ��

��ֵ�ڴ����ģ���������� < 256M
CPU���� < 1000ms

�����ʽ

����Ϊһ����������ɵĴ�����ʾnλ��(n<1000);

�����ʽ

���Ϊһλ������ʾ������λ��͵Ľ����

��������1

Input��
35379

Output��
9
��������2

Input��
7583676109608471656473500295825

Output��
1
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _07��λ��� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		System.out.println(f(n));
	}

	private static int f(String n) {
		// TODO Auto-generated method stub
		int num = 0;
		while (n.length()>1) {
			num = 0;
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			num = c - '0' + num;
			int a = c - '0';
			}
		n = String.valueOf(num);
//		System.out.println(n);
		}
		return num;
	}
}
