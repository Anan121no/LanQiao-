package _2018_B;

import java.util.Arrays;
import java.util.Scanner;

/*
 * x����ľ���Ƣ����̫�ã�����������������ʱ��Ψһ���쳣�ٶ��ǣ�ˤ�ֻ���
������Ҳ�ͷ׷��Ƴ�������ˤ���ֻ���x������ʼ�ֹ涨���ֻ����뾭����ˤ���ԣ�����������һ����ˤָ������֮�������������ͨ��
x�����кܶ�������Ƶĸ������պÿ�����������ˤ���ԡ�����ÿһ��߶ȶ���һ���ģ�����������в�ͬ���ǣ����ǵĵ�һ�㲻�ǵ��棬�����൱�����ǵ�2¥��
����ֻ��ӵ�7������ȥûˤ��������8��ˤ���ˣ����ֻ���ˤָ��=7��
�ر�أ�����ֻ��ӵ�1������ȥ�ͻ��ˣ�����ˤָ��=0��
�������������߲��n����ûˤ��������ˤָ��=n
Ϊ�˼��ٲ��Դ�������ÿ�����ҳ���3���ֻ��μӲ��ԡ�
ĳ�β��Ե�����Ϊ1000�㣬����������ǲ�����Ѳ��ԣ�����������������Ҫ���Զ��ٴβ���ȷ���ֻ�����ˤָ���أ�
����д��������Դ�����
ע�⣺��Ҫ��д����һ����������Ҫ��д�κζ������ݡ�
����˼·
��̬�滮�Ŀ���
��������
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _04���Դ��� {
	//�ȸ������⣬�˼��������붼һ�����ڴ����n==¥�㣬m==�ֻ�
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
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(dpoptimize(n,m));
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
	private static int dpoptimize(int n, int m) {
		// TODO Auto-generated method stub
		int dp[][] = new int[n+1][m+1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], 0x3f3f3f3f);
		}
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i <= n; i++) {
			dp[i][1] = i;
		}
		for (int j = 2; j <= m; j++) {
			for (int i = 1; i <= n; i++) {
				for (int k = 2; k < i; k++) {
					System.out.print("i:"+i+"j:"+j+"k:"+k+" "+dp[i][j]+" ");
				dp[i][j] = Math.min(dp[i][j], Math.max(dp[k-1][j-1], dp[i-k][j])+1);
			}}
		}
		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[n-1][m];
	}
}
