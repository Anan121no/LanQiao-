package _2020_B1;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * 2020 �� 7 �� 1 �����й����������� 99 ��������ա�
�й������������� 1921 �� 7 �� 23 �ա�
���ʴ� 1921 �� 7 �� 23 ������ 12 ʱ�� 2020 �� 7 �� 1 ������ 12 ʱһ����
�����ٷ��ӣ�
���ύ
����һ���������⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ��
���������ύ��ʱֻ��д�����������д��������ݽ��޷��÷�
52038720
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _02������ {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1=s.parse("1921-7-23");
		java.util.Date date2=s.parse("2020-7-1");
		int a=(int)((date2.getTime()-date1.getTime())/(1000*60));
		System.out.println(a);
	}	
}
