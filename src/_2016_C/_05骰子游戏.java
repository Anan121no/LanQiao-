package _2016_C;
/*
 * ��������һ����Ϸ��
ͬʱ����3����ͨ���ӣ�6�����ϵ����ֱַ���1~6����
�������һ�������ϵ����ֵ������������ĺͣ����Ӯ�ˡ�
����ĳ����������ܻ�ʤ�ľ�ȷ���ʣ��Լ�Լ������ʾ��
 */
public class _05������Ϸ {
	public static void main(String[] args) {
		int ans = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j =1; j <= 6; j++) {
				for (int k = 1; k <= 6; k++) {
					if (i+j==k) {
						ans++;
					}
				}
			}
		}
		ans*=3;
		System.out.println(f(ans,6*6*6));
		int n = 0;
		for(int i=0; i<6; i++)
		for(int j=0; j<6; j++)
		for(int k=0; k<6; k++){
			if(i+j+1==k || i+k+1==j || j+k+1==i) n++;   //���λ��
		}
		
		int m = gcd(n,6*6*6);
		System.out.println(n/m + "/" + 6*6*6/m);
	}

	private static String f(int a, int b) {
		// TODO Auto-generated method stub
		int num=a<b?a:b;
		int maxb=1;
		for (int i = num; i >=2; i--) {
			if (a%i==0&&b%i==0) {
				maxb*=i;
				a=a/i;
				b=b/i;
			}
		}
		String string = a+""+"/"+b+"";
		return string;
	}
	public static int gcd(int a, int b)
	{
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
