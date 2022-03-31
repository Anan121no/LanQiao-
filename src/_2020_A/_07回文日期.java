package _2020_A;

import java.util.Scanner;

/*
 * 2020年春节期间，有一个特殊的日期引起了大家的注意：2020年2月2日。
 * 因为如果将这个日期按 yyyymmdd 的格式写成一个8位数是 20200202 ，
 * 恰好是一个回文数。我们称这样的日期是回文日期。
有人表示 20200202 是“千年一遇”的特殊日子。对此小明很不认同，
因为不到2年之后就是下一个回文日期：20211202 即2021年12月2日。
也有人表示 20200202 并不仅仅是一个回文日期，还是一个 ABABBABA 型的回文日期。对此小明也不认同，
因为大约 100 年后就能遇到下一个 ABABBABA 型的回文日期：
21211212 即2121年12月12日。算不上“千年一遇”，顶多算“千年两遇”。
给定一个8位数的日期，请你计算该日期之后下一个回文日期和下一个 ABABBABA 型的回文日期各是哪一天。
【输入格式】
输入包含一个八位整数 ，表示日期。
【输出格式】
输出两行，每行1个八位数。
第一行表示下一个回文日期，第二行表示下一个 型的回文日期。
【样例输入】
20200202
【样例输出】
20211202
21211212
【评测用例规模与约定】
对于所有评测用例，10000101<=N<=89991231， 保证 N 是一个合法日期的 8 位数表示。
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _07回文日期 {
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
