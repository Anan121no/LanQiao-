package _2016_A;
/*
 * 现在小学的数学题目也不是那么好玩的。
看看这个寒假作业：
   □ + □ = □
   □ - □ = □
   □ × □ = □
   □ ÷ □ = □  
   (如果显示不出来，可以参见【图1.jpg】)   
每个方块代表1~13中的某一个数字，但不能重复。
比如：
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
以及： 
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
就算两种解法。（加法，乘法交换律后算不同的方案）
你一共找到了多少种方案？
请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
答案:64,2^13,需要提前剪枝才能跑出答案
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _06寒假作业 {
	private static int []a = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	static int ans;
	public static void main(String[] args) {
		dfs(0);
	}
	private static void dfs(int k) {
		// TODO Auto-generated method stub
		if (k==13) {
			if (check()) {
				System.out.println();
			}
		}
		for (int i = k; i < a.length; i++) {
			swap(k,i);
			dfs(k+1);
			swap(k,i);
		}
	}
	private static boolean check() {
		// TODO Auto-generated method stub
		if(a[0]+a[1]==a[2]&&
			a[3]-a[4]==a[5]&&
			a[6]*a[7]==a[8]&&
			a[9]/a[10]==a[11])
			return true;
		return false;
	}
	private static void swap(int k, int i) {
		// TODO Auto-generated method stub
		int t = a[i];
		a[i] = a[k];
		a[k] = t;
	}
}
