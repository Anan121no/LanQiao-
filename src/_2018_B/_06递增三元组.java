package _2018_B;

import java.util.Scanner;

/*
 * ����������������
A = [A1, A2, �� AN],
B = [B1, B2, �� BN],
C = [C1, C2, �� CN]��
����ͳ���ж��ٸ���Ԫ��(i, j, k) ���㣺
1 <= i, j, k <= N
Ai < Bj < Ck
�������ʽ��
��һ�а���һ������N��
�ڶ��а���N������A1, A2, �� AN��
�����а���N������B1, B2, �� BN��
�����а���N������C1, C2, �� CN��
����30%�����ݣ�1 <= N <= 100
����60%�����ݣ�1 <= N <= 1000
����100%�����ݣ�1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
�������ʽ��
һ��������ʾ��
������������
3
1 1 1
2 2 2
3 3 3
�����������
27
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU���� < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ����������롭�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
����˼·
����ö�� ö���Ż������� ʱ�临�Ӷ�
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _06������Ԫ�� {
	public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];
        int [] c = new int[n];

        for (int i = 0; i <n ; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            c[i] = sc.nextInt();
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(n>=b[j]&&b[j]>a[i])
                for (int k = 0; k <n ; k++) {
                    if(n>=c[k]&&c[k]>b[j]){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
