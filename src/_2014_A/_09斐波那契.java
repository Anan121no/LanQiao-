package _2014_A;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 쳲��������д�Ҷ��ǳ���Ϥ�����Ķ����ǣ�

f(x) = 1                    .... (x=1,2)
    f(x) = f(x-1) + f(x-2)      .... (x>2)

���ڸ��������� n �� m������ϣ�������
    f(1) + f(2) + ... + f(n)  ��ֵ�������ֵ���ܷǳ����������ǰ����� f(m) ȡģ��
    ��ʽ�μ���ͼ1.png��

�����������Ȼ�ܴ�������Ҫ�ٶ� p ��ģ��

�����ݸ�ʽ��
����Ϊһ���ÿո�ֿ������� n m p (0 < n, m, p < 10^18)
���Ϊ1������

���磬������룺
2 3 5
����Ӧ�������
0

�����磬���룺
15 11 29
����Ӧ�������
25
https://www.bbsmax.com/A/MAzADK9nd9/
 */
/*
public class _09쳲����� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n,m,p;
		n = in.nextLong();
		m = in.nextLong();
		p = in.nextLong();
		BigInteger bigP = BigInteger.valueOf(p);
		if (m>=n+2) {
			BigInteger ans = fib(n+2,bigP);
			System.out.println(ans.mod(bigP).longValue()-1);
		}else {
			BigInteger fibm = fib(m);
			BigInteger ans = fib(n+2,fibm);
			System.out.println(ans.mod(fibm).mod(bigP).longValue()-1);
		}
	}
	//���پ�����fib
	private static BigInteger fib(long m) {
		// TODO Auto-generated method stub
		BigInteger[][] ans = mpow(m-2);
		return ans[0][0].add(ans[1][0]);
	}
	private static BigInteger fib(long m,BigInteger mod) {
		BigInteger[][] ans = mpow(m-2,mod);
		return ans[0][0].add(ans[1][0]);
	}
	//���������
	private static BigInteger[][] mpow(long n) {
		// TODO Auto-generated method stub
		BigInteger[][] a = 
			{
					{
						BigInteger.ONE,BigInteger.ONE
					},
					{
						BigInteger.ONE,BigInteger.ZERO
					}
			};
		BigInteger[][] ans =
			{
					{
						BigInteger.ONE,BigInteger.ZERO
					},
					{
						BigInteger.ZERO,BigInteger.ONE
					}
			};
		while (n!=0) {
			if ((n&1)==1) {
				BigInteger t1 = ans[0][0];
				BigInteger t2 = ans[0][0];
				ans[0][0] = ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0]));
				a[0][1] = t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1]));
				ans[1][0] = ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0]));
				a[1][1] = t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1]));
			}
			//����ƽ��
			BigInteger t1 = a[0][0];
			BigInteger t2 = a[1][0];
			BigInteger t3 = a[0][1];
			a[0][0] = a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0]));
			a[0][1] = t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1]));
			a[1][0] = a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0]));
			a[1][1] = t2.multiply(t3).add(a[1][1].multiply(a[1][1]));
			n>>=1;
		}
		return ans;
	}
	private static BigInteger[][] mpow(long n, BigInteger mod) {
		// TODO Auto-generated method stub
		BigInteger[][] a =
			{
					{
						BigInteger.ONE,BigInteger.ONE
					},
					{
						BigInteger.ONE,BigInteger.ZERO
					}
		};
		BigInteger[][] ans = 
			{
				{
					BigInteger.ONE,BigInteger.ZERO
				},
				{
					BigInteger.ZERO,BigInteger.ONE
				}
		};
		while (n!=0) {
			if ((n&1)==1) {
				//������Ե�ǰƽ��
				BigInteger t1 = ans[0][0];
				BigInteger t2 = ans[1][0];
				ans[0][0] = ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0])).mod(mod);
				ans[0][1] = t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1])).mod(mod);
				ans[1][0] = ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0])).mod(mod);
				ans[1][1] = t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1])).mod(mod);
			}
			//����ƽ��
			BigInteger t1 = a[0][0];
			BigInteger t2 = a[1][0];
			BigInteger t3 = a[0][1];
			a[0][0] = a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0])).mod(mod);
			a[0][1] = t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1])).mod(mod);
			a[1][0] = a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0])).mod(mod);
			a[1][1] = t2.multiply(t3).add(a[1][1].multiply(a[1][1])).mod(mod);
			n=n>>1;
		}
		return ans[1][0];
	}
}
*/


