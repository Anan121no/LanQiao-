package _2015_A;
/*
 * 1~9�����ֿ������3��3λ������Ϊ��A,B,C,  ����Ҫ���������¹�ϵ��
B = 2 * A
C = 3 * A
����д��A�����п��ܴ𰸣����ּ��ÿո�ֿ������ְ��������С�
ע�⣺ֻ�ύA��ֵ���ϸ��ո�ʽҪ�������
��:192 219 273 327,д��ȫ��
 */
public class _03���������� {
	static int arr[] = {1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		f(0);
	}
	private static void f(int k) {
		// TODO Auto-generated method stub
		if(k==9) {
			int a = arr[0]*100+arr[1]*10+arr[2];
			int b = arr[3]*100+arr[4]*10+arr[5];
			int c = arr[6]*100+arr[7]*10+arr[8];
			if (2*a==b&&3*a==c) {
				System.out.println(a);
			}
		}
		for (int i = k; i < 9; i++) {
			int t = arr[i];arr[i]=arr[k];arr[k]=t;
			f(k+1);
			t = arr[i];arr[i]=arr[k];arr[k]=t;
		}
	}
}
