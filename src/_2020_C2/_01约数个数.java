package _2020_C2;
import java.util.Scanner;
/*
 * 对于一个整数，能整除这个整数的数称为这个数的约数。
例如：1, 2, 3, 6 都是 6 的约数。
请问 78120 有多少个约数。
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

【题解】
答案 ：96
遍历一遍所有小于等于78120的数得了
————————————————
版权声明：本文为CSDN博主「编程夜游神」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_48598155/article/details/109133151
 */
public class _01约数个数 {
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		int n= 78120;
		int count=0;
		for (int i = 1; i <=n; i++) {
			if(n%i==0){
				count++;
			}
		}
		System.out.println(count);
	}
	}

