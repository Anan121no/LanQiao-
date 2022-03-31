package _2020_C1;

import java.io.*;

/*
 * 输入一个字符串，请输出这个字符串包含多少个大写字母，多少个小写字
母，多少个数字。
输入格式
输入一行包含一个字符串。
输出格式
输出三行，每行一个整数，分别表示大写字母、小写字母和数字的个数。
测试样例1
Input：
1+a=Aab

Output：
1
3
1

评测用例规模与约定
对于所有评测用例，字符串由可见字符组成，长度不超过 100。
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _06分类计数 {
	public static void main(String[] args) throws IOException {
        byte[] buff = new byte[100];
        int len = System.in.read(buff), a = 0, b = 0, c = 0;
        for (int i = 0; i < len; i++) {
            if (buff[i] >= 'a' && buff[i] <= 'z') b++;
            else if (buff[i] >= 'A' && buff[i] <= 'Z') a++;
            else if (buff[i] >= '0' && buff[i] <= '9') c++;
        }
        System.out.print(a + "\n" + b + "\n" + c);
    }
}
