package _2015_B;
/*
 * 观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...
请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？
请填写该数字，不要填写任何多余的内容或说明性的文字。
答案:6,暴力枚举1到10000，打印观察，发现最大的数只是到27，没必要再扩大枚举的范围了，6已是答案
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/87975540
 */
public class _02立方变自身 {
	public static void main(String[] args) {
		int ans = 0;
		for(int i=1;i<=10000;i++) {
			if(i==f(i*i*i)) {
				System.out.println(":"+i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	static int f(int x) {
		int ans=0;
		while(x>0) {
			ans+=x%10;
			x/=10;
		}
		return ans;
	}
}
