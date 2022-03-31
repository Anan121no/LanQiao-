package _2020_B1;

import java.io.*;

/*
 * 小明正在做一个网络实验。
他设置了 n 台电脑，称为节点，用于收发和存储数据。
初始时，所有节点都是独立的，不存在任何连接。
小明可以通过网线将两个节点连接起来，连接后两个节点就可以互相通信
了。两个节点如果存在网线连接，称为相邻。
小明有时会测试当时的网络，他会在某个节点发送一条信息，信息会发送
到每个相邻的节点，之后这些节点又会转发到自己相邻的节点，直到所有直接
或间接相邻的节点都收到了信息。所有发送和接收的节点都会将信息存储下来。
一条信息只存储一次。
给出小明连接和测试的过程，请计算出每个节点存储信息的大小。

输入格式

输入的第一行包含两个整数 n, m，分别表示节点数量和操作数量。节点从
1 至 n 编号。
接下来 m 行，每行三个整数，表示一个操作。
如果操作为 1 a b，表示将节点 a 和节点 b 通过网线连接起来。当 a = b
时，表示连接了一个自环，对网络没有实质影响。
如果操作为 2 p t，表示在节点 p 上发送一条大小为 t 的信息。

输出格式

输出一行，包含 n 个整数，相邻整数之间用一个空格分割，依次表示进行
完上述操作后节点 1 至节点 n 上存储信息的大小。

测试样例1

Input：
4 8
1 1 2
2 1 10
2 3 5
1 4 1
2 2 2
1 1 2
1 2 4
2 2 1

Output：
13 13 5 3
评测用例规模与约定

对于 30% 的评测用例，1 ≤ n ≤ 20，1 ≤ m ≤ 100。
对于 50% 的评测用例，1 ≤ n ≤ 100，1 ≤ m ≤ 1000。
对于 70% 的评测用例，1 ≤ n ≤ 1000，1 ≤ m ≤ 10000。
对于所有评测用例，1 ≤ n ≤ 10000，1 ≤ m ≤ 100000，1 ≤ t ≤ 100。
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _10网络分析 {
static int[] link, lazy, value;
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		in.nextToken();
		int n = (int)in.nval;
		in.nextToken();
		int m = (int)in.nval;
		value = new int[n + 1];
		lazy = new int[n + 1];
		link = new int[n + 1];
		for (int i = 1; i <= n; i++) link[i] = i;
		while (m-- > 0) {
			in.nextToken();
			int i = (int)in.nval;
			in.nextToken();
			int v = (int)in.nval;
			in.nextToken();
			int w = (int)in.nval;
			if (i == 1) {
				v = find(v);
				w = find(w);
				if (v != w) {
					link[v] = w;
					lazy[v] = value[v] - value[w];
				}
			} else value[find(v)] += w;
		}
		for (int i = 1; i <= n; i++)
			out.print((value[find(i)] + lazy[i]) + " ");
		out.close();
	}
	
	static int find(int x) {
		if (link[x] != x) {
			int t = link[x];
			link[x] = find(link[x]);
			lazy[x] += lazy[t];
		}
		return link[x];
	}
}
