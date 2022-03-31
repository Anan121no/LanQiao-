package 蓝桥真题;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class 十二杨辉 {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Scanner in = new Scanner(System.in); 
		long m = in.nextInt();
		int arr[] = new int [999999];
		int a =0;
		for (int i = 1; i < 30; i++) {
			for (int j = 1; j <= i; j++) {
				arr[a] = YangHui(i, j);
				a++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			map.put(i, arr[i]);
		}
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          if (entry.getValue()==m) {
				System.out.println(entry.getKey()+1);
//				System.out.println("m");
				break;
			}
        }
//        System.out.println(Arrays.toString(arr));
	}
	public static int YangHui(int i,int j) {
		if (i == j||j == 1) {
			return 1;
		}
		
		return YangHui(i-1, j-1)+YangHui(i-1, j);
		
	}
}

//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) { new Main().run(); }
//
//    int N;
//
//    void run() {
//        N = new Scanner(System.in).nextInt();
//        if (N == 1) System.out.println(1);
//        else {
//            long ans = (N + 1L) * N / 2 + 2;
//            for (int m = 2; m < 16; m++) {
//                int start = m * 2, end = N;
//                while (start <= end) {
//                    int mid = start + end >> 1;
//                    if (C(mid, m) == N) {
//                        ans = min(ans, (mid + 1L) * mid / 2 + m + 1);
//                        break;
//                    } if (C(mid, m) > N) end = mid - 1;
//                    else start = mid + 1;
//                }
//            }
//            System.out.println(ans);
//        }
//    }
//
//    long min(long a, long b) { return a < b ? a : b; }
//
//    long C(int n, int m) {
//        long num = 1;
//        for (int nm = 1; nm <= m; n--, nm++)
//            if ((num = num * n / nm) > N) return num;
//        return num;
//    }
//}
//
