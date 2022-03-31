package _2020_B2;

import java.util.Scanner;

/*
 * 小蓝给学生们组织了一场考试，卷面总分为 100 分，每个学生的得分都是 一个 0 到 100 的整数。
请计算这次考试的最高分、最低分和平均分。
【输入格式】
输入的第一行包含一个整数 n，表示考试人数。 接下来 n 行，每行包含一个 0 至 100 的整数，表示一个学生的得分。
【输出格式】
输出三行。
第一行包含一个整数，表示最高分。
第二行包含一个整数，表示最低分。
第三行包含一个实数，四舍五入保留正好两位小数，表示平均分。
【样例输入】
7
80
92
56
74
88
99
10
【样例输出】
99
10
71.29
【评测用例规模与约定】
对于 50% 的评测用例，1≤n≤100。
对于所有评测用例，1≤n≤10000。
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _06成绩分析 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		double sum = 0;
		for(int i=0; i<n; ++i) {
			int t = sc.nextInt();
			sum += t;
			max = t>max?t:max;
			min = t<min?t:min;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(String.format("%.2f", sum/n));
//		System.out.printf("%.2f",sum/n);
	}
}
