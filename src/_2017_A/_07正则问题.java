package _2017_A;

import java.util.Scanner;
import java.lang.Math.*;

/*
 * 考虑一种简单的正则表达式：
只由 x ( ) | 组成的正则表达式。
小明想求出这个正则表达式能接受的最长字符串的长度。  
例如 ((xx|xxx)x|(x|xx))xx 能接受的最长字符串是： xxxxxx，长度是6。
输入
----
一个由x()|组成的正则表达式。输入长度不超过100，保证合法。  
输出
----
这个正则表达式能接受的最长字符串的长度。  
例如，
输入：
((xx|xxx)x|(x|xx))xx  
程序应该输出：
6  
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
这题的题目真的是没有讲明白,xx|xxx其中"|"是左右取最大的值，答案为3,括号就是优先级，递归可以实现这个计算，这里的细节要注意，p++为什么写4个，不只在while块的最后写一个就好，注意return!!!!
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _07正则问题 {
	private static String s;
	private static int len;
	private static int pos;
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 s = in.nextLine();
		 len = s.length();
		 int ans = f();
		 System.out.println(ans);
		 
	}
	private static int f() {
		// TODO Auto-generated method stub
		int m = 0;
		int tmp = 0;
		while (pos<len) {
			if (s.charAt(pos)=='(') {
				pos++;
				tmp += f();
			}else if (s.charAt(pos)=='x') {
				pos++;
				tmp++;
			}else if (s.charAt(pos)=='|') {
				pos++;
				m = Math.max(m,tmp);
				tmp = 0;
			}else if (s.charAt(pos)==')') {
				pos++;
				m = Math.max(m,tmp);
				return m;
			}
		}
		m = Math.max(m,tmp);
		return m;
	}
}
