package C21;
/*
 * С��ѧϰ�����·��֮���ر���ˣ���������һ���ر��ͼ��ϣ���ҵ�ͼ �е����·����
С����ͼ�� 2021 �������ɣ����α�� 1 �� 2021��
����������ͬ�Ľ�� a, b����� a �� b �Ĳ�ľ���ֵ���� 21����������� ֮��û�б���������� a �� b �Ĳ�ľ���ֵС�ڵ��� 21����������֮����һ�� ����Ϊ a �� b ����С�������������������
���磺��� 1 �ͽ�� 23 ֮��û�б���������� 3 �ͽ�� 24 ֮����һ���� ��ߣ�����Ϊ 24����� 15 �ͽ�� 25 ֮����һ������ߣ�����Ϊ 75��
����㣬��� 1 �ͽ�� 2021 ֮������·�������Ƕ��١�
 */
public class _05·�� {
    public static void main(String[] args) { 
    new _05·��().run(); 
    int[] f = new int[2050];
   	for (int i = 1; i <= 2021; i++) {
   		for (int j = i + 1; j <= i + 21; j++) {
   			if (f[j] == 0) {
   				f[j] = f[i] + lcm1(i, j);
   			} else {
   				f[j] = Math.min(f[j], f[i] + lcm1(i, j));
   			}
   		}
   	}
   	System.out.println(f[2021]);
    }
    int N = 2021;

    void run() {
        long[] dp = new long[N + 1];
        for (int w = 2; w <= N; w++) {
            dp[w] = Long.MAX_VALUE;
            for (int v = w - 1; v > 0 && v >= w - 21; v--)
                dp[w] = min(dp[w], dp[v] + lcm(v, w));
        }
        System.out.println(dp[N]);
    }
//������С����
    long min(long a, long b) { return a < b ? a : b; }

    int lcm(int a, int b) { return a * b / gcd(a, b); }

    int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); 
    }
private static int lcm1(int a, int b) {
	int t = 1;
	while (b * t % a != 0) {
		t++;
	}
	return t * b;
}
}

