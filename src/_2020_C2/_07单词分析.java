package _2020_C2;

import java.util.Scanner;

/*
 * 小蓝正在学习一门神奇的语言，这门语言中的单词都是由小写英文字母组
成，有些单词很长，远远超过正常英文单词的长度。小蓝学了很长时间也记不
住一些单词，他准备不再完全记忆这些单词，而是根据单词中哪个字母出现得
最多来分辨单词。
现在，请你帮助小蓝，给了一个单词后，帮助他找到出现最多的字母和这
个字母出现的次数。
【输入格式】
输入一行包含一个单词，单词只由小写英文字母组成。
【输出格式】
输出两行，第一行包含一个英文字母，表示单词中出现得最多的字母是哪
个。如果有多个字母出现的次数相等，输出字典序最小的那个。
第二行包含一个整数，表示出现得最多的那个字母在单词中出现的次数。
【样例输入】
lanqiao
【样例输出】
a
2
【样例输入】
longlonglongistoolong
【样例输出】
o
6
【评测用例规模与约定】
对于所有的评测用例，输入的单词长度不超过 1000。
思路：
记录每个字符的出现次数即可
————————————————
版权声明：本文为CSDN博主「胡毛毛_三月」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45696377/article/details/109147147
 */
public class _07单词分析 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		char c[]=scanner.next().toCharArray();
		int buf[]=new int[26];
		for(int i=0;i<c.length;i++){
			buf[c[i]-'a']++;
		}
		int val=buf[0],index=0;
		for(int i=0;i<26;i++){
			if(buf[i]>val){
				val=buf[i];
				index=i;
			}
		}
		System.out.println((char)('a'+index)+"\n"+val);
	}
}
