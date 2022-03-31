package _2018_A;
/*
 * 1/1 + 1/2 + 1/4 + 1/8 + 1/16 + …
每项是前一项的一半，如果一共有20项,
求这个和是多少，结果用分数表示出来。
类似：
3/2
当然，这只是加了前2项而已。分子分母要求互质。

注意：
需要提交的是已经约分过的分数，中间任何位置不能含有空格。
请不要填写任何多余的文字或符号。

解：等比数列，利用等比数列计算得
1048575/524288
————————————————
版权声明：本文为CSDN博主「郝大侠001」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/jmkmlm123456/article/details/87639598
 */
public class _01分数 {
	private static long b = 1;
	private static long a = 0;

	public static void main(String[] args) {
		b = (long) Math.pow(2, 19);
		a = 2*b - 1;
		System.out.println(a+"/"+b);
	}
}
