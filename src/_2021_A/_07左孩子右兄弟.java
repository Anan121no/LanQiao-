package _2021_A;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 对于一棵多叉树，我们可以通过 “左孩子右兄弟” 表示法，将其转化成一棵二叉树。如果我们认为每个结点的子结点是无序的，那么得到的二叉树可能不唯一。换句话说，每个结点可以选任意子结点作为左孩子，并按任意顺序连接右兄弟。
给定一棵包含 N 个结点的多叉树，结点从 1 至 N 编号，其中 1 号结点是根，每个结点的父结点的编号比自己的编号小。请你计算其通过 “左孩子右兄弟” 表示法转化成的二叉树，高度最高是多少。注：只有根结点这一个结点的树高度为 0 。
例如如下的多叉树：


可能有以下 3 种 (这里只列出 3 种，并不是全部) 不同的 “左孩子右兄弟”
表示：


其中最后一种高度最高，为 4。
【输入格式】
输入的第一行包含一个整数 N。
以下 N −1 行，每行包含一个整数，依次表示 2 至 N 号结点的父结点编号。
【输出格式】
输出一个整数表示答案。
【样例输入】
5
1
1
1
2
【样例输出】
4
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
public class _07左孩子右兄弟 {
	static ArrayList<Integer>[] list;
	static int n, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		list = new ArrayList[n + 10];
		for (int i = 0; i < list.length; ++i)
			list[i] = new ArrayList<Integer>();

		for (int i = 2; i <= n; ++i) {
			int t = sc.nextInt();
			list[t].add(i);
		}

		ans = 0;
		dfs(0, 1);
		System.out.println(ans);
	}

	public static void dfs(int total, int father) {
		int size = list[father].size();
		if (size == 0) {
			ans = Math.max(ans, total);
			return;
		}
		for (int p : list[father]) {
			dfs(total + size, p);
		}
	}
//————————————————
//版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
}
