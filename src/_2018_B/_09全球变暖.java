package _2018_B;
import java.util.Scanner;
/*
 * 你有一张某海域NxN像素的照片，".“表示海洋、”#"表示陆地，如下所示：
…
.##…
.##…
…##.
…####.
…###.
…
其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。
由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。
具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。
例如上图中的海域未来会变成如下样子：
…
…
…
…
…#…
…
…
请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。
【输入格式】
第一行包含一个整数N。 (1 <= N <= 1000)
以下N行N列代表一张海域照片。
照片保证第1行、第1列、第N行、第N列的像素都是海洋。
【输出格式】
一个整数表示答案。
【输入样例】
7
…
.##…
.##…
…##.
…####.
…###.
…
【输出样例】
1
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗 < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
解题思路
经典的 dfs题了
1.首先搜索 海岛的个数
2.然后进行淹没
3.然后再搜索 海岛的个数
因为搜索海岛个数的算法 对原 地图有影响 所以 引进一个book数组
对地图进行刻画 在这上面进行计算海岛个数
————————————————
版权声明：本文为CSDN博主「自由学习一门语言」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _09全球变暖 {
	 static int N ;  //大小
	    static char[][] map = new char[N+1][N+100];
	    static int[][] book = new int[N+1][N+1];
	    static  int[][] next = {{-1,0},{0,-1},{1,0},{0,1}};
	    public static void main(String[] args) {
	        Scanner sc =new Scanner(System.in);
	        N = sc.nextInt();
//	        N = 7;
	        int total = 0; //总共
	        int count = 0; //淹没
	        int result = 0;  //结果
	        String[] s = new String[N];
//	        String[] s={".......",
//	                    ".##....",
//	                    ".##....",
//	                    "....##.",
//	                    "..####.",
//	                    "...###.",
//	                    "......."} ;

	        for (int i = 0; i <N; i++) {
	            s[i] = sc.next();
	        }
	        sc.close();
	        for (int i = 0; i <N; i++) {
	            //s = sc.next();
	            map[i] =s[i].toCharArray();
	        }
	        for (int i = 0; i <N ; i++) {
	            for (int j = 0; j <N ; j++) {
	                if(map[i][j]=='#')
	                    book[i][j] = 1;
	                //System.out.print(book[i][j]);
	            }
	            //System.out.println();
	        }

	        //dfs 记录总共岛屿
	        for (int i = 0; i <N ; i++) {
	            for (int j = 0; j <N ; j++) {
	                if(book[i][j]==1){
	                    dfs(i,j);
	                    total++;
	                }
	            }
	        }
	        //淹没过程
	        for (int i = 0; i <N ; i++) {
	            for (int j = 0; j < N; j++) {
	                if(map[i][j]=='#'){
	                    int tx=i,ty=j;
	                    int k ;
	                    for ( k = 0; k <4 ; k++) {
	                        tx+=next[k][0];
	                        ty+=next[k][1];
	                        if(map[tx][ty]!='#')
	                            break;
	                        tx=i;
	                        ty=j;
	                    }
	                    if(k==4)
	                    book[i][j]=1;
	                }
	            }
	        }
	        //dfs记录剩余岛屿
	        for (int i = 0; i <N ; i++) {
	            for (int j = 0; j <N ; j++) {
	                if(book[i][j]==1){
	                    dfs(i,j);
	                    count++;
	                }
	            }
	        }
	        result = total - count;
	        System.out.println(result);
	    }
	    public static void  dfs(int x , int y ){
	        book[x][y] = 0;  //清除
	        int tx,ty;
	        for (int i = 0; i <4 ; i++) {
	            tx=x+next[i][0];
	            ty=y+next[i][1];
	            if(tx>=0 && tx<N && ty>=0 && ty<N){
	                if(book[tx][ty]==1)
	                    dfs(tx,ty);
	            }
	        }
	    }
}
