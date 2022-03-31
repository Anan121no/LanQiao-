package _2016_B;
/*
 * 有一堆煤球，堆成三角棱锥形。具体：
第一层放1个，
第二层3个（排列成三角形），
第三层6个（排列成三角形），
第四层10个（排列成三角形），
....
如果一共有100层，共有多少个煤球？
请填表示煤球总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
答案:171700,注意求的是100层总共的值,不是第100层的值
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _01煤球数目 {
	private static int ans;

	public static void main(String[] args) {
		System.out.println(f(1,101,0));
	}

	private static int f(int m, int n,int ans) {
		// TODO Auto-generated method stub
		if(m==n)return ans;
		int c = 0;
		for (int i = 1; i <= m; i++) {
			c+=i;
		}
		ans+=c;
		return f(m+1, n, ans);
	}
}
