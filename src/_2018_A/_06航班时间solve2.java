package _2018_A;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * 
 */
public class _06航班时间solve2 {
	private static Scanner sc;
	private static long[] res;
	private static int N;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		res = new long[N];
		sc.nextLine();// 这行代码一定不能省略，因为nextInt之后有回车，该语句用来接受回车，否则之后的nextLine不能得到预期结果
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

	// 获取一行输入，分别得到航班出发时间和返回时间，将时间转化为数字，最后返回他们的差
	private static long getTime() throws ParseException {
		long res = 0;
		String str = sc.nextLine();
		String[] lines = str.split(" ");
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
		// 将字符串解析为Date类型
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
