package _2021_A;

import java.util.Scanner;

/*
 * 你有一架天平。现在你要设计一套砝码，使得利用这些砝码可以称出任意
小于等于 N 的正整数重量。
那么这套砝码最少需要包含多少个砝码？
注意砝码可以放在天平两边。

【输入格式】
输入包含一个正整数 N。

【输出格式】
输出一个整数代表答案。

【样例输入】
7

【样例输出】
3

【样例说明】
3 个砝码重量是 1、4、6，可以称出 1 至 7 的所有重量。
1 = 1；
2 = 6 − 4 (天平一边放 6，另一边放 4)；
3 = 4 − 1；
4 = 4；
5 = 6 − 1；
6 = 6；
7 = 1 + 6；
少于 3 个砝码不可能称出 1 至 7 的所有重量。

【评测用例规模与约定】
对于所有评测用例，1 ≤ N ≤ 1000000000。
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
public class _06最少砝码 {
	/**
	 * 前四个比较特殊，罗列前20个数据可以发现规律
	 * @author HQL
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(dfs(n));
	}

	/**
	 * 时间和空间复杂度小
	 * @param cur
	 * @return
	 */
	public static int dfs(int cur) {
		if (cur == 1)		
			return 1;
		else if (cur >= 2 && cur <= 4)
			return 2;
		if (cur % 2 == 1) 
			return dfs(cur / 2 + 1) + 1;
		return dfs(cur / 2) + 1;
	}
	
	/**
	 * 效率慢，空间消耗大，但也可以通过一部分评测用例
	 * @param n
	 * @return
	 */
	public static int ffa(int n) {
		int[] dp = new int[n + 10];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 2;
		for (int i = 5; i <= n; ++i) {
			int ind = i / 2;
			if (i % 2 == 1)
				++ind;
			dp[i] = dp[ind] + 1; 
		}
		return dp[n];
	}
//————————————————
//版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
}
