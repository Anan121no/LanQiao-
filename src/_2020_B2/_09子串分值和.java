package _2020_B2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 对于一个字符串 S，我们定义 S 的分值 f(S ) 为 S 中出现的不同的字符个
数。例如 f(”aba”) = 2，f(”abc”) = 3, f(”aaa”) = 1。
现在给定一个字符串 S [0…n n 1]（长度为 n），请你计算对于所有 S 的非空
子串 S [i… j](0 ≤ i ≤ j < n)，f(S [i… j]) 的和是多少。
【输入格式】
输入一行包含一个由小写字母组成的字符串 S。
【输出格式】
输出一个整数表示答案。
【样例输入】
ababc
【样例输出】
28
【样例说明】




【评测用例规模与约定】
对于 20% 的评测用例，1 ≤ n ≤ 10；
对于 40% 的评测用例，1 ≤ n ≤ 100；
对于 50% 的评测用例，1 ≤ n ≤ 1000；
对于 60% 的评测用例，1 ≤ n ≤ 10000；
对于所有评测用例，1 ≤ n ≤ 100000。
————————————————
版权声明：本文为CSDN博主「胡毛毛_三月」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45696377/article/details/109147147
 */
public class _09子串分值和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int n = s.length();
		int sum = n;	//sum存储最终结果
		for (int i = 0; i < n; i++) {
			//哈希存储子串中各字符的个数
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			map.put(s.charAt(i), 1);
			int cut = 1;	//cut存储当前子串单字符的个数
			for (int j = i + 1; j < n; j++) {
				char c = s.charAt(j);
				int count = map.getOrDefault(c, 0);
				//拿到一个字符，如果这个字符是前面没出现过的，代表当前子串多了一个恰好出现一次的字符
				//如果前面这个字符有一个该字符，则当前子串少了一个恰好出现一次的字符
				if (count == 0) {
					cut ++;
				} else if (count == 1) {
					//cut最小为0，不要减到负数了
					cut = Math.max(cut - 1, 0);
				}
				//将字符加入哈希
				map.put(c, count+1);
				//将当前子串的恰好出现一次的字符的个数加入结果
				sum += cut;
			}
		}
		System.out.println(sum);
	}
}
