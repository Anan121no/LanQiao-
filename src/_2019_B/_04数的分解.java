package _2019_B;

import java.util.HashMap;

/*
 * �� 2019 �ֽ�� 3 ��������ͬ��������֮�ͣ�����Ҫ��ÿ��������������
������ 2 �� 4��һ���ж����ֲ�ͬ�ķֽⷽ����
ע�⽻�� 3 ��������˳����Ϊͬһ�ַ��������� 1000+1001+18 ��
1001+1000+18 ����Ϊͬһ�֡�
�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ
�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�
����˼·
���������Ҫ��Ϊ2019����ô��������ȡֵ��ȻС��2019��Ҫ�󲻰�������2��4��
���Դ������а���2��4����ֵ�浽map�С�3������ͬ��������Ϊһ�֣���֪3���������������6�֣����Դ�ֱ�ӳ�6���ɡ�
�𰸣�40785
��������������������������������
��Ȩ����������ΪCSDN���������޵�С�ס���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _04���ķֽ� {
	public static void main(String[] args) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int sum = 0;//��¼���������ܺ�
	        
	        for(int i=2; i<1995; i++){//����֪��2��1994������2,4��������
	            String s = String.valueOf(i);
	            char c[] = s.toCharArray();
	            for(int j=0; j<c.length; j++){
	                if('2'==c[j] || '4'==c[j]){
	                    map.put(i, 1);
	                    break;
	                }
	            }
	        }
	        
	        for(int i=1; i<2000; i++){
	            for(int j=1; j<2000; j++){
	                if(i+j >= 2019) break;//������֮�ͳ���2019  ��ô֮������ض�����2019  û������
	                if(i == j) continue;//�ų���ͬ����
	                for(int k=1; k<2000; k++){
	                    if(i+j+k == 2019){
	                        if(i==k || j==k) break;//�ų�k��i��j��ͬ����
	                        if(map.containsKey(i)==false && map.containsKey(j)==false && map.containsKey(k)==false){
	                            sum++;
	                        }
	                    }
	                }
	            }
	        }
	        System.out.println(sum/6);
	    }
	}
