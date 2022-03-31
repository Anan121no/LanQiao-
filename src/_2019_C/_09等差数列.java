package _2019_C;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 【问题描述】
数学老师给小明出了一道等差数列求和的题目。
但是粗心的小明忘记了一 部分的数列，只记得其中 N 个整数。 现在给出这 N 个整数，小明想知道包含这 N 个整数的最短的等差数列有 几项？
【输入格式】
输入的第一行包含一个整数 N。 第二行包含 N 个整数 A1,A2,··· ,AN。(注意 A1 ∼ AN 并不一定是按等差数 列中的顺序给出)
【输出格式】
输出一个整数表示答案。
【样例输入】 5 2 6 4 10 20
【样例输出】 10
【样例说明】
包含 2、6、4、10、20 的最短的等差数列是 2、4、6、8、10、12、14、16、 18、20。
【评测用例规模与约定】
对于所有评测用例，2≤ N ≤100000，0≤ Ai ≤109。
10、扫地机器人（编程题）（25分）
思路：
1.它们都是同一个等差数列的值，因此它们中间俩俩的差，肯定是
nd(d是公差)，因为要求最短的等差数列，因此只需求所有的
俩俩差的最大公约数，求出最大公约数剩下的就好求了，
为
2.在俩俩相减前要先排序，使求出的nd是正数，为了方便，我们
把除第一位的每一位减去排序后的第一位，这样的结果也是nd
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108705083
 */
public class _09等差数列 {
	public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int arr[]=new int[N+1];
        for(int i=0;i<N;i++){
            arr[i]=input.nextInt();
        }
        Arrays.sort(arr);
        int Max=arr[N];
        int Min=arr[1];
        int d=0;
        int cha[]=new int[N];
        int index=0;
        //找每个数与第一位的公差
        for(int i=2;i<=N;i++){
        cha[index++]=arr[i]-Min;
        }
        //找最大公差
        for(int i=0;i<index;i++){
      //     int temp= gcd(cha[i-1],cha[i]);
           d=gcd(cha[i],d);
        }
        //公差为0的时候原数组就是最小等差数列
        if(d==0)
        System.out.println(N);
        else
        System.out.println((Max-Min)/d+1);


    }
    public  static int gcd(int a,int b){
        if(b==0)
            return a;
        else {
            return gcd(b,a%b);
        }
    }
}
