package _2016_C;

import java.util.Arrays;
import java.util.Scanner;

/*
 * С����ϲ�������
�������������μ���X����Ĳ��ջ��
ÿλѡ�ֿ�ʼ��ʱ�򶼱�����777�����ӱҡ�
�����ǣ��¶��ˣ�����ĵ��ӱ���Ŀ������
�´��ˣ��۳�555�����ӱ�, ����Ϊֹ��
С��һ������15�����
ս��Ϊ��vxvxvxvxvxvxvvx
����v��ʾ�¶��ˣ�x��ʾ�´��ˡ�
�������һ�£�С���������ĵ��ӱ���Ŀ�Ƕ��١�
����д��ʾ�����ӱ���Ŀ�����֡�
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
��������������������������������
��Ȩ����������ΪCSDN��������С�ܡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_42069140/article/details/88911572
 */
public class _01�н����� {
	static char[] arr = new char[15];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.charAt(i);
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(f(777));
	}

	private static int f(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if (n<0) {
				break;
			}
			if (arr[i]=='v') n*=2;
			if (arr[i]=='x') n-=555;
		}
		return n;
	}
}
