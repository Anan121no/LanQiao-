package _2019_B;

import java.util.HashMap;

/*
 * һ���ַ����ķǿ��Ӵ���ָ�ַ����г�������Ϊ 1 ��������һ���ַ����
�Ĵ������磬�ַ���aaab �зǿ��Ӵ�a, b, aa, ab, aaa, aab, aaab��һ�� 7 ����
ע���ڼ���ʱ��ֻ�㱾�ʲ�ͬ�Ĵ��ĸ�����
���ʣ��ַ���0100110001010001 �ж��ٸ���ͬ�ķǿ��Ӵ���
�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ
�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�
����˼·
�ҳ���ͬ������ַ������ɣ����ַ����ӷָ��Ϊ1��ʼ��ֱ���ָ��Ϊ�����ַ������ȣ�
����ÿ�ηָ�������ַ������ж��Ƿ����map�������������ӽ�ȥ��������map��size()�õ��ж��ٸ���ͬ�Ӵ���
�𰸣�100
��������������������������������
��Ȩ����������ΪCSDN���������޵�С�ס���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _02��ͬ�Ӵ� {
	 public static void main(String[] args) {
	        String str = "0100110001010001";
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        for(int i=1; i<=str.length(); i++){
	            for(int j=0; j+i<=str.length(); j++){
	                String s = str.substring(j,j+i);
	                if(map.containsKey(s)==false)
	                    map.put(s, 1);
	            }
	        }
	        System.out.println(map.size());
	    }
}
