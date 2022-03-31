package _2020_B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * 小明发明了一种给由全大写字母组成的字符串编码的方法。对于每一个大
写字母，小明将它转换成它在 26 个英文字母中序号，即 A → 1, B → 2, … Z →
26。
这样一个字符串就能被转化成一个数字序列：
比如 ABCXYZ → 123242526。
现在给定一个转换后的数字序列，小明想还原出原本的字符串。当然这样
的还原有可能存在多个符合条件的字符串。小明希望找出其中字典序最大的字
符串。
输入格式
一个数字序列
输出格式
一个只包含大写字母的字符串，代表答案
测试样例1
Input：
123242526
Output：
LCXYZ
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _08字符串编码 {
	static byte[] chars = { 0, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line = in.readLine();
        int flag = 0;
        if (line.charAt(line.length() - 1) == '0') flag = 2;
        int pre = 0;
        for (int i = 0, h = line.length() - flag; i < h; i++) {
            pre = pre * 10 + (line.charAt(i) & 0xf);
            if (pre < 10) continue;
            if (pre > 26) {
                out.write(chars[pre / 10]);
                pre %= 10;
            } else if (pre > 10) {
                out.write(chars[pre]);
                pre = 0;
            }
        }
        if (pre != 0) out.write(chars[pre]);
        if (flag > 0) out.write(chars[(line.charAt(line.length() - 2) - '0') * 10]);
        out.close();
    }
}
