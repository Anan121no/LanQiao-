package _2018_A;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 整个20世纪（1901年1月1日至2000年12月31日之间），一共有多少个星期一？
(不要告诉我你不知道今天是星期几)

注意：需要提交的只是一个整数，不要填写任何多余的内容或说明文字。

解：计算一下一共有多少天，然后除以7算出一共有多少周即可。
5217
 */
public class _02星期一 {
	private static long day;
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd E");
	private static Date d;
	private static long c;
	public static void main(String[] args) {
		int year = 1901;
		int sum = 0;
		while (year<=2000) {
			if(year%4==0&&year%100!=0||year%400==0) {
				sum+=366;
			}else {
				sum+=365;
			}
			year++;
		}
//		System.out.println(sum); //36525
		System.out.println(sum/7);//5217
		
		Calendar c1 = new GregorianCalendar();
		Calendar c2 = new GregorianCalendar();
		c1.set(1901, 0,1);
		c2.set(2000, 11, 31);
		day = ((c2.getTimeInMillis()-c1.getTimeInMillis())/(1000*3600*24))+1;
		d = c1.getTime();
		System.out.println(day/7+" "+day%7);
//		System.out.println(df.format(c2.getTime()));
		Calendar a = new GregorianCalendar();
		Calendar b = new GregorianCalendar();
		a.set(2022, 2,25);
		b.set(2022, 2,27);
		c = ((b.getTimeInMillis()-a.getTimeInMillis())/(1000*3600*24));
		System.out.println(c);
	}
}
