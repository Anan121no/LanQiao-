package A13;

import java.util.Scanner;
import java.util.function.ToIntFunction;

/*全排列
 * 问题描述
100 可以表示为带分数的形式：100 = 3 + 69258 / 714。
还可以表示为：100 = 82 + 3546 / 197。
注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
类似这样的带分数，100 有 11 种表示法。
输入格式
从标准输入读入一个正整数N (N<1000*1000)
输出格式
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！
样例输入1
100
样例输出1
11
样例输入2
105
样例输出2
6
 */
public class _08带分数_同B09 {
	static int[] arr = {1,2,3,4,5,6,7,8,9};
	static int ans;
	private static int N;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		f(0);
		System.out.println(ans);
	}
	//确认某一个排列的第几位
	private static void f(int k) {
		// TODO Auto-generated method stub
		if (k==9) {
			check(arr);
			return;
		}
		//选定第K为
		for (int i = k; i < arr.length; i++) {
			//将第i位和第k位交换
			int t = arr[i];
			arr[i] = arr[k];
			arr[k] = t;
		//移交下一层去确认K+1
		f(k+1);
		//回溯
		t = arr[i];
		arr[i] = arr[k];
		arr[k] = t;
		}
	}
	//符号位置
	private static void check(int[] arr) {
		for (int i = 0; i < 8; i++) {
			int num1 = ToInt(arr,0,i);//”+“前面的一段整数
			if (num1>N) {
				continue;
			}//"+"的数额超过了N，就无须验算
			for (int j = 1; j < 9-i; j++) {
				int num2 = ToInt(arr, i, j);
				int num3 = ToInt(arr, i+j, 9-i-j);
				if (num2%num3==0&&num1+num2/num3==N) {
					ans++;
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	private static int ToInt(int[] arr, int pos, int len) {
		int t = 1;
		int ans = 0;
		for (int i = pos + len - 1; i >= pos; i--) {
			ans+=arr[i]*t;
			t*=10;
		}
		return ans;
		// TODO Auto-generated method stub
		
	}
}
