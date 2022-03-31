package _2020_B2;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 小蓝要用七段码数码管来表示一种特殊的文字。
上图给出了七段码数码管的一个图示，数码管中一共有 7 段可以发光的二极管，分别标记为 a, b, c, d, e, f, g。
小蓝要选择一部分二极管（至少要有一个）发光来表达字符。在设计字符的表达时，要求所有发光的二极管是连成一片的。
例如： b 发光，其他二极管不发光可以用来表达一种字符。
例如： c 发光，其他二极管不发光可以用来表达一种字符。这种 方案与上 一行的方案可以用来表示不同的字符，尽管看上去比较相似。
例如： a, b, c, d, e 发光， f, g 不发光可以用来表达一种字符。
例如： b, f 发光，其他二极管不发光则不能用来表达一种字符，因为发光 的二极管没有连成一片。
请问，小蓝可以用七段码数码管表达多少种不同的字符？
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
个人答案：80
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _04七段码 {
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
