package _2017_B;
/*
 * A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
下图就是一种排法（如有对齐问题，参看p1.png）。
      A
     9 6
    4   8
   3 7 5 2
这样的排法可能会有很多。
如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
请你计算并提交该数字。
注意：需要提交的是一个整数，不要提交任何多余内容。
考虑旋转、镜像后相同，最后答案别忘了除6，和往年一样的无脑全排后看看边是否相等，144
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/87976875
 */
public class _02纸牌三角形 {
	public static void main(String[] args) {
		dfs(0);
		System.out.println(ans/6.0);//除浮点数是想验证是否整除
	}
	
	static int[] a = new int[] {1,2,3,4,5,6,7,8,9};
	static int ans = 0;
	
	static void dfs(int m) {
		if(m>=9) {
			if(a[0]+a[1]+a[3]+a[5]==a[0]+a[2]+a[4]+a[8] && a[0]+a[1]+a[3]+a[5]==a[5]+a[6]+a[7]+a[8]) 
				ans++;
			
			return;
		}
		
		for(int i=m;i<9;i++) {
			swap(i,m);
			dfs(m+1);
			swap(i,m);
		}
		
	}
	
	static void swap(int i,int j) {
		int t = a[i];
		a[i] =a[j];
		a[j] = t;
	}
}
