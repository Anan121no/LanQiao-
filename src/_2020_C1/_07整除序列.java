package _2020_C1;

import java.util.Scanner;

/*
 * 有一个序列，序列的第一个数是 n，后面的每个数是前一个数整除 2，请输
出这个序列中值为正数的项。
输入格式
输入一行包含一个整数 n。
输出格式
输出一行，包含多个整数，相邻的整数之间用一个空格分隔，表示答案。
测试样例1
Input：
20
Output：
20 10 5 2 1
1
2
3
4
5
评测用例规模与约定
对于 80% 的评测用例，1 ≤ n ≤ 109。
对于所有评测用例，1 ≤ n ≤ 1018。
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _07整除序列 {
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
