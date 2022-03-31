package _2014_A;

import java.util.Arrays;

/*
 * 由4个不同的数字，组成的一个乘法算式，它们的乘积仍然由这4个数字组成。
比如：
210 x 6 = 1260
8 x 473 = 3784
27 x 81 = 2187
都符合要求。
如果满足乘法交换律的算式算作同一种情况，那么，包含上边已列出的3种情况，一共有多少种满足要求的算式。
请填写该数字
 */
public class _03神奇算式 {
	private static int ans;

	public static void main(String[] args) {
		int a = 1024;
		String s = String.valueOf(a);
		char b = s.charAt(2);
		char[] c = s.toCharArray();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c[2]);
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(i!=j)
				for (int k = 0; k < 10; k++) {
					if(k!=i&&k!=j)
					for (int l = 0;l < 10; l++) {
						if (l!=i&&l!=j&&l!=k) {
							int src = i*1000+j*100+k*10+l;
							if (j!=0) {
								int r1 = i*(j*100+k*10+l);
								if (check(src,r1)) {
//									System.out.printf("%d*%d\n",i,j*100+k*10+l);
									ans++;
								}
							}
							if (k!=0) {
								int r2 = (i*10+j)*(k*10+l);
								if ((i*10+j)<(k*10+l)&&check(src,r2)) {
//									System.out.printf("%d*%d\n",i*10+j,k*10+l);
									ans++;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static boolean check(int src, int r2) {
		// TODO Auto-generated method stub
		String s1 = String.valueOf(src);
		String s2 = String.valueOf(r2);
		char[] chars1 = s1.toCharArray();
		char[] chars = s2.toCharArray();
		Arrays.sort(chars);
		Arrays.sort(chars1);
		return new String(chars).equals(new String(chars1));
	}
}
