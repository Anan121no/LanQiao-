package _2015_A;

import java.util.Calendar;

/*
 * 在X星系的广袤空间中漂浮着许多X星人造“炸弹”，用来作为宇宙中的路标。
每个炸弹都可以设定多少天之后爆炸。
比如：阿尔法炸弹2015年1月1日放置，定时为15天，则它在2015年1月16日爆炸。
有一个贝塔炸弹，2014年11月9日放置，定时为1000天，请你计算它爆炸的准确日期。

请填写该日期，格式为 yyyy-mm-dd  即4位年份2位月份2位日期。比如：2015-02-19
请严格按照格式书写。不能出现其它文字或符号。

答案:2017-08-05,这题不想敲代码的，打开日期慢慢算就好，不过这题主要考点是java的API调用，Calendar的用法，最后需要注意输出格式
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88044052
 */
public class _02星系炸弹 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2014, 10,9);
		c.add(Calendar.DATE, 1000);
		System.out.println(c.getTime().toLocaleString());
	}
}
