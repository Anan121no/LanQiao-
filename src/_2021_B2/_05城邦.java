package _2021_B2;

import java.util.*;

/*
 * С������һ��ˮ���������� 2021 ���ǰ���α�� 1 �� 2021��
 * �����������ǰ�֮�䣬����һ����ֱ�����ӡ�Ϊ����ףС�����Ĵ�ͳ���գ�
 * С��������׼����һ������װ�����������ڱ��Ϊ a �� b �������ǰ
 * ����֮��������Ҫװ����������Ҫ�ķ������¼��㣺�ҵ� a �� b ��ʮ���������в�ͬ����λ
 * ������λ�ϵ�������͡����磬���Ϊ 2021 �� 922 �����ǰ�֮�䣬ǧλ����λ�͸�λ����ͬ��
 * ����Щ��λ�ϵ����ּ������� (2 + 0 + 1) + (0 + 9 + 2) = 14��ע�� 922 û��ǧλ��
 * ǧλ���� 0��Ϊ�˽�Լ��֧��С��������׼��ֻװ�� 2020 ���ţ�
 * ����Ҫ��֤������һ���ǰ������һ���ǰ�֮�������ȫֻͨ��װ�ε��ŵ��
 * ���ʣ�С������������Ҫ�����ٷ��ò������װ�Ρ�
��ʾ������ʹ�ü������̽�����⡣
��������������������������������
��Ȩ����������ΪCSDN������dem.o����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45800978/article/details/116724283
 */
public class _05�ǰ� {
	public static void main(String args[]) {
        // ���α�Ŵ�1 - 2021
        List<int[]>edges = new LinkedList<>();
        // ���
        for (int i = 1; i <= 2021; i++) {
            for (int j = i + 1; j <= 2021; j++) {
                edges.add(new int[]{i, j, getNum(i, j)});
            }
        }
        // �ǵø�������
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        // ���鼯
        class UF {
            // ��ͨ��������
            int count;
            // ����ÿ����
            int[] parent;
            // ����ÿ�����Ĵ�С
            int[] size;
            // ���캯��
            UF(int n) {
                this.count = n;
                this.parent = new int[n];
                this.size = new int[n];
                // ��ʼ��
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }
            // ��x�ĸ��ڵ�
            public int find(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
            // �ж��Ƿ�����
            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }
            // ��ͨ�����ڵ�
            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                // �Ѿ�����
                if (rootP == rootQ) return;
                // С�����ڴ�����
                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }
                // ��ͨ����--
                count--;
            }
            // ������ͨ��������
            public int count() {
                return count;
            }
        }
        // ��1 - 2021
        UF uf = new UF(2022);
        int mst = 0;
        for (int[] node : edges) {
            if (uf.connected(node[0], node[1])) continue;
            uf.union(node[0], node[1]);
            mst += node[2];
        }
        // ע��ڵ�0�����õ�������ʣ�����ͨ����Ӧ�� = 2
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
