package _2019_C;

import java.util.Scanner;

/*
 * 小明公司的办公区有一条长长的走廊，由 N 个方格区域组成，如下图所示。
走廊内部署了 K 台扫地机器人，其中第 i 台在第 Ai 个方格区域中。 已知扫地机器人每分钟可以移动到左右相邻的方格中，并将该区域清扫干净。
请你编写一个程序，计算每台机器人的清扫路线，使得
(1)、它们最终都返回出发方格，
(2)、每个方格区域都至少被清扫一遍，
(3)、从机器人开始行动到最后一台机器人归位花费的时间最少。
注意多台机器人可以同时清扫同一方块区域，它们不会互相影响。
输出最少花费的时间。 在上图所示的例子中，最少花费时间是 6。
第一台路线：2-1-2-3-4-3-2，清 扫了 1、2、3、4 号区域。
第二台路线 5-6-7-6-5，清扫了 5、6、7。第三台路线 10-9-8-9-10，清扫了 8、9 和 10。
【输入格式】
第一行包含两个整数 N 和 K。 接下来 K 行，每行一个整数 Ai。
【输出格式】
输出一个整数表示答案。
【样例输入】 10 3 5 2 10
【样例输出】 6
【评测用例规模与约定】
对于 30% 的评测用例，1≤ K < N ≤10。 对于 60% 的评测用例，
1≤ K < N ≤1000。 对于所有评测用例，1≤ K < N ≤100000，
1≤ Ai ≤ N。
 */
public class _10扫地机器人 {
	public static int n;
    public static int arr[];
    public static boolean clear[];
    public static boolean check(int arr[],int x){
        clear=new boolean[n+1];
        int p=0;
        int flag=0;
        int index=1;
        boolean out=true;
        while(index<=n){
            p=0;
            flag=0;
            while(p<x&&index+p<=n){
                if(index+p<=n&&arr[index+p]>0){
                    if(arr[index+p]==1){    
                        flag++;
                        if(flag==2){
                            break;
                        }
                    }else{
                        flag++;
                        arr[index+p]--;
                        clear[index+p]=true;
                        break;
                    }
                }
                clear[index+p]=true;
                p++;
            }
            if(flag>0){
                index+=p;
            }else{
                return false;
            }
        }
        for(int i=1;i<=n;i++){
            if(!clear[i])return clear[i];
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int k=sc.nextInt();
        arr=new int[n+1];
        for(int i=0;i<k;i++){
            arr[sc.nextInt()]++;
        }
         
        int l=1,r=n,mid=(l+r)/2;
        while(l<=r){
            mid=(l+r)/2;
            boolean cur=check(arr,mid);
            boolean cur1=check(arr,mid-1);
            if(cur&&!cur1){
                break;
            }else if(cur){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        System.out.println((mid-1)*2);
    }
}
