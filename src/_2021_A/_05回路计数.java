package _2021_A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * ����ѧԺ�� 21 ����ѧ¥��ɣ���ѧ¥��� 1 �� 21������������ѧ¥ a �� b���� a �� b ����ʱ��a �� b ֮����һ������ֱ����������������Կ�ͨ�У���
��û��ֱ�����ӵ����ȡ�
С�������ڵ�һ����ѧ¥������Ҫ����ÿ����ѧ¥����һ�Σ����ջص���
һ����ѧ¥������һ�����ܶ��ٻ�·�����������ж����ֲ�ͬ�ķ��ʷ���������
���ʷ�����ͬ��ָ����ĳ�� i��С�����������ʷ����з������ѧ¥ i �������
��ͬ�Ľ�ѧ¥��
��ʾ������ʹ�ü������̽�����⡣

�����ύ��
����һ�������յ��⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ�����������ύ��ʱֻ��д�����������д��������ݽ��޷��÷֡�

���˴𰸣�881012367360
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/116377115
 */
public class _05��·���� {
	/*
	 * ����˼·�����ѣ�һ��һ��Ҫ���м�֦�������ĳɰܾ����ڼ�֦��
	 * �տ�ʼ��ʱ��û�н��м�֦��ֻ��һ����������ȥ��¼��Щ��ѧ¥�Ѿ��߹�������������ظ��ߵ����󣬵��¸��Ӷȹ��ߡ�
����˵����ʮ�ָ�л��weixin_53212217����λ���ߵķ������Լ�������⣬û��ע��������⣬
�Ѿ���������res������������ԭ����int���ͻ���long���ͣ�����ֵ����ҵ���д�ķ���ֵ���;���long���ͣ��治���ҵ�ʱ����ô��ġ�
��������������������������������
��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/116377115
	 */
	static ArrayList<Integer>[] list;
	static Map<String, Long> set = new HashMap<String, Long>();

	public static void main(String[] args) {
		list = new ArrayList[21 + 1];
		for (int i = 0; i < list.length; ++i)
			list[i] = new ArrayList<Integer>();
		for (int i = 1; i <= 21; ++i)
			for (int j = i + 1; j <= 21; ++j)
				if (gcd(i, j) == 1) {
					list[i].add(j);
					list[j].add(i);
				}
		System.out.println(dfs(21, 1, 0));
	}

	public static long dfs(int total, int cur, int m) {
		if (total == 0)
			return 1;
		long res = 0;
		for (int p : list[cur]) {			//pΪĿ���ѧ¥��mΪ��ǰ�Ѿ����ʹ��Ľ�ѧ¥������m==12����Ӧ�Ķ�����Ϊ00001100����m��ʾ�Ѿ����ʹ��Ľ�ѧ¥��2��3�ţ�
			if ((m & (1 << p)) != (1 << p)) {
				String pm = p + "-" + m;
				long r = 0;
				if (set.containsKey(pm)) {		//��֦
					r = set.get(pm);
				} else {
					if (p != 1 || p == 1 && total == 1)
						r = dfs(total - 1, p, m | (1 << p));
					set.put(pm, r);
				}
				res += r;
			}
		}
		return res;
	}

	public static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		return a % b == 0 ? b : gcd(b, a % b);
	}
//��������������������������������
//��Ȩ����������ΪCSDN����������QIAO����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
//ԭ�����ӣ�https://blog.csdn.net/weixin_45640260/article/details/116377115
}
