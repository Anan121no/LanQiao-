package _2018_A;
/*
 * 如下的程序会在控制台绘制分形图（就是整体与局部自相似的图形）。

当n=1,2,3的时候，输出如下：
请仔细分析程序，并填写划线部分缺少的代码。

n=1时：
o
ooo
o

n=2时：
o
ooo
o
o o o
ooooooooo
o o o
o
ooo
o

n=3时：
o
ooo
o
o o o
ooooooooo
o o o
o
ooo
o
o o o
ooo ooo ooo
o o o
o o o o o o o o o
ooooooooooooooooooooooooooo
o o o o o o o o o
o o o
ooo ooo ooo
o o o
o
ooo
o
o o o
ooooooooo
o o o
o
ooo
o
static void draw(byte[][] buf, int x, int y, int size){
	if(size==1){
		buf[y][x] = 1;
		return;
	}
	
	int n = ________________________ ;  // 填空
	draw(buf, x, y, n);
	draw(buf, x-n, y ,n);
	draw(buf, x+n, y ,n);
	draw(buf, x, y-n ,n);
	draw(buf, x, y+n ,n);
}

public static void main(String[] args){
	final int N = 3;
	int t = 1;
	for(int i=0; i<N; i++) t *= 3;
	
	byte[][] buf = new byte[t][t];
	draw(buf, t/2, t/2, t);
	show(buf);
}

public class Main
{undefined
static void show(byte[][] buf){undefined
for(int i=0; i<buf.length; i++){undefined
for(int j=0; j<buf[i].length; j++){undefined
System.out.print(buf[i][j]==0? ’ ’ : ‘o’);
}
System.out.println();
}
}
————————————————
版权声明：本文为CSDN博主「郝大侠001」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/jmkmlm123456/article/details/87639598
 */
public class _05打印图形 {
	static void show(byte[][] buf){
	for(int i=0; i<buf.length; i++){
	for(int j=0; j<buf[i].length; j++){
	System.out.print(buf[i][j]==0?"" : 'o');
	}
	System.out.println();
	}
	}
	static void draw(byte[][] buf, int x, int y, int size){
		if(size==1){
			buf[y][x] = 1;
			return;
		}
		
		int n = size/3 ;  // 填空
		draw(buf, x, y, n);
		draw(buf, x-n, y ,n);
		draw(buf, x+n, y ,n);
		draw(buf, x, y-n ,n);
		draw(buf, x, y+n ,n);
	}

	public static void main(String[] args){
		final int N = 2;
		int t = 1;
		for(int i=0; i<N; i++) t *= 3;
		
		byte[][] buf = new byte[t][t];
		draw(buf, t/2, t/2, t);
		show(buf);
	}
}
