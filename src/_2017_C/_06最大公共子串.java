package _2017_C;
/*
 * 最大公共子串长度问题就是：
求两个串的所有子串中能够匹配上的最大长度是多少。
比如："abcdkkk" 和 "baabcdadabc"，
可以找到的最长的公共子串是"abcd",所以最大公共子串长度为4。
下面的程序是采用矩阵法进行求解的，这对串的规模不大的情况还是比较有效的解法。
请分析该解法的思路，并补全划线部分缺失的代码。
public class Main
{
    static int f(String s1, String s2)
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int[][] a = new int[c1.length+1][c2.length+1];
        
        int max = 0;
        for(int i=1; i<a.length; i++){
            for(int j=1; j<a[i].length; j++){
                if(c1[i-1]==c2[j-1]) {
                    a[i][j] = __________________;  //填空 
                    if(a[i][j] > max) max = a[i][j];
                }
            }
        }
        
        return max;
    }
    
    public static void main(String[] args){
        int n = f("abcdkkk", "baabcdadabc");
        System.out.println(n);
    }
}

注意：只提交缺少的代码，不要提交已有的代码和符号。也不要提交说明性文字。
答案:1+a[i-1][j-1]，建议粗心党遇到再熟悉的题目也要放进运行控制台验算下
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88422169
 */
public class _06最大公共子串 {
	static int f(String s1, String s2)
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] a = new int[c1.length+1][c2.length+1];
        int max = 0;
        for(int i=1; i<a.length; i++){
            for(int j=1; j<a[i].length; j++){
                if(c1[i-1]==c2[j-1]) {
                    a[i][j] = 1+a[i-1][j-1];  //填空 
                    if(a[i][j] > max) max = a[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        int n = f("abcdkkk", "baabcdadabc");
        System.out.println(n);
    }
}
