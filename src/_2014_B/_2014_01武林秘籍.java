package _2014_B;

import java.util.Scanner;

/*
 * 问题描述
小明到X山洞探险，捡到一本有破损的武功秘籍（2000多页！当然是伪造的）。
他注意到：书的第10页和第11页在同一张纸上，但第11页和第12页不在同一张纸上。
小明只想练习该书的第81页到第92页的武功，又不想带着整本书。
请问他至少要撕下多少张纸带走？
 */
public class _2014_01武林秘籍 {
private static int count=0;
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	int m = in.nextInt();
	solve(n,m);
}

private static void solve(int n, int m) {
	// TODO Auto-generated method stub
	count=(m-n+1)/2;
	if(n%2!=0&&m%2!=0)count++;
	if(n%2!=0&&m%2==0)count++;
	if(n%2==0&&(m&1)!=1)count+=2;
	System.out.println(count);
}
}
