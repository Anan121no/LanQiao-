package _2018_A;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * ����20���ͣ�1901��1��1����2000��12��31��֮�䣩��һ���ж��ٸ�����һ��
(��Ҫ�������㲻֪�����������ڼ�)

ע�⣺��Ҫ�ύ��ֻ��һ����������Ҫ��д�κζ�������ݻ�˵�����֡�

�⣺����һ��һ���ж����죬Ȼ�����7���һ���ж����ܼ��ɡ�
5217
 */
public class _02����һ {
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
