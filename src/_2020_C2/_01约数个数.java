package _2020_C2;
import java.util.Scanner;
/*
 * ����һ���������������������������Ϊ�������Լ����
���磺1, 2, 3, 6 ���� 6 ��Լ����
���� 78120 �ж��ٸ�Լ����
�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�

����⡿
�� ��96
����һ������С�ڵ���78120��������
��������������������������������
��Ȩ����������ΪCSDN���������ҹ���񡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_48598155/article/details/109133151
 */
public class _01Լ������ {
	
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		int n= 78120;
		int count=0;
		for (int i = 1; i <=n; i++) {
			if(n%i==0){
				count++;
			}
		}
		System.out.println(count);
	}
	}

