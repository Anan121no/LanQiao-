package _2018_A;
/*
 * 到x星球旅行的游客都被发给一个整数，作为游客编号。
x星的国王有个怪癖，他只喜欢数字3,5和7。
国王规定，游客的编号如果只含有因子：3,5,7,就可以获得一份奖品。

我们来看前10个幸运数字是：
3 5 7 9 15 21 25 27 35 45
因而第11个幸运数字是：49

小明领到了一个幸运数字 59084709587505，他去领奖的时候，人家要求他准确地说出这是第几个幸运数字，否则领不到奖品。

请你帮小明计算一下，59084709587505是第几个幸运数字。

答案提交

需要提交的是一个整数，请不要填写任何多余内容

1905
因为记录了 1，而 1 不包含上述三个因子，因此要减去 1
a * b * c > 0是比较溢出的值，小于 0 就是大于 Long.MAX_VALUE，等同于大于 n
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _04第几个幸运数 {
	public static void main(String[] args) {
		long n = 59084709587505L, cnt = 0;
        for (long a = 1; a <= n; a *= 3)
            for (long b = 1; b <= n; b *= 5)
                for (long c = 1; c <= n; c *= 7)
                    if (a * b * c <= n && a * b * c > 0) cnt++;
        System.out.print(cnt - 1);
    }
}
