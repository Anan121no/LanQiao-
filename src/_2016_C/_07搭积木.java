package _2016_C;

import java.util.HashSet;

/*
 * С�����ϲ�������ֻ�ľ��
һ����10���ľ��ÿ����ľ����һ�����֣�0~9��
���ľ����
ÿ����ľ�ŵ�����������ľ�����棬����һ���������������ľ����С��
�����4��Ľ������Σ������������еĻ�ľ��
���������ֺϸ�Ĵ��
   0
  1 2
 3 4 5
6 7 8 9
   0
  3 1
 7 5 2
9 8 6 4    
������������Ĵһ���ж����֣�
�����ʾ����Ŀ�����֡�
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
��:978,д��ȫ��,����������,��ɼ�֦,�߼������
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _07���ľ {
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
