package _2016_B;
/*
 * 某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
现在算起来，他一共吹熄了236根蜡烛。
请问，他从多少岁开始过生日party的？
请填写他开始过生日party的年龄数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
答案:26,暴力，枚举她开始过生日的年龄
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _02生日蜡烛 {
	public static void main(String[] args) {
		int count = 0;
		for (int j = 1; j < 100; j++) {
		for (int i = j; i < 100; i++) {
			count += i;
			if (count==236) {
				System.out.println(j);
				break;
				}
			}
		count=0;
		}
	}
}
