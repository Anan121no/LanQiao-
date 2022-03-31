package _2020_B1;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * 2020 年 7 月 1 日是中国共产党成立 99 周年纪念日。
中国共产党成立于 1921 年 7 月 23 日。
请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包
含多少分钟？
答案提交
这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分
52038720
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _02纪念日 {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1=s.parse("1921-7-23");
		java.util.Date date2=s.parse("2020-7-1");
		int a=(int)((date2.getTime()-date1.getTime())/(1000*60));
		System.out.println(a);
	}	
}
