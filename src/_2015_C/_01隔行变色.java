package _2015_C;
/*
 * Excel表的格子很多，为了避免把某行的数据和相邻行混淆，可以采用隔行变色的样式。
小明设计的样式为：第1行蓝色，第2行白色，第3行蓝色，第4行白色，....
现在小明想知道，从第21行到第50行一共包含了多少个蓝色的行。

请你直接提交这个整数，千万不要填写任何多余的内容。
 */
public class _01隔行变色 {
	private static int count=0;

	public static void main(String[] args) {
		for (int i = 21; i <= 50; i++) {
			if((i&1)!=0)count++;
		}
		System.out.println(count);
	}
}
