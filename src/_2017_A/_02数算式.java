package _2017_A;

import java.util.HashSet;
import java.util.Set;

/*
 * �۲����µ���ʽ��
9213 x 85674 = 789314562
��ߵĳ����ͱ����������õ���1~9���������֣�ÿ��1�Ρ�
���˻�ǡ��Ҳ���õ���1~9���������֣�����ÿ��1�Ρ�
��������������ǿ������������ҳ���������Ҫ���9����ʽһ���ж��ٸ���
ע�⣺
1. ����Ŀ������Ŀ�������Ǹ�ʾ����
2. �����ͱ�������������Ϊͬһ������������
��:1625,ȫ��+ö�ٳ˺�λ��+��ϣ���أ�x*y�в��ܳ���0!!!!!
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _02����ʽ {
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
