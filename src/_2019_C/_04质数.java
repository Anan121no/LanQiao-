package _2019_C;

import java.util.Scanner;

/*
 * ����֪����һ�������� 2���ڶ��������� 3�������������� 5����������� �� 2019 �������Ƕ��٣�
 */
public class _04���� {
	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
    int ans=0;
    int res=0;//����res++����ֱ�Ӵ�1��ʼ�˸�
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
    for(int i=2;i<=nums/2;i++){//2��num/2Ч�ʸ�һ�룬Ҳ���Ե�num
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
