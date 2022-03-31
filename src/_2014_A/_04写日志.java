package _2014_A;
/*
 * 写日志是程序的常见任务。现在要求在 t1.log, t2.log, t3.log 三个文件间轮流
写入日志。也就是说第一次写入t1.log，第二次写入t2.log，... 第四次仍然
写入t1.log，如此反复。
下面的代码模拟了这种轮流写入不同日志文件的逻辑。
public class A
{
private static int n = 1;

public static void write(String msg)
{
String filename = "t" + n + ".log";
n = ____________;
System.out.println("write to file: " + filename + " " + msg);
}
}
上代码：
public class Main
{
　　private static int n = 1;
　　public static void main(String args[]){
　　　　for (int i = 0; i<=100; i++) {
　　　　　　write(i,"1111");
　　　　}
　　}
　　public static void write(int n, String msg)
　　{
　　　　n = n%3+1;
　　　　String filename = "t" + n + ".log";
　　　　System.out.println("write to file: " + filename + " " + msg);
　　}
}
 */
public class _04写日志 {
	private static int n = 1;

	public static void write(String msg)
	{
	String filename = "t" + n + ".log";
//	n = n%3+1;
	n = ++n%4==0?1:n;
//	System.out.println(n);
	System.out.println("write to file: " + filename + " " + msg);
	}
	public static void main(String[] args) {
		_04写日志.write("msg");
		write("msg");
		write("msg");
		write("msg");
		write("msg");
	}
}
