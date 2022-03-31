package C21;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 对于一棵多叉树，我们可以通过 “左孩子右兄弟” 表示法，将其转化成一棵二叉树。
  如果我们认为每个结点的子结点是无序的，那么得到的二叉树可能不唯一。换句话说，每个结点可以选任意子结点作为左孩子，并按任意顺序连接右兄弟。
  给定一棵包含 N NN 个结点的多叉树，结点从 1 11 至 N NN 编号，其中 1 11 号结点是根，每个结点的父结点的编号比自己的编号小。请你计算其通过 “左孩子右兄弟” 表示法转化成的二叉树，高度最高是多少。注：只有根结点这一个结点的树高度为 0 00 。
  例如如下的多叉树：

  可能有以下 3 33 种 (这里只列出 3 33 种，并不是全部) 不同的 “左孩子右兄弟”表示：

  其中最后一种高度最高，为 4 44。

输入格式

  输入的第一行包含一个整数 N NN。
  以下 N − 1 N −1N−1 行，每行包含一个整数，依次表示 2 22 至 N NN 号结点的父结点编号。

输出格式

  输出一个整数表示答案。

测试样例1

Input：
5
1
1
1
2

Output：
4
评测用例规模与约定

  对于 30 3030% 的评测用例，1 ≤ N ≤ 20 1 ≤ N ≤ 201≤N≤20；
  对于所有评测用例，1 ≤ N ≤ 100000 1 ≤ N ≤ 1000001≤N≤100000。

树形 DP
  一棵树的高度等于根节点最高子树的高度加一，

  而一棵由左孩子右兄弟表示法得到的二叉树，

  我们可以将最大的子树放在最右边，

  这种策略下，每棵子树的高度为子树个数加最高子树高度。

  显 然 正 确

  于是有状态转移方程：
d p ( v ) = c o u n t ( s o n ( v ) ) + m a x { d p ( s o n ( v ) ) } dp(v) = \mathrm{count(son(}v\mathrm{))} + \mathrm{max\{}dp\mathrm{(son(}v\mathrm{))\}}
dp(v)=count(son(v))+max{dp(son(v))}
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/115876990
 */
public class _09左孩子右兄弟 {
	public static void main(String[] args) { new _09左孩子右兄弟().run(); }

    List<Integer>[] tree;

    void run() {
        InputReader in = new InputReader(System.in);
        int n = in.readInt(), v;
        tree = new List[n + 1];
        for (int w = 2; w <= n; w++) {
            v = in.readInt();
            if (tree[v] == null)
                tree[v] = new ArrayList();
            tree[v].add(w);
        }
        System.out.println(dp(1));
    }

    int dp(int v) {
        if (tree[v] == null) return 0;
        int max = 0;
        for (int w : tree[v])
            max = Math.max(max, dp(w));
        return tree[v].size() +  max;
    }

    class InputReader {

        BufferedReader reader;
        StringTokenizer token;

        InputReader(InputStream in) {
            this.reader = new BufferedReader(new InputStreamReader(in));
        }

        String read() {
            while (token == null || !token.hasMoreTokens()) {
                try {
                    token = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return token.nextToken();
        }

        int readInt() { return Integer.parseInt(read()); }
    }
//————————————————
//版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_43449564/article/details/115876990
}
