package _2019_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 在游戏《星际争霸 II》中，高阶圣堂武士作为星灵的重要 AOE 单位，在
游戏的中后期发挥着重要的作用，其技能”灵能风暴“可以消耗大量的灵能对
一片区域内的敌军造成毁灭性的伤害。经常用于对抗人类的生化部队和虫族的
刺蛇飞龙等低血量单位。
【问题描述】
你控制着 n 名高阶圣堂武士，方便起见标为 1, 2, · · · , n。每名高阶圣堂武士
需要一定的灵能来战斗，每个人有一个灵能值 ai 表示其拥有的灵能的多少（ai
非负表示这名高阶圣堂武士比在最佳状态下多余了 ai 点灵能，ai 为负则表示这
名高阶圣堂武士还需要 −ai 点灵能才能到达最佳战斗状态）。现在系统赋予了
你的高阶圣堂武士一个能力，传递灵能，每次你可以选择一个 i ∈ [2, n − 1]，若
ai ≥ 0 则其两旁的高阶圣堂武士，也就是 i − 1、i + 1 这两名高阶圣堂武士会从
i 这名高阶圣堂武士这里各抽取 ai 点灵能；若 ai < 0 则其两旁的高阶圣堂武士，
也就是 i − 1, i + 1 这两名高阶圣堂武士会给 i 这名高阶圣堂武士 −ai 点灵能。形
式化来讲就是 ai−1+ = ai, ai+1+ = ai, ai− = 2ai。
灵能是非常高效的作战工具，同时也非常危险且不稳定，一位高阶圣堂
武士拥有的灵能过多或者过少都不好，定义一组高阶圣堂武士的不稳定度为
maxni=1|ai|，请你通过不限次数的传递灵能操作使得你控制的这一组高阶圣堂武
士的不稳定度最小。
【输入格式】
本题包含多组询问。输入的第一行包含一个正整数 T 表示询问组数。
接下来依次输入每一组询问。
每组询问的第一行包含一个正整数 n，表示高阶圣堂武士的数量。
接下来一行包含 n 个数 a1, a2, · · · , an。
【输出格式】
输出 T 行。每行一个整数依次表示每组询问的答案。
【样例输入】
3
3
5 -2 3
4
0 0 0 0
3
1 2 3
【样例输出】
3
0
3
【样例说明】
对于第一组询问：
对 2 号高阶圣堂武士进行传输操作后 a1 = 3，a2 = 2，a3 = 1。答案为 3。
对于第二组询问：
这一组高阶圣堂武士拥有的灵能都正好可以让他们达到最佳战斗状态。
【样例输入】
3
4
-1 -2 -3 7
4
2 3 4 -8
5
-1 -1 6 -1 -1
【样例输出】
5
7
4
【样例输入】
见文件trans3.in。
【样例输出】
见文件trans3.ans。
【数据规模与约定】
对于所有评测用例，T ≤ 3，3 ≤ n ≤ 300000，|ai
| ≤ 109。
评测时将使用 25 个评测用例测试你的程序，每个评测用例的限制如下：
评测用例编号 n |ai
| 特殊性质
1 = 3 ≤ 1000 无
2,3 ≤ 5 ≤ 1000 无
4,5,6,7 ≤ 10 ≤ 1000 无
8,9,10 ≤ 20 ≤ 1000 无
11 ≤ 100 ≤ 109 所有 ai 非负
12,13,14 ≤ 100 ≤ 109 无
15,16 ≤ 500 ≤ 109 无
17,18,19 ≤ 5000 ≤ 109 无
20 ≤ 5000 ≤ 109 所有 ai 非负
21 ≤ 100000 ≤ 109 所有 ai 非负
22,23 ≤ 100000 ≤ 109 无
24,25 ≤ 300000 ≤ 109 无
注意：本题输入量较大请使用快速的读入方式。
————————————————
版权声明：本文为CSDN博主「非洲的小白」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _10灵能传输 {
	//https://blog.csdn.net/qq_43319748/article/details/109096972
	int min = Integer.MAX_VALUE;
	 
	public _10灵能传输() throws Exception {
		// 注意：本题输入量较大请使用快速的读入方式。因此我们需要用流的方式先读入缓冲区，再不紧不忙的使用
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// T组询问
		int T = Integer.parseInt(br.readLine().trim());// String.trim()除去字符开头和结尾的空白
		// 存储每组轮询的结果
		int[] re = new int[T + 1];
		// 开始读取每组数据
		for (int a = 1; a <= T; a++) {
			int num = Integer.parseInt(br.readLine().trim());
			//split(" +")表示分割一个或多个空格;
			String[] split = br.readLine().split(" +");
			//存储前缀和
			int[] sum = new int[split.length + 1];
			for (int i = 1; i <= num; i++) {
				// 积累前缀和
				sum[i] = sum[i - 1] + Integer.parseInt(split[i - 1]);
			}
			//用来存储排列时产生的前缀和排列
			int[] temp = new int[sum.length];
			//这里直接取走最后一个前缀和，因为最后一项不会被改变
			temp[sum.length - 1] = sum[sum.length - 1];
			//全排列的必备访问表
			boolean[] visit = new boolean[sum.length];
			//开始深度搜索
			dfs(temp, sum, visit, 1);
			//存入得到的最小值结果
			re[a] = min;
			//初始化全局变量
			min = Integer.MAX_VALUE;
		}
		
		//打印输出
		for (int i = 1; i <= T; i++) {
			System.out.println(re[i]);
			
		}
        br.close();//记得关闭流
 
	}
 
	private void dfs(int[] temp, int[] sum, boolean[] visit, int n) {
		// 当搜索到前缀和最后一项的时候，当前排列搜索已经到头
		if (n == sum.length - 1) {
			int max = max(temp, n);
			// 如果小，那么进行替换
			if (max < min) {
				min = max;
			}
			return;
		}
		//开始进行全排列
		for (int  i= 1; i < sum.length - 1; i++) {
			// 如果sum数组里面的第j个数我们没有用过
			if (!visit[i]) {
				//追加一位排列长度
				temp[n] = sum[i]; 
			    /* 这里是针对本次排列的结果与前一次比较
			     * 根据题意要找最大值的最小值
			     * 如果当前未完成的数组中已经有任意一项大于前一次排列的最大值
			     * 那么以本次排列顺序为开头的多次深度搜索就没必要继续了
				 */
				if (max(temp, n)> min) continue; // 结束本层循环
				//设置为正在访问
				visit[i] = true; 
				// 搜索深度+1
				dfs(temp, sum, visit, n + 1);
				//访问完成，还原搜索前的状态未访问
				visit[i] = false;
			}
		}
	}
 
	//这里用来寻找排列产生的最大值，也就是题目中的不稳定度，要加绝对值
	public int max(int[] sum, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			//利用差值还原每个武士灵能情况
			if (Math.abs(sum[i] - sum[i - 1]) > max) {
				max = Math.abs(sum[i] - sum[i - 1]);
			}
		}
		return max;
	}
 
    public static void main(String[] args) throws Exception {
 
          new _10灵能传输();
 
    }
//
//————————————————
//版权声明：本文为CSDN博主「学习使我快乐——玉祥」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_43319748/article/details/109096972
}
