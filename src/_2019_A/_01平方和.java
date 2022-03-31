package _2019_A;

import java.util.Scanner;

/*
 * 【问题描述】
小明对数位中含有 2、0、1、9 的数字很感兴趣，在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574，平方和是 14362。注意，平方和是指将每个数分别平方后求和。
请问，在 1 到 2019 中，所有这样的数的平方和是多少？
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
提示：如果你编写程序计算，发现结果是负的，请仔细检查自己的程序， 不要怀疑考场的编程软件。
【题目分析】
利用for循环，循环因子i从1到2019，写一个函数判断i是否含2、0、1、9，若含则平方求和。注意最终结果int型会溢出，用long或double即可防止溢出
答案：2658417853
————————————————
版权声明：本文为CSDN博主「leangx86」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/leangx86/article/details/95937062
 */
public class _01平方和 {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		long sum=0;
		for(int i=1;i<=2019;i++) {
			if(shu(i)) {
				sum+=i*i;
			}
		}
		System.out.println(sum);
	}
	public static boolean shu(int n) {
		while(n>0) {
			if(n%10==2||n%10==0||n%10==1||n%10==9) {
				return true;
			}else {
				n=n/10;
			}
		}
		return false;
	}
}
