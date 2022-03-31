package C21;
/*
 * 小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图 中的最短路径。
小蓝的图由 2021 个结点组成，依次编号 1 至 2021。
对于两个不同的结点 a, b，如果 a 和 b 的差的绝对值大于 21，则两个结点 之间没有边相连；如果 a 和 b 的差的绝对值小于等于 21，则两个点之间有一条 长度为 a 和 b 的最小公倍数的无向边相连。
例如：结点 1 和结点 23 之间没有边相连；结点 3 和结点 24 之间有一条无 向边，长度为 24；结点 15 和结点 25 之间有一条无向边，长度为 75。
请计算，结点 1 和结点 2021 之间的最短路径长度是多少。
 */
public class _05路径 {
    public static void main(String[] args) { 
    new _05路径().run(); 
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
//计算最小长度
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

