package _2021_A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * 蓝桥学院由 21 栋教学楼组成，教学楼编号 1 到 21。对于两栋教学楼 a 和 b，当 a 和 b 互质时，a 和 b 之间有一条走廊直接相连，两个方向皆可通行，否
则没有直接连接的走廊。
小蓝现在在第一栋教学楼，他想要访问每栋教学楼正好一次，最终回到第
一栋教学楼（即走一条哈密尔顿回路），请问他有多少种不同的访问方案？两个
访问方案不同是指存在某个 i，小蓝在两个访问方法中访问完教学楼 i 后访问了
不同的教学楼。
提示：建议使用计算机编程解决问题。

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

个人答案：881012367360
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
public class _05回路计数 {
	/*
	 * 解题思路：深搜，一定一定要进行剪枝，这道题的成败就在于剪枝。
	 * 刚开始的时候没有进行剪枝，只用一个布尔数组去记录哪些教学楼已经走过，这样会出现重复走的现象，导致复杂度过高。
补充说明：十分感谢‘weixin_53212217’这位读者的反馈，自己疏忽大意，没有注意溢出问题，
已经将代码中res的数据类型由原来的int类型换成long类型，但奇怪的是我当初写的返回值类型就是long类型，真不是我当时是怎么想的。
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
	 */
	static ArrayList<Integer>[] list;
	static Map<String, Long> set = new HashMap<String, Long>();

	public static void main(String[] args) {
		list = new ArrayList[21 + 1];
		for (int i = 0; i < list.length; ++i)
			list[i] = new ArrayList<Integer>();
		for (int i = 1; i <= 21; ++i)
			for (int j = i + 1; j <= 21; ++j)
				if (gcd(i, j) == 1) {
					list[i].add(j);
					list[j].add(i);
				}
		System.out.println(dfs(21, 1, 0));
	}

	public static long dfs(int total, int cur, int m) {
		if (total == 0)
			return 1;
		long res = 0;
		for (int p : list[cur]) {			//p为目标教学楼，m为当前已经访问过的教学楼（假设m==12，对应的二进制为00001100，则m表示已经访问过的教学楼有2、3号）
			if ((m & (1 << p)) != (1 << p)) {
				String pm = p + "-" + m;
				long r = 0;
				if (set.containsKey(pm)) {		//剪枝
					r = set.get(pm);
				} else {
					if (p != 1 || p == 1 && total == 1)
						r = dfs(total - 1, p, m | (1 << p));
					set.put(pm, r);
				}
				res += r;
			}
		}
		return res;
	}

	public static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		return a % b == 0 ? b : gcd(b, a % b);
	}
//————————————————
//版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
}
