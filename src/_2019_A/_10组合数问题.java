package _2019_A;

import java.util.Scanner;

/*
 * 给 n, m, k， 求 有 多 少 对 (i, j) 满 足 1 ≤ i ≤ n, 0 ≤ j ≤ min(i, m) 且 C j ≡
0(mod k)，k 是质数。其中 C j 是组合数，表示从 i 个不同的数中选出 j 个组成
一个集合的方案数。
【输入格式】
第一行两个数 t, k，其中 t 代表该测试点包含 t 组询问，k 的意思与上文中相同。
接下来 t 行每行两个整数 n, m，表示一组询问。
【输出格式】
输出 t 行，每行一个整数表示对应的答案。由于答案可能很大，请输出答案除以 109 + 7 的余数。
【样例输入】
1 2
3 3
【样例输出】
1
【样例说明】
在所有可能的情况中，只有 C1 = 2 是 2 的倍数。
【样例输入】
2 5
4 5
6 7
【样例输出】
0
7
【样例输入】
3 23
23333333 23333333
233333333 233333333
2333333333 2333333333
【样例输出】
851883128
959557926
680723120
【数据规模和约定】
对于所有评测用例，1 ≤ k ≤ 108, 1 ≤ t ≤ 105, 1 ≤ n, m ≤ 1018，且 k 是质数。评测时将使用 10 个评测用例测试你的程序，每个评测用例的限制如下：

评测用例编号 t n, m k
1, 2 ≤ 1 ≤ 2000 ≤ 100
3, 4 ≤ 105 ≤ 2000 ≤ 100
5, 6, 7 ≤ 100 ≤ 1018 ≤ 100
8, 9, 10 ≤ 105 ≤ 1018 ≤ 108

【题目分析】
t次循环，分别对数据进行判断。
二重循环1 ≤ i ≤ n， 0 ≤ j ≤ min(i, m)，如果C j ≡0(mod k)，计数加1，当循环结束输出计数即可。
此题数据很大，数据应用double。
这题对时间复杂度的要求很高，我的算法并不能完全通过，但写出来还是很简单的，对于考试来说，最后一道题能写出来一个样例拿点分也很不错了。
————————————————
版权声明：本文为CSDN博主「leangx86」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/leangx86/article/details/95937062
 */
public class _10组合数问题 {
	public static void main(String[] args) {
//  最全解法		https://blog.csdn.net/xuxiaobo1234/article/details/108096786?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164813448416780265450394%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=164813448416780265450394&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm_bkp-3-108096786.142^v3^pc_search_quality_down,143^v4^register&utm_term=%E8%93%9D%E6%A1%A5%E6%9D%AF%E7%BB%84%E5%90%88%E6%95%B0%E9%97%AE%E9%A2%98Java&spm=1018.2226.3001.4187
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		int k=in.nextInt();
		while(t-->0) {
			int sum=0;
			int n=in.nextInt();
			int m=in.nextInt();
			for(int i=1;i<=n;i++) {
				for(int j=0;j<Math.min(i, m);j++) {
					if(c(i,j)%k==0) {
						sum++;
					}
					if(sum==1000000007) {
						sum=0;
					}
				}
			}
			System.out.println(sum);
		}
	}
	public static double c(double i,double j) {
		if(j==0) {
			return 1;
		}
		return i/j*c(i-1,j-1);
	}
}
