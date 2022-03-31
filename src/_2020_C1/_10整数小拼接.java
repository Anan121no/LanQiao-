package _2020_C1;

import java.util.Scanner;

/*
 * 给定义个长度为 n nn 的数组 A 1 , A 2 , ⋅ ⋅ ⋅ , A n A_1, A_2, · · · , A_nA 
1
​
 ,A 
2
​
 ,⋅⋅⋅,A 
n
​
 。你可以从中选出两个数 A i A_iA 
i
​
  和 A j A_jA 
j
​
 
(i ii 不等于 j jj)，然后将 A i A_iA 
i
​
  和 A j A_jA 
j
​
  一前一后拼成一个新的整数。例如 12 和 345 可
以拼成 12345 或 34512 。注意交换 A i A_iA 
i
​
  和 A j A_jA 
j
​
  的顺序总是被视为 2 种拼法，即便
是 A i A_iA 
i
​
  = A j A_jA 
j
​
  时。
请你计算有多少种拼法满足拼出的整数小于等于 K KK。

输入格式

第一行包含 2 22 个整数 n nn 和 K KK。
第二行包含 n nn 个整数 A 1 , A 2 , ⋅ ⋅ ⋅ , A n A_1, A_2, · · · , A_nA 
1
​
 ,A 
2
​
 ,⋅⋅⋅,A 
n
​
 。
输出格式
一个整数代表答案。
测试样例1
Input：
4 33
1 2 3 4
Output：
8
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _10整数小拼接 {

static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr [] = new int [n];
		int K =sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				String temp1 = (""+arr[i]+arr[j]);
				String temp2 = (""+arr[j]+arr[i]);
				if (Integer.parseInt(temp1)<=K) {
					//System.out.print(temp1+" ");
					count++;
				}
				if (Integer.parseInt(temp2)<=K) {
					//System.out.print(temp2+" ");
					count++;
				}
			}
		}
		System.out.println(count);
	}
//————————————————
//版权声明：本文为CSDN博主「4444l」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_59816727/article/details/123338513
}
