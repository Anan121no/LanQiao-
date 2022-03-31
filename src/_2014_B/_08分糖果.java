package _2014_B;

import java.util.Scanner;

/*
 * 问题描述
　　有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：
　　每个小朋友都把自己的糖果分一半给左手边的孩子。
　　一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
　　反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
　　你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
输入格式
　　程序首先读入一个整数N(2<N<100)，表示小朋友的人数。
　　接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）
输出格式
　　要求程序输出一个整数，表示老师需要补发的糖果数。
样例输入
3
2 2 4
样例输出
4
 */
public class _08分糖果 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//输入目标数据
		int N = in.nextInt();
		
		int arr[] = new int[N];
		int medArr[] = new int[N];
		
		//完成初始化
		for(int i = 0; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		//标记元素
		boolean flag = false;
		
		//变换次数
		int num = 0;
		
		while(flag == false) {
			
			flag = true;
			//将目标数组的一半存入中间数组，目标数组减半，并判断数组中的元素是否相同
			for(int i=0;i<N;i++) {
				medArr[i] = arr[i]/2;
				arr[i] = arr[i]/2;
				
				//检测是否在数组中的元素完全相同
				if(medArr[0] != medArr[i]) {
					flag = false;
				}
			}
			
			//执行变换
			for(int i=N-1;i>=0;i--) {
				//当i等于N-1时
				if(i == N-1) {
					arr[i] = arr[i]+medArr[0];
					//老师分给他一颗糖
					if(arr[i]%2 == 1) {
						arr[i]++;
						num++;
					}
				}else {
					arr[i] = arr[i]+medArr[i+1];
					//老师分给他一颗糖
					if(arr[i]%2 == 1) {
						arr[i]++;
						num++;
					}
				}
			}
			
		}
		//输出最终老师分的糖数
		System.out.println(num);
	}
}
