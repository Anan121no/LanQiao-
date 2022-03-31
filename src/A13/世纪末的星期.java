package A13;

import java.util.Calendar;

import javax.print.CancelablePrintJob;

/*
 * 题目描述
曾有邪教称1999年12月31日是世界末日。当然该谣言已经不攻自破。
还有人称今后的某个世纪末的12月31日，如果是星期一则会…
有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一!!
于是，“谣言制造商”又修改为星期日…
1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？
请回答该年份（只写这个4位整数，不要写12月31等多余信息）
 */
//使用日期API
/*
 * 蓝桥杯日期问题常考，java提供了日期类很方便；
//日历类
Calendar c = Calendar.getInstance();　　// 获取实例化对象
Date date =c.getTime();    　 // 日期类得到c的时间；
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");　　// 修改格式
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
String now =sdf.format(date);　　//  以字符串方式得到时间，用sdf修改date得到自己希望的格式
System.out.println(now);　　// 输出当前时间/日期
使用日历类根据日期得到星期：
Calendar calendar = Calendar.getInstance();
//2017年12月29日：星期五
calendar.set(2017 , 11, 29); //注意月份是用0-11代表1-12月
int a = calendar.get(Calendar.DAY_OF_WEEK);
System.out.println(a);//1-7代表星期日-星期六
例题：
从键盘输入一个日期，格式为yyyy-M-d
要求计算该日期与1949年10月1日距离多少天
例如：
用户输入了：1949-10-2 程序输出：1
用户输入了：1949-11-1 程序输出：31
代码：
public class Demo1 {undefined
static long sum = 0;
public static void main(String[] args) {undefined
Scanner sc = new Scanner(System.in);
String next = sc.next();
String[] s = next.split("-");// 以 - 为分界拆分为字符串数组
int year = Integer.parseInt(s[0]);
int month = Integer.parseInt(s[1]);
int day = Integer.parseInt(s[2]);
// 日期类
// 取得两个到元年的时间相减变成天数
Date d1 = new Date(year, month, day);
long t1 = d1.getTime();// 返回的是毫秒值
Date d2 = new Date(1949, 10, 1);
long t2 = d2.getTime();
long sum = (t1 - t2) / (1000 * 60 * 60 * 24) + 1; // 转化为天数
System.out.println(sum);
}
}
————————————————
版权声明：本文为CSDN博主「weixin_39897887」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_39897887/article/details/114964349
 */
public class 世纪末的星期 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		for (int year = 1999; year < 10000; year+=100) {
			calendar.set(Calendar.YEAR,year);
			calendar.set(Calendar.MONTH,11);
			calendar.set(calendar.DAY_OF_MONTH, 31);
			if(calendar.get(calendar.DAY_OF_WEEK)==1) {
				System.out.println(year);
				break;
			}
		}
	}
}
