package _2020_A;
/*
 * 如下图所示，小明用从 1 开始的正整数“蛇形”填充无限大的矩阵。
容易看出矩阵第二行第二列中的数是 5。请你计算矩阵中第 20 行第 20 列 的数是多少？
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
个人答案：761
————————————————
版权声明：本文为CSDN博主「衣书QIAO」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _03蛇形填数 {
	public static void main(String[] args) {
		int res = 1, t = 4;
		for(int i=2; i<=20; ++i) {
			res += t;
			t += 4;
		}
		System.out.println(res);		//761
	}
}
