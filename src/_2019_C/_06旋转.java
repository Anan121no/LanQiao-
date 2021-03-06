package _2019_C;

import java.util.Scanner;

/*
 * 图片旋转是对图片最简单的处理方式之一，在本题中，你需要对图片顺时 针旋转 90 度。 
 * 我们用一个 n×m 的二维数组来表示一个图片，例如下面给出一个 3×4 的 图片的例子：
3 4
1 3 5 7
9 8 7 6
3 5 9 7
这个图片顺时针旋转 90 度后的图片如下：
3 9 1 
5 8 3 
9 7 5 
7 6 7 
给定初始图片，请计算旋转后的图片。
【输入格式】
输入的第一行包含两个整数 n 和 m，分别表示行数和列数。
 接下来 n 行，每行 m 个整数，表示给定的图片。图片中的每个元素（像 素）为一个值为 0 至 255 之间的整数（包含 0 和 255）。
【输出格式】
输出 m 行 n 列，表示旋转后的图片。
思路：
由画图可知，第一行的元素旋转后，会变成目标数组的最后一列，
第二行的元素旋转后，会变成目标数组的倒数第二列，由此可以
推出来规律了
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108705083
 */
public class _06旋转 {
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int tran[][]=new int[m][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<m;j++){
				tran[j][i]=sc.nextInt();
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(tran[i][j]+" ");
			}
			System.out.println();
		}
}
}
