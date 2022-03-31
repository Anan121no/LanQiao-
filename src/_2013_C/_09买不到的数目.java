package _2013_C;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。
    小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。
    你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。
    本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。
输入：
两个正整数，表示每种包装中糖的颗数(都不多于1000)
要求输出：
一个正整数，表示最大不能买到的糖数
不需要考虑无解的情况
例如：
用户输入：
4 7
程序应该输出：
17
再例如：
用户输入：
3 5
程序应该输出：
7
 */
public class _09买不到的数目 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		solve(a, b);
		enumeration(a, b);
	}
	//公式法
	static private void solve(int a,int b) {
		// TODO Auto-generated method stub
		int res = a*b-a-b;
		System.out.println(res);
	}
	//枚举法
	static private void enumeration(int a,int b) {
		// TODO Auto-generated method stub
		int max = a*b;
		Set<Integer> ss = new HashSet<Integer>();
		for (int i = 0; a*i < max; i++) {
			for (int j = 0; a*i+b*j < max; j++) {
				ss.add(a*i+b*j);
			}
		}
		for (int i = max-1; i >= 0; i--) {
			if (!ss.contains(i)) {
				System.out.println(i);
				break;
			}
		}
	}
}
