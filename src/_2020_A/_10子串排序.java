package _2020_A;

import java.util.Scanner;

/*
 * 小蓝最近学习了一些排序算法，其中冒泡排序让他印象深刻。
在冒泡排序中，每次只能交换相邻的两个元素。小蓝发现，如果对一个字符串中的字符排序，
只允许交换相邻的两个字符，则在所有可能的排序方案中，冒泡排序的总交换次数是最少的。
例如，对于字符串l a n lanlan排序，只需要1 11次交换。对于字符串 q i a o qiaoqiao 排序，总共需要 4 44 次交换。
小蓝找到了很多字符串试图排序，他恰巧碰到一个字符串，需要 V VV 次交换，可是他忘了把这个字符串记下来，现在找不到了。
小蓝的幸运数字是V VV ，他想找到一个只包含小写英文字母的字符串，对这个串中的字符进行冒泡排序，正好需要V VV次交换。
请帮助小蓝找一个这样的字符串。
如果可能找到多个，请告诉小蓝最短的那个。如果最短的仍然有多个，请告诉小蓝字典序最小的那个。请注意字符串中可以包含相同的字符。
解题思路
冒泡排序的交换次数——序列中逆序对的个数。
在满足交换次数V的前提下，要求最短的序列。因为确定长度下的序列，逆序对个数的最大值是确定的，
那么只需找到第一个逆序对个数>=V的序列长度，该长度即为所要求的最短序列的长度。
字典序最小，在已知序列长度下，我们可以从序列的第一个（开头）字母开始往后枚举，每次从’a’~'z’的顺序枚举每个字母，
直到找到第一个满足以该枚举的字母为开头的序列的最大逆序对个数 + 已经确定的逆序对个数 >= V，才继续往后枚举下一个字母的值。
具体做法
① 求最短序列长度
在确定的长度下，要求序列的逆序对个数的最大值，那么序列的第 i 个字母一定要 >= 第 i + 1 个字母（可以用反证法证明）
② 求字典序最小的序列
根据①的分析，可以知道每次的枚举应该改为从’a’~last，last为序列中的上一个字母。
重点就是要算出以该枚举的字母为开头的序列的最大逆序对个数，这里采用dp的方法，并且将该步和①的计算放在一起。
分析方法：闫氏DP分析法
链接里看图
————————————————
版权声明：本文为CSDN博主「Dripping.」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43619717/article/details/112595685
 */
public class _10子串排序 {
	static int N = (int)1e4+5;
public static int n;
public static int m;
public static int _max;
public static int len;
private static int[] res;
private static int[] num;

	static boolean judge(int letter) {
		int i = 26, j = letter;
		while (0!=res[i]) i--;//while (!res[i]) i--;原来是这样的
		if (i == j) {
			while (i > 0 && j > 0) {
				if (res[i] != num[j]) {
					return res[i] > num[j];
				} else {
					i--; j--;
				}
			}
		}
		return i > j;
	}

	static void dfs(int letter, int curlen, int cursum, int l) {
		if (cursum > n) return ;
		if (letter > _max) return ;
		if (curlen > len) return ;
		
		if (curlen == len && cursum != n) return ;
		if (letter == _max && cursum != n) return ;
		
		if (cursum == n) {
			if (curlen < len || judge(letter)) { //长度减小或字典序减小更新结果
				len = curlen;
				for (int i = 1; i <= 26; i++) {
					res[i] = num[i];
				}
			}
			return ;
		}

		for (int i = 1; i <= l; i++) {
			num[letter + 1] = i;
			dfs(letter + 1, curlen + i, cursum + i * curlen, i);
		}
		num[letter + 1] = 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = 0; len = 0;
		while (m < n) {
			int id = 1;
			for (int i = 2; i <= 26; i++) { //找到s最小的点, 如果存在多个取字典序更小的
	      if (res[i] < res[id]) id = i;
			}
			m += len - res[id];
			_max = Math.max(_max, id);
			len ++; res[id] ++;
		}
		
		dfs(0, 0, 0, 10);
		
		for (int i = _max; i >= 1; i--) {
			for (int j = res[i]; j > 0; j--) {
				System.out.printf("%c", i-1+'a');
			}
		}
		System.out.printf("\n");
}
}