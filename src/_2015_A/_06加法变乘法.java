package _2015_A;
/*
 * 我们都知道：1+2+3+ ... + 49 = 1225
现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
比如：
1+2+3+...+10*11+12+...+27*28+29+...+49 = 2015
就是符合要求的答案。
请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交（对于示例，就是提交10）。
注意：需要你提交的是一个整数，不要填写任何多余的内容。
答案：16,开始看错题目了，还想用下前缀和，这里模拟，先减去这4个改变的数，再加入2个乘积的结果
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88044052
 */
public class _06加法变乘法 {
	public static void main(String[] args) {
		for (int i = 1; i <= 46; i++) {
			for (int j = i+2; j <= 48; j++) {
				if (i*(i+1)-(i+i+1)+j*(j+1)-(j+j+1)==2015-1225) {
					System.out.println(i+" "+j);
				}
			}
		}
	}
}
