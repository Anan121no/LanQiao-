package A13;

import java.util.Arrays;

/*
 * 一般的排序有许多经典算法，如快速排序、希尔排序等。
但实际应用时，经常会或多或少有一些特殊的要求。我们没必要套用那些经典算法，可以根据实际情况建立更好的解法。
比如，对一个整型数组中的数字进行分类排序：
使得负数都靠左端，正数都靠右端，0在中部。注意问题的特点是：负数区域和正数区域内并不要求有序。可以利用这个特点通过1次线性扫描就结束战斗!!
以下的程序实现了该目标。
其中x指向待排序的整型数组，len是数组的长度。
void sort3p(int* x, int len)
{
int p = 0;
int left = 0;
int right = len-1;
while(p<=right){
	if(x[p]<0){
		int t = x[left];
		x[left] = x[p];
		x[p] = t;
		left++;
		p++;
	}
	else if(x[p]>0){
		int t = x[right];
		x[right] = x[p];
		x[p] = t;
		right--;			
	}
	else{
		__________________________;  //填空位置
	}
}
}
如果给定数组：
25,18,-2,0,16,-5,33,21,0,19,-16,25,-3,0
则排序后为：
-3,-2,-16,-5,0,0,0,21,19,33,25,16,18,25
 */
//题解思路：把小于0的放最左边，大于0的放最右边。等于0的p++也就是放当前的后面
public class 三步排序 {
	public static void main(String[] args) {
		int []x = {25,18,-2,0,16,-5,33,21,0,19,-16,25,-3,0};
		int len = x.length;
		sort3p(x, len);
		System.out.println(Arrays.toString(x));
	}
		static void sort3p(int x[], int len){
		int p = 0;
		int left = 0;//下标
		int right = len-1;//最大下标
		while(p<=right){
			if(x[p]<0){
				int t = x[left];
				x[left] = x[p];
				x[p] = t;		//元素小于0，将元素和left位置交换
				left++;
				p++;
			}
			else if(x[p]>0){
				int t = x[right];
				x[right] = x[p];
				x[p] = t;
				right--;		//元素大于0，将元素和left位置交换	
			}
			else{	//元素等于0
				p++;	 //填空位置
			}
		}	
	}
}

