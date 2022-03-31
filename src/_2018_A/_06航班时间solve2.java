package _2018_A;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * 
 */
public class _06����ʱ��solve2 {
	private static Scanner sc;
	private static long[] res;
	private static int N;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		res = new long[N];
		sc.nextLine();// ���д���һ������ʡ�ԣ���ΪnextInt֮���лس���������������ܻس�������֮���nextLine���ܵõ�Ԥ�ڽ��
		for (int i = 0; i < N; i++) {
			long time1 = 0, time2 = 0;
			try {
				time1 = getTime();
				time2 = getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			res[i] = (time1 + time2) / 2;
		}
		for (int i = 0; i < N; i++) {
			System.out.printf("%02d:%02d:%02d\n", res[i] / 3600, res[i] % 3600 / 60, res[i] % 3600 % 60);
		}
		sc.close();
	}

	// ��ȡһ�����룬�ֱ�õ��������ʱ��ͷ���ʱ�䣬��ʱ��ת��Ϊ���֣���󷵻����ǵĲ�
	private static long getTime() throws ParseException {
		long res = 0;
		String str = sc.nextLine();
		String[] lines = str.split(" ");
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
		// ���ַ�������ΪDate����
		Date time1 = (Date) ft.parse(lines[0]);
		Date time2 = (Date) ft.parse(lines[1]);
		if (lines.length == 3) {
			long day = lines[2].charAt(2) - '0';
			res += day * 24 * 3600;
		}
		res += time2.getTime() / 1000 - time1.getTime() / 1000;
		return res;
	}
}
