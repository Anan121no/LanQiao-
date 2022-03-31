package _2018_B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 小明维护着一个程序员论坛。现在他收集了一份"点赞"日志，日志共有N行。其中每一行的格式是：
ts id
表示在ts时刻编号id的帖子收到一个"赞"。
现在小明想统计有哪些帖子曾经是"热帖"。如果一个帖子曾在任意一个长度为D的时间段内收到不少于K个赞，小明就认为这个帖子曾是"热帖"。
具体来说，如果存在某个时刻T满足该帖在[T, T+D)这段时间内(注意是左闭右开区间)收到不少于K个赞，该帖就曾是"热帖"。
给定日志，请你帮助小明统计出所有曾是"热帖"的帖子编号。
【输入格式】
第一行包含三个整数N、D和K。
以下N行每行一条日志，包含两个整数ts和id。
对于50%的数据，1 <= K <= N <= 1000
对于100%的数据，1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000
【输出格式】
按从小到大的顺序输出热帖id。每个id一行。
【输入样例】
7 10 2
0 1
0 10
10 10
10 1
9 1
100 3
100 3
【输出样例】
1
3
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
解题思路
运用到了结构体 利用结构体来存储这些数据
然后进行排序 排好序
就循环一遍就可以检索出来 热帖
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
	/**
	 * @author sjf
	 * @date 2020/3/8 18:01
	 */
	class log {

	     int ts;
	     int id;

	    public log(int ts, int id) {
	        this.ts = ts;
	        this.id = id;
	    }


	    @Override
	    public String toString() {
	        return "log{" +
	                "ts=" + ts +
	                ", id=" + id +
	                '}';
	    }
	}

	public class _08日志统计 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N , K , D;
	        N = sc.nextInt();
	        D = sc.nextInt();
	        K = sc.nextInt();

	        ArrayList<log> log1 = new ArrayList<>();

	        for (int i = 0; i < N; i++) {
	            int tst = sc.nextInt();
	            int idt = sc.nextInt();
	            log1.add(new log(tst,idt));
	        }

	        Collections.sort(log1, new Comparator<log>() {
	            @Override
	            public int compare(log o1, log o2) {
	                //首先看 id 的大小
	                int result = o1.id - o2.id;
	                //id大小相同 看 时刻
	                if(result == 0){
	                    result = o1.ts - o2.ts;
	                }
	                return result;
	            }
	        });

	        //System.out.println(log1);
	        //[log{ts=0, id=1}, log{ts=9, id=1}, log{ts=10, id=1}, log{ts=100, id=3}, log{ts=100, id=3}, log{ts=0, id=10}, log{ts=10, id=10}]

	        int previousid = log1.get(0).id;
	        int flag= 0;
	        for (int i = 0; i < N-K+1; i++) {
	            //记录每次的 id
	            int idtemp = log1.get(i).id;
	            if(log1.get(i+K-1).id == previousid && log1.get(i+K-1).id == idtemp && flag == 0){
	                //如果在距离  K 处有相等的id 那么判断 ts 的关系
	                if(log1.get(i).ts+D > log1.get(i+K-1).ts) {
	                    flag = 1;
	                    System.out.println(idtemp);
	                }
	            }
	            else if(log1.get(i).id != previousid ){
	                previousid = idtemp;  //开始一个新的帖子的检查
	                flag = 0;
	                i--;  // 退回一下 来缓冲掉之后的那个 i++；
	            }

	        }
		 }
}
