package _2018_C;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 班里N个小朋友，每个人都有自己最崇拜的一个小朋友（也可以是自己）。
在一个游戏中，需要小朋友坐一个圈，
每个小朋友都有自己最崇拜的小朋友在他的右手边。
求满足条件的圈最大多少人？
小朋友编号为1,2,3,…N
资源约定
峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms
输入格式
输入第一行，一个整数N（3<N<100000）
接下来一行N个整数，由空格分开。
输出格式
要求输出一个整数，表示满足条件的最大圈的人数。
测试样例1
Input：
9
3 4 2 5 3 8 4 6 9
Output：
4
Explanation：
如图p1.png所示，崇拜关系用箭头表示，红色表示不在圈中。
显然，最大圈是[2 4 5 3] 构成的圈
测试样例2
Input：
30
22 28 16 6 27 21 30 1 29 10 9 14 24 11 7 2 8 5 26 4 12 3 25 18 20 19 23 17 13 15

Output：
16
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _09小朋友崇拜圈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n+1];
		for (int i = 1; i <=n; i++) {
			num[i]=sc.nextInt();
		}
		sc.close();
		//记录当前的下标	 当前圈的大小	最大的圈有多少人
		int index=1,count=0,	max=-1;;
		Set<Integer> set=new HashSet<Integer>();
		boolean[] bool = new boolean[n+1];
		while(true){
			//能添加进去，说明里面没有重复的，可以加
			if(set.add(index)){
				//当前圈的数量+1
				count++;
				//当前人被用过了
				bool[index]=true;
				//替换下标
				index=num[index];
				continue;
			}
			else{
				//证明找到圈，与最大圈的人数比较
				max=Math.max(max, count);
				//上个圈的记录清空
				count=0;
				set.clear();
				//从1开始找没有被访问过的人，用没访问过的人去继续找圈，循环
				for (int i = 1; i <=n; i++) {
					if(!bool[i]){
						index=i;
						break;
					}
					//如果找到最后一个人都被访问过，证明全部被访问过，直接跳出
					if(i==n){
						 System.out.println(max);
						 return;
					}
				}
			}
		}
	}
}


class Text35 {
	static int N=30;	//N个小朋友
	static int max=0;
	static String maxStr="";
	public static void main(String[] args) {
		String str="22 28 16 6 27 21 30 1 29 10 9 14 24 11 7 2 8 5 26 4 12 3 25 18 20 19 23 17 13 15"; 	//N个小朋友对应崇拜的对象
		String quang="";		//崇拜圈临时变量
		String[] arr=str.split(" ");
		for(int i=0;i<arr.length;i++){
			quang=i+1+" ";
			dg(i+1,quang,arr);
		}
		System.out.println("最大圈="+max+"  ["+maxStr+"]");
	}
	public static void dg(int i,String quang,String[] arr){
		if(quang.split(" ")[0].equalsIgnoreCase(arr[i-1])){	//找到圈
			//System.out.println("找到圈= "+quang);
			if(quang.split(" ").length>max){
				 max=quang.split(" ").length;
				 maxStr=quang;
			}
			return;
		}
		quang+=arr[i-1]+" ";
		//System.out.println(quang);
		if(!quang.split(" ")[0].equalsIgnoreCase(arr[i-1])&&quang.split(" ").length>N){	//死循环圈
			return;
		}
		dg(Integer.parseInt(arr[i-1]),quang,arr);
	}
}