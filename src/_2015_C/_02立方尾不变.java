package _2015_C;
/*
 * ��Щ���ֵ�������ĩβ�����Ǹ����ֱ���
���磺1,4,5,6,9,24,25,....

�������һ�£���10000���ڵ������У�ָ�����֣����������������ֵ�����������������������һ���ж��ٸ���

���ύ����������Ҫ��д�κζ�������ݡ�
 */
public class _02����β���� {
	private static int ans;

	public static void main(String[] args) {
		for (long i = 1; i < 10000; i++) {
			if (i<10) {
				if(i*i*i%10==i)ans++;
			}else if (i<100){
				if(i*i*i%100==i)ans++;
			}else if (i<1000){
				if(i*i*i%1000==i)ans++;
			}else if (i<10000){
				if(i*i*i%10000==i)ans++;
			}
		}
		System.out.println(ans);
	}
}
