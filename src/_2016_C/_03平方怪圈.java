package _2016_C;
/*
 * 如果把一个正整数的每一位都平方后再求和，得到一个新的正整数。
对新产生的正整数再做同样的处理。
如此一来，你会发现，不管开始取的是什么数字，
最终如果不是落入1，就是落入同一个循环圈。
请写出这个循环圈中最大的那个数字。
请填写该最大数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108925934
 */
public class _03平方怪圈 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			f(i,0,0);
		}
	}

	private static void f(int n,int c,double max) {
		// TODO Auto-generated method stub
		if (n==1) {
			return;
		}
		if(c==10) {
			System.out.println(max);
			return;
		}
		double a;
		a = Math.pow(n%10, 2)+Math.pow(n/10%10, 2)+Math.pow(n/100, 2);
		max = max>a?max:a;
		f((int)a,c+1,max);
	}
}
