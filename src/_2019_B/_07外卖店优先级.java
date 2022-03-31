package _2019_B;

import java.util.Scanner;

/*
 * “饱了么”外卖系统中维护�? N 家外卖店，编�? 1 �? N。每家外卖店都有�?个优先级，初始时 (0 时刻) 优先级都�? 0�?
每经�? 1 个时间单位，如果外卖店没有订单，则优先级会减�? 1，最低减�? 0；�?�如果外卖店有订单，则优先级不减反加，每有一单优先级�? 2�?
如果某家外卖店某时刻优先级大�? 5，则会被系统加入优先缓存中；如果优先级小于等�? 3，则会被清除出优先缓存�??
给定 T 时刻以内�? M 条订单信息，请你计算 T 时刻时有多少外卖店在优先缓存中�??
【输入格式�??
第一行包�? 3 个整�? N、M �? T �?
以下 M 行每行包含两个整�? ts �? id，表�? ts 时刻编号 id 的外卖店收到�?个订单�??
【输出格式�??
输出�?个整数代表答案�??
【样例输入�??
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
【样例输出�??
1
【样例解释�??
6 时刻时，1 号店优先级降�? 3，被移除出优先缓存；2 号店优先级升�? 6�? 加入优先缓存。所以是�? 1 家店 (2 �?) 在优先缓存中�?
【评测用例规模与约定�?
对于 80% 的评测用例，1 �? N, M, T �? 10000�?
对于�?有评测用例，1 �? N, M, T �? 100000�?1 �? ts �? T �?1 �? id �? N�?
【题目分析�??
体现java方便性的时�?�到了！！！
该题可以利用数据结构，写�?个shop类，存储订单和优先级信息�?
主函数中建立shop类数组，将订单分别录入对应的shop中，�?后再根据题设计算shop的优先级，得到最后时刻在优先队列的shop数量�?
如此，可以很轻松的得到结果！
—�?��?��?��?��?��?��?��?��?��?��?��?��?��?��??
版权声明：本文为CSDN博主「leangx86」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明�?
原文链接：https://blog.csdn.net/leangx86/article/details/95937062
 */
public class _07外卖店优先级 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ss=0;
		int n=in.nextInt();
		int m=in.nextInt();
		int t=in.nextInt();
		shop[] s=new shop[n];
		for(int i=0;i<n;i++) {
			s[i]=new shop(t);
		}
		for(int i=0;i<m;i++) {
			int ts=in.nextInt();
			int id=in.nextInt();
			s[id-1].add(ts);
		}
		for(int i=0;i<n;i++) {
//			System.out.println(s[i].first()+" "+s[i].f);
			ss+=s[i].first();
		}
		System.out.println(ss);
	}
}
class shop{
	int f,q;
	int[] t;
	public shop(int T) {
		f=0;
		t=new int[T+1];
	}
	public void add(int T) {
		t[T]++;
	}
	public int first() {//判断�?处队�?
		f=0;
		for(int i=0;i<t.length;i++) {
			if(t[i]==0) {
				if(f>0) {
					f--;
				}
			}else {
				f+=2*t[i];
			}
			if(f>5&&q==0) {
				q=1;
			}else if(f<=3&&q==1) {
				q=0;
			}
		}
		return q;
	}
}
