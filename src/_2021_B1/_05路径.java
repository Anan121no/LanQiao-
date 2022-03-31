package _2021_B1;

import java.util.Arrays;

/*
 * 小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图
中的最短路径。
小蓝的图由 2021 个结点组成，依次编号 1 至 2021。
对于两个不同的结点 a, b，如果 a 和 b 的差的绝对值大于 21，则两个结点
之间没有边相连；如果 a 和 b 的差的绝对值小于等于 21，则两个点之间有一条
长度为 a 和 b 的最小公倍数的无向边相连。
例如：结点 1 和结点 23 之间没有边相连；结点 3 和结点 24 之间有一条无
向边，长度为 24；结点 15 和结点 25 之间有一条无向边，长度为 75。
请计算，结点 1 和结点 2021 之间的最短路径长度是多少。
提示：建议使用计算机编程解决问题。

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

个人答案：10266837
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
public class _05路径 {
	//动归
	public static void main(String[] args) {
        long[] dp = new long[2022 + 5];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i <= 2021; ++i) {
            for (int j = 1; j <= 21; ++j) {
                if (i - j <= 0) break;
                dp[i] = Math.min(dp[i], dp[i - j] + lcm(i, i - j));
            }
        }
        System.out.println(dp[2021]);
    }
    
    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
    
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
//————————————————
//版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
}
