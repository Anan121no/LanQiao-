package _2021_C2;

import java.util.Scanner;

/*
 * 今年是 2021 年，2021 这个数字非常特殊，它的千位和十位相等，个位比百位大 1，我们称满足这样条件的年份为特殊年份。输入 5
个年份，请计算这里面有多少个特殊年份。 【输入格式】 输入 5 行，每行一个 4 位十进制数（数值范围为 1000 至
9999），表示一个年份
【输出格式】 输出一个整数，表示输入的 5 个年份中有多少个特殊年份。
【样例输入】
2019
2021
1920
2120
9899
【样例输出】 2
【样例说明】 2021 和 9899 是特殊年份，其它不是特殊年份。

解题思路：
没啥难度，直接获取各个位数，进行判断即可。
————————————————
版权声明：本文为CSDN博主「dem.o」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45800978/article/details/116724283
 */
public class _07特殊年份 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;
		int count = 0;
		for (int i = 0; i < 5; i++) {
			n = in.nextInt();
			if (n/1000==n/10%10&&n%10-1==n/100%10) {
				count++;
//				System.out.println(n);
			}
		}
		System.out.println(count);
	}
}
