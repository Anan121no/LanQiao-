package _2016_C;

import java.util.Scanner;

/*
 * X����Ŀ���ѧ�ҷ�����һ���Ŵ������������롣
��Щ��������A��B��C��D ����ֲ������Ӵ��ɵ����С�
��ϸ�������֣���Щ���봮����Ӧ����ǰ��ԳƵģ�Ҳ��������˵�ľ��񴮣���
���������Զ������������������ˣ�������ܻ�ʧȥ�����������
��������ǣ�
����һ�����ڿ��������봮������һ�´ӵ�����״̬����Ҫ����������ٸ����ӣ��ſ��ܻ������ڵ����ӡ�
����һ�У���ʾ���ڿ��������봮�����Ȳ�����1000��
Ҫ�����һ������������ʾ���������˶��ٸ����ӡ�
���磬���룺
ABCBA
�����Ӧ�������
0
�����磬���룺
ABDCDCBABC
�����Ӧ�������
3
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108925934
 */
public class _10�������� {
	//https://www.acwing.com/problem/content/solution/1224/1/ ������
	static int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int n = s.length();
        for(int len = 1;len <= n;len ++)
        {
            for(int i = 0;i + len - 1 < n;i ++)
            {
                int j = i + len - 1;

                if(len == 1) f[i][j] = 1;
                else
                {
                    f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
                    if(s.charAt(i) == s.charAt(j)) f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        System.out.println(n - f[0][n - 1]);
    }
}
