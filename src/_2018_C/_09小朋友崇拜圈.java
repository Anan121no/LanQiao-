package _2018_C;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * ����N��С���ѣ�ÿ���˶����Լ����ݵ�һ��С���ѣ�Ҳ�������Լ�����
��һ����Ϸ�У���ҪС������һ��Ȧ��
ÿ��С���Ѷ����Լ����ݵ�С�������������ֱߡ�
������������Ȧ�������ˣ�
С���ѱ��Ϊ1,2,3,��N
��ԴԼ��
��ֵ�ڴ����ģ���������� < 256M
CPU���� < 1000ms
�����ʽ
�����һ�У�һ������N��3<N<100000��
������һ��N���������ɿո�ֿ���
�����ʽ
Ҫ�����һ����������ʾ�������������Ȧ��������
��������1
Input��
9
3 4 2 5 3 8 4 6 9
Output��
4
Explanation��
��ͼp1.png��ʾ����ݹ�ϵ�ü�ͷ��ʾ����ɫ��ʾ����Ȧ�С�
��Ȼ�����Ȧ��[2 4 5 3] ���ɵ�Ȧ
��������2
Input��
30
22 28 16 6 27 21 30 1 29 10 9 14 24 11 7 2 8 5 26 4 12 3 25 18 20 19 23 17 13 15

Output��
16
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _09С���ѳ��Ȧ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n+1];
		for (int i = 1; i <=n; i++) {
			num[i]=sc.nextInt();
		}
		sc.close();
		//��¼��ǰ���±�	 ��ǰȦ�Ĵ�С	����Ȧ�ж�����
		int index=1,count=0,	max=-1;;
		Set<Integer> set=new HashSet<Integer>();
		boolean[] bool = new boolean[n+1];
		while(true){
			//����ӽ�ȥ��˵������û���ظ��ģ����Լ�
			if(set.add(index)){
				//��ǰȦ������+1
				count++;
				//��ǰ�˱��ù���
				bool[index]=true;
				//�滻�±�
				index=num[index];
				continue;
			}
			else{
				//֤���ҵ�Ȧ�������Ȧ�������Ƚ�
				max=Math.max(max, count);
				//�ϸ�Ȧ�ļ�¼���
				count=0;
				set.clear();
				//��1��ʼ��û�б����ʹ����ˣ���û���ʹ�����ȥ������Ȧ��ѭ��
				for (int i = 1; i <=n; i++) {
					if(!bool[i]){
						index=i;
						break;
					}
					//����ҵ����һ���˶������ʹ���֤��ȫ�������ʹ���ֱ������
					if(i==n){
						 System.out.println(max);
						 return;
					}
				}
			}
		}
	}
}


class Text35 {
	static int N=30;	//N��С����
	static int max=0;
	static String maxStr="";
	public static void main(String[] args) {
		String str="22 28 16 6 27 21 30 1 29 10 9 14 24 11 7 2 8 5 26 4 12 3 25 18 20 19 23 17 13 15"; 	//N��С���Ѷ�Ӧ��ݵĶ���
		String quang="";		//���Ȧ��ʱ����
		String[] arr=str.split(" ");
		for(int i=0;i<arr.length;i++){
			quang=i+1+" ";
			dg(i+1,quang,arr);
		}
		System.out.println("���Ȧ="+max+"  ["+maxStr+"]");
	}
	public static void dg(int i,String quang,String[] arr){
		if(quang.split(" ")[0].equalsIgnoreCase(arr[i-1])){	//�ҵ�Ȧ
			//System.out.println("�ҵ�Ȧ= "+quang);
			if(quang.split(" ").length>max){
				 max=quang.split(" ").length;
				 maxStr=quang;
			}
			return;
		}
		quang+=arr[i-1]+" ";
		//System.out.println(quang);
		if(!quang.split(" ")[0].equalsIgnoreCase(arr[i-1])&&quang.split(" ").length>N){	//��ѭ��Ȧ
			return;
		}
		dg(Integer.parseInt(arr[i-1]),quang,arr);
	}
}