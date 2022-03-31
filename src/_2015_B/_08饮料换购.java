package _2015_B;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/*
 * 乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料，并且可以一直循环下去，但不允许赊账。
请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的n瓶饮料，最后他一共能得到多少瓶饮料。
输入：一个整数n，表示开始购买的饮料数量（0<n<10000）
输出：一个整数，表示实际得到的饮料数
例如：
用户输入：
100
程序应该输出：
149
用户输入：
101
程序应该输出：
151
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
问题 1072: 汽水瓶之前做到过一题，比这题难一点的，区别是这题可以先借给你一瓶汽水，意思是最后2个瓶盖也可以换一瓶，
这2题的做法都是递归+直接模拟= =
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/87975540
 */
public class _08饮料换购 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = n;
		while (n>=3) {
			n-=3;
			n++;
			count++;
		}
		System.out.println(count);
 	}
}
