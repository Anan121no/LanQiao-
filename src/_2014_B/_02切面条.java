package _2014_B;
/*
 * 题目：
一根高筋拉面，中间切一刀，可以得到2根面条。
如果先对折1次，中间切一刀，可以得到3根面条。
如果连续对折2次，中间切一刀，可以得到5根面条。
那么，连续对折10次，中间切一刀，会得到多少面条呢？
答案是个整数，请通过浏览器提交答案。不要填写任何多余的内容。
答案：1025
解题思路：
通过题目的已知信息，加上实验（用纸张进行实验）连续对折3次，能得9根面条。 
所以是0 2；1 3；2 5；3 9；假设f[i]表示对折i次中间切一刀可以得到的面条数。
可以得到递归公式，f(i)=2*f(i-1)-1 
 */
public class _02切面条 {
	private static int res = 0;
	public static void main(String[] args) {
		int n = 10;
		System.out.println(sovel(n));
	}
	private static int sovel(int n) {
		if(n==0)return res;
		if(n==1)return 3;
		return res+=2*sovel(n-1)-1;
	}
}
