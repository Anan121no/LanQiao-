package _2017_B;

import java.util.Arrays;
import java.util.Scanner;

/*
 * X星球的高科技实验室中整齐地堆放着某批珍贵金属原料。

每块金属原料的外形、尺寸完全一致，但重量不同。
金属材料被严格地堆放成金字塔形。

                             7 
                            5 8 
                           7 8 8 
                          9 2 7 2 
                         8 1 4 9 1 
                        8 1 8 8 4 1 
                       7 9 6 1 4 5 4 
                      5 6 5 5 6 9 5 6 
                     5 5 4 7 9 3 5 5 1 
                    7 5 7 9 7 4 7 3 3 1 
                   4 6 4 5 5 8 8 3 2 4 3 
                  1 1 3 3 1 6 6 5 5 4 4 2 
                 9 9 9 2 1 9 1 9 2 9 5 7 9 
                4 3 3 7 7 9 3 6 1 3 8 8 3 7 
               3 6 8 1 5 3 9 5 8 3 8 1 8 3 3 
              8 3 2 3 3 5 5 8 5 4 2 8 6 7 6 9 
             8 1 8 1 8 4 6 2 2 1 7 9 4 2 3 3 4 
            2 8 4 2 2 9 9 2 8 3 4 9 6 3 9 4 6 9 
           7 9 7 4 9 7 6 6 2 8 9 4 1 8 1 7 2 1 6 
          9 2 8 6 4 2 7 9 5 4 1 2 5 1 7 3 9 8 3 3 
         5 2 1 6 7 9 3 2 8 9 5 5 6 6 6 2 1 8 7 9 9 
        6 7 1 8 8 7 5 3 6 5 4 7 3 4 6 7 8 1 3 2 7 4 
       2 2 6 3 5 3 4 9 2 4 5 7 6 6 3 2 7 2 4 8 5 5 4 
      7 4 4 5 8 3 3 8 1 8 6 3 2 1 6 2 6 4 6 3 8 2 9 6 
     1 2 4 1 3 3 5 3 4 9 6 3 8 6 5 9 1 5 3 2 6 8 8 5 3 
    2 2 7 9 3 3 2 8 6 9 8 4 4 9 5 8 2 6 3 4 8 4 9 3 8 8 
   7 7 7 9 7 5 2 7 9 2 5 1 9 2 6 5 3 9 3 5 7 3 5 4 2 8 9 
  7 7 6 6 8 7 5 5 8 2 4 7 7 4 7 2 6 9 2 1 8 2 9 8 5 7 3 6 
 5 9 4 5 5 7 5 5 6 3 5 3 9 5 8 9 5 4 1 2 6 1 4 3 5 3 2 4 1 
X X X X X X X X X X X X X X X X X X X X X X X X X X X X X X 
其中的数字代表金属块的重量（计量单位较大）。
最下一层的X代表30台极高精度的电子秤。
假设每块原料的重量都十分精确地平均落在下方的两个金属块上，
最后，所有的金属块的重量都严格精确地平分落在最底层的电子秤上。
电子秤的计量单位很小，所以显示的数字很大。
工作人员发现，其中读数最小的电子秤的示数为：2086458231
请你推算出：读数最大的电子秤的示数为多少？
注意：需要提交的是一个整数，不要填写任何多余的内容。
答案:72665192664
这题目很坑，而且还用到了精确地平均，7/2的平方算是3.5还是3呢？这样真的精确吗？算了不吐槽了，就当出题人没想那么多用int做把，
但int可能会溢出导致答案错误，这应该也算是个考察点把，仔细....另外呢真要精确的话，最小的电子秤的示数给的应该是浮点数，
题目也会说精确到多少位之类的，所以...题目还是不要用精确的字眼把,如果真要精确的话,希望大家能联系到大数类
这题的结构和杨辉三角很像，不多解释了，每次把上一层的值除2累加到下面去，最后遍历最后一行求最值
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/87976875
 */
public class _03承压计算 {
	static long[][] arr = new long[30][30];
	 
	  public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    long factor=1;//2的 30次方
	    for (int i = 0; i < 30; ++i) {
	      factor<<=1;
	    }
	 
//	    输入数据放入二维数组
	    for (int i = 0; i < 29; ++i) {
	      for (int j = 0; j <= i; ++j) {
	        long a=sc.nextLong();
	        arr[i][j]=a*factor;//每个数据都乘以factor
	      }
	    }
	 
	//自上而下处理a[i][j]*factor（2的30次方）-->除以2，计入a[i+1][j]和a[i+1][j+1]
	//循环处理第1~N-1行
	    for (int i = 0; i < 29; ++i) {
	      for (int j = 0; j <=i ; ++j) {
	        long ha =arr[i][j]/2;
	        arr[i+1][j]+=ha;
	        arr[i+1][j+1]+=ha;
	      }
	    }
	//对a[N-1]这一行进行排序，查看最小值与factor之间的倍数关系，决定最大值是多少
	    Arrays.sort(arr[29]);
	    System.out.println(arr[29][0]);
	    System.out.println(arr[29][29]);
	    System.out.println(arr[29][29]/(arr[29][0]/2086458231));
	  }
}
