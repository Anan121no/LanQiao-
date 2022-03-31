package _2020_B2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * ����һ���ַ��� S�����Ƕ��� S �ķ�ֵ f(S ) Ϊ S �г��ֵĲ�ͬ���ַ���
�������� f(��aba��) = 2��f(��abc��) = 3, f(��aaa��) = 1��
���ڸ���һ���ַ��� S [0��n n 1]������Ϊ n������������������ S �ķǿ�
�Ӵ� S [i�� j](0 �� i �� j < n)��f(S [i�� j]) �ĺ��Ƕ��١�
�������ʽ��
����һ�а���һ����Сд��ĸ��ɵ��ַ��� S��
�������ʽ��
���һ��������ʾ�𰸡�
���������롿
ababc
�����������
28
������˵����




������������ģ��Լ����
���� 20% ������������1 �� n �� 10��
���� 40% ������������1 �� n �� 100��
���� 50% ������������1 �� n �� 1000��
���� 60% ������������1 �� n �� 10000��
������������������1 �� n �� 100000��
��������������������������������
��Ȩ����������ΪCSDN��������ëë_���¡���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45696377/article/details/109147147
 */
public class _09�Ӵ���ֵ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int n = s.length();
		int sum = n;	//sum�洢���ս��
		for (int i = 0; i < n; i++) {
			//��ϣ�洢�Ӵ��и��ַ��ĸ���
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			map.put(s.charAt(i), 1);
			int cut = 1;	//cut�洢��ǰ�Ӵ����ַ��ĸ���
			for (int j = i + 1; j < n; j++) {
				char c = s.charAt(j);
				int count = map.getOrDefault(c, 0);
				//�õ�һ���ַ����������ַ���ǰ��û���ֹ��ģ�����ǰ�Ӵ�����һ��ǡ�ó���һ�ε��ַ�
				//���ǰ������ַ���һ�����ַ�����ǰ�Ӵ�����һ��ǡ�ó���һ�ε��ַ�
				if (count == 0) {
					cut ++;
				} else if (count == 1) {
					//cut��СΪ0����Ҫ����������
					cut = Math.max(cut - 1, 0);
				}
				//���ַ������ϣ
				map.put(c, count+1);
				//����ǰ�Ӵ���ǡ�ó���һ�ε��ַ��ĸ���������
				sum += cut;
			}
		}
		System.out.println(sum);
	}
}
