package _2020_C2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * 小蓝每天都锻炼身体。
正常情况下，小蓝每天跑 1 千米。如果某天是周一或者月初（1 日），为了激励自己，小蓝要跑 2 千米。如果同时是周一或月初，小蓝也是跑 2 千米。
小蓝跑步已经坚持了很长时间，从 2000 年 1 月 1 日周六（含）到 2020 年10 月 1 日周四（含）。请问这段时间小蓝总共跑步多少千米？
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

【题解】
答案：8879
————————————————
版权声明：本文为CSDN博主「编程夜游神」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_48598155/article/details/109133151
 */
public class _03跑步锻炼 {
	public static void main(String[] args) {
		 int[] array = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	        int year=2000,month=1,day=1,week=6,ans=2;
	        while(year!=2020||month!=10||day!=1){
	            if((year%4==0&&year%100!=0)||year%400==0){
	                array[2]=29;
	            }else {
	                array[2]=28;
	            }
	            day++;
	            week=(week+1)%7;
	            if(day>array[month])
	            {
	                month++;
	                day=1;
	                if(month>12){
	                    month=1;
	                    year++;
	                }
	            }

	            if(day==1||week==1){
	                ans++;
	            }
	            ans++;
	        }
	        System.out.println(ans);
//	————————————————
//	版权声明：本文为CSDN博主「神谕的祝福」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//	原文链接：https://blog.csdn.net/GX_666/article/details/122664872
	}
}
