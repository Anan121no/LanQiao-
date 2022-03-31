package _2018_B;

import java.util.Scanner;

/*
 * 我们知道包含N个元素的堆可以看成是一棵包含N个节点的完全二叉树。
每个节点有一个权值。对于小根堆来说，父节点的权值一定小于其子节点的权值。

假设N个节点的权值分别是1~N，你能求出一共有多少种不同的小根堆吗？

例如对于N=4有如下3种：


由于数量可能超过整型范围，你只需要输出结果除以1000000009的余数。

【输入格式】
一个整数N。
对于40%的数据，1 <= N <= 1000
对于70%的数据，1 <= N <= 10000
对于100%的数据，1 <= N <= 100000

【输出格式】
一个整数表示答案。

【输入样例】
4

【输出样例】
3

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _10堆的计数 {
	static int mod = 1000000009;
	static long[] f;
	static long[] inv;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] s = new int[n + 1];// 求以i为根节点的子树，包括i的结点的个数。
		f = new long[n + 1];// i的阶乘
		long[] dp = new long[n + 1];// 以i为根节点的堆的种数
		inv = new long[n + 1];// n！的逆元
		for (int i = n; i >= 1; i--) {
			s[i]++;
			if (i * 2 <= n)
				s[i] += s[i * 2];
			if (i * 2 + 1 <= n)
				s[i] += s[i * 2 + 1];
		}
		f[0] = 1;
		inv[0] = 1;
		for (int i = 1; i <= n; i++) {
			f[i] = f[i - 1] * i % mod;
			// inv[i] = pow(f[i], mod - 2);
			inv[i] = pow(i, mod - 2) * inv[i - 1] % mod;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
		for (int i = n; i > 0; i--) {
			if (2 * i + 1 <= n) {
				dp[i] = c(s[i * 2], s[i] - 1) * dp[i * 2] % mod * dp[i * 2 + 1] % mod;
			} else if (2 * i <= n) {
				dp[i] = c(s[i * 2], s[i] - 1) * dp[i * 2] % mod;
			}

		}
		System.out.println(dp[1]);
	}

	private static long c(int k, int n) {
		return f[n] * inv[k] % mod * inv[n - k] % mod;
	}

	private static long pow(int i, int j) {
		if (i == 0)
			return 0;
		long res = 1;
		long x = i;
		while (j > 0) {
			if ((j & 1) == 1) {
				res = res * x % mod;
			}
			x = x * x % mod;
			j = j / 2;
		}
		return res;
	}
}
