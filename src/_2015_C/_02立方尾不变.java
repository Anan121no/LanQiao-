package _2015_C;
/*
 * 有些数字的立方的末尾正好是该数字本身。
比如：1,4,5,6,9,24,25,....

请你计算一下，在10000以内的数字中（指该数字，并非它立方后的数值），符合这个特征的正整数一共有多少个。

请提交该整数，不要填写任何多余的内容。
 */
public class _02立方尾不变 {
	private static int ans;

	public static void main(String[] args) {
		for (long i = 1; i < 10000; i++) {
			if (i<10) {
				if(i*i*i%10==i)ans++;
			}else if (i<100){
				if(i*i*i%100==i)ans++;
			}else if (i<1000){
				if(i*i*i%1000==i)ans++;
			}else if (i<10000){
				if(i*i*i%10000==i)ans++;
			}
		}
		System.out.println(ans);
	}
}
