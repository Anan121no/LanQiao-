package _2021_B1;
import java.util.Scanner;
/*
 * 你有一架天平。现在你要设计一套砝码，使得利用这些砝码可以称出任意小于等于 N NN 的正整数重量。
  那么这套砝码最少需要包含多少个砝码？
  注意砝码可以放在天平两边。
Input：
7
Output：
3
Explanation：
3 个砝码重量是 1、4、6，可以称出 1 至 7 的所有重量。
1 = 1；
2 = 6 − 4 (天平一边放 6，另一边放 4)；
3 = 4 − 1；
4 = 4；
5 = 6 − 1；
6 = 6；
7 = 1 + 6；
少于 3 个砝码不可能称出 1 至 7 的所有重量。
 */
public class _07砝码 {
    public static void main(String[] args) { new _07砝码().run(); }
    void run() {
        long N = new Scanner(System.in).nextLong(), ans = 1;
        for (long pow3 = 1; pow3 < N; pow3 = pow3 * 3 + 1, ans++);
        System.out.println(ans);
    }
}

