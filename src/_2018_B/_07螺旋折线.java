package _2018_B;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 如图p1.pgn所示的螺旋折线经过平面上所有整点恰好一次。
对于整点(X, Y)，我们定义它到原点的距离dis(X, Y)是从原点到(X, Y)的螺旋折线段的长度。
例如dis(0, 1)=3, dis(-2, -1)=9
给出整点坐标(X, Y)，你能计算出dis(X, Y)吗？
【输入格式】
X和Y
对于40%的数据，-1000 <= X, Y <= 1000
对于70%的数据，-100000 <= X， Y <= 100000
对于100%的数据, -1000000000 <= X, Y <= 1000000000
【输出格式】
输出dis(X, Y)
【输入样例】
0 1
【输出样例】
3
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _07螺旋折线 {
		// 以 右下角 对角线上的点 为 参照点，测算给定的点到参照点要走的距离
	 
		public static void main(String[] args) throws FileNotFoundException {
			Scanner sc = new Scanner(System.in);
			long X = sc.nextLong(), Y = sc.nextLong();
			long d = 0; // 距离
			long n = 0; // 第几圈
	 
			if (Y > 0 && Math.abs(X) <= Y) { // 点在上面的横线上
				n = Y; // 等差数列有多少项? Y项
				d = (Y - X) + (2 * Y); // X的最大值是Y,第一、四象限的距离---2Y
			} else if (X > 0 && Math.abs(Y) <= X) { // 点在最右边的横线上
				n = X;
				d = Y + X;
			} else if (Y <= 0 && X >= Y - 1 && X <= -Y) { // 点在最下边的横线上
				n = -Y;
				d = -(-Y - X);
			} else if (X < 0 && Y >= X + 1 && Y <= -X) { // 点在最左边的横线上
				n = -X - 1;
				d = -(Y - X - 1 - 2 * X - 1);
			}
	 
			System.out.println(sum(1L, 2 * n, 1) * 2 - d);
		}
	 
		/**
		 * 等差数列求和
		 * 
		 * @param a0 首项
		 * @param n  项数
		 * @param d  公差
		 * @return
		 */
		private static long sum(long a0, long n, int d) {
			return (2 * a0 + (n - 1) * d) * n / 2;
		}
	}
