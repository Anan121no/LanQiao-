package _2018_A;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 几个人一起出去吃饭是常有的事。但在结帐的时候，常常会出现一些争执。
现在有 n 个人出去吃饭，他们总共消费了 S 元。其中第 i 个人带了 ai 元。
幸运的是，所有人带的钱的总数是足够付账的，但现在问题来了：每个人分别要出多少钱呢？
为了公平起见，我们希望在总付钱量恰好为 S 的前提下，最后每个人付的钱的标准差最小。
这里我们约定，每个人支付的钱数可以是任意非负实数，即可以不是1分钱的整数倍。你需要输出最小的标准差是多少。
标准差的介绍：标准差是多个数与它们平均数差值的平方平均数，一般用于刻画这些数之间的“偏差有多大”。
形式化地说，设第 i 个人付的钱为 bi 元，那么标准差为 : [参见p1.png]
【输入格式】
从标准输入读入数据。
第一行包含两个整数 n、S；
第二行包含 n 个非负整数 a1, …, an。
【输出格式】
输出到标准输出。
输出最小的标准差，四舍五入保留 4 位小数。
保证正确答案在加上或减去 10^−9 后不会导致四舍五入的结果发生变化。
【样例输入】
5 2333
666 666 666 666 666
【样例输出】
0.0000
【样例解释】
每个人都出 2333/5 元，标准差为 0。
再比如：
【样例输入】
10 30
2 1 4 7 4 8 3 6 4 7
【样例输出】
0.7928
【数据约定】
对于 10% 的数据，所有 ai 相等；
对于 30% 的数据，所有非 0 的 ai 相等；
对于 60% 的数据，n ≤ 1000；
对于 80% 的数据，n ≤ 10^5；
对于所有数据，n ≤ 5 × 10^5, 0 ≤ ai ≤ 10^9。
————————————————
版权声明：本文为CSDN博主「郝大侠001」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/jmkmlm123456/article/details/87639598
 */
public class _10付账问题 {
	private static int n;
	private static int cost;
	private static int pans;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n =sc.nextInt();
		cost =sc.nextInt();
		double pin=(double)cost/n;
		double[] a=new double[n];
		double cube=0;
		//标准差:开根号(((a[0]-pin)^2+..+(a[n]-pin)^2)/n)
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
			if(a[i]<=pin) {
				cost-=a[i];
				pans++;//记录多少个人的钱不够付平均账
				cube=cube+(pin-a[i])*(pin-a[i]);
			}
		}
		Arrays.sort(a);//排序下减少下面运行时间
		double k=n-pans;//钱大于初始平均值的人数
		double pin2=cost/(k);//记录钱够付人数的平均值
		for (int i = pans; i < n; i++) {
			if(a[i]<pin2) {//记录还存在小于够付平均值的人
				cube=cube+Math.pow(a[i]-pin,2);
				k--;
				cost-=a[i];
				pin2=cost/(k);
			}else {
				cube=cube+k*(Math.pow(pin2-pin,2));
				break;
			}
		}
		
		System.out.printf("%.4f",Math.sqrt(cube/n));
	}
}
