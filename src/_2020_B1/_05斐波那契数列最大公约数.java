package _2020_B1;

import java.math.BigInteger;

/*
 * 斐波那契数列满足 F 1 = F 2 = 1 F_1 = F_2 = 1F 
1
​
 =F 
2
​
 =1，从 F 3 F_3F 
3
​
  开始有 F n = F n − 1 + F n − 2 F_n = F_{n−1} + F_{n−2}F 
n
​
 =F 
n−1
​
 +F 
n−2
​
 。请你计算
G C D ( F 2020 , F 520 ) GCD(F_{2020}, F_{520})GCD(F 
2020
​
 ,F 
520
​
 )，其中 G C D ( A , B ) GCD(A, B)GCD(A,B) 表示 A AA 和 B BB 的最大公约数。

答案提交

这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分

6765
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _05斐波那契数列最大公约数 {
	 public static void main(String[] args) {
	        BigInteger F520 = BigInteger.ZERO;
	        BigInteger F1 = BigInteger.ONE, F2 = BigInteger.ONE, F3 = BigInteger.ZERO;
	        for (int i = 3; i <= 2020; i++) {
	            F3 = F1.add(F2);
	            F1 = F2;
	            F2 = F3;
	            if (i == 520) F520 = F3;
	        }
	        System.out.println(gcd(F3, F520));
	    }
	    static BigInteger gcd (BigInteger a, BigInteger b) { 
	    	return b.compareTo(BigInteger.ZERO) == 0? a: gcd(b, a.mod(b)); 
	    	}
}
