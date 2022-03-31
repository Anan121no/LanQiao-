package _2014_A;
/*
 * 小明带两个妹妹参加元宵灯会。别人问她们多大了，她们调皮地说：“我们俩的年龄之积是年龄之和的6倍”。小明又补充说：“她们可不是双胞胎，年龄差肯定也不超过8岁啊。”
请你写出：小明的较小的妹妹的年龄。
 */
public class _01猜年龄 {
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (i<j&&i*j==(i+j)*6&&(j-i)<9) {
					System.out.println(i);
				}
			}
		}
	}
}
