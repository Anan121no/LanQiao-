package _2015_C;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * 无穷的分数，有时会趋向于固定的数字。
请计算【图1.jpg】所示的无穷分数，要求四舍五入，精确到小数点后5位，小数位不足的补0。

请填写该浮点数，不能填写任何多余的内容。
https://blog.csdn.net/weixin_41793113/article/details/88422559
 */
public class _03无穷分数 {
	public static void main(String[] args) {
		BigDecimal fn = new BigDecimal(BigInteger.ONE);
		for (int i = 1000; i >=1; i--) {//再试试2000，发现稳定了，所以答案没问题
			BigDecimal ii = new BigDecimal(BigInteger.valueOf(i));
			fn = ii.divide(fn.add(ii),6,BigDecimal.ROUND_HALF_UP);//除
		}
		System.out.println(fn.toPlainString());
	}
}
