package _2017_A;

import javax.security.auth.x500.X500Principal;

/*
 * X星球的一处迷宫游乐场建在某个小山坡上。
它是由10x10相互连通的小房间组成的。
房间的地板上写着一个很大的字母。
我们假设玩家是面朝上坡的方向站立，则：
L表示走到左边的房间，
R表示走到右边的房间，
U表示走到上坡方向的房间，
D表示走到下坡方向的房间。
X星球的居民有点懒，不愿意费力思考。
他们更喜欢玩运气类的游戏。这个游戏也是如此！
开始的时候，直升机把100名玩家放入一个个小房间内。
玩家一定要按照地上的字母移动。
迷宫地图如下：
------------
UDDLUULRUL
UURLLLRRRU
RRUURLDLRD
RUDDDDUUUU
URUDLLRRUU
DURLRLDLRL
ULLURLLRDU
RDLULLRDDD
UUDDUDUDLL
ULRDLUURRR
------------
请你计算一下，最后，有多少玩家会走出迷宫? 
而不是在里边兜圈子。
请提交该整数，表示走出迷宫的玩家数目，不要填写任何多余的内容。
如果你还没明白游戏规则，可以参看一个简化的4x4迷宫的解说图：
p1.png
“把100名玩家放入一个个小房间内”意思就是每个格子有一个玩家，不然不仔细看题还不知道玩家在哪儿呢qaq
这题很简单，就是对每一个格子作一次搜索，能在有效次数内走去迷宫的就++，因为不在有效次数内说明有循环嘛，
当然也可以vis[][]数组标记下重复路径(大材小用),或者换成递归写法传入父亲的坐标（上一个节点）,这里用的是迭代，答案:31
相似题:[蓝桥杯][2014年第五届真题]兰顿蚂蚁
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _01迷宫 {
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(ok(i,j))ans++;
			}
		}
		System.out.println(ans);
	}
	static char[][] ch = new char[][] {
		"UDDLUULRUL".toCharArray(),
		"UURLLLRRRU".toCharArray(),
		"RRUURLDLRD".toCharArray(),
		"RUDDDDUUUU".toCharArray(),
		"URUDLLRRUU".toCharArray(),
		"DURLRLDLRL".toCharArray(),
		"ULLURLLRDU".toCharArray(),
		"RDLULLRDDD".toCharArray(),
		"UUDDUDUDLL".toCharArray(),
		"ULRDLUURRR".toCharArray(),
	};

	private static boolean ok(int x, int y) {
		// TODO Auto-generated method stub
		int t = 25;
		while (t-->0) {
			if (x<0||x>=10||y<0||y>=10) return true;
			if(ch[x][y]=='U')x--;
			else if(ch[x][y]=='D')x++;
			else if(ch[x][y]=='L')y--;
			else if(ch[x][y]=='R')y++;
		}
		return false;
	}
}
