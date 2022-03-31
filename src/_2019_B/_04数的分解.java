package _2019_B;

import java.util.HashMap;

/*
 * 把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包
含数字 2 和 4，一共有多少种不同的分解方法？
注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和
1001+1000+18 被视为同一种。
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
解题思路
三个数相加要求为2019，那么三个数的取值必然小于2019。要求不包含数字2和4，
可以打表出所有包含2和4的数值存到map中。3个数不同的排列视为一种，已知3个数的排列组合有6种，所以答案直接除6即可。
答案：40785
————————————————
版权声明：本文为CSDN博主「非洲的小白」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _04数的分解 {
	public static void main(String[] args) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int sum = 0;//记录所有排列总和
	        
	        for(int i=2; i<1995; i++){//将已知的2到1994包含的2,4整数保存
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
	                if(i+j >= 2019) break;//两个数之和超过2019  那么之后的数必定大于2019  没有意义
	                if(i == j) continue;//排除相同的数
	                for(int k=1; k<2000; k++){
	                    if(i+j+k == 2019){
	                        if(i==k || j==k) break;//排除k与i、j相同的数
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
