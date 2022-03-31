package _2020_B1;

import java.io.*;

/*
 * 给定正整数 n nn, 求 1 8 + 2 8 + ⋅ ⋅ ⋅ + n 8 1^8 + 2^8 + · · · + n^81 
8
 +2 
8
 +⋅⋅⋅+n 
8
  mod 123456789 。其中 mod 表示取余。

输入格式

输入的第一行包含一个整数 n。

输出格式

输出一行，包含一个整数，表示答案

测试样例1
Input：
2
Output：
257
测试样例2
Input：
987654
Output：
43636805
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _07八次求和 {
	static final int mod = 123456789;

    public static void main(String[] args) throws IOException {
        long n = nextInt(System.in), cnt = 0;
        for (long i = 1, k = 1; i <= n; k = ++i) {
            for (int j = 0; j < 3; j++)
                k = (k * k) % mod;
            cnt = (cnt + k) % mod;
        }
        System.out.print(cnt);
    }

    static int nextInt(InputStream in) throws IOException {
        int n = 0, c = in.read();
        while (c < '0' || c > '9') c = in.read();
        while (c >='0' && c <='9') {
            n = n * 10 + (c & 0xf);
            c = in.read();
        }
        return n;
    }
}
