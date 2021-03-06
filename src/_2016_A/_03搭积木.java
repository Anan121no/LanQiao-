package _2016_A;

import java.util.HashSet;

/*
 * 小明最近喜欢搭数字积木，
一共有10块积木，每个积木上有一个数字，0~9。
搭积木规则：
每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
最后搭成4层的金字塔形，必须用完所有的积木。
下面是两种合格的搭法：
   0
  1 2
 3 4 5
6 7 8 9
   0
  3 1
 7 5 2
9 8 6 4    
请你计算这样的搭法一共有多少种？
请填表示总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
答案:978,写个全排,把限制条件,变成剪枝,逻辑更清楚
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _03搭积木 {
	public static void main(String[] args) {
		dfs(0);
		System.out.println(ans);
	}
	static HashSet<String> set = new HashSet<>();
	static int[] a = new int[] {0,1,2,3,4,5,6,7,8,9};
	static int ans=0;
	static void dfs(int m) {
		if(m>=10) {
			if(a[0]>=a[1]||a[0]>=a[2])
				return;
			if(a[1]>=a[3]||a[1]>=a[3])
				return;			
			if(a[2]>=a[4]||a[2]>=a[5])
				return;			
			if(a[3]>=a[6]||a[3]>=a[7])
				return;	
			if(a[4]>=a[7]||a[4]>=a[8])
				return;	
			if(a[5]>=a[8]||a[5]>=a[9])
				return;	
			String s="";
			for(int i=0;i<10;i++) {
				s+=a[i];
//				System.out.print(a[i]+" ");
			}
//			System.out.println();
//			if(!set.contains(s)) {
//				set.add(s);
//				ans++;
//			}
			ans++;
			return;
		}
		
		for(int i=m;i<10;i++) {
			swap(m,i);
			dfs(m+1);
			swap(m,i);
		}
		
	}
 
	static void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
