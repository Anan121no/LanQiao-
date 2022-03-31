package _2017_C;
import java.util.Scanner;
/*
 * A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
下图就是一种排法
这样的排法可能会有很多。
如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
请你计算并提交该数字。
注意：需要提交的是一个整数，不要提交任何多余内容。
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
1.这里正三角要求每个边的和相等，这就相当与给了一个判断条件；
2.可以用一个数组来判断是否三条边的和是否相等；
3.用全排列求出1~9的全排列，每种结果存在数组中，再写一个判断
条件看是否满足条件1，满足条件就加1；
4.最后的结果是包含重复的，题目说了旋转、镜像后相同的算同一种，
一个顶点可以在三角形的三个顶点中的任何一个，因此旋转去重结果
要除以3，镜像就是左右换除以2；
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _03纸牌三角形 {
	 public static int ans=0;
	    public static void main(String[] args) {
	        Scanner input=new Scanner(System.in);
	        int arr[]=new int[10];
	        int visted[]=new int[10];
	        dfs(1,arr,visted);
	        System.out.print(ans/6);

	    }
	    public static void dfs(int level,int []arr ,int []visted)
	    {
	        if(level>9){
	            //判断是否为等边三角形
	            int bound1=arr[1]+arr[2]+arr[3]+arr[4];
	            int bound2=arr[4]+arr[5]+arr[6]+arr[7];
	            int bound3=arr[7]+arr[8]+arr[9]+arr[1];
	            //去重
	            if(bound1==bound2&&bound1==bound3){
	                ans++;
	            }
	            return;
	        }
	        //全排列
	        for(int i=1;i<=9;i++){
	            if(visted[i]==0){
	                visted[i]=1;
	                arr[level]=i;
	                dfs(level+1,arr,visted);
	                visted[i]=0;
	            }
	        }
	    }
}
