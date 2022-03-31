package _2021_B1;
/*
 * 下面的图形是著名的杨辉三角形：
  如果我们按从上到下、从左到右的顺序把所有数排成一列，可以得到如下数列：


  1 , 1 , 1 , 1 , 2 , 1 , 1 , 3 , 3 , 1 , 1 , 4 , 6 , 4 , 1 , ⋯ 1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1, \cdots1,1,1,1,2,1,1,3,3,1,1,4,6,4,1,⋯
  给定一个正整数 N NN，请你输出数列中第一次出现 N NN 是在第几个数？
Input：
6
Output：
13

 */
import java.util.Scanner;
public class _08杨辉三角 {
    public static void main(String[] args) { new _08杨辉三角().run(); }
    int N;
    void run() {
        N = new Scanner(System.in).nextInt();
        if (N == 1) System.out.println(1);
        else {
            long ans = (N + 1L) * N / 2 + 2;
            for (int m = 2; m < 16; m++) {
                int start = m * 2, end = N;
                while (start <= end) {
                    int mid = start + end >> 1;
                    if (C(mid, m) == N) {
                        ans = min(ans, (mid + 1L) * mid / 2 + m + 1);
                        break;
                    } if (C(mid, m) > N) end = mid - 1;
                    else start = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
    long min(long a, long b) { return a < b ? a : b; }
    long C(int n, int m) {
        long num = 1;
        for (int nm = 1; nm <= m; n--, nm++)
            if ((num = num * n / nm) > N) return num;
        return num;
    }
}

