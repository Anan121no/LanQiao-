package _2020_A;
/*
 * ���һ�������ķ��Ӻͷ�ĸ�����Լ���� 1�����������Ϊ��Լ������
���磬3/4��5/2��1/8��7/1���Ǽ�Լ������
���ʣ��ж��ٸ���Լ���������Ӻͷ�ĸ����1��2020֮������������� 1�� 2020����
�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�
���˴𰸣�2481215
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/115309449
 */
public class _02��Լ���� {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 2020; i++) {
			for (int j = 1; j <= 2020; j++) {
				if (gcd(i,j)==1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		return b==0?a:gcd(b, a%b);
	}
}
