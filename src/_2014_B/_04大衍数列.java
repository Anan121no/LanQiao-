package _2014_B;
/*
 * * 问题描述：

中国古代文献中，曾记载过“大衍数列”, 主要用于解释中国传统文化中的太极衍生原理。

它的前几项是：0、2、4、8、12、18、24、32、40、50 ...

其规律是：对偶数项，是序号平方再除2，奇数项，是序号平方减1再除2。

以下的代码打印出了大衍数列的前 100 项。

for(int i=1; i<100; i++)
{
if(________________) //填空
System.out.println(i*i/2);
else
System.out.println((i*i-1)/2);
}

请填写划线部分缺失的代码。通过浏览器提交答案。
 */
public class _04大衍数列 {
	public static void main(String[] args) {
		question();
	}
	private static void question() {
		// TODO Auto-generated method stub
		for(int i=1; i<100; i++)
		{
		if((i&1)!=1) //填空
		System.out.println(i*i/2);
		else
		System.out.println((i*i-1)/2);
		}
	}
}
