package _2014_B;
/*
 * * ����������

�й��Ŵ������У������ع����������С�, ��Ҫ���ڽ����й���ͳ�Ļ��е�̫������ԭ��

����ǰ�����ǣ�0��2��4��8��12��18��24��32��40��50 ...

������ǣ���ż��������ƽ���ٳ�2������������ƽ����1�ٳ�2��

���µĴ����ӡ���˴������е�ǰ 100 �

for(int i=1; i<100; i++)
{
if(________________) //���
System.out.println(i*i/2);
else
System.out.println((i*i-1)/2);
}

����д���߲���ȱʧ�Ĵ��롣ͨ��������ύ�𰸡�
 */
public class _04�������� {
	public static void main(String[] args) {
		question();
	}
	private static void question() {
		// TODO Auto-generated method stub
		for(int i=1; i<100; i++)
		{
		if((i&1)!=1) //���
		System.out.println(i*i/2);
		else
		System.out.println((i*i-1)/2);
		}
	}
}
