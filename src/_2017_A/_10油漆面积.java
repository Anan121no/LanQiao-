package _2017_A;

import java.util.Scanner;

/*
 * X�����һ�����Ż���������һƬ�����Ͽ��š�
������ĵ����Ӳ��ʯ��ƽ���羵��
������ԱΪ���㣬�����˱�׼��ֱ������ϵ��
ÿ�������˶������س��������������Ǹ���Ȥ������Ҳ����ͬ��
�������ֲ�����ÿ�������˶��ᱨ��һ����������������Ϊ���ȿ��ŵ�����
���εı�ʾ��ʽΪ(x1,y1,x2,y2)��������ε������Խǵ����ꡣ
Ϊ����Ŀ���ܲ�Ҫ������л�����ѡ�еľ�������Ϳ��ɫ���ᡣ
С��������Ҫ�����Ṥ��ֻ������Ҫ����һ�£�һ��Ҫ�ķѶ������ᡣ
��ʵ��Ҳ���ѣ�ֻҪ������о��θ��ǵ�����һ���ж������Ϳ����ˡ�
ע�⣬�������μ�����ص���
���������Ϊ���ɾ��Σ�Ҫ������串�ǵ��������
�����ʽ��
��һ�У�һ������n����ʾ�ж��ٸ�����(1<=n<10000)
��������n�У�ÿ����4������x1 y1 x2 y2���ո�ֿ�����ʾ���ε������ԽǶ������ꡣ
(0<= x1,y1,x2,y2 <=10000)
�����ʽ��
һ��һ����������ʾ���θ��ǵ��������
���磬
���룺
3
1 5 10 10
3 1 20 20
2 7 15 17
����Ӧ�������
340
�����磬
���룺
3
5 2 10 6
2 7 12 10
8 1 15 15
����Ӧ�������
128
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
�������룬��˵����ֱ��ACŶ������Ҫ�߶���+ɨ����+��ɢ��
����ı�������ȷʵû�г�ʱ�����������Լ����ĵ�һ�������������Ǵ�ģ��Ǻǣ��Ѿ������²�
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _10������� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		vis = new boolean[10005][10005];
//		for(int i=0;i<10005;i++)
//			for(int j=0;j<10005;j++)
//				vis[i][j] = false;
		while(n-->0) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
//			if(x1>x2 && y1>y2)
//				paint(x2,y2,x1,y1);
//			else
				paint(x1,y1,x2,y2);
		}
		int ans=0;
		for(int i=0;i<10005;i++)
			for(int j=0;j<10005;j++)
				if(vis[i][j])
					ans++;
		System.out.println(ans);
	}
	
	static boolean[][] vis;
	
	
	static void paint(int x1,int y1,int x2,int y2) {
		for(int i=x1;i<x2;i++)
			for(int j=y1;j<y2;j++)
				vis[i][j] = true;
	}
}


/*
import java.util.Arrays;
import java.util.Scanner;
 

public class _10�������_2 {
 
  /���������ݽṹ��ɨ����/
  private static class Line implements Comparable<Line> {
    int x1, x2, h, f;//�������꣬�����꣨�߶ȣ���f=1Ϊ��ߣ�f=-1Ϊ����
 
    Line() {
    }
 
    Line(int _l, int _r, int _h, int _f) {
      x1 = _l;
      x2 = _r;
      h = _h;
      f = _f;
    }
 
    /���߶�����/
    @Override
    public int compareTo(Line o) {
      if (h < o.h) return -1;
      else if (h > o.h) return 1;
      else return 0;
    }
  }
 
  /�߶����Ķ���/
  private static class SegTree {
    int pl, pr, cnt, len;//��˵��ţ��Ҷ˵��ţ������Ǵ����������˵�֮�䱻���ǵĳ���
 
    SegTree() {
    }
 
    SegTree lson, rson;
  }
 
 
 
  static int n;
  static int[] X ;//= new int[N << 1];//��¼���еĺ�����
  //int PL=0,PR;
  static Line[] lines ;//= new Line[N];
 
  /*����������/
  static SegTree buildTree(int pl, int pr) {
    SegTree t = new SegTree();
    t.pl = pl;
    t.pr = pr;
    if (pl == pr) return t;
    int mid = ((pl + pr) >> 1);
    t.lson = buildTree(pl, mid);
    t.rson = buildTree(mid + 1, pr);
    return t;
  }
 
  static void updateLength(SegTree pTree, int tl, int tr) {
    if (pTree.cnt > 0) {
      pTree.len = X[tr] - X[tl - 1];//���������ϵĶ˵㣨��ţ����뵽X����ö�ά�����ϵ�ʵ�ʺ�����
    } else if (tl == tr) {
      pTree.len = 0;
    } else {//����
      pTree.len = pTree.lson.len + pTree.rson.len;
    }
 
  }
 
  static void update(SegTree tree, int pl, int pr, int value) {
    int tl = tree.pl;
    int tr = tree.pr;
    if (pl <= tl && pr >= tr) {
      tree.cnt += value;
      updateLength(tree, tl, tr);
      return;
    }
    int m = (tl + tr) >> 1;
    if (pl <= m) update(tree.lson, pl, pr, value);
    if (pr > m) update(tree.rson, pl, pr, value);
    updateLength(tree, tl, tr);
  }
 
  static int ans;
 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    X=new int[n*2];
    lines=new Line[n*2];
    int x1, y1, x2, y2;
    int index = 0;
    for (int i = 0; i < n; i++) {
      x1 = sc.nextInt();
      y1 = sc.nextInt();
      x2 = sc.nextInt();
      y2 = sc.nextInt();
      X[index] = x1;
      lines[index] = new Line(x1, x2, y1, 1);//�߶�1
      index++;
 
      X[index] = x2;
      lines[index] = new Line(x1, x2, y2, -1);//�߶�2
      index++;
    }
//    �����Ͼ�����2n�������꣬2n��ˮƽ�߶�
    Arrays.sort(X);//���к����������
    Arrays.sort(lines);//ɨ�������򣬴ӵ͵���
    /*��ɢ��������/
    int X_end = unique(X);//ȥ�ط���ֵ��һ������������ָ�����ȥ�غ������в��ظ����е����һ��Ԫ��
//    PR=X_end;
//    ��ʼ���߶���
    SegTree root = buildTree(1, X_end);
//    �ӵ͵��ߣ�����ɨ����
    for (int i = 0; i < index-1; ++i) {
      int pl = Arrays.binarySearch(X, 0, X_end + 1, lines[i].x1);//���ֲ��ң���¼�±꣬�����ǵڼ�����
      int pr = Arrays.binarySearch(X, 0, X_end + 1, lines[i].x2);//���ֲ��ң���¼�±꣬�����ǵڼ�����
      update(root, pl + 1, pr, lines[i].f);
      ans += root.len * (lines[i + 1].h - lines[i].h);//���*�߶�
 
    }
    System.out.println(ans);
  }
 
  private static int unique(int[] x) {
    int index = 0;
    for (int i = 1; i < x.length; i++) {
      if (x[i] == x[index]) continue;
      else {
        index++;
        x[index] = x[i];
      }
    }
    return index;
  }
}
*/