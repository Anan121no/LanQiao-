package _2021_B2;
/*
 * 如果一个点 ( x , y ) (x, y)(x,y) 的两维坐标都是整数，即 x ∈ Z x ∈ Zx∈Z 且 y ∈ Z y ∈ Zy∈Z，则称这个点为一个格点。
  如果一个点 ( x , y ) (x, y)(x,y) 的两维坐标都是正数，即 x > 0 x > 0x>0 且 y > 0 y > 0y>0，则称这个点在第一象限。
  请问在第一象限的格点中，有多少个点 ( x , y ) (x, y)(x,y) 的两维坐标乘积不超过 2021 20212021，即 x ⋅ y ≤ 2021 x · y ≤ 2021x⋅y≤2021。
  提示：建议使用计算机编程解决问题。
答案提交
  这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
15698
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/121003236
 */
public class _03格点 {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 2021; i++) {
			for (int j = 1; j <= 2021; j++) {
				if (i*j<=2021) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
