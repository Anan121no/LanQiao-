package _2014_B;
/*
 * ��Ŀ����
��Сѧ��ʱ��С�������Լ��������㷨��һ�Σ���ʦ������Ŀ�ǣ�
1/4 ���� 8/5
С����Ȼ�ѷ���ƴ����һ�𣬷�ĸƴ����һ�𣬴��ǣ�18/45 ���μ�ͼ1.png��
��ʦ������������ת��һ�룬����𰸴���Ҳ�԰������Ǽ���
���ڷ��ӡ���ĸ���� 1~9 �е�һλ���������������Щ��ʽ�������������أ�
��д�����в�ͬ��ʽ�ĸ������������о����ģ���
��Ȼ���������ӷ�ĸ�����磺4/1 ���� 5/8 ������Ҫ��ģ���������ͬ����ʽ��
�����ڷ��ӷ�ĸ��ͬ�������2/2 ���� 3/3 ����������̫���ˣ����ڼ���֮��!
ע�⣺���Ǹ����������ǶԳ��ԣ��϶���ż��������ͨ��������ύ����Ҫ��д��������ݡ�
https://blog.csdn.net/weixin_44833195/article/details/106371209
 */
public class _06��ֵķ�ʽ {
private static int ans = 0;

public static void main(String[] args) {
	for (int a = 1; a < 10; a++) {
		for (int b = 0; b < 10; b++) {
			if(a==b)continue;
			for (int c = 1; c < 10; c++) {
				for (int d = 1; d < 10; d++) {
					if(c==d)continue;
					int gcd1 = gcd(a*c,b*d);
					int gcd2 = gcd(a*10+c,b*10+d);
					if(a*c/gcd1==(a*10+c)/gcd2&&b*d/gcd1==(b*10+d)/gcd2)
						ans ++;
				}
			}
		}
	}
	System.out.println(ans);
}

private static int gcd(int a, int b) {
	// TODO Auto-generated method stub
	if(b==0)return a;
	return gcd(b, a%b);
}
}
