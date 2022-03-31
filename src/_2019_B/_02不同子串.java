package _2019_B;

import java.util.HashMap;

/*
 * 一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成
的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
注意在计算时，只算本质不同的串的个数。
请问，字符串0100110001010001 有多少个不同的非空子串？
【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
解题思路
找出不同的组合字符串即可，将字符串从分割长度为1开始，直到分割长度为整个字符串长度，
对于每次分割出来的字符串做判断是否存在map里，若不存在则添加进去，最后输出map的size()得到有多少个不同子串。
答案：100
————————————————
版权声明：本文为CSDN博主「非洲的小白」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _02不同子串 {
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
