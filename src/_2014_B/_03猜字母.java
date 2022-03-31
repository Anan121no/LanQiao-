package _2014_B;

import java.util.Arrays;

/*
 * 题目概述
字母a到s，一共19个，不断重复拼接，拼接106次，拼成一个2014长的串串。
接下来删除第1个字母（即开头的字母a），以及第3个，第5个等全部奇数位置的字母。
获得的新串再进行删除奇数位置字母的动做。如此下去，最后只剩下一个字母，请写出该字母。
 */
public class _03猜字母 {
	public static void main(String[] args) {
		int arr[] = new int[2014];
		int a[] = new int[arr.length/2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		int c = del(arr);
		c = c%19;
		char[] d = new char[19];
		for (int i = 0; i < 19; i++) {
			d[i] = (char) ('a' + i);
		}
		System.out.println(d[c-1]);
	}

	private static int del(int[] arr) {
		if (arr.length==2) {
			return arr[1];
		}
		int nl;
		if ((arr.length&1)==1) {
			nl = arr.length/2+1;
		}else {
			nl = arr.length/2;
		}
//		int b[] = new int[arr.length/2];
//		b = Arrays.copyOf(arr, arr.length/2);
		int a[] = new int[nl];
		for (int i = 1; i < nl; i++) {
			a[i] = arr[i*2];
		}
		return del(a);
	}
}
