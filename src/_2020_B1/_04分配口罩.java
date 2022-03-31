package _2020_B1;

import java.util.Scanner;

/*
 * 某市市长获得了若干批口罩，每一批口罩的数目如下：（如果你把以下文
字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在试题目
录下有一个文件 mask.txt，内容与下面的文本相同）
9090400
8499400
5926800
8547000
4958200
4422600
5751200
4175600
6309600
5865200
6604400
4635000
10663400
8087200
4554000
现在市长要把口罩分配给市内的 2 所医院。由于物流限制，每一批口罩只
能全部分配给其中一家医院。市长希望 2 所医院获得的口罩总数之差越小越好。
请你计算这个差最小是多少？

答案提交

这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

2400
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _04分配口罩 {
	 static int sum, cnt = 0x3f3f3f3f, value[] = new int[15];

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        for (int i = 0; i < 15; i++)
	            sum += value[i] = in.nextInt();
	        dfs(0, 0);
	        System.out.print(cnt);
	    }

	    static void dfs(int d, int v) {
	        if (d == 15) cnt = min(cnt, abs(sum - v - v));
	        else {
	            dfs(d + 1, v + value[d]);
	            dfs(d + 1, v);
	        }
	    }

	    static int min(int a, int b) { return a < b? a: b; }

	    static int abs(int a) { return a > 0? a: -a; }
}
