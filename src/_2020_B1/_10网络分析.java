package _2020_B1;

import java.io.*;

/*
 * С��������һ������ʵ�顣
�������� n ̨���ԣ���Ϊ�ڵ㣬�����շ��ʹ洢���ݡ�
��ʼʱ�����нڵ㶼�Ƕ����ģ��������κ����ӡ�
С������ͨ�����߽������ڵ��������������Ӻ������ڵ�Ϳ��Ի���ͨ��
�ˡ������ڵ���������������ӣ���Ϊ���ڡ�
С����ʱ����Ե�ʱ�����磬������ĳ���ڵ㷢��һ����Ϣ����Ϣ�ᷢ��
��ÿ�����ڵĽڵ㣬֮����Щ�ڵ��ֻ�ת�����Լ����ڵĽڵ㣬ֱ������ֱ��
�������ڵĽڵ㶼�յ�����Ϣ�����з��ͺͽ��յĽڵ㶼�Ὣ��Ϣ�洢������
һ����Ϣֻ�洢һ�Ρ�
����С�����ӺͲ��ԵĹ��̣�������ÿ���ڵ�洢��Ϣ�Ĵ�С��

�����ʽ

����ĵ�һ�а����������� n, m���ֱ��ʾ�ڵ������Ͳ����������ڵ��
1 �� n ��š�
������ m �У�ÿ��������������ʾһ��������
�������Ϊ 1 a b����ʾ���ڵ� a �ͽڵ� b ͨ������������������ a = b
ʱ����ʾ������һ���Ի���������û��ʵ��Ӱ�졣
�������Ϊ 2 p t����ʾ�ڽڵ� p �Ϸ���һ����СΪ t ����Ϣ��

�����ʽ

���һ�У����� n ����������������֮����һ���ո�ָ���α�ʾ����
������������ڵ� 1 ���ڵ� n �ϴ洢��Ϣ�Ĵ�С��

��������1

Input��
4 8
1 1 2
2 1 10
2 3 5
1 4 1
2 2 2
1 1 2
1 2 4
2 2 1

Output��
13 13 5 3
����������ģ��Լ��

���� 30% ������������1 �� n �� 20��1 �� m �� 100��
���� 50% ������������1 �� n �� 100��1 �� m �� 1000��
���� 70% ������������1 �� n �� 1000��1 �� m �� 10000��
������������������1 �� n �� 10000��1 �� m �� 100000��1 �� t �� 100��
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _10������� {
static int[] link, lazy, value;
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		in.nextToken();
		int n = (int)in.nval;
		in.nextToken();
		int m = (int)in.nval;
		value = new int[n + 1];
		lazy = new int[n + 1];
		link = new int[n + 1];
		for (int i = 1; i <= n; i++) link[i] = i;
		while (m-- > 0) {
			in.nextToken();
			int i = (int)in.nval;
			in.nextToken();
			int v = (int)in.nval;
			in.nextToken();
			int w = (int)in.nval;
			if (i == 1) {
				v = find(v);
				w = find(w);
				if (v != w) {
					link[v] = w;
					lazy[v] = value[v] - value[w];
				}
			} else value[find(v)] += w;
		}
		for (int i = 1; i <= n; i++)
			out.print((value[find(i)] + lazy[i]) + " ");
		out.close();
	}
	
	static int find(int x) {
		if (link[x] != x) {
			int t = link[x];
			link[x] = find(link[x]);
			lazy[x] += lazy[t];
		}
		return link[x];
	}
}
