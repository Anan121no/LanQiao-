package _2013_C;

import java.awt.Checkbox;
import java.util.HashSet;
import java.util.Set;

/*
 * 美国数学家维纳(N.Wiener)智力早熟，11岁就上了大学。他曾在1935~1936年应邀来中国清华大学讲学。
  一次，他参加某个重要会议，年轻的脸孔引人注目。于是有人询问他的年龄，他回答说：
 “我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。”
 请你推算一下，他当时到底有多年轻。
思路点拨：
最常见的是先用/10和%10把各个位上的数取出来，然后判断是否相等，有点麻烦 但着实是一个好办法；
另外可以大致推算他的年龄大概在10~30岁之间
 */
public class _01猜年龄 {
	public static void main(String[] args) {
		for (int i = 10; i < 100; i++) {
			int i1 = i*i*i;
			int i2 = i1*i;
			String s1 = i1 + "";
			String s2 = i2 + "";
			if (s1.length()==4&&s2.length()==6&&Check(s1+s2)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean Check(String s) {
		// TODO Auto-generated method stub
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		return set.size()==10;
	}
}
