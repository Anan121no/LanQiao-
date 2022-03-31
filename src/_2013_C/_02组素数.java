package _2013_C;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 问题描述：
素数就是不能再进行等分的数。比如：2 3 5 7 11 等。
9 = 3 * 3 说明它可以3等分，因而不是素数。
我们国家在1949年建国。如果只给你 1 9 4 9 这4个数字卡片，
可以随意摆放它们的先后顺序（但卡片不能倒着摆放啊，我们不是在脑筋急转弯！），
那么，你能组成多少个4位的素数呢？
* 输入描述：
* 程序输出：　　　　比如：1949，4919 都符合要求。
 */
public class _02组素数 {
	static void f(int [] arr,int k) {
		if (k==4) {
			Check(arr);
//			System.out.println(Arrays.toString(arr));
		}
		for (int i = k; i < 4; i++) {
			int t = arr[k];
			arr[k]=arr[i];
			arr[i]=t;
			f(arr, k+1);
			t = arr[k];
			arr[k]=arr[i];
			arr[i]=t;
		}
	}
	static Set<Integer> set = new HashSet<Integer>();
	static private void Check(int[] arr) {
		boolean flag = true;
		// TODO Auto-generated method stub
		int x = arr[0]*1000+arr[1]*100+arr[2]*10+arr[3];
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x%i==0) {
				flag = false;
//				System.out.println(x+"f");
				break;
			}
		}
		if (flag) {
			set.add(x);
//			System.out.println(x+"t");
		}
	}
	public static void main(String[] args) {
		int []arr= {1,4,9,9};
		f(arr, 0);
//		System.out.println(set);
		System.out.println(set.size());
	}
}
