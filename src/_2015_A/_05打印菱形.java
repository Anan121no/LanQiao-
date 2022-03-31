package _2015_A;
/*
 * 给出菱形的边长，在控制台上打印出一个菱形来。
为了便于比对空格，我们把空格用句点代替。
当边长为8时，菱形为：
.......*
......*.*
.....*...*
....*.....*
...*.......*
..*.........*
.*...........*
*.............*
.*...........*
..*.........*
...*.......*
....*.....*
.....*...*
......*.*
.......*

下面的程序实现了这个功能，但想法有点奇怪。
请仔细分析代码，并填写划线部分缺失的代码。

public class A
{
    public static void f(int n)
    {
        String s = "*";
        for(int i=0; i<2*n-3; i++) s += ".";
        s += "*";
    
        String s1 = s + "\n";
        String s2 = "";
        
        for(int i=0; i<n-1; i++){
            //System.out.println("=>"+s);
            s = "." + _____________________________________ + "*";  //填空
            s1 = s + "\n" + s1;
            s2 += s + "\n";
        }
        System.out.println(s1+s2);        
    }
    
    public static void main(String[] args)
    {
        f(8);
    }
}
————————————————
版权声明：本文为CSDN博主「一叶之修」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_41793113/article/details/88044052
 */
public class _05打印菱形 {
	    public static void f(int n)
	    {
	        String s = "*";
	        for(int i=0; i<2*n-3; i++) s += ".";
	        s += "*";
	    
	        String s1 = s + "\n";
	        String s2 = "";
	        
	        for(int i=0; i<n-1; i++){
	            //System.out.println("=>"+s);
	            s = "." + s.substring(0,s.length()-3) + "*";  //填空
	            s1 = s + "\n" + s1;
	            s2 += s + "\n";
	        }
	        System.out.println(s1+s2);        
	    }
	    
	    public static void main(String[] args)
	    {
	        f(8);
	}
}
