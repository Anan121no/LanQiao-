package _2020_C1;

import java.math.BigInteger;

/*
 * 7 月 1 日是建党日，从 1921 年到 2020 年，中国共产党已经带领中国人民
走过了 99 年。
请计算：7 2020 7^{2020}7 
2020
  mod 1921，其中 A mod B 表示 A 除以 B 的余数。
答案提交
这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
480
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _01指数计算 {
	public static void main(String[] args) {
		BigInteger n;
		n = new BigInteger("7").pow(2020).mod(new BigInteger("1921"));
		System.out.println(n);
	}
}
