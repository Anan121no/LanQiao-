package _2014_C;

import java.math.BigDecimal;

/*
 * С�������д���3��Ԫ��Լ����24���£��Եȶ��ʽ���
���ֻ��ʽ���ǰѴ����ȵȷֵ�24���¡�
ÿ���³���Ҫ���̶��ı����⣬��Ҫ�����������һ�����в�������Ϣ��
�����������ǣ�0.005������ǧ��֮�塣��ô��
��һ���£�С��Ҫ������ 1250, ��Ҫ����Ϣ��30000 * 0.005���ܼ� 1400
�ڶ����£�������ȻҪ�� 1250, ����ϢΪ��(30000-1250) * 0.005 �ܼ� 1393.75
���ʣ�С���ڵ�15���£�Ӧ�û�����٣��������Ϣ���ܺͣ���
��Ѵ𰸽����������󣬱�����λС����ע�⣺32.5��һ��ҪдΪ��32.50
ͨ��������ύ�𰸣�����һ������С�������λС���ĸ������֡�
��Ҫд�������ݣ����磺��д�ˡ�Ԫ�������˵�����֣�
��������������������������������
��Ȩ����������ΪCSDN������Bear����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/bear_huangzhen/article/details/78582251
������λС��
double f = 111231.5585;
 6         public void m1() {
 7             BigDecimal bg = new BigDecimal(f);
 8             double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
 9             System.out.println(f1);
10         }
11         /
12         DecimalFormatת������
14         public void m2() {
15             DecimalFormat df = new DecimalFormat("#.00");
16             System.out.println(df.format(f));
17         }
18         /
19          String.format��ӡ����
20          /
21         public void m3() {
22             System.out.println(String.format("%.2f", f));
23         }
24         public void m4() {
25             NumberFormat nf = NumberFormat.getNumberInstance();
26             nf.setMaximumFractionDigits(2);
27             System.out.println(nf.format(f));
28         }
 */
public class _02�ȶ�� {
	public static void main(String[] args) {
		double benjin = 30000;
		double res = 0;
		for (int i = 1; i <= 15; i++) {
			res = 1250+benjin*0.005;
			benjin -= 1250;
		}
		System.out.println(String.format("%.2f", res));
		System.out.printf("%.2f", res);
	}
}
