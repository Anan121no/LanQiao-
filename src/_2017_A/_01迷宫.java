package _2017_A;

import javax.security.auth.x500.X500Principal;

/*
 * X�����һ���Թ����ֳ�����ĳ��Сɽ���ϡ�
������10x10�໥��ͨ��С������ɵġ�
����ĵذ���д��һ���ܴ����ĸ��
���Ǽ���������泯���µķ���վ������
L��ʾ�ߵ���ߵķ��䣬
R��ʾ�ߵ��ұߵķ��䣬
U��ʾ�ߵ����·���ķ��䣬
D��ʾ�ߵ����·���ķ��䡣
X����ľ����е�������Ը�����˼����
���Ǹ�ϲ�������������Ϸ�������ϷҲ����ˣ�
��ʼ��ʱ��ֱ������100����ҷ���һ����С�����ڡ�
���һ��Ҫ���յ��ϵ���ĸ�ƶ���
�Թ���ͼ���£�
------------
UDDLUULRUL
UURLLLRRRU
RRUURLDLRD
RUDDDDUUUU
URUDLLRRUU
DURLRLDLRL
ULLURLLRDU
RDLULLRDDD
UUDDUDUDLL
ULRDLUURRR
------------
�������һ�£�����ж�����һ��߳��Թ�? 
����������߶�Ȧ�ӡ�
���ύ����������ʾ�߳��Թ��������Ŀ����Ҫ��д�κζ�������ݡ�
����㻹û������Ϸ���򣬿��Բο�һ���򻯵�4x4�Թ��Ľ�˵ͼ��
p1.png
����100����ҷ���һ����С�����ڡ���˼����ÿ��������һ����ң���Ȼ����ϸ���⻹��֪��������Ķ���qaq
����ܼ򵥣����Ƕ�ÿһ��������һ��������������Ч��������ȥ�Թ��ľ�++����Ϊ������Ч������˵����ѭ���
��ȻҲ����vis[][]���������ظ�·��(���С��),���߻��ɵݹ�д�����븸�׵����꣨��һ���ڵ㣩,�����õ��ǵ�������:31
������:[���ű�][2014����������]��������
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _01�Թ� {
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(ok(i,j))ans++;
			}
		}
		System.out.println(ans);
	}
	static char[][] ch = new char[][] {
		"UDDLUULRUL".toCharArray(),
		"UURLLLRRRU".toCharArray(),
		"RRUURLDLRD".toCharArray(),
		"RUDDDDUUUU".toCharArray(),
		"URUDLLRRUU".toCharArray(),
		"DURLRLDLRL".toCharArray(),
		"ULLURLLRDU".toCharArray(),
		"RDLULLRDDD".toCharArray(),
		"UUDDUDUDLL".toCharArray(),
		"ULRDLUURRR".toCharArray(),
	};

	private static boolean ok(int x, int y) {
		// TODO Auto-generated method stub
		int t = 25;
		while (t-->0) {
			if (x<0||x>=10||y<0||y>=10) return true;
			if(ch[x][y]=='U')x--;
			else if(ch[x][y]=='D')x++;
			else if(ch[x][y]=='L')y--;
			else if(ch[x][y]=='R')y++;
		}
		return false;
	}
}
