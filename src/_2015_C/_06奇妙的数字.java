package _2015_C;

import java.util.HashSet;
import java.util.Set;

/*
 * С��������һ����������֡�����ƽ�����������ð�0~9��10������ÿ������ֻ����һ�Ρ�
���ܲ³���������Ƕ�����

����д�����֣���Ҫ��д�κζ�������ݡ�
 */
public class _06��������� {
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
