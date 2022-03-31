package _2018_C;
/*
 * 5只猴子是好朋友，在海边的椰子树上睡着了。这期间，有商船把一大堆香蕉忘记在沙滩上离去。
第1只猴子醒来，把香蕉均分成5堆，还剩下1个，就吃掉并把自己的一份藏起来继续睡觉。
第2只猴子醒来，重新把香蕉均分成5堆，还剩下2个，就吃掉并把自己的一份藏起来继续睡觉。
第3只猴子醒来，重新把香蕉均分成5堆，还剩下3个，就吃掉并把自己的一份藏起来继续睡觉。
第4只猴子醒来，重新把香蕉均分成5堆，还剩下4个，就吃掉并把自己的一份藏起来继续睡觉。

第5只猴子醒来，重新把香蕉均分成5堆，哈哈，正好不剩！

请计算一开始最少有多少个香蕉。

答案提交

需要提交的是一个整数，不要填写任何多余的内容。

3141
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _02猴子分香蕉 {
	public static void main(String[] args) {
		viosolve();
		int i, n;
        for (i = n = 1; true; n = ++i) {
            if (n % 5 != 1) continue;
            n = n / 5 * 4;
            if (n % 5 != 2) continue;
            n = n / 5 * 4;
            if (n % 5 != 3) continue;
            n = n / 5 * 4;
            if (n % 5 != 4) continue;
            n = n / 5 * 4;
            if (n > 0 && n % 5 == 0) break;
        }
        System.out.print(i);
	}

	private static void viosolve() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10000; i++) {
			int n = (i-1)/5;
			int m = (n*4-2)/5;
			int t = (m*4-3)/5;
			int r = (t*4-4)/5;
			if (i%5==1&&(4*n)%5==2&&(m*4)%5==3&&(t*4)%5==4&&r%5==0&&r!=0) {
				System.out.println(i);
			}
		}
	}
}
