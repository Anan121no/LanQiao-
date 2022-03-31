package _2019_A;

import java.util.Scanner;

/*
 * 糖果店的老板�?共有 M 种口味的糖果出售。为了方便描述，我们�? M 种口味编�? 1 �? M�?
小明希望能品尝到�?有口味的糖果。遗憾的是�?�板并不单独出售糖果，�?? �? K 颗一包整包出售�??
幸好糖果包装上注明了其中 K 颗糖果的口味，所以小明可以在买之前就知道每包内的糖果口味�?
给定 N 包糖果，请你计算小明�?少买几包，就可以品尝到所有口味的糖果�?
【输入格式�??
第一行包含三个整�? N、M �? K�?
接下�? N 行每�? K 这整�? T1, T2, · · · , TK，代表一包糖果的口味�?
【输出格式�??
�?个整数表示答案�?�如果小明无法品尝所有口味，输出 �?1�?
【样例输入�??
6 5 3
1 1 2
1 2 3
1 1 3
2 3 5
5 4 2
5 1 2
【样例输出�??
2
【评测用例规模与约定�?
对于 30% 的评测用例，1 �? N �? 20 �?
对于�?有评测样例，1 �? N �? 100�?1 �? M �? 20�?1 �? K �? 20�?1 �? Ti �? M�?

【题目分析�??
做这题我的�?�想是回溯，函数solu（f，u），f为前f包糖果，u为前n包已拿数目，函数fulll（）判断是否全部覆盖全部糖果口味，一旦full（）成立，记录下此时u值并�?出当前搜索，�?终得到覆盖全部糖果所�?的最小的u数�?��??
—�?��?��?��?��?��?��?��?��?��?��?��?��?��?��??
版权声明：本文为CSDN博主「leangx86」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明�?
原文链接：https://blog.csdn.net/leangx86/article/details/95937062
 */
public class _09糖果 {
	static int g;
	static int[] ts;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int k=in.nextInt();
		int[][] a=new int[n][k];
		g=n;
		ts=new int[m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<k;j++) {
				a[i][j]=in.nextInt();
			}
		}
		solu(a,0,0);
		System.out.println(g);
	}
	public static void solu(int[][] a,int f,int u) {
		if(f==a.length) {
			return;
		}
		solu(a,f+1,u);
		for(int i=0;i<a[f].length;i++) {
			ts[a[f][i]-1]++;
		}
		if(full()) {
			if(g>u+1) {
				g=u+1;
			}
		}else {
			solu(a,f+1,u+1);
		}
		for(int i=0;i<a[f].length;i++) {
			ts[a[f][i]-1]--;
		}
	}
	public static boolean full() {
		for(int i=0;i<ts.length;i++) {
			if(ts[i]==0) {
				return false;
			}
		}
		return true;
	}
}
