package _2015_C;
/*
 * Excel��ĸ��Ӻܶ࣬Ϊ�˱����ĳ�е����ݺ������л��������Բ��ø��б�ɫ����ʽ��
С����Ƶ���ʽΪ����1����ɫ����2�а�ɫ����3����ɫ����4�а�ɫ��....
����С����֪�����ӵ�21�е���50��һ�������˶��ٸ���ɫ���С�

����ֱ���ύ���������ǧ��Ҫ��д�κζ�������ݡ�
 */
public class _01���б�ɫ {
	private static int count=0;

	public static void main(String[] args) {
		for (int i = 21; i <= 50; i++) {
			if((i&1)!=0)count++;
		}
		System.out.println(count);
	}
}
