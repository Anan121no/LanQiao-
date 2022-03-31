package _2017_B;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * ����һ������ΪN�����У�A1, A2, ... AN��
 * �������һ��������������Ai, Ai+1, ... Aj(i <= j)֮����K�ı��������Ǿͳ��������[i, j]��K�����䡣  
��������������ܹ��ж��ٸ�K��������  
����
-----
��һ�а�����������N��K��(1 <= N, K <= 100000)  
����N��ÿ�а���һ������Ai��(1 <= Ai <= 100000)  
���
-----
���һ������������K���������Ŀ��  
���磬
���룺
5 2
1  
2  
3  
4  
5  
����Ӧ�������
6
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
����һ����ͨ��ǰ׺�ͱ������룬���������Ż���2��for������10W������
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/87976875
 */

public class _10k������ {
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
		//ȡ�෨
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
