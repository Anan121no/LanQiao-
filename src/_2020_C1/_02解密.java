package _2020_C1;
/*
 * С�������һ�����¼��ܵķ���������ÿ����ĸ c���������ĳ�������
�ַ� T_c �±�������ַ��任�Ĺ���



���磬���ַ��� YeRi ���ܿɵ��ַ��� EaFn��
С����һ��������ַ��������ܺ�Ϊ
EaFnjISplhFviDhwFbEjRjfIBBkRyY
���� 30 ����СдӢ����ĸ��ɣ����������з���������ԭ�ַ����Ƕ��٣�
�������������ַ����ͱ���Ƶ��ı��ļ��У�����ؼ�鸴�Ƶ�����
�Ƿ����ĵ��е�һ�¡�������Ŀ¼����һ���ļ� str.txt����һ��Ϊ������ַ�
�������� 52 ������Ϊ����е����ݡ���
���ύ
����һ���������⣬��ֻ��Ҫ���������ύ���ɡ�����Ľ��Ϊһ��
ֻ���� 30 3030 ����СдӢ����ĸ���ַ��������ύ��ʱֻ��д����ַ�������д
��������ݽ��޷��÷֡�
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _02���� {
	public static void main(String[] args) { // 30���ַ�
		String s = "EaFnjISplhFviDhwFbEjRjfIBBkRyY"; // ���ܺ���ַ�
		char[] arr = s.toCharArray();
		String s1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // ԭ�ַ�
		String s2 = "yxmdacikntjhqlgoufszpwbrevYXMDACIKNTJHQLGOUFSZPWBREV"; // ���ܺ���ַ�
		String s3 = ""; // ���ܺ���ַ�
		for (int i = 0; i < arr.length; i++) {
			int j = s2.indexOf(arr[i]);   // �����ǰ�ַ��ڼ��ܺ��ַ��е�λ��
			s3 = s3 + s1.substring(j, j + 1); // �ҳ�ԭ�ַ��ڴ�λ�ö�Ӧ���ַ�
		}
		System.out.println(s3);
	}
}
