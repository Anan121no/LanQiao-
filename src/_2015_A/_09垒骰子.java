package _2015_A;

import java.util.Scanner;

/*
 * ��ʥatm�����������������ӣ����ǰ�����һ��������һ���ϱߣ���������ŤŤ��Ҫ�ݳɷ����塣
�������ڹ۲죬atm �������ȶ����ӵİ��أ���Щ���ֵ������Żụ���ų⣡
���������淶һ�����ӣ�1 �Ķ����� 4��2 �Ķ����� 5��3 �Ķ����� 6��
������ m �黥������ÿ���е����������ֵ��������һ�����ӾͲ����ȶ����������� atm�����һ���ж����ֲ�ͬ�Ŀ��ܵ������ӷ�ʽ��
���������ӷ�ʽ��ͬ�����ҽ��������ַ�ʽ�ж�Ӧ�߶ȵ����ӵĶ�Ӧ���ֵĳ�����ͬ��
���ڷ��������ܹ��࣬�����ģ 10^9 + 7 �Ľ����
��ҪС���� atm ����������Ŷ��
�������ʽ��
��һ���������� n m
n��ʾ������Ŀ
������ m �У�ÿ���������� a b ����ʾ a �� b ���ܽ�����һ��
�������ʽ��
һ��һ��������ʾ��ģ 10^9 + 7 �Ľ����
���������롹
2 1
1 2
�����������
544
�����ݷ�Χ��
���� 30% �����ݣ�n <= 5
���� 60% �����ݣ�n <= 100
���� 100% �����ݣ�0 < n <= 10^9, m <= 36
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
����:dp+������+���������
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88044052
 */
public class _09������ {
	 static int op[] = new int[7];
	  private static int n;
	  private static int m;
	  private static final long MOD = 1000000007;
	 
	  static void init() {
	    op[1] = 4;
	    op[4] = 1;
	    op[2] = 5;
	    op[5] = 2;
	    op[3] = 6;
	    op[6] = 3;
	  }
	 
	  public static void main(String[] args) {
	    init();
	    Scanner sc = new Scanner(System.in);
	    n = sc.nextInt();
	    m = sc.nextInt();
	    long conflict[][] = new long[6][6];
	    for (int i = 0; i < 6; i++) {
	      for (int j = 0; j < 6; j++) {
	        conflict[i][j]=1;
	      }
	    }
	    //������ͻ����
	    for (int i = 0; i < m; i++) {
	      int a = sc.nextInt();
	      int b = sc.nextInt();
	      conflict[op[a] - 1][b - 1] = 0;
	      conflict[op[b] - 1][a - 1] = 0;
	    }
	    //  ���ͻ�����n-1�η�
	    long[][] mPow_n_1 = mPow(conflict, n - 1);
	    //�ۼӾ����ÿ��Ԫ��
	    long ans = 0;
	    for (int i = 0; i < 6; i++) {
	      for (int j = 0; j < 6; j++) {
	        ans = (ans + mPow_n_1[i][j]) % MOD;
	      }
	    }
	    //ans*4^n
	    System.out.println(ans * power(4, n) % MOD);
	  }
	 
	  private static long power(long i, int n) {
	    long ans = 1;
	    while (n != 0) {
	      if ((n & 1) == 1) ans = (ans * i) % MOD;
	      i = i * i % MOD;
	      n >>= 1;
	    }
	    return ans;
	  }
	 
	  /*����Ŀ�����*/
	  private static long[][] mPow(long[][] conflict, int n) {
	    long[][] e = new long[6][6];
	    for (int i = 0; i < 6; i++) {
	      for (int j = 0; j < 6; j++) {
	        if (i == j) e[i][j] = 1;
	        else e[i][j] = 0;
	      }
	    }
	    while (n != 0) {
	      if ((n & 1) == 1) {
	        e = mMul(e, conflict);
	      }
	      conflict = mMul(conflict, conflict);
	      n >>= 1;
	    }
	 
	    return e;
	  }
	 
	  private static long[][] mMul(long[][] a, long[][] b) {
	    long[][] ans = new long[6][6];
	    for (int i = 0; i < 6; i++) {
	      for (int j = 0; j < 6; j++) {
	        for (int k = 0; k < 6; k++) {
	          ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % MOD;
	        }
	      }
	    }
	    return ans;
	  }
}
