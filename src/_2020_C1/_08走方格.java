package _2020_C1;

import java.io.IOException;
import java.util.Scanner;

/*
 * ��ƽ������һЩ��ά�ĵ���
��Щ��ı�ž����ά����ı��һ�������ϵ�������Ϊ�� 1 ���� n �У�
����������Ϊ�� 1 ���� m �У�ÿһ����������кź��к�����ʾ��
�����и���վ�ڵ� 1 �е� 1 �У�Ҫ�ߵ��� n �е� m �С�ֻ�����һ�������
�ߡ�
ע�⣬����кź���������ż��������������һ���С�
���ж����ַ�����
�����ʽ
����һ�а����������� n, m��
�����ʽ
���һ����������ʾ�𰸡�
��������1
Input��
3 4
Output��
2
��������2
Input��
6 6
Output��
0
����������ģ��Լ��

������������������1 �� n �� 30, 1 �� m �� 30��
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _08�߷��� {
	//�ݹ�
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
    
    //��̬�滮
//    public class Main {
//        public static void main(String[] args) {        
//        	Scanner sc=new Scanner(System.in);
//    		int n=sc.nextInt(),m=sc.nextInt();
//    		int[][] dp=new int[n+1][m+1];
//    		for(int i=1;i<=n;i++){ //��һ��ȫΪ1
//    			dp[i][1]=1;
//    		}
//    		for(int i=1;i<=m;i++){ //��һ��ȫΪ1
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
