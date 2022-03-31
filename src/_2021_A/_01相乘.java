package _2021_A;
/*
 * 小蓝发现，他将 1 至 1000000007 之间的不同的数与 2021 相乘后再求除以
1000000007 的余数，会得到不同的数。
小蓝想知道，能不能在 1 至 1000000007 之间找到一个数，与 2021 相乘后
再除以 1000000007 后的余数为 999999999。如果存在，请在答案中提交这个数；
如果不存在，请在答案中提交 0。
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
个人答案：17812964
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
public class _01相乘 {
	public static void main(String[] args) {
		long mod = 1000000007L;
		long n = 2021;
		for (long i = 1; i < mod; i++) {
			if (n*i%mod==999999999L) {
				System.out.println(i);
			}
		}
	}
}
