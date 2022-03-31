package _2017_B;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 给定一个长度为N的数列，A1, A2, ... AN，
 * 如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数，我们就称这个区间[i, j]是K倍区间。  
你能求出数列中总共有多少个K倍区间吗？  
输入
-----
第一行包含两个整数N和K。(1 <= N, K <= 100000)  
以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)  
输出
-----
输出一个整数，代表K倍区间的数目。  
例如，
输入：
5 2
1  
2  
3  
4  
5  
程序应该输出：
6
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
先来一发普通的前缀和暴力代码，接着来个优化，2个for过不了10W数据呢
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/87976875
 */

public class _10k倍区间 {
	static Map<Integer, Long> cnt = new HashMap<Integer, Long>();
	private static int[] a;
	private static int[] s;	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] sum = new int[n+1];
//		for(int i=1;i<=n;i++)
//			sum[i] = sum[i-1] + in.nextInt();
		//取余法
		a = new int[n];
		s = new int[k];
		s[0] = 0;
		cnt.put(0,  1L);
		for (int i = 0; i < n; i++) {
			if(i==0)	a[i] = in.nextInt()%k;
			else		a[i] = (a[i-1] + in.nextInt())%k;
			s[a[i]]++;
		}
		long ans = 0;
		for (int i = 0; i < k; i++) {
			ans += (long)s[i]*(s[i]-1)/2;
		}
		ans += s[0];
		System.out.println(ans);
		
//		System.out.println(viosolve(n,k,sum));
	}

	private static int viosolve(int n, int k, int[] sum) {
		// TODO Auto-generated method stub
		int ans = 0;
		for(int i=1;i<=n;i++) 
			for(int j=0;j+i<=n;j++)
				if((sum[j+i]-sum[j])%k==0)
					ans++;
		return ans;	
	}
}
