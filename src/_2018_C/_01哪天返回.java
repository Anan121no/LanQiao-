package _2018_C;
/*
 * 小明被不明势力劫持。后被扔到x星站再无问津。小明得知每天都有飞船飞往地球，但需要108元的船票，而他却身无分文。
他决定在x星战打工。好心的老板答应包食宿，第1天给他1元钱。
并且，以后的每一天都比前一天多2元钱，直到他有足够的钱买票。
请计算一下，小明在第几天就能凑够108元，返回地球。
答案提交
要求提交的是一个整数，表示第几天。请不要提交任何多余的内容。
11
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _01哪天返回 {
	public static void main(String[] args) {
		int n = 1;
		int count = 1;
		int mony = 1;
		while (mony <= 108) {
			n = n + 2;
			mony = mony+n;
			count++;
		}
		System.out.println(count);
	}
}
