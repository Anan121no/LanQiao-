package _2019_C;

import java.util.HashMap;
import java.util.Scanner;

/*
 * С�����ڷ���һ��С˵�е���������ԡ�����֪����С˵�� Alice �� Bob
�ж��ٴ�ͬʱ���֡�
��׼ȷ��˵��С������ Alice �� Bob��ͬʱ���֡�����˼�ǣ���С˵�ı�
�� Alice �� Bob ֮�䲻���� K ���ַ���
���������ı���
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
���� K = 20���� Alice �� Bob ͬʱ������ 2 �Σ��ֱ��ǡ�Alice and Bob��
�͡�Bob. Alice����ǰ�� Alice �� Bob ֮���� 5 ���ַ��������� 2 ���ַ���
ע��:
1. Alice �� Bob �Ǵ�Сд���еģ�alice �� bob �Ȳ����������ڡ�
2. Alice �� Bob ӦΪ�����ĵ��ʣ�ǰ������б����źͿո񣬵��ǲ���
����ĸ������ Bobbi �K��������� Bob��
�������ʽ��
��һ�а���һ������ K��
�ڶ��а���һ���ַ�����ֻ������Сд��ĸ�������źͿո񡣳��Ȳ���
�� 1000000��
�������ʽ��
���һ����������ʾ Alice �� Bob ͬʱ���ֵĴ�����
���������롿
20
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
�����������
2
������������ģ��Լ����
������������������1 �� K �� 1000000��
����˼·
��������ΪAlice��Bob���ַ�����Ȼ������equals�Ƚϡ�ѭ���ַ����ĳ��ȣ��ӵ�һ���ַ���ʼ��
�ж�����������ٵ�ǰ�ַ��ĺ�5���ַ�ƴ�������պ�ΪAlice���ڵ�ǰ�ַ��ĺ�3���ַ�ƴ�������պ�ΪBob��
�۶����ǣ�������һ���ַ���    ������ǰ��������������жϵ�ǰƴ���������ַ���ǰ���ַ��Ƿ�Ϊ��ĸ��
����Ϊ��ĸ�����ж�k���ַ�֮���Ƿ�����һ���ַ�����ǰ���ַ���Ϊ��ĸ��
      ����Ҫע���ַ���һ��ʼΪAlice��Bob���ͽ���ΪAlice��Bob��,����Alice test Bob
ע�⣺������Ŀʱ�����������ʡ���1�������㲻����ĸ�������������ˣ�  ��2�������ź������ĸ��
��:Alice Bob.Bob���ҵ����Ϸ��ģ���ӦΪ2��
��������������������������������
��Ȩ����������ΪCSDN���������޵�С�ס���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _08��������Է��� {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
 
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		//����Сд��a��z���
		for(int i=65; i<=90; i++){
			map.put(String.valueOf((char)i), 1);
		}
		for(int i=97; i<=122; i++){
			map.put(String.valueOf((char)i), 1);
		}
		//������0-9���
		for(int i=0; i<=9; i++){
			map.put(String.valueOf(i), 1);
		}
		String sa = "Alice";
		String sb = "Bob";
		int sum = 0; //��¼ͬʱ���ֵĴ���
		int k = reader.nextInt();
		reader.nextLine();
		String str = reader.nextLine();
		
		for(int i=0; i+9<=str.length() && i<str.length(); i++){
			//i+9���Բ��ÿ��������9λʱ������Alice����Bobʱ hou��substringԽ������
			String s5 = str.substring(i,i+5);
			String s3 = str.substring(i,i+3);
			if(s5.equals(sa)){
				String qian = " ";
				if(i!=0)
					qian = str.substring(i-1, i);//��ȡAliceǰһ���ַ�
				String hou = str.substring(i+5,i+6);//��ȡAlice��һ���ַ�
				if(map.containsKey(qian)==false && map.containsKey(hou)==false){
					//���ǰ�󶼲�Ϊ�ַ�
					for(int j=i+6; j+3<=str.length()&&j<i+6+k; j++){
						s3 = str.substring(j,j+3);
						if(s3.equals(sb)){
							String hou2 = " ";
							if(j+3 != str.length())
								hou2 = str.substring(j+3,j+4);//��ȡBob��һ���ַ�
							String qian2 = str.substring(j-1, j);//��ȡBobǰһ���ַ�
							if(map.containsKey(qian2)==false && map.containsKey(hou2)==false){
								//���ǰ�󶼲�Ϊ�ַ�
								sum++;
								j+=3;//��ֱ����3���ַ�
							}
						}
					}
				}
			}else if(s3.equals(sb)){
				String qian = " ";
				if(i!=0)
					qian = str.substring(i-1, i);//��ȡBobǰһ���ַ�
				String hou = str.substring(i+3,i+4);//��ȡBob��һ���ַ�
				if(map.containsKey(qian)==false && map.containsKey(hou)==false){
					//���ǰ�󶼲�Ϊ�ַ�
					for(int j=i+4; j+5<=str.length()&&j<i+4+k; j++){
						s3 = str.substring(j,j+5);
						if(s3.equals(sa)){
							String hou2 = " ";
							if(j+5 != str.length())
								hou2 = str.substring(j+5,j+6);//��ȡAlice��һ���ַ�
							String qian2 = str.substring(j-1, j);//��ȡAliceǰһ���ַ�
							if(map.containsKey(qian2)==false && map.containsKey(hou2)==false){
								//���ǰ�󶼲�Ϊ�ַ�
								sum++;
								j+=5;//��ֱ����3���ַ�
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
}
