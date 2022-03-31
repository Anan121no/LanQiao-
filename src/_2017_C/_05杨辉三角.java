package _2017_C;
/*
 * 杨辉三角也叫帕斯卡三角，在很多数量关系中可以看到，十分重要。
第0行： 1
第1行： 1 1
第2行： 1 2 1
第3行： 1 3 3 1
第4行： 1 4 6 4 1
…
两边的元素都是1， 中间的元素是左上角的元素与右上角的元素和。
我们约定，行号，列号都从0计数。
所以： 第6行的第2个元素是15，第3个元素是20
直观地看，需要开辟一个二维数组，其实一维数组也可以胜任。
如下程序就是用一维数组“腾挪”的解法。
请仔细分析源码，并完成划线部分缺少的代码。
注意：只提交缺少的代码，不要提交已有的代码和符号。也不要提交说明性文字。
这个跟背包问题的优化很像，优化的一维数组就是从后往前遍历
1
答案：int q=p-1; q>=1; q- -
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _05杨辉三角 {
	static long f(int row, int col){
		if(row<2) return 1;
		if(col==0) return 1;
		if(col==row) return 1;
		
		long[] a = new long[row+1];
		a[0]=1;
		a[1]=1;
		
		int p = 2;
		
		while(p<=row){
			a[p] = 1;
			for(int q=p-1; q>=1; q--) a[q] = a[q] + a[q-1];
			p++;
		}
		
		return a[col];
	}
	
	public static void main(String[] args){
		System.out.println(f(6,2));
		System.out.println(f(6,3));		
	}
}
