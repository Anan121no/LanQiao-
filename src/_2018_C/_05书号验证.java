package _2018_C;
/*
 * 2004年起，国际ISBN中心出版了《13位国际标准书号指南》。
原有10位书号前加978作为商品分类标识；校验规则也改变。
校验位的加权算法与10位ISBN的算法不同，具体算法是：
用1分别乘ISBN的前12位中的奇数位（从左边开始数起），用3乘以偶数位，乘积之和以10为模，10与模值的差值再对10取模（即取个位的数字）
即可得到校验位的值，其值范围应该为0~9。

下面的程序实现了该算法，请仔细阅读源码，填写缺失的部分。
public class A
{
    static boolean f(String s){
        int k=1;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='-' || c==' ') continue;
            sum += ______________________________;  //填空
            k++;
            if(k>12) break; 
        }
        
        return s.charAt(s.length()-1)-'0' == (10-sum % 10)%10;
    }
    
    public static void main(String[] args){
        System.out.println(f("978-7-301-04815-3"));
        System.out.println(f("978-7-115-38821-6"));
    }
}
案提交

注意：只提交空缺的代码，不要抄写已经存在的代码。

(c - ‘0’) * (1 == (k & 1)? 1: 3);

题目描述的很清晰，没啥好说的
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _05书号验证 {
	static boolean f(String s){
        int k=1;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='-' || c==' ') continue;
            sum += (c-'0')*(1==(1&k)?1:3);  //填空
            k++;
            if(k>12) break; 
        }
        return s.charAt(s.length()-1)-'0' == (10-sum % 10)%10;
    }
    
    public static void main(String[] args){
        System.out.println(f("978-7-301-04815-3"));
        System.out.println(f("978-7-115-38821-6"));
    }
}
