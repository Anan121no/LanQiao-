package _2021_B2;

import java.io.*;
import java.util.*;

/*
 * 有 n 台计算机，第 i 台计算机的运算能力为 vi。
有一系列的任务被指派到各个计算机上，第 i 个任务在 ai 时刻分配，指定
计算机编号为 bi ，耗时为 ci 且算力消耗为 di 。如果此任务成功分配，将立刻
开始运行，期间持续占用 bi 号计算机 di 的算力，持续 ci 秒。
对于每次任务分配，如果计算机剩余的运算能力不足则输出 −1，并取消这
次分配，否则输出分配完这个任务后这台计算机的剩余运算能力。
【输入格式】
输入的第一行包含两个整数 n, m，分别表示计算机数目和要分配的任务数。
第二行包含 n 个整数 v1, v2, · · · vn，分别表示每个计算机的运算能力。
接下来 m 行每行 4 个整数 ai, bi, ci, di，意义如上所述。数据保证 ai 严格递
增，即 ai < ai+1。
【输出格式】
输出 m 行，每行包含一个数，对应每次任务分配的结果。
【样例输入】
2 6
5 5
1 1 5 3
2 2 2 6
3 1 2 3
4 1 6 1
5 1 3 3
6 1 3 4
【样例输出】
2
-1
-1
1
-1
0
【样例说明】
时刻 1，第 1 个任务被分配到第 1 台计算机，耗时为 5 ，这个任务时刻 6
会结束，占用计算机 1 的算力 3。
时刻 2，第 2 个任务需要的算力不足，所以分配失败了。
时刻 3，第 1 个计算机仍然正在计算第 1 个任务，剩余算力不足 3，所以
失败。
时刻 4，第 1 个计算机仍然正在计算第 1 个任务，但剩余算力足够，分配
后剩余算力 1。
时刻 5，第 1 个计算机仍然正在计算第 1, 4 个任务，剩余算力不足 4，失
败。
时刻 6，第 1 个计算机仍然正在计算第 4 个任务，剩余算力足够，且恰好
用完。
【评测用例规模与约定】
对于 20% 的评测用例，n, m ≤ 200。
对于 40% 的评测用例，n, m ≤ 2000。
对于所有评测用例，1 ≤ n, m ≤ 200000，1 ≤ ai, ci, di, vi ≤ 109，1 ≤ bi ≤ n。
————————————————
版权声明：本文为CSDN博主「dem.o」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45800978/article/details/116724283
 */
public class _09负载均衡 {
/*
 * 直接模拟，用优先队列，也就是所谓的堆去存储一个个节点，这个节点存储着当前任务的结束时刻，
 * 和恢复体力值，考虑到有多个计算机，应该要用优先队列数组进行存储。
再次强调Java中使用System.out.println速度过慢的问题，改用BufferedWriter，
打印的时候将输出内容转换为String类型即可。
————————————————
版权声明：本文为CSDN博主「可乐塞满冰」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Mxeron/article/details/123021102
 */
	static class node{
	    int reHour;
	    int health;
	    node(){};
	    node(int reHour, int health) {
	        this.reHour = reHour;
	        this.health = health;
	    }
	    static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
	    public static void main(String args[]) throws IOException {
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        int m = scan.nextInt();
	        // 运算能力
	        int[] com = new int[n + 1];
	        for (int i = 1; i <= n; i++) {
	            com[i] = scan.nextInt();
	        }
	        // 构建优先队列
	        Queue<node>[] pq = new PriorityQueue[n + 1];
	        for (int i = 0; i < n + 1; i++) {
	            pq[i] = new PriorityQueue<>(new Comparator<node>() {
	                @Override
	                // 按照恢复时间从小到大排序
	                public int compare(node o1, node o2) {
	                    return o1.reHour - o2.reHour;
	                }
	            });
	        }
	        int a, b, c, d;
	        for (int i = 0; i < m; i++) {
	            // 第 i 个任务在 ai 时刻分配，指定计算机编号为 bi，耗时为 ci 且算力消耗为 di
	            // 如果此任务成功分配，将立刻开始运行，期间持续占用 bi 号计算机 di 的算力，持续 ci 秒
	            a = scan.nextInt();
	            b = scan.nextInt();
	            c = scan.nextInt();
	            d = scan.nextInt();
	            // 注意任务执行完，算力是可以恢复的
	            while (!pq[b].isEmpty()) {
	                node tmp = pq[b].peek();
	                if (tmp.reHour <= a) {
	                    com[b] += tmp.health;
	                    pq[b].poll();
	                } else {
	                    break;
	                }
	            }
	            if (com[b] < d) {
	                log.write(-1 + "");
	                log.write("\n");
	            } else {
	                // 消耗计算机算力
	                com[b] -= d;
	                // 入队
	                pq[b].offer(new node(a + c, d));
	                log.write(com[b] + "");
	                log.write('\n');
	            }
	        }
	        log.flush();
	    }
	}
}
