package A13;

import java.util.Calendar;

import javax.print.CancelablePrintJob;

/*
 * ��Ŀ����
����а�̳�1999��12��31��������ĩ�ա���Ȼ��ҥ���Ѿ��������ơ�
�����˳ƽ���ĳ������ĩ��12��31�գ����������һ��ᡭ
��Ȥ���ǣ��κ�һ������ĩ����ݵ�12��31�ն�������������һ!!
���ǣ���ҥ�������̡����޸�Ϊ�����ա�
1999���12��31���������壬���ʣ�δ����һ�������������һ������ĩ�꣨��xx99�꣩��12��31�������������죨�������գ���
��ش����ݣ�ֻд���4λ��������Ҫд12��31�ȶ�����Ϣ��
 */
//ʹ������API
/*
 * ���ű��������ⳣ����java�ṩ��������ܷ��㣻
//������
Calendar c = Calendar.getInstance();����// ��ȡʵ��������
Date date =c.getTime();    �� // ������õ�c��ʱ�䣻
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");����// �޸ĸ�ʽ
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
String now =sdf.format(date);����//  ���ַ�����ʽ�õ�ʱ�䣬��sdf�޸�date�õ��Լ�ϣ���ĸ�ʽ
System.out.println(now);����// �����ǰʱ��/����
ʹ��������������ڵõ����ڣ�
Calendar calendar = Calendar.getInstance();
//2017��12��29�գ�������
calendar.set(2017 , 11, 29); //ע���·�����0-11����1-12��
int a = calendar.get(Calendar.DAY_OF_WEEK);
System.out.println(a);//1-7����������-������
���⣺
�Ӽ�������һ�����ڣ���ʽΪyyyy-M-d
Ҫ������������1949��10��1�վ��������
���磺
�û������ˣ�1949-10-2 ���������1
�û������ˣ�1949-11-1 ���������31
���룺
public class Demo1 {undefined
static long sum = 0;
public static void main(String[] args) {undefined
Scanner sc = new Scanner(System.in);
String next = sc.next();
String[] s = next.split("-");// �� - Ϊ�ֽ���Ϊ�ַ�������
int year = Integer.parseInt(s[0]);
int month = Integer.parseInt(s[1]);
int day = Integer.parseInt(s[2]);
// ������
// ȡ��������Ԫ���ʱ������������
Date d1 = new Date(year, month, day);
long t1 = d1.getTime();// ���ص��Ǻ���ֵ
Date d2 = new Date(1949, 10, 1);
long t2 = d2.getTime();
long sum = (t1 - t2) / (1000 * 60 * 60 * 24) + 1; // ת��Ϊ����
System.out.println(sum);
}
}
��������������������������������
��Ȩ����������ΪCSDN������weixin_39897887����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_39897887/article/details/114964349
 */
public class ����ĩ������ {
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
