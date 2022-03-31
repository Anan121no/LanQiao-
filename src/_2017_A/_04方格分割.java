package _2017_A;
/*
 * 6x6的方格，沿着格子的边线剪开成两部分。
要求这两部分的形状完全相同。
如图：p1.png, p2.png, p3.png 就是可行的分割法。
试计算：
包括这3种分法在内，一共有多少种不同的分割方法。
注意：旋转对称的属于同一种分割法。
请提交该整数，不要填写任何多余的内容或说明文字。
先贴个超时代码典范,按照往年真题剪邮票枚举+求联通快的做法，超时了，2^18次方太多了，而且求出的答案也不一定正确，
基本的思路是对的，对称位置上的颜色不能一样，即vis[i][j]!=vis[5-i][5-j],在此思路上，我们不妨从搜索块的思路上变成枚举分割线，
从中心搜索到边界的线，当然是从2个方向搜索的，不过其实只要搜索一个方向，另外个方向取对称点,对称分割
最后答案别忘了除4(对称),509
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _04方格分割 {
	static int ans;
	static int[][] dire = {{-1,0},
			{1,0},
			{0,-1},
			{0,1}};
	static int[][] vis = new int[7][7];
	public static void main(String[] args) {
		dfs(3,3);
		System.out.println(ans/4);
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		if (x==0||y==0||x==6||y==6) {
			ans++;
			return;
		}
		vis[x][y] = 1;//当前点标记为已访问
		vis[6-x][6-y] = 1;//对称点也标记为已访问
		for (int k = 0; k < 4; k++) {
			int nx = x + dire[k][0];
			int ny = y + dire[k][1];
			//新坐标
			if (nx<0||nx>6||ny<0||ny>6) {
				continue;
			}
			if (0==vis[nx][ny]) {
				dfs(nx, ny);
			}
		}
		vis[x][y] = 0;
		vis[6-x][6-y] = 0;//对称
	}
}
