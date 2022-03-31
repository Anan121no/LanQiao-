package _2019_C;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob
有多少次同时出现。
更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：在小说文本
中 Alice 和 Bob 之间不超过 K 个字符。
例如以下文本：
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob”
和”Bob. Alice”。前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。
注意:
1. Alice 和 Bob 是大小写敏感的，alice 或 bob 等并不计算在内。
2. Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能
有字母。例如 Bobbi 並不算出现了 Bob。
【输入格式】
第一行包含一个整数 K。
第二行包含一行字符串，只包含大小写字母、标点符号和空格。长度不超
过 1000000。
【输出格式】
输出一个整数，表示 Alice 和 Bob 同时出现的次数。
【样例输入】
20
This is a story about Alice and Bob. Alice wants to send a private message to Bob.
【样例输出】
2
【评测用例规模与约定】
对于所有评测用例，1 ≤ K ≤ 1000000。
解题思路
定义两个为Alice、Bob的字符串，然后利用equals比较。循环字符串的长度，从第一个字符开始，
判断三种情况，①当前字符的后5个字符拼接起来刚好为Alice；②当前字符的后3个字符拼接起来刚好为Bob；
③都不是，进入下一个字符。    若进入前两种情况，则再判断当前拼接起来的字符串前后字符是否不为字母，
当不为字母后再判断k个字符之内是否有另一个字符串并前后字符不为字母。
      还需要注意字符串一开始为Alice（Bob）和结束为Alice（Bob）,例：Alice test Bob
注意：分析题目时，有两个疑问。（1）数字算不算字母（我算在其中了）  （2）标点符号后紧跟字母，
例:Alice Bob.Bob（我当做合法的，答案应为2）
————————————————
版权声明：本文为CSDN博主「非洲的小白」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _08人物相关性分析 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
 
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		//将大小写的a到z存放
		for(int i=65; i<=90; i++){
			map.put(String.valueOf((char)i), 1);
		}
		for(int i=97; i<=122; i++){
			map.put(String.valueOf((char)i), 1);
		}
		//将数字0-9存放
		for(int i=0; i<=9; i++){
			map.put(String.valueOf(i), 1);
		}
		String sa = "Alice";
		String sb = "Bob";
		int sum = 0; //记录同时出现的次数
		int k = reader.nextInt();
		reader.nextLine();
		String str = reader.nextLine();
		
		for(int i=0; i+9<=str.length() && i<str.length(); i++){
			//i+9可以不用考虑最后不足9位时出现了Alice或者Bob时 hou的substring越界问题
			String s5 = str.substring(i,i+5);
			String s3 = str.substring(i,i+3);
			if(s5.equals(sa)){
				String qian = " ";
				if(i!=0)
					qian = str.substring(i-1, i);//获取Alice前一个字符
				String hou = str.substring(i+5,i+6);//获取Alice后一个字符
				if(map.containsKey(qian)==false && map.containsKey(hou)==false){
					//如果前后都不为字符
					for(int j=i+6; j+3<=str.length()&&j<i+6+k; j++){
						s3 = str.substring(j,j+3);
						if(s3.equals(sb)){
							String hou2 = " ";
							if(j+3 != str.length())
								hou2 = str.substring(j+3,j+4);//获取Bob后一个字符
							String qian2 = str.substring(j-1, j);//获取Bob前一个字符
							if(map.containsKey(qian2)==false && map.containsKey(hou2)==false){
								//如果前后都不为字符
								sum++;
								j+=3;//可直接跳3个字符
							}
						}
					}
				}
			}else if(s3.equals(sb)){
				String qian = " ";
				if(i!=0)
					qian = str.substring(i-1, i);//获取Bob前一个字符
				String hou = str.substring(i+3,i+4);//获取Bob后一个字符
				if(map.containsKey(qian)==false && map.containsKey(hou)==false){
					//如果前后都不为字符
					for(int j=i+4; j+5<=str.length()&&j<i+4+k; j++){
						s3 = str.substring(j,j+5);
						if(s3.equals(sa)){
							String hou2 = " ";
							if(j+5 != str.length())
								hou2 = str.substring(j+5,j+6);//获取Alice后一个字符
							String qian2 = str.substring(j-1, j);//获取Alice前一个字符
							if(map.containsKey(qian2)==false && map.containsKey(hou2)==false){
								//如果前后都不为字符
								sum++;
								j+=5;//可直接跳3个字符
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
}