public class _09쳲����� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long m = in.nextLong();
		long p = in.nextLong();
		
		if(m >= n+2){
			BigInteger ans = fibMod(n+2, p);
			long lo = (ans.longValue() - 1)%p;
			System.out.println(lo);
		}
		else {
			BigInteger fn = fib(n+2);
			BigInteger fm = fib(m);
			long lo = fn.longValue()-1;
			lo %= fm.longValue();
			lo %= p;
			System.out.println(lo);
		}
	}
	
	public static BigInteger fib(long n){
		BigInteger[][] one = {
				{BigInteger.ONE,BigInteger.ONE},
				{BigInteger.ONE,BigInteger.ZERO}
		};
		BigInteger[][] ans = {
				{BigInteger.ONE,BigInteger.ZERO},
				{BigInteger.ZERO,BigInteger.ONE}
		};
		while(n>0){
			if((n&1) == 1){
				BigInteger t1 = ans[0][0];
				BigInteger t2 = ans[1][0];
				ans[0][0] = ans[0][0].multiply(one[0][0]).add(ans[0][1].multiply(one[1][0]));
				ans[0][1] = t1.multiply(one[0][1]).add(ans[0][1].multiply(one[1][1]));
				ans[1][0] = ans[1][0].multiply(one[0][0]).add(ans[1][1].multiply(one[1][0]));
				ans[1][1] = t2.multiply(one[0][1]).add(ans[1][1].multiply(one[1][1]));
			}
			BigInteger t1 = one[0][0];
			BigInteger t2 = one[1][0];
			BigInteger t3 = one[0][1];
			one[0][0] = one[0][0].multiply(one[0][0]).add(one[0][1].multiply(one[1][0]));
			one[0][1] = t1.multiply(one[0][1]).add(one[0][1].multiply(one[1][1]));
			one[1][0] = one[1][0].multiply(t1).add(one[1][1].multiply(one[1][0]));
			one[1][1] = t2.multiply(t3).add(one[1][1].multiply(one[1][1]));
			n=n>>1;
		}
		return ans[1][0];
	}
	
	public static BigInteger fibMod(long n,long p){
		BigInteger mod = BigInteger.valueOf(p);
		BigInteger[][] one = {
				{BigInteger.ONE,BigInteger.ONE},
				{BigInteger.ONE,BigInteger.ZERO}
		};
		BigInteger[][] ans = {
				{BigInteger.ONE,BigInteger.ZERO},
				{BigInteger.ZERO,BigInteger.ONE}
		};
		while(n>0){
			if((n&1) == 1){
				BigInteger t1 = ans[0][0];
				BigInteger t2 = ans[1][0];
				ans[0][0] = ans[0][0].multiply(one[0][0]).add(ans[0][1].multiply(one[1][0])).mod(mod);
				ans[0][1] = t1.multiply(one[0][1]).add(ans[0][1].multiply(one[1][1])).mod(mod);
				ans[1][0] = ans[1][0].multiply(one[0][0]).add(ans[1][1].multiply(one[1][0])).mod(mod);
				ans[1][1] = t2.multiply(one[0][1]).add(ans[1][1].multiply(one[1][1])).mod(mod);
			}
			BigInteger t1 = one[0][0];
			BigInteger t2 = one[0][1];
			BigInteger t3 = one[1][0];
			one[0][0] = one[0][0].multiply(one[0][0]).add(one[0][1].multiply(one[1][0])).mod(mod);
			one[0][1] = t1.multiply(one[0][1]).add(one[0][1].multiply(one[1][1])).mod(mod);
			one[1][0] = one[1][0].multiply(t1).add(one[1][1].multiply(one[1][0])).mod(mod);
			one[1][1] = t2.multiply(t3).add(one[1][1].multiply(one[1][1])).mod(mod);
			n=n>>1;
		}
		return ans[1][0];
	}
}
