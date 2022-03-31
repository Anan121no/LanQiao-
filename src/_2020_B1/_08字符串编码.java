package _2020_B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * С��������һ�ָ���ȫ��д��ĸ��ɵ��ַ�������ķ���������ÿһ����
д��ĸ��С������ת�������� 26 ��Ӣ����ĸ����ţ��� A �� 1, B �� 2, �� Z ��
26��
����һ���ַ������ܱ�ת����һ���������У�
���� ABCXYZ �� 123242526��
���ڸ���һ��ת������������У�С���뻹ԭ��ԭ�����ַ�������Ȼ����
�Ļ�ԭ�п��ܴ��ڶ�������������ַ�����С��ϣ���ҳ������ֵ���������
������
�����ʽ
һ����������
�����ʽ
һ��ֻ������д��ĸ���ַ����������
��������1
Input��
123242526
Output��
LCXYZ
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _08�ַ������� {
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
