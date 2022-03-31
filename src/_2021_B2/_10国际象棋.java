package _2021_B2;

import java.util.Scanner;

/*
 * 众所周知，“八皇后” 问题是求解在国际象棋棋盘上摆放 8 个皇后，使得两
两之间互不攻击的方案数。已经学习了很多算法的小蓝觉得 “八皇后” 问题太简
单了，意犹未尽。作为一个国际象棋迷，他想研究在 N × M 的棋盘上，摆放 K
个马，使得两两之间互不攻击有多少种摆放方案。由于方案数可能很大，只需
计算答案除以 1000000007 (即 109 + 7) 的余数。
如下图所示，国际象棋中的马摆放在棋盘的方格内，走 “日” 字，位于 (x, y)
格的马（第 x 行第 y 列）可以攻击 (x + 1, y + 2)、(x + 1, y − 2)、(x − 1, y + 2)、 (x − 1, y − 2)、(x + 2, y + 1)、(x + 2, y − 1)、(x − 2, y + 1) 和 (x − 2, y − 1) 共 8 个
格子。
【输入格式】
输入一行包含三个正整数 N, M, K，分别表示棋盘的行数、列数和马的个
数。
试题 J: 国际象棋 13
第十二届蓝桥杯大赛软件赛省赛第二场 Java 大学 B 组
【输出格式】
输出一个整数，表示摆放的方案数除以 1000000007 (即 109 + 7) 的余数。
【样例输入】
1 2 1
【样例输出】
2
【样例输入】
4 4 3
【样例输出】
276
【样例输入】
3 20 12
【样例输出】
914051446
【评测用例规模与约定】
对于 5% 的评测用例，K = 1；
对于另外 10% 的评测用例，K = 2；
对于另外 10% 的评测用例，N = 1；
对于另外 20% 的评测用例，N, M ≤ 6，K ≤ 5；
对于另外 25% 的评测用例，N ≤ 3，M ≤ 20，K ≤ 12；
对于所有评测用例，1 ≤ N ≤ 6，1 ≤ M ≤ 100，1 ≤ K ≤ 20。
————————————————
版权声明：本文为CSDN博主「dem.o」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45800978/article/details/116724283
 */
public class _10国际象棋 {
	 static int MOD = 1000000007;
	    static int ans = 0;
	    static int n, m, k;
	    // 方向数组
	    static int[] xx = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
	    static int[] yy = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
	    static int[][] cnt;
	    // 是否有马
//	    static boolean[][] vis; 不能用vis数组来标记不能放马的位置，因为棋盘上某一点可能有多个马共同进行限制，需要对限制数计数
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        n = scan.nextInt();
	        m = scan.nextInt();
	        k = scan.nextInt();
	        cnt = new int[n][m];
	        // 从左上角第一个格子开始放，初始已放马的个数 = 0
	        dfs(0, 0, 0);
	        System.out.println(ans);
	    }
	    static void dfs (int x, int y, int horse) {
	        if (horse == k) {
	            ans = (ans + 1) % MOD;
	            return;
	        }
	        // 切换到下一行第一个元素
	        if (y >= m) {
	            y = 0;
	            x++;
	            if (x >= n) return;
	        }
	        // 当前(x,y)位置不放马
	        dfs(x, y + 1, horse);

	        // 当前(x,y)位置放马
	        // 先判断能否放马
	        if (cnt[x][y] == 0) {
	            cnt[x][y]++;
	            // 遍历当前位置的马能够跳到的棋盘位置，标记为true
	            for (int i = 0; i < 8; i++) {
	                int tmpx = x + xx[i];
	                int tmpy = y + yy[i];
	                if (tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
	                    continue;
	                }
	                cnt[tmpx][tmpy]++;
	            }
	            // 放了马之后继续遍历
	            dfs(x, y + 1, horse + 1);
	            // 别忘了回溯
	            // 回溯：一切在之前change过的变量，全都要恢复
	            cnt[x][y]--;
	            for (int i = 0; i < 8; i++) {
	                int tmpx = x + xx[i];
	                int tmpy = y + yy[i];
	                if (tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m) {
	                    continue;
	                }
	                cnt[tmpx][tmpy]--;
	            }
	        }
	    }
}
