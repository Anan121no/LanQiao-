package _2019_B;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 给定 N 个加号、M 个减号以及 N + M + 1 个整数 A1, A2, · · · , AN+M+1，小
明想知道在所有由这 N 个加号、M 个减号以及 N + M + 1 个整数凑出的合法的
后缀表达式中，结果最大的是哪一个？
请你输出这个最大的结果。
例如使用1 2 3 + -，则 “2 3 + 1 -” 这个后缀表达式结果是 4，是最大的。
【输入格式】
第一行包含两个整数 N 和 M。
第二行包含 N + M + 1 个整数 A1, A2, · · · , AN+M+1。
【输出格式】
输出一个整数，代表答案。
【样例输入】
1 1
1 2 3
【样例输出】
4
【评测用例规模与约定】
对于所有评测用例，0 ≤ N, M ≤ 100000，−109 ≤ Ai ≤ 109。

解题思路
只有加减法，将输入的所有数进行排序然后先加后减。（由于算法太过简单又是作为倒数第二题，不敢相信是正确的）
————————————————
版权声明：本文为CSDN博主「非洲的小白」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _09后缀表达式 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		int n = reader.nextInt();
		int m = reader.nextInt();
		int nm = n+m+1;
		int a[] = new int[nm];
		int sum = 0;
		for(int i=0; i<nm; i++)
			a[i] = reader.nextInt();
		
		Arrays.sort(a);
		for(int i=0,j=n+m; i<=n; i++,j--){
			sum+=a[j];
		}
		for(int i=0,j=m-1; i<m; i++,j--){
			sum-=a[j];
		}
		System.out.println(sum);
	}
}
