package _2016_A;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��������ȡ�����Ϸ��
һ����N����ÿ������ȡ��ÿ�ο�ȡ����{n1,n2,n3}�е��κ�һ����Ŀ��
����޷�����ȡ������Ϸ������
��ʱ���������������һ����ʤ��
������˶�����������Ϊƽ�֡�
����˫���������������ȡ����
��һ��ȡ�����һ����Ӯ��
�Ա�̽��������⡣
�����ʽ��
��һ��3��������n1 n2 n3���ո�ֿ�����ʾÿ�ο�ȡ����Ŀ (0<n1,n2,n3<100)
�ڶ���5��������x1 x2 ... x5���ո�ֿ�����ʾ5�ֵĳ�ʼ����(0<xi<1000)
�����ʽ��
һ��5���ַ����ո�ֿ����ֱ��ʾÿ����ȡ������ܷ��ʤ��
�ܻ�ʤ�����+��
��֮�����а취��ƽ���֣����0��
������ζ����䣬�����-
���磬���룺
1 2 3
1 2 3 4 5
����Ӧ�������
+ 0 + 0 -
�����磬���룺
1 4 5
10 11 12 13 15
����Ӧ�������
0 - 0 + +
�����磬���룺
2 3 5
7 8 9 10 11
����Ӧ�������
+ 0 0 0 0
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 3000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _08ȡ���� {
	static int n[] = new int[3];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			n[i] = in.nextInt();
		}
		Arrays.sort(n);
		int r;
		for (int i = 0; i < 5; i++) {
			r = in.nextInt();
			char res = f(r,0,0);
			System.out.print(res + " ");
		}
		
	}

static char[][][]cache = new char[1000][2][2];
	private static char f(int r, int me, int you) {
		// TODO Auto-generated method stub
		if (r<n[0]) {
			if((me&1)==1&&(you&1)==0)return '+';
			if((me&1)==1&&(you&1)==1)return '0';
			if((me&1)==0&&(you&1)==1)return '-';
		}
		 if (cache[r][me][you]!='\0')return cache[r][me][you];
		    boolean ping = false;
		    for (int i = 0; i < 3; i++) {
		      if (r >= n[i]) {
		        char res = f(r - n[i], you, (n[i]&1)==0?me:(1-me));//ע��˴�������me��you����ż��
		        if (res == '-')
		        {
		          cache[r][me][you]='+';
		          return '+';
		        }
		        if (res == '0')
		          ping = true;
		      }
		    }
		    //������ߵ������У�˵�������ڶ�������������ô�Ƿ����ƽ�����
		    if (ping)
		    {
		      cache[r][me][you]='0';
		      return '0';
		    }
		    else
		    {
		      cache[r][me][you]='-';
		      return '-';
		    }
	}
}
