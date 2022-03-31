package _2018_B;

import java.util.Random;

/*
 * 以下代码可以从数组a[]中找出第k小的元素。
它使用了类似快速排序中的分治算法，期望时间复杂度是O(N)的。
请仔细阅读分析源码，填写划线部分缺失的内容。
import java.util.Random;
public class Main{
public static int quickSelect(int a[], int l, int r, int k) {
Random rand = new Random();
int p = rand.nextInt(r - l + 1) + l;
int x = a[p];
int tmp = a[p]; a[p] = a[r]; a[r] = tmp;
int i = l, j = r;
while(i < j) {
while(i < j && a[i] < x) i++;
if(i < j) {
a[j] = a[i];
j–;
}
while(i < j && a[j] > x) j–;
if(i < j) {
a[i] = a[j];
i++;
}
}
a[i] = x;
p = i;
if(i - l + 1 == k) return a[i];
if(i - l + 1 < k) return quickSelect( _________________________________ ); //填空
else return quickSelect(a, l, i - 1, k);
}
public static void main(String args[]) {
int [] a = {1, 4, 2, 8, 5, 7};
System.out.println(quickSelect(a, 0, 5, 4));
}
}
注意：只提交划线部分缺少的代码，不要抄写任何已经存在的代码或符号。
解题思路
题目很简单 但是可以学习这个思路来解决 TOPK 问题
答案：a, l+1 , r ,k
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _05快速排序 {
	public static int quickSelect(int a[], int l, int r, int k) {
		Random rand = new Random();
		int p = rand.nextInt(r - l + 1) + l;
		int x = a[p];
		int tmp = a[p]; a[p] = a[r]; a[r] = tmp;
		int i = l, j = r;
		while(i < j) {
		while(i < j && a[i] < x) i++;
		if(i < j) {
		a[j] = a[i];
		j--;
		}
		while(i < j && a[j] > x) j--;
		if(i < j) {
		a[i] = a[j];
		i++;
		}
		}
		a[i] = x;
		p = i;
		if(i - l + 1 == k) return a[i];// (1)说明到底了
		if(i - l + 1 < k) return quickSelect(a, i + 1, r, k - i + l - 1); //填空   
		// qsort(a, i + 1, right);
        // (3)先试试k，
        // (4)再考虑：k要移动到等于（i - l + 1），试试k-(i - l + 1)
		else return quickSelect(a, l, i - 1, k);// (2)qsort(a, left, i -
        										// 1);对上了，k不变
		}
		public static void main(String args[]) {
		int [] a = {1, 4, 2, 8, 5, 7};
		System.out.println(quickSelect(a, 0, 5, 4));
		}
}
