package _2017_A;

import java.util.Scanner;
import java.lang.Math.*;

/*
 * ����һ�ּ򵥵�������ʽ��
ֻ�� x ( ) | ��ɵ�������ʽ��
С����������������ʽ�ܽ��ܵ���ַ����ĳ��ȡ�  
���� ((xx|xxx)x|(x|xx))xx �ܽ��ܵ���ַ����ǣ� xxxxxx��������6��
����
----
һ����x()|��ɵ�������ʽ�����볤�Ȳ�����100����֤�Ϸ���  
���
----
���������ʽ�ܽ��ܵ���ַ����ĳ��ȡ�  
���磬
���룺
((xx|xxx)x|(x|xx))xx  
����Ӧ�������
6  
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
�������Ŀ�����û�н�����,xx|xxx����"|"������ȡ����ֵ����Ϊ3,���ž������ȼ����ݹ����ʵ��������㣬�����ϸ��Ҫע�⣬p++Ϊʲôд4������ֻ��while������дһ���ͺã�ע��return!!!!
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _07�������� {
	private static String s;
	private static int len;
	private static int pos;
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 s = in.nextLine();
		 len = s.length();
		 int ans = f();
		 System.out.println(ans);
		 
	}
	private static int f() {
		// TODO Auto-generated method stub
		int m = 0;
		int tmp = 0;
		while (pos<len) {
			if (s.charAt(pos)=='(') {
				pos++;
				tmp += f();
			}else if (s.charAt(pos)=='x') {
				pos++;
				tmp++;
			}else if (s.charAt(pos)=='|') {
				pos++;
				m = Math.max(m,tmp);
				tmp = 0;
			}else if (s.charAt(pos)==')') {
				pos++;
				m = Math.max(m,tmp);
				return m;
			}
		}
		m = Math.max(m,tmp);
		return m;
	}
}
