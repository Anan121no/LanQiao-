package _2018_B;
import java.math.BigInteger;

/*
 * 设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。

答案写成 “实部±虚部i” 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，
(2+3i)^5 的写成: 122-597i

注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。

解题思路
首先 是BigInteger的考察
然后就是 复数的运算规律 具体看代码
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _03复数幂 {
	static BigInteger A=new BigInteger("2");
	static BigInteger B=new BigInteger("3");
	static BigInteger a=new BigInteger("2");
	static BigInteger b=new BigInteger("3");
	static BigInteger ta=new BigInteger("0");
	static BigInteger tb=new BigInteger("0");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<123456;i++){//进行乘方的时候，两两相乘只需要进行i-1次
			ta=A.multiply(a).subtract(B.multiply(b));//Aa-Bb
			tb=A.multiply(b).add(b.multiply(a));//Ab+ba
			A=ta;
			B=tb;
		}
		System.out.print(A);
		//先判断复数是不是为0
		if(B.compareTo(BigInteger.ZERO)>0)//比0大
			System.out.print("+");
		System.out.print(B);
		System.out.println("i");//复数的标志
	}
}
