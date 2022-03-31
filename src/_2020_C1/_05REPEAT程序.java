package _2020_C1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * 附件 prog.txt 中是一个用某种语言写的程序。
其中 REPEAT k 表示一个次数为 k 的循环。循环控制的范围由缩进表达，
从次行开始连续的缩进比该行多的（前面的空白更长的）为循环包含的内容。
例如如下片段：
REPEAT 2:
	A = A + 4
	REPEAT 5:
		REPEAT 6:
			A = A + 5
		A = A + 7
	A = A + 8
A = A + 9
该片段中从 A = A + 4 所在的行到 A = A + 8 所在的行都在第一行的
循环两次中。
REPEAT 6: 所在的行到 A = A + 7 所在的行都在 REPEAT 5: 循环中。
A = A + 5 实际总共的循环次数是 2 × 5 × 6 = 60 次。
请问该程序执行完毕之后，A 的值是多少？
答案提交
这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分
241830
calcCode：
啊这
首先确认一下是否只包含 REPEAT、A、+、常量、= 这几种语句
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _05REPEAT程序 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream("C:\\Users\\1\\Desktop\\蓝桥\\prog.txt"));
		Map<String, Integer> map = new HashMap();
		while (in.hasNext()) {
			String now = in.next();
			Integer cnt = map.get(now);
			if (cnt == null) map.put(now, 1);
			else map.put(now, cnt + 1);
		}
		for (Entry<String, Integer> e: map.entrySet())
			System.out.println(e.getKey() + ": " + e.getValue());

	}
}
