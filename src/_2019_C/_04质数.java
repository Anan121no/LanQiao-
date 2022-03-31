package _2019_C;

import java.util.Scanner;

/*
 * 我们知道第一个质数是 2、第二个质数是 3、第三个质数是 5……请你计算 第 2019 个质数是多少？
 */
public class _04质数 {
	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
    int ans=0;
    int res=0;//下面res++，就直接从1开始了改
    while (ans<=2019){
        res++;
        if(check(res)){
            ans++;
        }
    }
    System.out.println(res);
}
public static boolean check(int nums){
    int flag=0;
    for(int i=2;i<=nums/2;i++){//2到num/2效率高一半，也可以到num
        if(nums%i==0){
            flag=1;
            break;
        }
    }
    if(flag==1)
        return  false;
    else
        return  true;
}
}
