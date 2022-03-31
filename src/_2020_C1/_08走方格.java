package _2020_C1;

import java.io.IOException;
import java.util.Scanner;

/*
 * 在平面上有一些二维的点阵。
这些点的编号就像二维数组的编号一样，从上到下依次为第 1 至第 n 行，
从左到右依次为第 1 至第 m 列，每一个点可以用行号和列号来表示。
现在有个人站在第 1 行第 1 列，要走到第 n 行第 m 列。只能向右或者向下
走。
注意，如果行号和列数都是偶数，不能走入这一格中。
问有多少种方案。
输入格式
输入一行包含两个整数 n, m。
输出格式
输出一个整数，表示答案。
测试样例1
Input：
3 4
Output：
2
测试样例2
Input：
6 6
Output：
0
评测用例规模与约定

对于所有评测用例，1 ≤ n ≤ 30, 1 ≤ m ≤ 30。
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _08走方格 {
	//递归
	public static void main(String[] args) {        
    	Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int count=dfs(1,1,n,m);
		System.out.print(count);
    }
    public static int dfs(int i,int j,int n,int m){
    	if(i%2==0&&j%2==0){
    		return 0;
    	}
    	if(i==n&&j==m){
    		return 1;
    	}  	
    	if(i==n){
    		return dfs(i,j+1,n,m);
    	}
    	if(j==m){
    		return dfs(i+1,j,n,m);
    	}
    	
    	return dfs(i,j+1,n,m)+dfs(i+1,j,n,m);
    	
    }
    
    //动态规划
//    public class Main {
//        public static void main(String[] args) {        
//        	Scanner sc=new Scanner(System.in);
//    		int n=sc.nextInt(),m=sc.nextInt();
//    		int[][] dp=new int[n+1][m+1];
//    		for(int i=1;i<=n;i++){ //第一列全为1
//    			dp[i][1]=1;
//    		}
//    		for(int i=1;i<=m;i++){ //第一行全为1
//    			dp[1][i]=1;
//    		}
//    		for(int i=2;i<=n;i++){
//    			for(int j=2;j<=m;j++){
//    				if(i%2!=0||j%2!=0)
//    					dp[i][j]=dp[i][j-1]+dp[i-1][j];
//    			}
//    		}
//    		System.out.print(dp[n][m]);
//        }
}
