package _2017_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * 小明需要在一篇文档中加入 N 张图片，其中第 i 张图片的宽度是 Wi，高度是 Hi。
假设纸张的宽度是 M，小明使用的文档编辑工具会用以下方式对图片进行自动排版：

该工具会按照图片顺序，在宽度 M 以内，将尽可能多的图片排在一行。该行的高度是行内最高的图片的高度。例如在 M=10 的纸张上依次打印 3x4, 2x2, 3x3 三张图片，则效果如下图所示，这一行高度为4。(分割线以上为列标尺，分割线以下为排版区域；数字组成的矩形为第x张图片占用的版面)
0123456789

111
111 333
11122333
11122333

如果当前行剩余宽度大于0，并且小于下一张图片，则下一张图片会按比例缩放到宽度为当前行剩余宽度(高度向上取整)，然后放入当前行。例如再放入一张4x9的图片，由于剩余宽度是2，这张图片会被压缩到2x5，再被放入第一行的末尾。此时该行高度为5：
0123456789
44
111 44
111 33344
1112233344
1112233344

如果当前行剩余宽度为0，该工具会从下一行开始继续对剩余的图片进行排版，直到所有图片都处理完毕。此时所有行的总高度和就是这 N 张图片的排版高度。例如再放入11x1, 5x5, 3x4 的图片后，效果如下图所示，总高度为11：
0123456789
44
111 44
111 33344
1112233344
1112233344
5555555555
66666
66666777
66666777
66666777
66666777

现在由于排版高度过高，图片的先后顺序也不能改变，小明只好从 N 张图片中选择一张删除掉以降低总高度。他希望剩余N-1张图片按原顺序的排版高度最低，你能求出最低高度是多少么？

输入：

第一行包含两个整数 M 和 N，分别表示纸张宽度和图片的数量。
接下来 N 行，每行2个整数Wi, Hi，表示第 i 个图大小为 Wi*Hi。

对于30%的数据，满足1<=N<=1000
对于100%的数据，满足1<=N<=100000，1<=M, Wi, Hi<=100

输出：

一个整数，表示在删除掉某一张图片之后，排版高度最少能是多少。

样例输入：

4 3
2 2
2 3
2 2

样例输出：

2

另一个示例，
样例输入：

2 10
4 4
4 3
1 3
4 5
2 1
2 3
5 4
5 3
1 5
2 4

样例输出：

17
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _10图形排版 {
	public static void main(String[] arg) {
		 solve();
	}
	
	static	StringTokenizer ST;
	static	BufferedReader BR;
	static	PrintWriter PW;
	
	static	String next() {
		while(ST == null || !ST.hasMoreTokens()) {
			try {
				ST = new StringTokenizer(BR.readLine());
			}catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		}
		return ST.nextToken();
	}
	
	static int nextInt() {
		return Integer.parseInt(next());
	}
	
public	static void solve() {
		BR = new BufferedReader(new InputStreamReader(System.in));
		PW = new PrintWriter(System.out);
		
		int m = nextInt(), n = nextInt();
		Pair a[] = new Pair[n + 10];
		Triple cr[] = new Triple[n + 10];
		cr[0] = new Triple();
		//正向处理出加到第i块的状态，Triple记忆第i块右下坐标(x,y)和第i块缩放后的高度h
		for(int i = 1; i <= n; i++) {
			//创建
			Triple tmp = new Triple(cr[i-1]);
			//如果这一行装不下，就置零换行
			if(tmp.x == m) tmp.x = tmp.h = 0;
			//新建输入的宽高
			a[i] = new Pair(nextInt(), nextInt());
			cr[i] = new Triple();
			
			Pair b = Change(a[i], m - tmp.x);
			//保存当前的位置
			cr[i].x = tmp.x + b.x;
			cr[i].h = Math.max(tmp.h, b.y);
			cr[i].y = cr[i].h + tmp.y - tmp.h;
		}
		
		Triple A[] = new Triple[m];
		Triple B[] = new Triple[m];
		for(int i = 0; i < m; i++) {
			A[i] = new Triple();
			B[i] = new Triple();
		}
		
		int ans = cr[n].y;
		//把每一个都尝试一下
		for(int i = n; i >= 1; i--) {
           //处理删除第i块的答案ah
			Triple pre = cr[i-1];
			int ah;
			if(pre.x == m) {
				ah = pre.y + B[0].y;
			} else {
				ah = pre.y - pre.h + B[pre.x].y - B[pre.x].h + Math.max(pre.h, B[pre.x].h);
			}
			ans = Math.min(ans, ah);
			
			//逆向DP，处理出第i至n块从(0,j)位置开始放置
			for(int j = 0; j < m; j++) {
				Pair b = Change(a[i], m - j);
				Triple tmp;
				//放完这个我就要换行
				if(j + b.x == m) tmp = new Triple(0, B[0].y, 0);
				//如果不换行，还是这个
				else tmp = new Triple(B[j + b.x]);
				
				A[j].h = Math.max(b.y, tmp.h);
				A[j].y = A[j].h + tmp.y - tmp.h;
			}
			
			for(int j = 0; j < m; j++)
				B[j] = new Triple(A[j]);
		}
		
		PW.print(ans);

		
		PW.close();
	}
	//a的x小就返回a，否则返回
static Pair Change(Pair A, int x) {
		if(A.x <= x) return new Pair(A);
		return new Pair(x, (A.y * x + A.x - 1) / A.x);
	}
}


class Pair implements Comparable<Pair> {
	int x, y;
	
	Pair() { }
	
	Pair(Pair A) { x = A.x; y = A.y; }
	
	Pair(int x, int y) {
		this.x = x; this.y = y;
	}
	
	@Override
	public int compareTo(Pair A) {
		return x == A.x ? y - A.y : x - A.x;
	}
}

class Triple {
	int x, y, h;
	
	Triple() {}
	
	Triple(int x, int y, int h) {
		this.x = x; this.y = y; this.h = h;
	}
	
	Triple(Triple A) {
		x = A.x; y = A.y; h = A.h;
	}
	
	@Override
	public String toString() {
		return String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(h);
	}
}
