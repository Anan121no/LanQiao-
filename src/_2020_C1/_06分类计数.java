package _2020_C1;

import java.io.*;

/*
 * ����һ���ַ��������������ַ����������ٸ���д��ĸ�����ٸ�Сд��
ĸ�����ٸ����֡�
�����ʽ
����һ�а���һ���ַ�����
�����ʽ
������У�ÿ��һ���������ֱ��ʾ��д��ĸ��Сд��ĸ�����ֵĸ�����
��������1
Input��
1+a=Aab

Output��
1
3
1

����������ģ��Լ��
�������������������ַ����ɿɼ��ַ���ɣ����Ȳ����� 100��
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _06������� {
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
