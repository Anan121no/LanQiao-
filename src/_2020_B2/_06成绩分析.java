package _2020_B2;

import java.util.Scanner;

/*
 * С����ѧ������֯��һ�����ԣ������ܷ�Ϊ 100 �֣�ÿ��ѧ���ĵ÷ֶ��� һ�� 0 �� 100 ��������
�������ο��Ե���߷֡���ͷֺ�ƽ���֡�
�������ʽ��
����ĵ�һ�а���һ������ n����ʾ���������� ������ n �У�ÿ�а���һ�� 0 �� 100 ����������ʾһ��ѧ���ĵ÷֡�
�������ʽ��
������С�
��һ�а���һ����������ʾ��߷֡�
�ڶ��а���һ����������ʾ��ͷ֡�
�����а���һ��ʵ�����������뱣��������λС������ʾƽ���֡�
���������롿
7
80
92
56
74
88
99
10
�����������
99
10
71.29
������������ģ��Լ����
���� 50% ������������1��n��100��
������������������1��n��10000��
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _06�ɼ����� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		double sum = 0;
		for(int i=0; i<n; ++i) {
			int t = sc.nextInt();
			sum += t;
			max = t>max?t:max;
			min = t<min?t:min;
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(String.format("%.2f", sum/n));
//		System.out.printf("%.2f",sum/n);
	}
}
