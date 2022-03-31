package _2020_C1;
/*
 * 小明设计了一种文章加密的方法：对于每个字母 c，将它变成某个另外的
字符 T_c 下表给出了字符变换的规则：



例如，将字符串 YeRi 加密可得字符串 EaFn。
小明有一个随机的字符串，加密后为
EaFnjISplhFviDhwFbEjRjfIBBkRyY
（由 30 个大小写英文字母组成，不包含换行符），请问原字符串是多少？
（如果你把以上字符串和表格复制到文本文件中，请务必检查复制的内容
是否与文档中的一致。在试题目录下有一个文件 str.txt，第一行为上面的字符
串，后面 52 行依次为表格中的内容。）
答案提交
这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
只包含 30 3030 个大小写英文字母的字符串，在提交答案时只填写这个字符串，填写
多余的内容将无法得分。
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109015828
 */
public class _02解密 {
	public static void main(String[] args) { // 30个字符
		String s = "EaFnjISplhFviDhwFbEjRjfIBBkRyY"; // 加密后的字符
		char[] arr = s.toCharArray();
		String s1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 原字符
		String s2 = "yxmdacikntjhqlgoufszpwbrevYXMDACIKNTJHQLGOUFSZPWBREV"; // 加密后的字符
		String s3 = ""; // 解密后的字符
		for (int i = 0; i < arr.length; i++) {
			int j = s2.indexOf(arr[i]);   // 输出当前字符在加密后字符中的位置
			s3 = s3 + s1.substring(j, j + 1); // 找出原字符在此位置对应的字符
		}
		System.out.println(s3);
	}
}
