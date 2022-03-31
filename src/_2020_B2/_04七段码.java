package _2020_B2;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * С��Ҫ���߶������������ʾһ����������֡�
��ͼ�������߶�������ܵ�һ��ͼʾ���������һ���� 7 �ο��Է���Ķ����ܣ��ֱ���Ϊ a, b, c, d, e, f, g��
С��Ҫѡ��һ���ֶ����ܣ�����Ҫ��һ��������������ַ���������ַ��ı��ʱ��Ҫ�����з���Ķ�����������һƬ�ġ�
���磺 b ���⣬���������ܲ���������������һ���ַ���
���磺 c ���⣬���������ܲ���������������һ���ַ������� �������� һ�еķ�������������ʾ��ͬ���ַ������ܿ���ȥ�Ƚ����ơ�
���磺 a, b, c, d, e ���⣬ f, g ����������������һ���ַ���
���磺 b, f ���⣬���������ܲ����������������һ���ַ�����Ϊ���� �Ķ�����û������һƬ��
���ʣ�С���������߶�������ܱ������ֲ�ͬ���ַ���
�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�
���˴𰸣�80
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _04�߶��� {
	static ArrayList<Integer>[] list;
	static HashSet<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) {
		init();
		for(int i=0; i<7; ++i) {
			vis[0] = i; 
			set.add(1<<i);
			dfs(1, 1<<i);
		}
		System.out.println(set.size());
	}
	
	static int[] vis = new int[7];
	public static void dfs(int n, int v) {
		for(int i=0; i<n; ++i) {
			for(int t : list[vis[i]]) {
				int p = v|(1<<t);
				if(!set.contains(p)) {
					set.add(p);
					vis[n] = t;
					dfs(n+1, p);
				}
			}
		}
	}
	
	/**
	 *    		0
	 *  	5    	1
	 *  		6
	 *  	4		2
	 *  		3
	 */
	public static void init() {
		list = new ArrayList[7];
		for(int i=0; i<7; ++i) {
			list[i] = new ArrayList<Integer>();
		}
		
		list[0].add(1);
		list[0].add(5);
		
		list[1].add(0);
		list[1].add(6);
		list[1].add(2);
		
		list[2].add(1);
		list[2].add(3);
		list[2].add(6);
		
		list[3].add(2);
		list[3].add(4);
		
		list[4].add(3);
		list[4].add(5);
		list[4].add(6);
		
		list[5].add(0);
		list[5].add(4);
		list[5].add(6);
		
		list[6].add(1);
		list[6].add(2);
		list[6].add(4);
		list[6].add(5);
	}
}
