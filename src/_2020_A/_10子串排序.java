package _2020_A;

import java.util.Scanner;

/*
 * С�����ѧϰ��һЩ�����㷨������ð����������ӡ����̡�
��ð�������У�ÿ��ֻ�ܽ������ڵ�����Ԫ�ء�С�����֣������һ���ַ����е��ַ�����
ֻ���������ڵ������ַ����������п��ܵ����򷽰��У�ð��������ܽ������������ٵġ�
���磬�����ַ���l a n lanlan����ֻ��Ҫ1 11�ν����������ַ��� q i a o qiaoqiao �����ܹ���Ҫ 4 44 �ν�����
С���ҵ��˺ܶ��ַ�����ͼ������ǡ������һ���ַ�������Ҫ V VV �ν��������������˰�����ַ����������������Ҳ����ˡ�
С��������������V VV �������ҵ�һ��ֻ����СдӢ����ĸ���ַ�������������е��ַ�����ð������������ҪV VV�ν�����
�����С����һ���������ַ�����
��������ҵ�����������С����̵��Ǹ��������̵���Ȼ�ж���������С���ֵ�����С���Ǹ�����ע���ַ����п��԰�����ͬ���ַ���
����˼·
ð������Ľ���������������������Եĸ�����
�����㽻������V��ǰ���£�Ҫ����̵����С���Ϊȷ�������µ����У�����Ը��������ֵ��ȷ���ģ�
��ôֻ���ҵ���һ������Ը���>=V�����г��ȣ��ó��ȼ�Ϊ��Ҫ���������еĳ��ȡ�
�ֵ�����С������֪���г����£����ǿ��Դ����еĵ�һ������ͷ����ĸ��ʼ����ö�٣�ÿ�δӡ�a��~'z����˳��ö��ÿ����ĸ��
ֱ���ҵ���һ�������Ը�ö�ٵ���ĸΪ��ͷ�����е��������Ը��� + �Ѿ�ȷ��������Ը��� >= V���ż�������ö����һ����ĸ��ֵ��
��������
�� ��������г���
��ȷ���ĳ����£�Ҫ�����е�����Ը��������ֵ����ô���еĵ� i ����ĸһ��Ҫ >= �� i + 1 ����ĸ�������÷�֤��֤����
�� ���ֵ�����С������
���ݢٵķ���������֪��ÿ�ε�ö��Ӧ�ø�Ϊ�ӡ�a��~last��lastΪ�����е���һ����ĸ��
�ص����Ҫ����Ը�ö�ٵ���ĸΪ��ͷ�����е��������Ը������������dp�ķ��������ҽ��ò��͢ٵļ������һ��
��������������DP������
�����￴ͼ
��������������������������������
��Ȩ����������ΪCSDN������Dripping.����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43619717/article/details/112595685
 */
public class _10�Ӵ����� {
	static int N = (int)1e4+5;
public static int n;
public static int m;
public static int _max;
public static int len;
private static int[] res;
private static int[] num;

	static boolean judge(int letter) {
		int i = 26, j = letter;
		while (0!=res[i]) i--;//while (!res[i]) i--;ԭ����������
		if (i == j) {
			while (i > 0 && j > 0) {
				if (res[i] != num[j]) {
					return res[i] > num[j];
				} else {
					i--; j--;
				}
			}
		}
		return i > j;
	}

	static void dfs(int letter, int curlen, int cursum, int l) {
		if (cursum > n) return ;
		if (letter > _max) return ;
		if (curlen > len) return ;
		
		if (curlen == len && cursum != n) return ;
		if (letter == _max && cursum != n) return ;
		
		if (cursum == n) {
			if (curlen < len || judge(letter)) { //���ȼ�С���ֵ����С���½��
				len = curlen;
				for (int i = 1; i <= 26; i++) {
					res[i] = num[i];
				}
			}
			return ;
		}

		for (int i = 1; i <= l; i++) {
			num[letter + 1] = i;
			dfs(letter + 1, curlen + i, cursum + i * curlen, i);
		}
		num[letter + 1] = 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = 0; len = 0;
		while (m < n) {
			int id = 1;
			for (int i = 2; i <= 26; i++) { //�ҵ�s��С�ĵ�, ������ڶ��ȡ�ֵ����С��
	      if (res[i] < res[id]) id = i;
			}
			m += len - res[id];
			_max = Math.max(_max, id);
			len ++; res[id] ++;
		}
		
		dfs(0, 0, 0, 10);
		
		for (int i = _max; i >= 1; i--) {
			for (int j = res[i]; j > 0; j--) {
				System.out.printf("%c", i-1+'a');
			}
		}
		System.out.printf("\n");
}
}