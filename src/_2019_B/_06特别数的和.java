package _2019_B;

import java.util.HashMap;
import java.util.Scanner;

/*
 * С������λ�к��� 2��0��1��9 �����ֺܸ���Ȥ��������ǰ�� 0������ 1 ��
40 �������������� 1��2��9��10 �� 32��39 �� 40���� 28 �������ǵĺ��� 574��
���ʣ��� 1 �� n �У��������������ĺ��Ƕ��٣�
�������ʽ��
����һ�а����������� n��
�������ʽ��
���һ�У�����һ����������ʾ�������������ĺ͡�
���������롿
40
�����������
574
������������ģ��Լ����
���� 20% ������������1 �� n �� 10��
���� 50% ������������1 �� n �� 100��
���� 80% ������������1 �� n �� 1000��
������������������1 �� n �� 10000��

����˼·
ͬ����D ���ķֽ�ԭ�����ƣ���������Ϊ10000���ڣ����Խ�10000���ڵİ���2��0��1��9��������ɡ�
��������������������������������
��Ȩ����������ΪCSDN���������޵�С�ס���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _06�ر����ĺ� {
	 public static void main(String[] args) {
	        Scanner reader = new Scanner(System.in);
	        
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int sum = 0;//��¼�������������ĺ͡�
	        for(int i=1; i<=10000; i++){
	            String s = String.valueOf(i);
	            char c[] = s.toCharArray();
	            for(int j=0; j<c.length; j++){
	                if('2'==c[j] || '0'==c[j] || '1'==c[j] || '9'==c[j]){
	                    map.put(i, 1);
	                    break;
	                }
	            }
	        }
	        
	        int n = reader.nextInt();
	        for(int i=1; i<=n; i++){
	            if(map.containsKey(i))
	                sum+=i;
	        }
	        System.out.println(sum);
	        reader.close();
	    }
}
