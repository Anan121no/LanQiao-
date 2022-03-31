package _2020_B1;

import java.io.*;
import java.util.Arrays;

/*
 * 给定一棵包含 N 个节点的二叉树，节点编号是 1 ∼ N。其中 i 号节点具有
权值 Wi，并且这些节点的权值恰好形成了一棵排序二叉树 (BST)。
现在给定一个节点编号 K，小明想知道，在这 N 个权值以外，有多少个整
数 X (即 X 不等于任何 Wi ) 满足：给编号为 K 的节点增加一个权值为 X 的子
节点，仍可以得到一棵 BST。
例如在下图中，括号外的数字表示编号、括号内的数字表示权值。即编号
1 ∼ 4 的节点权值依次是 0、10、20、30。


如果 K = 1，那么答案为 0。因为 1 号节点已经有左右子节点，不能再增
加子节点了。
如果 K = 2，那么答案为无穷多。因为任何一个负数都可以作为 2 的左子
节点。
如果 K = 3，那么答案为 9。因为 X = 11, 12, · · · , 19 都可以作为 3 的左子
节点。

输入格式

第一行包含 2 个整数 N 和 K。
以下 N 行每行包含 2 个整数，其中第 i 行是编号为 i 的节点的父节点编号
Pi 和权值 Wi 。注意 Pi = 0 表示 i 是根节点。
输入保证是一棵 BST。

输出格式

一个整数代表答案。如果答案是无穷多，输出 −1。

测试样例1

Input：
4 3
0 10
1 0
1 20
3 30

Output：
9

评测用例规模与约定

对于 60% 的评测用例，1 ≤ K ≤ N ≤ 100，0 ≤ Wi ≤ 200，且 Wi 各不相同。
对于所有评测用例，1 ≤ K ≤ N ≤ 10000，0 ≤ Wi ≤ 100000000，且 Wi 各不
相同。
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _09插入节点问题 {
	public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int)in.nval, v, w;
        in.nextToken();
        int k = (int)in.nval;
        Node[] tree = new Node[n + 1];
        tree[0] = new Node(0);
        for (int i = 1; i <= n; i++){
            in.nextToken();
            w = (int)in.nval;
            in.nextToken();
            v = (int)in.nval;
            if (v < tree[w].value) tree[i] = tree[w].left = new Node(v);
            else tree[i] = tree[w].right = new Node(v);
        }
        if (tree[k].left != null && tree[k].right!= null) System.out.print('0');
        else {
            Node node = tree[k];
            Arrays.sort(tree);
            int left = 1, right = n, mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (tree[mid].value < node.value) left = mid + 1;
                else if (tree[mid].value > node.value) right = mid - 1;
                else break;
            }
            if (mid == 1 || mid == n) System.out.print("-1");
            else {
                left = node.left == null? tree[mid - 1].value: node.value;
                right = node.right == null? tree[mid + 1].value: node.value;
                System.out.print(right - left - 1);
            }
        }
    }

    static class Node implements Comparable<Node> {

        int value;

        Node left, right;

        Node(int value) { this.value = value; }

        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }
}
