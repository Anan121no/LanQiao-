package _2017_B;

import java.util.Scanner;

/*
 *  儿童节那天有K位小朋友到小明家做客。小明拿出了珍藏的巧克力招待小朋友们。
    小明一共有N块巧克力，其中第i块是Hi x Wi的方格组成的长方形。
    为了公平起见，小明需要从这 N 块巧克力中切出K块巧克力分给小朋友们。切出的巧克力需要满足：
    1. 形状是正方形，边长是整数  
    2. 大小相同  
例如一块6x5的巧克力可以切出6块2x2的巧克力或者2块3x3的巧克力。
当然小朋友们都希望得到的巧克力尽可能大，你能帮小Hi计算出最大的边长是多少么？
输入
第一行包含两个整数N和K。(1 <= N, K <= 100000)  
以下N行每行包含两个整数Hi和Wi。(1 <= Hi, Wi <= 100000) 
输入保证每位小朋友至少能获得一块1x1的巧克力。   
输出
输出切出的正方形巧克力最大可能的边长。
样例输入：
2 10  
6 5  
5 6  
样例输出：
2
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
原题链接
提供大家一个oj链接，官网的java过不了，数据出的不好，这里可以AC,思路二分答案
二分答案最后输出的边界很重要，不然很容易WA,下面类似模板结果，ok()函数要自己写
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _09分巧克力_二分问题 {
	public static void main(String[] args) {
		int n,k;
		int[] h = new int[100000];
		int[] w = new int[100000];
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		for (int i = 0; i <n; i++) {
			h[i] = in.nextInt();
			w[i] = in.nextInt();
		}
		int r = 100001;
		int l = 1;
		int ans = 0;
		while (l<=r) {
			int mid = (l+r)/2;
			int cnt = 0;
			//每块巧克力，都按照len来切割
			for (int i = 0; i < n; i++) {
				cnt += (h[i]/mid)*(w[i]/mid);
			}
			if (cnt>=k) {
				l = mid +1;
				ans = mid;
			}else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}
}


