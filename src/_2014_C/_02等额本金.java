package _2014_C;

import java.math.BigDecimal;

/*
 * 小明从银行贷款3万元。约定分24个月，以等额本金方式还款。
这种还款方式就是把贷款额度等分到24个月。
每个月除了要还固定的本金外，还要还贷款余额在一个月中产生的利息。
假设月利率是：0.005，即：千分之五。那么，
第一个月，小明要还本金 1250, 还要还利息：30000 * 0.005，总计 1400
第二个月，本金仍然要还 1250, 但利息为：(30000-1250) * 0.005 总计 1393.75
请问：小明在第15个月，应该还款多少（本金和利息的总和）？
请把答案金额四舍五入后，保留两位小数。注意：32.5，一定要写为：32.50
通过浏览器提交答案，这是一个含有小数点和两位小数的浮点数字。
不要写多余内容（例如：多写了“元”或添加说明文字）
————————————————
版权声明：本文为CSDN博主「Bear」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/bear_huangzhen/article/details/78582251
保留两位小数
double f = 111231.5585;
 6         public void m1() {
 7             BigDecimal bg = new BigDecimal(f);
 8             double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
 9             System.out.println(f1);
10         }
11         /
12         DecimalFormat转换最简便
14         public void m2() {
15             DecimalFormat df = new DecimalFormat("#.00");
16             System.out.println(df.format(f));
17         }
18         /
19          String.format打印最简便
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
public class _02等额本金 {
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
