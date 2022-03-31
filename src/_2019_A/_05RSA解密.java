package _2019_A;
import java.math.BigInteger;
import java.util.*;
/*
 * RSA 是一种经典的加密算法。它的基本加密过程如下�??
首先生成两个质数 p, q，令 n = p · q，设 d �? (p �? 1) · (q �? 1) 互质，则可找�? e 使得 d · e �? (p �? 1) · (q �? 1) 的余数为 1�?
n, d, e 组成了私钥，n, d 组成了公钥�??
当使用公钥加密一个整�? X 时（小于 n），计算 C = Xd mod n，则 C 是加密后的密文�??
当收到密�? C 时，可使用私钥解�?，计算公式为 X = Ce mod n。例如，�? p = 5, q = 11, d = 3 时，n = 55, e = 27�?
若加密数�? 24，得 243 mod 55 = 19。解密数�? 19，得 1927 mod 55 = 24�?
现在你知道公钥中 n = 1001733993063167141, d = 212353，同时你截获了别人发送的密文 C = 20190324，请问，原文是多少？
【答案提交�??
这是�?道结果填空的题，你只�?要算出结果后提交即可。本题的结果为一 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分�?

【题目分析�??
首先要对公钥中的n进行质因子分解，得到p = 891234941, q = 1123984201
因为d * e % (p-1) * (q-1) == 1，可得e = 823816093931522017
�?后X = C^e mod n =579706994112328949
注意，此题数值极大，运算也很复杂，暴力算法普通计算机�?要算十年，java中可以利用BigInteger，运算过程中要掌握方法，此题就需要用到快速幂运算和扩展欧几里得算�?
—�?��?��?��?��?��?��?��?��?��?��?��?��?��?��??
版权声明：本文为CSDN博主「leangx86」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明�?
原文链接：https://blog.csdn.net/leangx86/article/details/95937062
 */
public class _05RSA解密 {
	  public  static  boolean hasChar(String s){
	        char[] chars=s.toCharArray();
	        for (int i = 0; i <chars.length ; i++) {
	            if(chars[i]=='2'||chars[i]=='0'||chars[i]=='1'||chars[i]=='9'){
	                return true;
	            }
	        }
	        return false;
	    }
	    public static void main(String[] args) {
	        BigInteger res=new BigInteger("0");
	        for (int i = 1; i <= 2019; i++) {
	            String s=String.valueOf(i);
	            if(hasChar(s)){
	                BigInteger temp=new BigInteger(s);
	                res=res.add(temp.multiply(temp));
	            }

	        }
	        System.out.println(res);
	    }
	/*—�?��?��?��?��?��?��?��?��?��?��?��?��?��?��??
	版权声明：本文为CSDN博主「Zun-」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明�?
	原文链接：https://blog.csdn.net/weixin_42297075/article/details/104333361*/
}
