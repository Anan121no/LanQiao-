package _2014_B;

import java.util.Scanner;

/*
 * ��������
С����Xɽ��̽�գ���һ����������书�ؼ���2000��ҳ����Ȼ��α��ģ���
��ע�⵽����ĵ�10ҳ�͵�11ҳ��ͬһ��ֽ�ϣ�����11ҳ�͵�12ҳ����ͬһ��ֽ�ϡ�
С��ֻ����ϰ����ĵ�81ҳ����92ҳ���书���ֲ�����������顣
����������Ҫ˺�¶�����ֽ���ߣ�
 */
public class _2014_01�����ؼ� {
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
