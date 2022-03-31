package _2021_A;

import java.util.HashSet;
import java.util.Set;

/*
 * 在平面直角坐标系中，两点可以确定一条直线。如果有多点在一条直线上，
那么这些点中任意两点确定的直线是同一条。
给定平面上 2 × 3 个整点 {(x, y)|0 ≤ x < 2, 0 ≤ y < 3, x ∈ Z, y ∈ Z}，即横坐标
是 0 到 1 (包含 0 和 1) 之间的整数、纵坐标是 0 到 2 (包含 0 和 2) 之间的整数
的点。这些点一共确定了 11 条不同的直线。
给定平面上 20 × 21 个整点 {(x, y)|0 ≤ x < 20, 0 ≤ y < 21, x ∈ Z, y ∈ Z}，即横
坐标是 0 到 19 (包含 0 和 19) 之间的整数、纵坐标是 0 到 20 (包含 0 和 20) 之
间的整数的点。请问这些点一共确定了多少条不同的直线。

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

个人答案：40257
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
/**
 *	此代码是根据一位博主的思路编写而得
 * 	前提准备：两点确定一条直线的一般方程为：x*(y1-y2)+y*(x2-x1)+x1*(y2-y1)-y1*(x2-x1) = 0（ax+by+c=0）。
 * 
 * @author HQL
 *
 */
public class _02直线 {
	static Set<String> set = new HashSet<String>();

	public static void main(String[] args) {
		int n = 20, m = 21, num = n * m, gc;

		for (int i = 0; i < num; ++i) {
			int x1 = i / m, y1 = i % m;
			for (int j = 0; j < num; ++j) {
				int x2 = j / m, y2 = j % m;
				if (x1 > x2 && y1 > y2 || i == j || x1 == x2 || y1 == y2)
					continue;
				int a = y1 - y2, b = x2 - x1, c = x1 * (y2 - y1) - y1 * (x2 - x1);
				if (c == 0)
					gc = gcd(a, b);
				else
					gc = gcdx(a, b, c);
				set.add((a / gc) + "-" + (b / gc) + "-" + (c == 0 ? 0 : (c / gc)));
			}
		}
		System.out.println(set.size() + n + m);
	}

	public static int gcdx(int a, int b, int c) {
		return gcd(gcd(a, b), c);
	}

	public static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		return a % b == 0 ? b : gcd(b, a % b);
	}
}
