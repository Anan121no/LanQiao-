package C21;
/*
 * 小蓝发现，他将 1 11 至 1000000007 10000000071000000007 之间的不同的数与 2021 20212021 相乘后再求除以1000000007 10000000071000000007 的余数，会得到不同的数。
  小蓝想知道，能不能在 1 11 至 1000000007 10000000071000000007 之间找到一个数，与 2021 20212021 相乘后再除以1000000007 10000000071000000007 后的余数为 999999999 999999999999999999。如果存在，请在答案中提交这个数；
  如果不存在，请在答案中提交 0 00。

答案提交

  这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

17812964
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/115876990
 */
import java.math.BigInteger;
public class _04相乘{
public static void main(String[] args) {
	solve1();
	new _04相乘().run();
}
public static void solve1() {
	        BigInteger big=new BigInteger("2021");
	        BigInteger qi=new BigInteger("1000000007");
	        BigInteger target = new BigInteger("999999999");
	        for(int i=1;i<1000000007;i++){
	            if(big.multiply(new BigInteger(i+"")).mod(qi).compareTo(target) == 0){
	                System.out.println(i);
	                return;
	            }
	        }
	        System.out.println(0);
//	        System.out.println(BigInteger.valueOf(17812964).multiply(big).mod(qi).compareTo(target));
	    }

	    int N = 1000000007, M = 999999999;

	    void run() {
	        for (int i = 1; i <= N; i++)
	            if (i * 2021L % N == M) System.out.println(i);
	    }
	}
