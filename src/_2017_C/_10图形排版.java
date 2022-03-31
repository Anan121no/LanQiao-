package _2017_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * С����Ҫ��һƪ�ĵ��м��� N ��ͼƬ�����е� i ��ͼƬ�Ŀ���� Wi���߶��� Hi��
����ֽ�ŵĿ���� M��С��ʹ�õ��ĵ��༭���߻������·�ʽ��ͼƬ�����Զ��Ű棺

�ù��߻ᰴ��ͼƬ˳���ڿ�� M ���ڣ��������ܶ��ͼƬ����һ�С����еĸ߶���������ߵ�ͼƬ�ĸ߶ȡ������� M=10 ��ֽ�������δ�ӡ 3x4, 2x2, 3x3 ����ͼƬ����Ч������ͼ��ʾ����һ�и߶�Ϊ4��(�ָ�������Ϊ�б�ߣ��ָ�������Ϊ�Ű�����������ɵľ���Ϊ��x��ͼƬռ�õİ���)
0123456789

111
111 333
11122333
11122333

�����ǰ��ʣ���ȴ���0������С����һ��ͼƬ������һ��ͼƬ�ᰴ�������ŵ����Ϊ��ǰ��ʣ����(�߶�����ȡ��)��Ȼ����뵱ǰ�С������ٷ���һ��4x9��ͼƬ������ʣ������2������ͼƬ�ᱻѹ����2x5���ٱ������һ�е�ĩβ����ʱ���и߶�Ϊ5��
0123456789
44
111 44
111 33344
1112233344
1112233344

�����ǰ��ʣ����Ϊ0���ù��߻����һ�п�ʼ������ʣ���ͼƬ�����Ű棬ֱ������ͼƬ��������ϡ���ʱ�����е��ܸ߶Ⱥ;����� N ��ͼƬ���Ű�߶ȡ������ٷ���11x1, 5x5, 3x4 ��ͼƬ��Ч������ͼ��ʾ���ܸ߶�Ϊ11��
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

���������Ű�߶ȹ��ߣ�ͼƬ���Ⱥ�˳��Ҳ���ܸı䣬С��ֻ�ô� N ��ͼƬ��ѡ��һ��ɾ�����Խ����ܸ߶ȡ���ϣ��ʣ��N-1��ͼƬ��ԭ˳����Ű�߶���ͣ����������͸߶��Ƕ���ô��

���룺

��һ�а����������� M �� N���ֱ��ʾֽ�ſ�Ⱥ�ͼƬ��������
������ N �У�ÿ��2������Wi, Hi����ʾ�� i ��ͼ��СΪ Wi*Hi��

����30%�����ݣ�����1<=N<=1000
����100%�����ݣ�����1<=N<=100000��1<=M, Wi, Hi<=100

�����

һ����������ʾ��ɾ����ĳһ��ͼƬ֮���Ű�߶��������Ƕ��١�

�������룺

4 3
2 2
2 3
2 2

���������

2

��һ��ʾ����
�������룺

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

���������

17
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _10ͼ���Ű� {
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
		//��������ӵ���i���״̬��Triple�����i����������(x,y)�͵�i�����ź�ĸ߶�h
		for(int i = 1; i <= n; i++) {
			//����
			Triple tmp = new Triple(cr[i-1]);
			//�����һ��װ���£������㻻��
			if(tmp.x == m) tmp.x = tmp.h = 0;
			//�½�����Ŀ��
			a[i] = new Pair(nextInt(), nextInt());
			cr[i] = new Triple();
			
			Pair b = Change(a[i], m - tmp.x);
			//���浱ǰ��λ��
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
		//��ÿһ��������һ��
		for(int i = n; i >= 1; i--) {
           //����ɾ����i��Ĵ�ah
			Triple pre = cr[i-1];
			int ah;
			if(pre.x == m) {
				ah = pre.y + B[0].y;
			} else {
				ah = pre.y - pre.h + B[pre.x].y - B[pre.x].h + Math.max(pre.h, B[pre.x].h);
			}
			ans = Math.min(ans, ah);
			
			//����DP���������i��n���(0,j)λ�ÿ�ʼ����
			for(int j = 0; j < m; j++) {
				Pair b = Change(a[i], m - j);
				Triple tmp;
				//��������Ҿ�Ҫ����
				if(j + b.x == m) tmp = new Triple(0, B[0].y, 0);
				//��������У��������
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
	//a��xС�ͷ���a�����򷵻�
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
