package _2018_C;

import java.util.Scanner;

/*
 * 在电子计算机普及以前，人们经常用一个粗略的方法来验算四则运算是否正确。
比如：248 * 15 = 3720
把乘数和被乘数分别逐位求和，如果是多位数再逐位求和，直到是1位数，得
2 + 4 + 8 = 14 ==> 1 + 4 = 5;
1 + 5 = 6
5 * 6
而结果逐位求和为 3
5 * 6 的结果逐位求和与3符合，说明正确的可能性很大！！（不能排除错误）

请你写一个计算机程序，对给定的字符串逐位求和

资源约定

峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms

输入格式

输入为一个由数字组成的串，表示n位数(n<1000);

输出格式

输出为一位数，表示反复逐位求和的结果。

测试样例1

Input：
35379

Output：
9
测试样例2

Input：
7583676109608471656473500295825

Output：
1
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _07缩位求和 {
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
