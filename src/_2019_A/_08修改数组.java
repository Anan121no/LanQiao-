package _2019_A;

import java.util.Scanner;

/*
 * 给定�?个长度为 N 的数�? A = [A1, A2, · · · AN]，数组中有可能有重复出现的整数�??
现在小明要按以下方法将其修改为没有重复整数的数组。小明会依次修改
A2, A3, · · · , AN�?
当修�? Ai 时，小明会检�? Ai 是否�? A1 �? Ai�?1 中出现过。如果出现过，则小明会给 Ai 加上 1 ；如果新�? Ai 仍在之前出现过，小明会持续给 Ai �? 1 ，直�? Ai 没有�? A1 �? Ai�?1 中出现过�?
�? AN 也经过上述修改之后，显然 A 数组中就没有重复的整数了。现在给定初始的 A 数组，请你计算出�?终的 A 数组�?
【输入格式�??
第一行包含一个整�? N�?
第二行包�? N 个整�? A1, A2, · · · , AN �?
【输出格式�??
输出 N 个整数，依次是最终的 A1, A2, · · · , AN�?
【样例输入�??
5
2 1 1 3 4
【样例输出�??
2 1 3 4 5
【评测用例规模与约定�?
对于 80% 的评测用例，1 �? N �? 10000�?
对于�?有评测用例，1 �? N �? 100000�?1 �? Ai �? 1000000�?

【题目分析�??
此题个人想法利用桶排序，读入数i，先看i桶中有没有数，没有则在i桶中计数加一，若有则i++，重复上述判断过程即可�??
（算法很笨�?�但蓝桥杯有名暴力杯，还是能过的�?
—�?��?��?��?��?��?��?��?��?��?��?��?��?��?��??
版权声明：本文为CSDN博主「leangx86」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明�?
原文链接：https://blog.csdn.net/leangx86/article/details/95937062
 */
public class _08修改数组 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		int[] b=new int[100000];
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
			while(b[a[i]]>0) {
				a[i]++;
			}
			b[a[i]]++;
		}
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
