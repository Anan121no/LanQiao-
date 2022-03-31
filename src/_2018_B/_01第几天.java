package _2018_B;

import java.util.Calendar;

/*
 * 2000年的1月1日，是那一年的第1天。
那么，2000年的5月4日，是那一年的第几天？
 */
public class _01第几天 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2000, 4, 4);//0是一月
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
	}
}
