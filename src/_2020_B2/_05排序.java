package _2020_B2;

import java.util.Scanner;

/*
 * 小蓝最近学习了一些排序算法，其中冒泡排序让他印象深刻。
在冒泡排序中，每次只能交换相邻的两个元素。
小蓝发现，如果对一个字符串中的字符排序，只允许交换相邻的两个字符，
则在所有可能的排序方案中，冒泡排序的总交换次数是最少的。
例如，对于字符串 lan 排序，只需要 1 次交换。对于字符串 qiao 排序，
总共需要 4 次交换。
小蓝找到了很多字符串试图排序，他恰巧碰到一个字符串，需要 100 次交
换，可是他忘了吧这个字符串记下来，现在找不到了。
请帮助小蓝找一个只包含小写英文字母且没有字母重复出现的字符串，对
该串的字符排序，正好需要 100 次交换。如果可能找到多个，请告诉小蓝最短
的那个。如果最短的仍然有多个，请告诉小蓝字典序最小的那个。请注意字符
串中不可以包含相同的字符。
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
个只包含小写英文字母的字符串，在提交答案时只填写这个字符串，填写多余
的内容将无法得分

思路：
jonmlkihgfedcba

冒泡排序，要求字符串最短，那就假设完全逆序，
设长度为n，则移动次数为 n*(n-1)/2
要求移动次数恰好大于100，则 n=15；移动次数105
要求字典序最小，则把第六个字符移动到第一个位置，前五个字符后移一位。
————————————————
版权声明：本文为CSDN博主「胡毛毛_三月」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45696377/article/details/109147147
 */
public class _05排序 {
	static int counts=0;
	public static void main(String[] args) {
		int[]str=new int[] {9,14,13,12,11,10,8,7,6,5,4,3,2,1,0};
		//System.out.println(sort2(str));
		StringBuilder sb = new StringBuilder();
		for(int i:str)sb.append((char)(i+'a'));
		System.out.println(sb);
	}
	static int sort2(int []arr) {
		int temp=0;//临时变量
		int res=0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                //如果前面的数比后面的数大，则交换
                if(arr[j]>arr[j+1]){
                	res++;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return res;
	}
}
