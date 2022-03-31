package _2021_B1;
/*
 * 小蓝有一个超大的仓库，可以摆放很多货物。
现在，小蓝有 n 箱货物要摆放在仓库，每箱货物都是规则的正方体。小蓝
规定了长、宽、高三个互相垂直的方向，每箱货物的边都必须严格平行于长、
宽、高。
小蓝希望所有的货物最终摆成一个大的立方体。即在长、宽、高的方向上
分别堆 L、W、H 的货物，满足 n = L × W × H。
给定 n，请问有多少种堆放货物的方案满足要求。
例如，当 n = 4 时，有以下 6 种方案：1×1×4、1×2×2、1×4×1、2×1×2、 2 × 2 × 1、4 × 1 × 1。
请问，当 n = 2021041820210418 （注意有 16 位数字）时，总共有多少种
方案？
提示：建议使用计算机编程解决问题。

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

个人答案：2430
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
public class _04货物摆放 {
	static long[] val = new long[101000];
	static int total = 0;
	public static void main(String[] args) {
		long n = 2021041820210418L, r = (long) Math.sqrt(n);
		int total = 0;
		for (long i = 1; i <= r; i++) {
			if (n % i == 0) {
				val[++total] = i;
				val[++total] = n / i;
			}
		}
		if (r * r == n)
			--total;

		long res = 0;
		for (int i = 1; i <= total; ++i) {
			for (int j = 1; j <= total; ++j) {
				if (n % (val[i] * val[j]) == 0)
					++res;
			}
		}
		System.out.println(res);
}
}