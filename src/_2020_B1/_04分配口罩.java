package _2020_B1;

import java.util.Scanner;

/*
 * ĳ���г���������������֣�ÿһ�����ֵ���Ŀ���£���������������
�ָ��Ƶ��ı��ļ��У�����ؼ�鸴�Ƶ������Ƿ����ĵ��е�һ�¡�������Ŀ
¼����һ���ļ� mask.txt��������������ı���ͬ��
9090400
8499400
5926800
8547000
4958200
4422600
5751200
4175600
6309600
5865200
6604400
4635000
10663400
8087200
4554000
�����г�Ҫ�ѿ��ַ�������ڵ� 2 ��ҽԺ�������������ƣ�ÿһ������ֻ
��ȫ�����������һ��ҽԺ���г�ϣ�� 2 ��ҽԺ��õĿ�������֮��ԽСԽ�á�
��������������С�Ƕ��٣�

���ύ

����һ���������⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ��
���������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�

2400
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _04������� {
	 static int sum, cnt = 0x3f3f3f3f, value[] = new int[15];

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        for (int i = 0; i < 15; i++)
	            sum += value[i] = in.nextInt();
	        dfs(0, 0);
	        System.out.print(cnt);
	    }

	    static void dfs(int d, int v) {
	        if (d == 15) cnt = min(cnt, abs(sum - v - v));
	        else {
	            dfs(d + 1, v + value[d]);
	            dfs(d + 1, v);
	        }
	    }

	    static int min(int a, int b) { return a < b? a: b; }

	    static int abs(int a) { return a > 0? a: -a; }
}
