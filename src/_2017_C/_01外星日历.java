package _2017_C;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * ĳ��ϵ������������ż���
���ǵļ���Ҳ����ʮ���ơ�
���ǵ�����Ҳ������������ֻ��������û���ꡢ�µĸ��
��Ȥ���ǣ�����Ҳʹ�������ơ����ڡ��ĸ��
ֻ�������ǵ�һ�����ڰ�����9�죬
Ϊ�˷��㣬����ֱ��Ϊ: A,B,C��H,I
��һЩ�����Ͽ�����
���ǵ�23��������E
���ǵ�190��������A
���ǵ�343251��������I
�����˷ܵ��ǣ����Ǿ�ȻҲԤ���ˡ�����ĩ�ա������죬
��Ȼ��һ���ܴ�ܴ������
651764141421415346185
�������һ�£���ңԶ��һ���Ǹ����������ڼ���
����Ҫ�ύ����һ����д��ĸ����ʾ�����������ڼ���
��Ҫ��д�κζ�������ݡ�
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _01�������� {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        char []arr={'I','A','B','C','D','E','F','G','H'};
        BigInteger num=input.nextBigInteger();
        BigInteger mod=new BigInteger("9");
        String ans=num.mod(mod).toString();
        System.out.println(arr[Integer.parseInt(ans)]);
	}
}
