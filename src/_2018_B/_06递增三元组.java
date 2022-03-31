package _2018_B;

import java.util.Scanner;

/*
 * 给定三个整数数组
A = [A1, A2, … AN],
B = [B1, B2, … BN],
C = [C1, C2, … CN]，
请你统计有多少个三元组(i, j, k) 满足：
1 <= i, j, k <= N
Ai < Bj < Ck
【输入格式】
第一行包含一个整数N。
第二行包含N个整数A1, A2, … AN。
第三行包含N个整数B1, B2, … BN。
第四行包含N个整数C1, C2, … CN。
对于30%的数据，1 <= N <= 100
对于60%的数据，1 <= N <= 1000
对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
【输出格式】
一个整数表示答案
【输入样例】
3
1 1 1
2 2 2
3 3 3
【输出样例】
27
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
解题思路
暴力枚举 枚举优化来降低 时间复杂度
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _06递增三元组 {
	public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];
        int [] c = new int[n];

        for (int i = 0; i <n ; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            c[i] = sc.nextInt();
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(n>=b[j]&&b[j]>a[i])
                for (int k = 0; k <n ; k++) {
                    if(n>=c[k]&&c[k]>b[j]){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
