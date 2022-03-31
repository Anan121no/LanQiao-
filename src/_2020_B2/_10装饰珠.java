package _2020_B2;

import java.util.Scanner;

/*
 * 在怪物猎人这一款游戏中，玩家可以通过给装备镶嵌不同的装饰珠来获取
相应的技能，以提升自己的战斗能力。
已知猎人身上一共有 6 件装备，每件装备可能有若干个装饰孔，每个装饰
孔有各自的等级，可以镶嵌一颗小于等于自身等级的装饰珠 (也可以选择不镶
嵌)。
装饰珠有 M 种，编号 1 至 M，分别对应 M 种技能，第 i 种装饰珠的等级
为 Li，只能镶嵌在等级大于等于 Li 的装饰孔中。
对第 i 种技能来说，当装备相应技能的装饰珠数量达到 Ki 个时，会产生
Wi(Ki) 的价值。镶嵌同类技能的数量越多，产生的价值越大，即 Wi(Ki 뫶 1) < Wi(Ki)。但每个技能都有上限 Pi(1 ≤ Pi ≤ 7)，当装备的珠子数量超过 Pi 时，只
会产生 Wi(Pi) 的价值。
对于给定的装备和装饰珠数据，求解如何镶嵌装饰珠，使得 6 件装备能得
到的总价值达到最大。
【输入格式】
输入的第 1 至 6 行，包含 6 件装备的描述。其中第 i 的第一个整数 Ni 表示
第 i 件装备的装饰孔数量。后面紧接着 Ni 个整数，分别表示该装备上每个装饰
孔的等级 L(1 ≤ L ≤ 4)。 第 7 行包含一个正整数 M，表示装饰珠 (技能) 种类数量。
第 8 至 M + 7 行，每行描述一种装饰珠 (技能) 的情况。每行的前两个整数
Lj(1 ≤ Lj ≤ 4) 和 Pj(1 ≤ Pi ≤ 7) 分别表示第 j 种装饰珠的等级和上限。接下来
Pj 个整数，其中第 k 个数表示装备该中装饰珠数量为 k 时的价值 Wj(k)

【输出格式】

输出一行包含一个整数，表示能够得到的最大价值。
【样例输入】
1 1
2 1 2
1 1
2 2 2
1 1
1 3
3
1 5 1 2 3 5 8
2 4 2 4 8 15
3 2 5 10
【样例输出】
20
【样例说明】
按照如下方式镶嵌珠子得到最大价值 18，括号内表示镶嵌的装饰珠的种类
编号：
1: (1)
2: (1) (2)
3: (1)
4: (2) (2)
5: (1)
6: (2)
4 颗技能 1 装饰珠，4 颗技能 2 装饰珠 W1(4) + W2(4) = 5 + 15 = 20。

【评测用例规模与约定】
对于 30% 的评测用例，1 ≤ Ni ≤ 10, 1 ≤ M ≤ 20, 1 ≤ Wj(k) ≤ 500；
对于所有评测用例，1 ≤ Ni ≤ 50, 1 ≤ M ≤ 10000, 1 ≤ Wj(k) ≤ 10000。
————————————————
版权声明：本文为CSDN博主「胡毛毛_三月」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45696377/article/details/109147147
 */
public class _10装饰珠 {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int []zhu = new int[5];
	        for(int i = 1; i <= 6; i++) {
	            int n = in.nextInt();
	            for(int j = 0; j < n; ++j) {
	                zhu[in.nextInt()]++;
	            }
	        }
	        int M = in.nextInt();
	        int [][]w = new int[M + 1][8];
	        for(int i = 1; i <= M; ++i) {
	            int z = in.nextInt();
	            int k = in.nextInt();
	            for(int j = 1; j <= k; ++j) {
	                if(j <= 7)
	                    w[z][j] = in.nextInt();
	                else
	                    in.nextInt();
	            }
	        }
	        in.close();
	        int zhumax = 0;
	        for(int i = 1; i <= 4; ++i) {
	            zhumax = zhumax > zhu[i] ? zhumax : zhu[i];
	        }
	        int [][]dp = new int[M + 1][];
	        int sum = 0;
	        dp[1] = new int[zhu[1] + 1];
	        for(int i = 1; i <= zhu[1]; ++i)
	            dp[1][i] = w[1][i];
	        for(int i = 2; i <= M; ++i) {
	            dp[i] = new int[zhu[i] + 1];
	            int max = 0;
	            for(int k = 1; k <= zhu[i]; ++k) {                
	                for(int j = 1; j < i; ++j) {
	                    for(int z = 1; z < zhu[i - j]; ++z) {
	                        dp[i][k] = Math.max(w[i][zhu[i]]+dp[i-j][z], w[i][zhu[i]-k]+w[i - j][zhu[i - j]+ k]);
	                        }
	                    }
	                    max = max > dp[i][k] ? max : dp[i][k];
	                }
	                sum += max;
	            }
	        System.out.println(sum);
	        }
}
