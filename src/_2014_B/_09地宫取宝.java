package _2014_B;

import java.util.Scanner;


/*
 * 问题描述
　　X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
　　地宫的入口在左上角，出口在右下角。
　　小明被带到地宫的入口，国王要求他只能向右或向下行走。
　　走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
　　当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
　　请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。
输入格式
　　输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)
　　接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值
输出格式
　　要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。
样例输入
2 2 2
1 2
2 1
样例输出
2
样例输入
2 3 2
1 2 3
2 1 5
样例输出
14
————————————————
版权声明：本文为CSDN博主「2014乘风破浪2014」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/wqy20140101/article/details/50639269
 */
public class _09地宫取宝 {
	private static int[][] data;
	private static int n;
	private static int m;
	private static int k;
	private static int MOD = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		data = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				data[i][j]=in.nextInt();
			}
		}
		for (int i = 0; i < 51; i++) {
			for (int j = 0; j < 51; j++) {
				for (int l = 0; l < 14; l++) {
					for (int o = 0; o < 14; o++) {
						cache[i][j][l][o] = -1;
					}
				}
			}
		}
		long ans = dfs(0,0,-1,0);
		System.out.println(ans);
	}
	static long cache[][][][] = new long [51][51][14][14];
	private static long dfs(int x, int y, int max, int cnt) {
		if (cache[x][y][max+1][cnt]!=-1) {
			return cache[x][y][max+1][cnt];
		}
		// TODO Auto-generated method stub
		if (x==n||y==m||cnt>k) {
			return 0;
		}
		int ans=0;
		int cur = data[x][y];
		if (x==n-1&&y==m-1) {
			if (cnt==k||(cnt==k-1&&cur>max)) {
				return 1;
			}
			return ans;
		}
		if(cur>max) {
			ans+=dfs(x, y+1, cur, cnt+1);
			ans+=dfs(x+1, y, cur, cnt+1);
		}
		ans+=dfs(x, y+1, max, cnt);
		ans+=dfs(x+1, y, max, cnt);
		cache[x][y][max+1][cnt] = ans%MOD;
		return ans%MOD ;
	}
}
