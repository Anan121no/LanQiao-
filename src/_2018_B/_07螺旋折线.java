package _2018_B;

import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * ��ͼp1.pgn��ʾ���������߾���ƽ������������ǡ��һ�Ρ�
��������(X, Y)�����Ƕ�������ԭ��ľ���dis(X, Y)�Ǵ�ԭ�㵽(X, Y)���������߶εĳ��ȡ�
����dis(0, 1)=3, dis(-2, -1)=9
������������(X, Y)�����ܼ����dis(X, Y)��
�������ʽ��
X��Y
����40%�����ݣ�-1000 <= X, Y <= 1000
����70%�����ݣ�-100000 <= X�� Y <= 100000
����100%������, -1000000000 <= X, Y <= 1000000000
�������ʽ��
���dis(X, Y)
������������
0 1
�����������
3
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU���� < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ����������롭�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _07�������� {
		// �� ���½� �Խ����ϵĵ� Ϊ ���յ㣬��������ĵ㵽���յ�Ҫ�ߵľ���
	 
		public static void main(String[] args) throws FileNotFoundException {
			Scanner sc = new Scanner(System.in);
			long X = sc.nextLong(), Y = sc.nextLong();
			long d = 0; // ����
			long n = 0; // �ڼ�Ȧ
	 
			if (Y > 0 && Math.abs(X) <= Y) { // ��������ĺ�����
				n = Y; // �Ȳ������ж�����? Y��
				d = (Y - X) + (2 * Y); // X�����ֵ��Y,��һ�������޵ľ���---2Y
			} else if (X > 0 && Math.abs(Y) <= X) { // �������ұߵĺ�����
				n = X;
				d = Y + X;
			} else if (Y <= 0 && X >= Y - 1 && X <= -Y) { // �������±ߵĺ�����
				n = -Y;
				d = -(-Y - X);
			} else if (X < 0 && Y >= X + 1 && Y <= -X) { // ��������ߵĺ�����
				n = -X - 1;
				d = -(Y - X - 1 - 2 * X - 1);
			}
	 
			System.out.println(sum(1L, 2 * n, 1) * 2 - d);
		}
	 
		/**
		 * �Ȳ��������
		 * 
		 * @param a0 ����
		 * @param n  ����
		 * @param d  ����
		 * @return
		 */
		private static long sum(long a0, long n, int d) {
			return (2 * a0 + (n - 1) * d) * n / 2;
		}
	}
