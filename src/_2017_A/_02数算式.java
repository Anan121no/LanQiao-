package _2017_A;

import java.util.HashSet;
import java.util.Set;

/*
 * 观察如下的算式：
9213 x 85674 = 789314562
左边的乘数和被乘数正好用到了1~9的所有数字，每个1次。
而乘积恰好也是用到了1~9的所有数字，并且每个1次。
请你借助计算机的强大计算能力，找出满足如上要求的9数算式一共有多少个？
注意：
1. 总数目包含题目给出的那个示例。
2. 乘数和被乘数交换后作为同一方案来看待。
答案:1625,全排+枚举乘号位置+哈希查重，x*y中不能出现0!!!!!
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _02数算式 {
	private static int ans = 0;
	static HashSet<String> set = new HashSet<>();
	private static int[] a = new int[] {1,2,3,4,5,6,7,8,9};
	private static int count;
	public static void main(String[] args) {
//		dfs(0);
		f(0);
//		System.out.println(ans);
		System.out.println(count/2);
	}
	private static void f(int k) {
		// TODO Auto-generated method stub
		if (k==9) {
		for (int i = 1; i < 9; i++) {
			int x1 = a2i(0,i);
			int x2 = a2i(i,9);
			int x= x1*x2;
			if(check(x))count++;
			}
		}
		for (int i = k; i < 9; i++) {
			swap(i, k);
			f(k+1);
			swap(i, k);
		}
	}
	private static boolean check(int x) {
		// TODO Auto-generated method stub
		String s = x+"";
		if (s.length()!=9||s.indexOf('0')>-1) {
			return false;
		}
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		return set.size()==9;
	}
	private static int a2i(int i, int j) {
		// TODO Auto-generated method stub
		int ans = 0;
			int p = 1;
		for (int k = j-1; k >=i; k--) {
			ans+=a[k]*p;
			p*=10;
		}
		return ans;
	}
	private static void dfs(int m) {
		// TODO Auto-generated method stub
		if (m>=9) {
			for (int i = 1; i < 8; i++) {
				int x = 0,y = 0;
				for (int j = 0; j < i; j++) 
					x = 10*x + a[j];
				for (int j = i; j < 9; j++) 
					y = 10*y + a [j];
				String s = ""+x*y;
				if (ok(s)) {
					String v = x+"x"+y;
					String u = y+"x"+x;
					if (!set.contains(v)&&!set.contains(u)) {
						set.add(u);
						set.add(v);
						ans++;
					}
				}
			}
			return;
		}
		for (int i = m; i < 9; i++) {
			swap(i,m);
			dfs(m+1);
			swap(i,m);
		}
	}
	private static boolean ok(String s) {
		// TODO Auto-generated method stub
		if(s.length()!=9||s.indexOf("0")>=0)
			return false;
		int []b = new int [10];
		for (int i = 0; i < s.length(); i++) {
			if(b[s.charAt(i)-'0']==1)
				return false;
			else 
				b[s.charAt(i)-'0']=1;
		}
		return true;
	}
	static void swap(int i, int j) {

		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}
}
