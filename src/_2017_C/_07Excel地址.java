package _2017_C;

import java.util.Scanner;

/*
 * Excel单元格的地址表示很有趣，它使用字母来表示列号。
比如，
A表示第1列，
B表示第2列，
Z表示第26列，
AA表示第27列，
AB表示第28列，
BA表示第53列，
…
当然Excel的最大列号是有限度的，所以转换起来不难。
如果我们想把这种表示法一般化，可以把很大的数字转换为很长的字母序列呢？
本题目既是要求对输入的数字, 输出其对应的Excel地址表示方式。
例如，
输入：
26
则程序应该输出：
Z
再例如，
输入：
2054
则程序应该输出：
BZZ
我们约定，输入的整数范围[1,2147483647]
AcWing此题测试地点
笨笨有话说：
这有点像进制关系，又不完全是。好像末2位是以1当26，末3位是以1当26*26
歪歪有话说：
要是从字母序列转数字还好点，倒过来有点麻烦，不过计算机跑得快啊。
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _07Excel地址 {
	    public static void main(String[] args) {
	        Scanner input=new Scanner(System.in);
	        int num=input.nextInt();
	        char []arr={'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'
	        ,'R','S','T','U','V','W','X','Y'};
	        String ans="";
	        int flag=0;
	        while (num>0){
	            ans+=arr[num%26];
	            num--;
	            num/=26;
	        }
	        char []ansarr=ans.toCharArray();
	        for(int i=ans.length()-1;i>=0;i--){
	            System.out.print(ansarr[i]);
	        }
	    }
}
