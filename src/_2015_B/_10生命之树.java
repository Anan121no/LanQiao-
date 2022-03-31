package _2015_B;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * ��Xɭ����ϵ۴���������֮����
����ÿ������ÿ���ڵ㣨Ҷ��Ҳ��Ϊһ���ڵ㣩�ϣ�������һ�����������������ĺ�гֵ��
�ϵ�Ҫ���������ѡ��һ���ǿսڵ㼯S��ʹ�ö���S�е�����������a,b��
������һ������ {a, v1, v2, ..., vk, b} ʹ����������е�ÿ���㶼��S�����Ԫ�أ����������������������һ����������
�����ǰ���£��ϵ�Ҫʹ��S�еĵ�����Ӧ�������ĺ;�����
������ĺ;����ϵ۸�����֮�������֡�
����atm��Ŭ�������Ѿ�֪�����ϵ۸�ÿ������ÿ���ڵ��ϵ�������
�������� atm ���ó����㣬����֪��������Ч�������֡�����Ҫ��Ϊ��дһ������������һ�����ķ�����
�������ʽ��
��һ��һ������ n ��ʾ������� n ���ڵ㡣
�ڶ��� n �����������α�ʾÿ���ڵ�����֡�
������ n-1 �У�ÿ�� 2 ������ u, v����ʾ����һ�� u �� v �ıߡ���������һ�����������ǲ����ڻ��ġ�
�������ʽ��
���һ��һ��������ʾ�ϵ۸�������ķ�����
���������롹
5
1 -2 -3 4 5
4 2
3 1
1 2
2 5

�����������
8
�����ݷ�Χ��
���� 30% �����ݣ�n <= 10
���� 100% �����ݣ�0 < n <= 10^5, ÿ���ڵ�����ֵľ���ֵ������ 10^6 ��
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 3000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
������������״dp,�޸���ת�и�����˼ά�ѶȺܴ󣬵���30%������10���ڵģ�����Ӧ�������£�ԭ�����ø���ķ�0.0��������Ļ���
����ö�����е��Ӽ������ж����е��Ӽ����Ƿ������ͨ��������жϿ�����dfs�������߲��鼯����30%
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/87975540


public class _10����֮�� {
 
  private static int n;
  private static long[] w;
  private static List<Integer>[] g;
  private static long ans ;
 
  public static void main(String[] args) throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("/Users/zhengwei/workspace/lanqiaobei2019/src/2015_Java_B/data10/in5.txt")));
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    w = new long[n + 1];
    g = new ArrayList[n + 1];
    initG();
    for (int i = 1; i <= n; i++) {
      w[i] = sc.nextLong();
    }
    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      g[a].add(b);
      g[b].add(a);
    }
    dfs(1, 0);
    System.out.println(ans);
  }
 
  /**
   * u��Ϊ���������������һ�����Ȩ�ͣ�����洢��w[u]��
   * @param u
   * @param fa
   *
  private static void dfs(int u, int fa) {
    for (int i = 0; i < g[u].size(); i++) {
      Integer child = g[u].get(i);
      if (child == fa) continue;
      dfs(child, u);
      if (w[child] > 0)
        w[u] += w[child];
    }
    if (w[u] > ans) ans = w[u];
  }
 
  private static void initG() {
    for (int i = 0; i < n + 1; i++) {
      g[i] = new ArrayList<Integer>();
    }
 
  }
}
 
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/87975540
 */
public class _10����֮�� {
	private static int n;
	private static long[] w;
	private static ArrayList<Integer>[] g;
	private static long ans;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		w=new long[n+1];
		g = new ArrayList[n+1];
		initG();
		for (int i = 1; i <= n; i++) {
			w[i]=in.nextLong();
		}
		for (int i = 0; i < n-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			g[a].add(b);
			g[b].add(a);
		}
		dfs(1,0);
		System.out.println(ans);
	}
//u��Ϊ���������������һ�����Ȩ�ͣ�����洢��w[u]��;
	private static void dfs(int u, int fa) {
		// TODO Auto-generated method stub
		for (int i = 0; i < g[u].size(); i++) {
			Integer child = g[u].get(i);
			if(child==fa)continue;
			dfs(child, u);
			if(w[child]>0) {
				w[u]+=w[child];
			}
		}
		if(w[u]>ans)ans=w[u];
	}

	private static void initG() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n+1; i++) {
			g[i]=new ArrayList<Integer>();
		}
	}
}
