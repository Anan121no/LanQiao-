package _2016_B;
/*
 * ��һ��ú�򣬶ѳ�������׶�Ρ����壺
��һ���1����
�ڶ���3�������г������Σ���
������6�������г������Σ���
���Ĳ�10�������г������Σ���
....
���һ����100�㣬���ж��ٸ�ú��
�����ʾú������Ŀ�����֡�
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
��:171700,ע�������100���ܹ���ֵ,���ǵ�100���ֵ
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _01ú����Ŀ {
	private static int ans;

	public static void main(String[] args) {
		System.out.println(f(1,101,0));
	}

	private static int f(int m, int n,int ans) {
		// TODO Auto-generated method stub
		if(m==n)return ans;
		int c = 0;
		for (int i = 1; i <= m; i++) {
			c+=i;
		}
		ans+=c;
		return f(m+1, n, ans);
	}
}
