package _2016_C;

import java.util.Scanner;

/*
 * X星球的考古学家发现了一批古代留下来的密码。
这些密码是由A、B、C、D 四种植物的种子串成的序列。
仔细分析发现，这些密码串当初应该是前后对称的（也就是我们说的镜像串）。
由于年代久远，其中许多种子脱落了，因而可能会失去镜像的特征。
你的任务是：
给定一个现在看到的密码串，计算一下从当初的状态，它要至少脱落多少个种子，才可能会变成现在的样子。
输入一行，表示现在看到的密码串（长度不大于1000）
要求输出一个正整数，表示至少脱落了多少个种子。
例如，输入：
ABCBA
则程序应该输出：
0
再例如，输入：
ABDCDCBABC
则程序应该输出：
3
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108925934
 */
public class _10密码脱落 {
	//https://www.acwing.com/problem/content/solution/1224/1/ 还不会
	static int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int n = s.length();
        for(int len = 1;len <= n;len ++)
        {
            for(int i = 0;i + len - 1 < n;i ++)
            {
                int j = i + len - 1;

                if(len == 1) f[i][j] = 1;
                else
                {
                    f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
                    if(s.charAt(i) == s.charAt(j)) f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        System.out.println(n - f[0][n - 1]);
    }
}
