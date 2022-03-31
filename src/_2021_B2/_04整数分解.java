package _2021_B2;

import java.util.Arrays;

/*
 * 将 3 33 分解成两个正整数的和，有两种分解方法，分别是 3 = 1 + 2 3 = 1 + 23=1+2 和 3 = 2 + 1 3 = 2 + 13=2+1。注意顺序不同算不同的方法。
  将 5 55 分解成三个正整数的和，有 6 66 种分解方法，它们是 1 + 1 + 3 = 1 + 2 + 2 = 1 + 3 + 1 = 2 + 1 + 2 = 2 + 2 + 1 = 3 + 1 + 1 1 + 1 + 3 = 1 + 2 + 2 = 1 + 3 + 1 = 2 + 1 + 2 = 2 + 2 + 1 = 3 + 1 + 11+1+3=1+2+2=1+3+1=2+1+2=2+2+1=3+1+1。
  请问，将 2021 20212021 分解成五个正整数的和，有多少种分解方法？

答案提交

  这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

691677274345
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/121003236
 */
public class _04整数分解 {
	public static void main(String[] args) {
		 new _04整数分解().run(); 
		 new _04整数分解().run2();
		 new _04整数分解().run3();}
//排列组合
    int n = 2021;

    void run() {
        long ans = 0;
        for (int k = 1, a, b; k <= n - 2 - 2; k++) {
            for (a = 2, b = n - 2 - k; b >= 2; a++, b--)
                ans += (a - 1) * (b - 1);
        }
        System.out.println(ans);
	}
    //排列组合公式版
    long m = 2021;

    void run2() {
        System.out.println((m - 1) * (m - 2) * (m - 3) * (m - 4) / 4 / 3 / 2);
    }
    
    //动归。。。看链接https://blog.csdn.net/qq_43449564/article/details/121003236
    

    void run3() {
    	int n = 2021, k = 5;
        long[][] dp = new long[k + 1][n + 1];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= k; i++)
            for (int j = i; j <= n; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        System.out.println(dp[k][n]);
    }
}
