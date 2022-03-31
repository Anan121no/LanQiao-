package _2021_C2;

import java.util.Scanner;

/*
 * 题目： 一个整数 a 是一个完全平方数，是指它是某一个整数的平方，
 * 即存在一个整数 b，使得 $ a = b^2 $。给定一个正整数 n，
 * 请找到最小的正整数 x，使得它们的乘积是一个完全平方数。

【输入格式】
输入一行包含一个整数 n。

【输出格式】
输出找到的最小的正整数 x。

【样例输入】
12
【样例输出】
3
【样例输入】
15
【样例输出】
15
【评测用例规模与约定】 对于 30% 的评测用例，1 ≤ n ≤ 1000，答案不超过 1000。

对于 60% 的评测用例，1 ≤ n ≤ 108，答案不超过 $ 10^8 。

对于所有评测用例，1 ≤ n ≤ 1012，答案不超过 $ 10^{12} 。
————————————————
版权声明：本文为CSDN博主「dem.o」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45800978/article/details/116724283
 */
public class _08完全平方数 {
	public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
       long k = cin.nextLong() ;
       long num;
        for (double i = 1; i <=k ; i++) {
            num = (long) Math.sqrt((long) i*k);
            if (num*num==i*k){
                System.out.println((int)i);
                System.out.println(num);
                break;
            }
        }
    }
}
