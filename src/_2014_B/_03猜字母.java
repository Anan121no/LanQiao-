package _2014_B;

import java.util.Arrays;

/*
 * ��Ŀ����
��ĸa��s��һ��19���������ظ�ƴ�ӣ�ƴ��106�Σ�ƴ��һ��2014���Ĵ�����
������ɾ����1����ĸ������ͷ����ĸa�����Լ���3������5����ȫ������λ�õ���ĸ��
��õ��´��ٽ���ɾ������λ����ĸ�Ķ����������ȥ�����ֻʣ��һ����ĸ����д������ĸ��
 */
public class _03����ĸ {
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
