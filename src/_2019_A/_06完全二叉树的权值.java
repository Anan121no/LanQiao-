package _2019_A;

import java.util.Scanner;

/*
 * 给定�?棵包�? N 个节点的完全二叉树，树上每个节点都有�?个权值，按从上到下�?�从左到右的顺序依次�? A1, A2, · · · AN，如下图�?示：
现在小明要把相同深度的节点的权�?�加在一起，他想知道哪个深度的节点权值之和最大？如果有多个深度的权�?�和同为�?大，请你输出其中�?小的深度�?
注：根的深度�? 1�?
【输入格式�??
第一行包含一个整�? N�?
第二行包�? N 个整�? A1, A2, · · · AN �?
【输出格式�??
输出�?个整数代表答案�??
【样例输入�??
7
1 6 5 4 3 2 1
【样例输出�??
2
【评测用例规模与约定�?
对于�?有评测用例，1 �? N �? 100000，−100000 �? Ai �? 100000�?
【题目分析�??
给定�?个节点的序号，可以得到该节点�?在的层数�?
�?以设立两个数组：节点数组a[]和层数组b[]
每个节点将其值加到其对应的层数组上，�?后判断层数组的权值最大的层数，即该层的节点权值之和最大�??
注意该题给出1 �? N �? 100000，−100000 �? Ai �? 100000，为了防止溢出最好是设置double数组�?
—�?��?��?��?��?��?��?��?��?��?��?��?��?��?��??
版权声明：本文为CSDN博主「leangx86」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明�?
原文链接：https://blog.csdn.net/leangx86/article/details/95937062
 */
public class _06完全二叉树的权值 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int h=0;
		double m=0;
		double[] a=new double[n];
		double[] b=new double[floor(n)+1];
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
			b[floor(i)]+=a[i];
		}
		m=b[0];
		for(int i=1;i<n;i++) {
			if(m<b[floor(i)]) {
				m=b[floor(i)];
				h=floor(i);
			}
		}
		System.out.println(h+1);
	}
	public static int floor(int n) {
		int h=1;
		n++;
		while(n/2>0) {
			n=n/2;
			h++;
		}
		return h-1;
	}
}
