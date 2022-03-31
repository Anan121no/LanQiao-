package _2017_C;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 某星系深处发现了文明遗迹。
他们的计数也是用十进制。
他们的文明也有日历。日历只有天数，没有年、月的概念。
有趣的是，他们也使用了类似“星期”的概念，
只不过他们的一个星期包含了9天，
为了方便，这里分别记为: A,B,C…H,I
从一些资料上看到，
他们的23日是星期E
他们的190日是星期A
他们的343251日是星期I
令人兴奋的是，他们居然也预见了“世界末日”的那天，
当然是一个很大很大的数字
651764141421415346185
请你计算一下，这遥远的一天是该文明的星期几？
你需要提交的是一个大写字母，表示该文明的星期几，
不要填写任何多余的内容。
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _01外星日历 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        char []arr={'I','A','B','C','D','E','F','G','H'};
        BigInteger num=input.nextBigInteger();
        BigInteger mod=new BigInteger("9");
        String ans=num.mod(mod).toString();
        System.out.println(arr[Integer.parseInt(ans)]);
	}
}
