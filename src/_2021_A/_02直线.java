package _2021_A;

import java.util.HashSet;
import java.util.Set;

/*
 * ��ƽ��ֱ������ϵ�У��������ȷ��һ��ֱ�ߡ�����ж����һ��ֱ���ϣ�
��ô��Щ������������ȷ����ֱ����ͬһ����
����ƽ���� 2 �� 3 ������ {(x, y)|0 �� x < 2, 0 �� y < 3, x �� Z, y �� Z}����������
�� 0 �� 1 (���� 0 �� 1) ֮����������������� 0 �� 2 (���� 0 �� 2) ֮�������
�ĵ㡣��Щ��һ��ȷ���� 11 ����ͬ��ֱ�ߡ�
����ƽ���� 20 �� 21 ������ {(x, y)|0 �� x < 20, 0 �� y < 21, x �� Z, y �� Z}������
������ 0 �� 19 (���� 0 �� 19) ֮����������������� 0 �� 20 (���� 0 �� 20) ֮
��������ĵ㡣������Щ��һ��ȷ���˶�������ͬ��ֱ�ߡ�

�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�

���˴𰸣�40257
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
/**
 *	�˴����Ǹ���һλ������˼·��д����
 * 	ǰ��׼��������ȷ��һ��ֱ�ߵ�һ�㷽��Ϊ��x*(y1-y2)+y*(x2-x1)+x1*(y2-y1)-y1*(x2-x1) = 0��ax+by+c=0����
 * 
 * @author HQL
 *
 */
public class _02ֱ�� {
	static Set<String> set = new HashSet<String>();

	public static void main(String[] args) {
		int n = 20, m = 21, num = n * m, gc;

		for (int i = 0; i < num; ++i) {
			int x1 = i / m, y1 = i % m;
			for (int j = 0; j < num; ++j) {
				int x2 = j / m, y2 = j % m;
				if (x1 > x2 && y1 > y2 || i == j || x1 == x2 || y1 == y2)
					continue;
				int a = y1 - y2, b = x2 - x1, c = x1 * (y2 - y1) - y1 * (x2 - x1);
				if (c == 0)
					gc = gcd(a, b);
				else
					gc = gcdx(a, b, c);
				set.add((a / gc) + "-" + (b / gc) + "-" + (c == 0 ? 0 : (c / gc)));
			}
		}
		System.out.println(set.size() + n + m);
	}

	public static int gcdx(int a, int b, int c) {
		return gcd(gcd(a, b), c);
	}

	public static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		return a % b == 0 ? b : gcd(b, a % b);
	}
}
