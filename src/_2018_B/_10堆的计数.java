package _2018_B;

import java.util.Scanner;

/*
 * ����֪������N��Ԫ�صĶѿ��Կ�����һ�ð���N���ڵ����ȫ��������
ÿ���ڵ���һ��Ȩֵ������С������˵�����ڵ��Ȩֵһ��С�����ӽڵ��Ȩֵ��

����N���ڵ��Ȩֵ�ֱ���1~N���������һ���ж����ֲ�ͬ��С������

�������N=4������3�֣�


�����������ܳ������ͷ�Χ����ֻ��Ҫ����������1000000009��������

�������ʽ��
һ������N��
����40%�����ݣ�1 <= N <= 1000
����70%�����ݣ�1 <= N <= 10000
����100%�����ݣ�1 <= N <= 100000

�������ʽ��
һ��������ʾ�𰸡�

������������
4

�����������
3

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU���� < 1000ms

���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ����������롭�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _10�ѵļ��� {
	static int mod = 1000000009;
	static long[] f;
	static long[] inv;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] s = new int[n + 1];// ����iΪ���ڵ������������i�Ľ��ĸ�����
		f = new long[n + 1];// i�Ľ׳�
		long[] dp = new long[n + 1];// ��iΪ���ڵ�Ķѵ�����
		inv = new long[n + 1];// n������Ԫ
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
