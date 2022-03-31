package _2018_C;

import java.util.Scanner;

/*
 * x星球的居民脾气不太好，但好在他们生气的时候唯一的异常举动是：摔手机。
各大厂商也就纷纷推出各种耐摔型手机。x星球的质监局规定了手机必须经过耐摔测试，并且评定出一个耐摔指数来，之后才允许上市流通。
x星球有很多高耸入云的高塔，刚好可以用来做耐摔测试。塔的每一层高度都是一样的，与地球上稍有不同的是，他们的第一层不是地面，而是相当于我们的2楼。
如果手机从第7层扔下去没摔坏，但第8层摔坏了，则手机耐摔指数=7。
特别地，如果手机从第1层扔下去就坏了，则耐摔指数=0。
如果到了塔的最高层第n层扔没摔坏，则耐摔指数=n
为了减少测试次数，从每个厂家抽样3部手机参加测试。
某次测试的塔高为1000层，如果我们总是采用最佳策略，在最坏的运气下最多需要测试多少次才能确定手机的耐摔指数呢？
请填写这个最多测试次数。
注意：需要填写的是一个整数，不要填写任何多余内容。
解题思路
动态规划的考点
题解待更新
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _10测试次数 {
	//谷歌面试题，人鸡蛋，代码都一样，在此题里，n==楼层，m==手机
	private static int maxn = 1005;
	private static int[][] dp = new int[maxn][10];
	private static int inf = 0x3f3f3f3f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		for(int i = 0; i <= n; ++i) {
			for(int j = 0; j <= m; ++j) {
				dp[i][j] = inf;
			}
		}
		System.out.println(work(n, m));
	}
	private static int work(int n, int m) {
		if(dp[n][m] != inf) {
			return dp[n][m];
		}
		if(n == 0) {
			return dp[n][m] = 0;
		}
		if(m == 1) {
			return dp[n][m] = n;
		}
		for(int i = 1; i <= n; ++i) {
			dp[n][m] = Math.min(dp[n][m], 1 + Math.max(work(i-1, m-1), work(n-i, m)));
		}
		return dp[n][m];
	}
}
