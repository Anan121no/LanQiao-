package _2021_B2;

import java.util.Scanner;

/*
 * 小蓝发现，对于一个正整数 n 和一个小于 n 的正整数 v，将 v 平方后对 n取余可能小于 n 的一半，
 * 也可能大于等于 n的一半。请问，在 1 到 n − 1 中，有多少个数平方后除以 n 的余数小于 n 的一半。
 * 例如，当 n = 4 时，1, 2, 3的平方除以 4 的余数都小于 4 的一半。
 * 又如，当 n = 5 时，1, 4 的平方除以 5 的余数都是 1，小于 5 的一半。
 * 而2, 3的平方除以 5 的余数都是 4，大于等于 5 的一半。
【输入格式】
输入一行包含一个整数 n。
【输出格式】
输出一个整数，表示满足条件的数的数量。
【样例输入】
5
【样例输出】
2
【评测用例规模与约定】 对于所有评测用例，1 ≤ n ≤ 10000。
解题思路
数据<10000，用int应该可以了。
————————————————
版权声明：本文为CSDN博主「dem.o」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45800978/article/details/116724283
 */
public class _07小平方 {
	static int ans = 0;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int k = cin.nextInt();
        for (int i = 1; i < k; i++) {
            if ((i*i)%k<(k/2)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
