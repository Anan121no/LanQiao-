package _2018_B;

import java.util.Calendar;

/*
 * 2000���1��1�գ�����һ��ĵ�1�졣
��ô��2000���5��4�գ�����һ��ĵڼ��죿
 */
public class _01�ڼ��� {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2000, 4, 4);//0��һ��
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
	}
}
