package _2020_A;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ����һ���ַ��� S�����Ƕ��� S �ķ�ֵ f(S) Ϊ S ��ǡ�ó���һ�ε��ַ����������� f(��aba��)=1��f(��abc��)=3, f(��aaa��)=0��
���ڸ���һ���ַ��� S[0��n-1]������Ϊ n������������������ S �ķǿ��Ӵ� S[i��j] (0<=i<=j<n)��f(S[i��j])�ĺ��Ƕ��١�
�������ʽ��
����һ�а���һ����Сд��ĸ��ɵ��ַ��� S��
�������ʽ��
���һ��������ʾ�𰸡�
���������롿
ababc
�����������
21
������˵����
�Ӵ� fֵ
a 1
ab 2
aba 1
abab 0
ababc 1
b 1
ba 2
bab 1
babc 2
a 1
ab 2
abc 3
b 1
bc 2
c 1
������������ģ��Լ����
���� 20% ������������1<=n<=10��
���� 40% ������������1<=n<=100��
���� 50% ������������1<=n<=1000��
���� 60% ������������1<=n<=10000��
������������������1<=n<=100000��
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _08�Ӵ���ֵ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] rv = sc.next().toCharArray();
		int[][] dr = new int[26][2];
		for (int i = 0; i < 26; ++i)
			Arrays.fill(dr[i], -1);
		int ans = 0, total = 0;
		for (int i = 0; i < rv.length; ++i) {
			int ind = rv[i] - 'a';
			total += i - 2 * dr[ind][1] + dr[ind][0];
			dr[ind][0] = dr[ind][1];
			dr[ind][1] = i;
			ans += total;
		}
		System.out.println(ans);
	}
}
