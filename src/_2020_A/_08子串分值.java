package _2020_A;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 对于一个字符串 S，我们定义 S 的分值 f(S) 为 S 中恰好出现一次的字符个数。例如 f(“aba”)=1，f(“abc”)=3, f(“aaa”)=0。
现在给定一个字符串 S[0…n-1]（长度为 n），请你计算对于所有 S 的非空子串 S[i…j] (0<=i<=j<n)，f(S[i…j])的和是多少。
【输入格式】
输入一行包含一个由小写字母组成的字符串 S。
【输出格式】
输出一个整数表示答案。
【样例输入】
ababc
【样例输出】
21
【样例说明】
子串 f值
a 1
ab 2
aba 1
abab 0
ababc 1
b 1
ba 2
bab 1
babc 2
a 1
ab 2
abc 3
b 1
bc 2
c 1
【评测用例规模与约定】
对于 20% 的评测用例，1<=n<=10；
对于 40% 的评测用例，1<=n<=100；
对于 50% 的评测用例，1<=n<=1000；
对于 60% 的评测用例，1<=n<=10000；
对于所有评测用例，1<=n<=100000。
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _08子串分值 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] rv = sc.next().toCharArray();
		int[][] dr = new int[26][2];
		for (int i = 0; i < 26; ++i)
			Arrays.fill(dr[i], -1);
		int ans = 0, total = 0;
		for (int i = 0; i < rv.length; ++i) {
			int ind = rv[i] - 'a';
			total += i - 2 * dr[ind][1] + dr[ind][0];
			dr[ind][0] = dr[ind][1];
			dr[ind][1] = i;
			ans += total;
		}
		System.out.println(ans);
	}
}
