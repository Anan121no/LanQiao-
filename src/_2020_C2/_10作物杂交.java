package _2020_C2;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 作物杂交是作物栽培中重要的一步。已知有 N 种作物 (编号 1 至 N )，第i 种作物从播种到成熟的时间为 Ti。作物之间两两可以进行杂交，杂交时间取两种中时间较长的一方。如作物 A 种植时间为 5 天，作物 B 种植时间为 7 天，则 AB 杂交花费的时间为 7 天。作物杂交会产生固定的作物，新产生的作物仍然属于 N 种作物中的一种。
初始时，拥有其中 M 种作物的种子 (数量无限，可以支持多次杂交)。同时可以进行多个杂交过程。求问对于给定的目标种子，最少需要多少天能够得到。
如存在 4 种作物 ABCD，各自的成熟时间为 5 天、7 天、3 天、8 天。初始拥有 AB 两种作物的种子，目标种子为 D，已知杂交情况为 A × B → C，
A × C → D。则最短的杂交过程为：

第 1 天到第 7 天 (作物 B 的时间)，A × B → C。
第 8 天到第 12 天 (作物 A 的时间)，A × C → D。
花费 12 天得到作物 D 的种子。
【输入格式】
输入的第 1 行包含 4 个整数 N, M, K, T，N 表示作物种类总数 (编号 1 至N)，M 表示初始拥有的作物种子类型数量，K 表示可以杂交的方案数，T 表示目标种子的编号。
第 2 行包含 N 个整数，其中第 i 个整数表示第 i 种作物的种植时间Ti(1 ≤ Ti ≤ 100)。
第 3 行包含 M 个整数，分别表示已拥有的种子类型 Kj(1 ≤ Kj ≤ M)，Kj两两不同。
第 4 至 K + 3 行，每行包含 3 个整数 A, B,C，表示第 A 类作物和第 B 类作物杂交可以获得第 C 类作物的种子。
【输出格式】
输出一个整数，表示得到目标种子的最短杂交时间。
【样例输入】

6 2 4 6
5 3 4 6 4 9
1 2
1 2 3
1 3 4
2 3 5
4 5 6
【样例输出】

16
【样例说明】

第 1 天至第 5 天，将编号 1 与编号 2 的作物杂交，得到编号 3 的作物种子。
第 6 天至第 10 天，将编号 1 与编号 3 的作物杂交，得到编号 4 的作物种子。
第 6 天至第 9 天，将编号 2 与编号 3 的作物杂交，得到编号 5 的作物种子。
第 11 天至第 16 天，将编号 4 与编号 5 的作物杂交，得到编号 6 的作物种子。
总共花费 16 天。
————————————————
版权声明：本文为CSDN博主「编程夜游神」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_48598155/article/details/109133151
 */
public class _10作物杂交 {
	static int n,m,k,t;
	static int[] ti;	//存储各种子成熟时间
	static boolean[] hi;	//存储是否已经拥有该种子
	
	//存储某个种子是由哪两个种子杂交而成
	static HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		t = sc.nextInt();
		ti = new int[n];
		hi = new boolean[n];
		for (int i = 0; i < n; i++) {
			ti[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			hi[sc.nextInt() - 1] = true;
		}
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt(),
				b = sc.nextInt(),
				c = sc.nextInt();
			map.put(c, new int[]{a,b});
		}
		int res = dfs(t);
		System.out.println(res);
	}
	/*
	该方法计算拿到种子t所需时间
	*/
	private static int dfs(int t) {
		//如果种子t存在，就返回0
		if (hi[t - 1]) {
			return 0;
		}
		//改变一下种子状态，设为已存在
		hi[t - 1] = true;
		//没有这个种子
		//计算获得能够杂交出种子t的种子a和b的时间
		int ai = dfs(map.get(t)[0]);
		int bi = dfs(map.get(t)[1]);
		//计算杂交出种子t的时间
		int at = ti[map.get(t)[0] - 1];
		int bt = ti[map.get(t)[1] - 1];
		//由于获得种子a和b可以同时进行，取耗费时间最大值
		//题上说杂交时间取最大值
		return Math.max(ai, bi) + Math.max(at,bt);
	}
}
