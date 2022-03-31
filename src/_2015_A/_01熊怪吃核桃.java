package _2015_A;
/*
 * 森林里有一只熊怪，很爱吃核桃。不过它有个习惯，每次都把找到的核桃分成相等的两份，吃掉一份，留一份。如果不能等分，熊怪就会扔掉一个核桃再分。
 * 第二天再继续这个过程，直到最后剩一个核桃了，直接丢掉。
有一天，熊怪发现了1543个核桃，请问，它在吃这些核桃的过程中，一共要丢掉多少个核桃。
请填写该数字（一个整数），不要填写任何多余的内容或说明文字。
 */
public class _01熊怪吃核桃 {
	public static void main(String[] args) {
		int ans = 1;
		for (int i = 1542; i > 0;) {
			if ((i&1)==0) {
				i/=2;
			}else {
				ans++;
				i=(i-1)/2;
			}
		}
		System.out.println(ans);
	}
}
