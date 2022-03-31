package _2015_C;

import java.util.HashSet;
import java.util.Set;

/*
 * 小明发现了一个奇妙的数字。它的平方和立方正好把0~9的10个数字每个用且只用了一次。
你能猜出这个数字是多少吗？

请填写该数字，不要填写任何多余的内容。
 */
public class _06奇妙的数字 {
	public static void main(String[] args) {
		for (int i = 1; i < 100000; i++) {
			String s = (i*i)+""+(i*i*i); 
			if(check(s))System.out.println(i);
		}
	}

	private static boolean check(String s) {
		// TODO Auto-generated method stub
		if(s.length()>10)return false;
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		return set.size()==10;
	}
}
