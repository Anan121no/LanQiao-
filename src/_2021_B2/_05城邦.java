package _2021_B2;

import java.util.*;

/*
 * 小蓝国是一个水上王国，有 2021 个城邦，依次编号 1 到 2021。
 * 在任意两个城邦之间，都有一座桥直接连接。为了庆祝小蓝国的传统节日，
 * 小蓝国政府准备将一部分桥装饰起来。对于编号为 a 和 b 的两个城邦，
 * 它们之间的桥如果要装饰起来，需要的费用如下计算：找到 a 和 b 在十进制下所有不同的数位
 * ，将数位上的数字求和。例如，编号为 2021 和 922 两个城邦之间，千位、百位和个位都不同，
 * 将这些数位上的数字加起来是 (2 + 0 + 1) + (0 + 9 + 2) = 14。注意 922 没有千位，
 * 千位看成 0。为了节约开支，小蓝国政府准备只装饰 2020 座桥，
 * 并且要保证从任意一个城邦到任意另一个城邦之间可以完全只通过装饰的桥到达。
 * 请问，小蓝国政府至少要花多少费用才能完成装饰。
提示：建议使用计算机编程解决问题。
————————————————
版权声明：本文为CSDN博主「dem.o」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45800978/article/details/116724283
 */
public class _05城邦 {
	public static void main(String args[]) {
        // 依次编号从1 - 2021
        List<int[]>edges = new LinkedList<>();
        // 存边
        for (int i = 1; i <= 2021; i++) {
            for (int j = i + 1; j <= 2021; j++) {
                edges.add(new int[]{i, j, getNum(i, j)});
            }
        }
        // 记得给边排序！
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        // 并查集
        class UF {
            // 连通分量个数
            int count;
            // 保存每棵树
            int[] parent;
            // 保存每棵树的大小
            int[] size;
            // 构造函数
            UF(int n) {
                this.count = n;
                this.parent = new int[n];
                this.size = new int[n];
                // 初始化
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }
            // 找x的根节点
            public int find(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
            // 判断是否相连
            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }
            // 连通两个节点
            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                // 已经相连
                if (rootP == rootQ) return;
                // 小树连在大树下
                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }
                // 连通分量--
                count--;
            }
            // 返回连通分量个数
            public int count() {
                return count;
            }
        }
        // 从1 - 2021
        UF uf = new UF(2022);
        int mst = 0;
        for (int[] node : edges) {
            if (uf.connected(node[0], node[1])) continue;
            uf.union(node[0], node[1]);
            mst += node[2];
        }
        // 注意节点0不会用到，所以剩余的连通分量应该 = 2
        if (uf.count() == 2) {
            System.out.println(mst);
        } else {
            System.out.println(-1);
        }
    }
    public static int getNum(int m, int n) {
        int sum = 0;
        while (m != 0 || n != 0) {
            if (m % 10 != n % 10) {
                sum += m % 10;
                sum += n % 10;
            }
            m /= 10;
            n /= 10;
        }
        return sum;
    }
}
