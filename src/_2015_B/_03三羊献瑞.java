package _2015_B;
/*
 * 观察下面的加法算式：
      祥 瑞 生 辉
  +   三 羊 献 瑞
-------------------
   三 羊 生 瑞 气
(如果有对齐问题，可以参看【图1.jpg】)
其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
这种0-9不同数字的枚举，直接暴力就好，不过感觉暴力也要写挺久的，也可以试下全排,答案：1085
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/87975540
 */
public class _03三羊献瑞 {
	public static void main(String[] args) {
		dfs(0);
	}
	static int[] a = new int [] {0,1,2,3,4,5,6,7,8,9};
	static void dfs(int m) {
		if(m>=10) {
			int x = 1000*a[0] + 100*a[1] + 10*a[2] + a[3];
			int y = 1000*a[4] + 100*a[5] + 10*a[6] + a[1];
			int z = 10000*a[4] + 1000*a[5] + 100*a[2] + 10*a[1] + a[7];
			if(a[0]==0 || a[4]==0)
				return;
			if(x+y==z)
				System.out.println(x+"+"+y+"=="+z);	
			return;
		}
		for(int i=m;i<10;i++) {
			swap(i,m);
			dfs(m+1);
			swap(i,m);
		}		
	}
	static void swap(int i,int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
