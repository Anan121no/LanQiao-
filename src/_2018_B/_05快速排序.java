package _2018_B;

import java.util.Random;

/*
 * ���´�����Դ�����a[]���ҳ���kС��Ԫ�ء�
��ʹ�������ƿ��������еķ����㷨������ʱ�临�Ӷ���O(N)�ġ�
����ϸ�Ķ�����Դ�룬��д���߲���ȱʧ�����ݡ�
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
j�C;
}
while(i < j && a[j] > x) j�C;
if(i < j) {
a[i] = a[j];
i++;
}
}
a[i] = x;
p = i;
if(i - l + 1 == k) return a[i];
if(i - l + 1 < k) return quickSelect( _________________________________ ); //���
else return quickSelect(a, l, i - 1, k);
}
public static void main(String args[]) {
int [] a = {1, 4, 2, 8, 5, 7};
System.out.println(quickSelect(a, 0, 5, 4));
}
}
ע�⣺ֻ�ύ���߲���ȱ�ٵĴ��룬��Ҫ��д�κ��Ѿ����ڵĴ������š�
����˼·
��Ŀ�ܼ� ���ǿ���ѧϰ���˼·����� TOPK ����
�𰸣�a, l+1 , r ,k
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _05�������� {
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
		if(i - l + 1 == k) return a[i];// (1)˵��������
		if(i - l + 1 < k) return quickSelect(a, i + 1, r, k - i + l - 1); //���   
		// qsort(a, i + 1, right);
        // (3)������k��
        // (4)�ٿ��ǣ�kҪ�ƶ������ڣ�i - l + 1��������k-(i - l + 1)
		else return quickSelect(a, l, i - 1, k);// (2)qsort(a, left, i -
        										// 1);�����ˣ�k����
		}
		public static void main(String args[]) {
		int [] a = {1, 4, 2, 8, 5, 7};
		System.out.println(quickSelect(a, 0, 5, 4));
		}
}
