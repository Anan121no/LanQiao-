package _2020_A;

import java.util.Scanner;

/*
 * 2020�괺���ڼ䣬��һ����������������˴�ҵ�ע�⣺2020��2��2�ա�
 * ��Ϊ�����������ڰ� yyyymmdd �ĸ�ʽд��һ��8λ���� 20200202 ��
 * ǡ����һ�������������ǳ������������ǻ������ڡ�
���˱�ʾ 20200202 �ǡ�ǧ��һ�������������ӡ��Դ�С���ܲ���ͬ��
��Ϊ����2��֮�������һ���������ڣ�20211202 ��2021��12��2�ա�
Ҳ���˱�ʾ 20200202 ����������һ���������ڣ�����һ�� ABABBABA �͵Ļ������ڡ��Դ�С��Ҳ����ͬ��
��Ϊ��Լ 100 ������������һ�� ABABBABA �͵Ļ������ڣ�
21211212 ��2121��12��12�ա��㲻�ϡ�ǧ��һ�����������㡰ǧ����������
����һ��8λ�������ڣ�������������֮����һ���������ں���һ�� ABABBABA �͵Ļ������ڸ�����һ�졣
�������ʽ��
�������һ����λ���� ����ʾ���ڡ�
�������ʽ��
������У�ÿ��1����λ����
��һ�б�ʾ��һ���������ڣ��ڶ��б�ʾ��һ�� �͵Ļ������ڡ�
���������롿
20200202
�����������
20211202
21211212
������������ģ��Լ����
������������������10000101<=N<=89991231�� ��֤ N ��һ���Ϸ����ڵ� 8 λ����ʾ��
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _07�������� {
	static int n;
	static String sn;
	static int curyear, curmm, curdd;
	static String ans1, ans2;
	static boolean v1, v2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sn = String.valueOf(n);
		curyear = Integer.parseInt(sn.substring(0, 4));
		curmm = Integer.parseInt(sn.substring(4, 6));
		curdd = Integer.parseInt(sn.substring(6, 8));
		int end = curyear + 200;
		for (int i = curyear; i <= end; ++i) {
			if (checkPing(i)) {
				if (!v1) {
					ans1 = i + "" + new StringBuilder(String.valueOf(i)).reverse().toString();
					v1 = true;
				}
				String si = String.valueOf(i);
				if ((si.substring(0, 2).equals(si.substring(2, 4))) && !v2) {
					ans2 = i + "" + new StringBuilder(String.valueOf(i)).reverse().toString();
					v2 = true;
				}
				if (v1 && v2)
					break;
			}
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}

	static int[] days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static boolean checkPing(int x) {
		String sy = new StringBuilder(String.valueOf(x)).reverse().toString();
		int mm = Integer.parseInt(sy.substring(0, 2)), dd = Integer.parseInt(sy.substring(2, 4));
		if (mm < 1 || mm > 12)
			return false;
		if ((mm == 2 && (x % 4 == 0 && x % 100 != 0 || x % 400 == 0)) && (dd < 1 || dd > 29))
			return false;
		else if (dd < 1 || dd > days[mm])
			return false;
		if (x == curyear && (mm < curmm || mm == curmm && dd <= curdd))
			return false;
		return true;
	}
}
