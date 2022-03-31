package _2016_A;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 两个人玩取球的游戏。
一共有N个球，每人轮流取球，每次可取集合{n1,n2,n3}中的任何一个数目。
如果无法继续取球，则游戏结束。
此时，持有奇数个球的一方获胜。
如果两人都是奇数，则为平局。
假设双方都采用最聪明的取法，
第一个取球的人一定能赢吗？
试编程解决这个问题。
输入格式：
第一行3个正整数n1 n2 n3，空格分开，表示每次可取的数目 (0<n1,n2,n3<100)
第二行5个正整数x1 x2 ... x5，空格分开，表示5局的初始球数(0<xi<1000)
输出格式：
一行5个字符，空格分开。分别表示每局先取球的人能否获胜。
能获胜则输出+，
次之，如有办法逼平对手，输出0，
无论如何都会输，则输出-
例如，输入：
1 2 3
1 2 3 4 5
程序应该输出：
+ 0 + 0 -
再例如，输入：
1 4 5
10 11 12 13 15
程序应该输出：
0 - 0 + +
再例如，输入：
2 3 5
7 8 9 10 11
程序应该输出：
+ 0 0 0 0
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 3000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _08取球博弈 {
	static int n[] = new int[3];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			n[i] = in.nextInt();
		}
		Arrays.sort(n);
		int r;
		for (int i = 0; i < 5; i++) {
			r = in.nextInt();
			char res = f(r,0,0);
			System.out.print(res + " ");
		}
		
	}

static char[][][]cache = new char[1000][2][2];
	private static char f(int r, int me, int you) {
		// TODO Auto-generated method stub
		if (r<n[0]) {
			if((me&1)==1&&(you&1)==0)return '+';
			if((me&1)==1&&(you&1)==1)return '0';
			if((me&1)==0&&(you&1)==1)return '-';
		}
		 if (cache[r][me][you]!='\0')return cache[r][me][you];
		    boolean ping = false;
		    for (int i = 0; i < 3; i++) {
		      if (r >= n[i]) {
		        char res = f(r - n[i], you, (n[i]&1)==0?me:(1-me));//注意此处，传递me和you的奇偶性
		        if (res == '-')
		        {
		          cache[r][me][you]='+';
		          return '+';
		        }
		        if (res == '0')
		          ping = true;
		      }
		    }
		    //如果能走到第这行，说明不存在对手输的情况，那么是否存在平的情况
		    if (ping)
		    {
		      cache[r][me][you]='0';
		      return '0';
		    }
		    else
		    {
		      cache[r][me][you]='-';
		      return '-';
		    }
	}
}
