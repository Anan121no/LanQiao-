package _2015_A;
/*
 * 小明被劫持到X赌城，被迫与其他3人玩牌。
一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
这时，小明脑子里突然冒出一个问题：
如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
请填写该整数，不要填写任何多余的内容或说明文字。
答案:3598180
考点递归，其实前面一直下来都没考到dp和递归，从这角度想，应该会用到了把，不过我是暴力模拟到开头就发现可以递归了org，这里呢，每种纸牌有5种取法，有13种纸牌，可以选择取1个，取2个，取3个，取4个，取0个，注意不取的情况一定不能漏qaq，第一次漏了，粗心鸭= =，所以考试记得回头检查
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88044052
 */
public class _07牌型种数 {
	static int ans;
	public static void main(String[] args) {
		f(0,0);
		System.out.println(ans);
	}
	private static void f(int k, int cnt) {
		// TODO Auto-generated method stub
		if(k>13||cnt>13)return;
		if (k==13&&cnt==13) {
			ans++;
			return;
		}
		for (int i = 0; i < 5; i++) {
			f(k+1, cnt+i);
		}
	}
}
