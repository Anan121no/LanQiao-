package _2016_C;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 小明很喜欢猜谜语。
最近，他被邀请参加了X星球的猜谜活动。
每位选手开始的时候都被发给777个电子币。
规则是：猜对了，手里的电子币数目翻倍，
猜错了，扣除555个电子币, 扣完为止。
小明一共猜了15条谜语。
战果为：vxvxvxvxvxvxvvx
其中v表示猜对了，x表示猜错了。
请你计算一下，小明最后手里的电子币数目是多少。
请填写表示最后电子币数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
————————————————
版权声明：本文为CSDN博主「方小傑」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_42069140/article/details/88911572
 */
public class _01有奖猜谜 {
	static char[] arr = new char[15];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.charAt(i);
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(f(777));
	}

	private static int f(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if (n<0) {
				break;
			}
			if (arr[i]=='v') n*=2;
			if (arr[i]=='x') n-=555;
		}
		return n;
	}
}
