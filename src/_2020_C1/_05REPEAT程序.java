package _2020_C1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * ���� prog.txt ����һ����ĳ������д�ĳ���
���� REPEAT k ��ʾһ������Ϊ k ��ѭ����ѭ�����Ƶķ�Χ��������
�Ӵ��п�ʼ�����������ȸ��ж�ģ�ǰ��Ŀհ׸����ģ�Ϊѭ�����������ݡ�
��������Ƭ�Σ�
REPEAT 2:
	A = A + 4
	REPEAT 5:
		REPEAT 6:
			A = A + 5
		A = A + 7
	A = A + 8
A = A + 9
��Ƭ���д� A = A + 4 ���ڵ��е� A = A + 8 ���ڵ��ж��ڵ�һ�е�
ѭ�������С�
REPEAT 6: ���ڵ��е� A = A + 7 ���ڵ��ж��� REPEAT 5: ѭ���С�
A = A + 5 ʵ���ܹ���ѭ�������� 2 �� 5 �� 6 = 60 �Ρ�
���ʸó���ִ�����֮��A ��ֵ�Ƕ��٣�
���ύ
����һ���������⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ��
���������ύ��ʱֻ��д�����������д��������ݽ��޷��÷�
241830
calcCode��
����
����ȷ��һ���Ƿ�ֻ���� REPEAT��A��+��������= �⼸�����
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _05REPEAT���� {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream("C:\\Users\\1\\Desktop\\����\\prog.txt"));
		Map<String, Integer> map = new HashMap();
		while (in.hasNext()) {
			String now = in.next();
			Integer cnt = map.get(now);
			if (cnt == null) map.put(now, 1);
			else map.put(now, cnt + 1);
		}
		for (Entry<String, Integer> e: map.entrySet())
			System.out.println(e.getKey() + ": " + e.getValue());

	}
}
