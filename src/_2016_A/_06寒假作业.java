package _2016_A;
/*
 * ����Сѧ����ѧ��ĿҲ������ô����ġ�
�������������ҵ��
   �� + �� = ��
   �� - �� = ��
   �� �� �� = ��
   �� �� �� = ��  
   (�����ʾ�����������Բμ���ͼ1.jpg��)   
ÿ���������1~13�е�ĳһ�����֣��������ظ���
���磺
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
�Լ��� 
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
�������ֽⷨ�����ӷ����˷������ɺ��㲻ͬ�ķ�����
��һ���ҵ��˶����ַ�����
����д��ʾ������Ŀ��������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
��:64,2^13,��Ҫ��ǰ��֦�����ܳ���
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _06������ҵ {
	private static int []a = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	static int ans;
	public static void main(String[] args) {
		dfs(0);
	}
	private static void dfs(int k) {
		// TODO Auto-generated method stub
		if (k==13) {
			if (check()) {
				System.out.println();
			}
		}
		for (int i = k; i < a.length; i++) {
			swap(k,i);
			dfs(k+1);
			swap(k,i);
		}
	}
	private static boolean check() {
		// TODO Auto-generated method stub
		if(a[0]+a[1]==a[2]&&
			a[3]-a[4]==a[5]&&
			a[6]*a[7]==a[8]&&
			a[9]/a[10]==a[11])
			return true;
		return false;
	}
	private static void swap(int k, int i) {
		// TODO Auto-generated method stub
		int t = a[i];
		a[i] = a[k];
		a[k] = t;
	}
}
