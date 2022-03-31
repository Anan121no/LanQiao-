package _2020_C2;
/*
 * 20个圆和20条直线最多能把平面分成多少部分？

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class _04平面分割 {
	public static void main(String[] args) {
		int ans=2;//第一个圆把平面分成2部分
		for (int i = 1; i <= 20; i++) {
			ans+=(i-1)*2;//第i个圆依次和前面(i-1)个圆产生(i-1)*2个交点，即被分成(i-1)*2段，亦即产生(i-1)*2个部分
		}
		System.out.println(ans);
		int n=20;
		ans+=n*2;//第一条直线和20个圆相交，平面增加2*n部分
		for (int i = 2; i <=20 ; i++) {
			ans+=(2*n+i);//第i条直线和前面20个圆和i-1条线最多产生40+i-1个焦点，被分成40+i段，亦即增加40+i个部分
		}
		System.out.println(ans);
	}
//————————————————
//版权声明：本文为CSDN博主「Hilbob」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_42714262/article/details/109522148
}
