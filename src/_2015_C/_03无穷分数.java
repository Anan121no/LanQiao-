package _2015_C;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * ����ķ�������ʱ�������ڹ̶������֡�
����㡾ͼ1.jpg����ʾ�����������Ҫ���������룬��ȷ��С�����5λ��С��λ����Ĳ�0��

����д�ø�������������д�κζ�������ݡ�
https://blog.csdn.net/weixin_41793113/article/details/88422559
 */
public class _03������� {
	public static void main(String[] args) {
		BigDecimal fn = new BigDecimal(BigInteger.ONE);
		for (int i = 1000; i >=1; i--) {//������2000�������ȶ��ˣ����Դ�û����
			BigDecimal ii = new BigDecimal(BigInteger.valueOf(i));
			fn = ii.divide(fn.add(ii),6,BigDecimal.ROUND_HALF_UP);//��
		}
		System.out.println(fn.toPlainString());
	}
}
