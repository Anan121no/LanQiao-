package _2017_C;

import java.util.Scanner;

/*
 * Excel��Ԫ��ĵ�ַ��ʾ����Ȥ����ʹ����ĸ����ʾ�кš�
���磬
A��ʾ��1�У�
B��ʾ��2�У�
Z��ʾ��26�У�
AA��ʾ��27�У�
AB��ʾ��28�У�
BA��ʾ��53�У�
��
��ȻExcel������к������޶ȵģ�����ת���������ѡ�
�������������ֱ�ʾ��һ�㻯�����԰Ѻܴ������ת��Ϊ�ܳ�����ĸ�����أ�
����Ŀ����Ҫ������������, ������Ӧ��Excel��ַ��ʾ��ʽ��
���磬
���룺
26
�����Ӧ�������
Z
�����磬
���룺
2054
�����Ӧ�������
BZZ
����Լ���������������Χ[1,2147483647]
AcWing������Եص�
�����л�˵��
���е�����ƹ�ϵ���ֲ���ȫ�ǡ�����ĩ2λ����1��26��ĩ3λ����1��26*26
�����л�˵��
Ҫ�Ǵ���ĸ����ת���ֻ��õ㣬�������е��鷳������������ܵÿ찡��
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _07Excel��ַ {
	    public static void main(String[] args) {
	        Scanner input=new Scanner(System.in);
	        int num=input.nextInt();
	        char []arr={'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'
	        ,'R','S','T','U','V','W','X','Y'};
	        String ans="";
	        int flag=0;
	        while (num>0){
	            ans+=arr[num%26];
	            num--;
	            num/=26;
	        }
	        char []ansarr=ans.toCharArray();
	        for(int i=ans.length()-1;i>=0;i--){
	            System.out.print(ansarr[i]);
	        }
	    }
}
