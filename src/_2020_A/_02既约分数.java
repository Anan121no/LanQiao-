package _2020_A;
/*
 * 如果一个分数的分子和分母的最大公约数是 1，这个分数称为既约分数。
例如，3/4，5/2，1/8，7/1都是既约分数。
请问，有多少个既约分数，分子和分母都是1到2020之间的整数（包括 1和 2020）？
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
个人答案：2481215
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _02既约分数 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 2020; i++) {
			for (int j = 1; j <= 2020; j++) {
				if (gcd(i,j)==1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		return b==0?a:gcd(b, a%b);
	}
}
