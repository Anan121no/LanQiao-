package _2018_B;
import java.util.Scanner;
/*
 * ����һ��ĳ����NxN���ص���Ƭ��".����ʾ���󡢡�#"��ʾ½�أ�������ʾ��
��
.##��
.##��
��##.
��####.
��###.
��
����"��������"�ĸ�����������һ���һƬ½�����һ�����졣������ͼ����2�����졣
����ȫ���ů�����˺�����������ѧ��Ԥ��δ����ʮ�꣬�����Եһ�����صķ�Χ�ᱻ��ˮ��û��
������˵���һ��½�������뺣������(���������ĸ������������к���)�����ͻᱻ��û��
������ͼ�еĺ���δ�������������ӣ�
��
��
��
��
��#��
��
��
������㣺���տ�ѧ�ҵ�Ԥ�⣬��Ƭ���ж��ٵ���ᱻ��ȫ��û��
�������ʽ��
��һ�а���һ������N�� (1 <= N <= 1000)
����N��N�д���һ�ź�����Ƭ��
��Ƭ��֤��1�С���1�С���N�С���N�е����ض��Ǻ���
�������ʽ��
һ��������ʾ�𰸡�
������������
7
��
.##��
.##��
��##.
��####.
��###.
��
�����������
1
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU���� < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ����������롭�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
����˼·
����� dfs����
1.�������� �����ĸ���
2.Ȼ�������û
3.Ȼ�������� �����ĸ���
��Ϊ���������������㷨 ��ԭ ��ͼ��Ӱ�� ���� ����һ��book����
�Ե�ͼ���п̻� ����������м��㺣������
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
public class _09ȫ���ů {
	 static int N ;  //��С
	    static char[][] map = new char[N+1][N+100];
	    static int[][] book = new int[N+1][N+1];
	    static  int[][] next = {{-1,0},{0,-1},{1,0},{0,1}};
	    public static void main(String[] args) {
	        Scanner sc =new Scanner(System.in);
	        N = sc.nextInt();
//	        N = 7;
	        int total = 0; //�ܹ�
	        int count = 0; //��û
	        int result = 0;  //���
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

	        //dfs ��¼�ܹ�����
	        for (int i = 0; i <N ; i++) {
	            for (int j = 0; j <N ; j++) {
	                if(book[i][j]==1){
	                    dfs(i,j);
	                    total++;
	                }
	            }
	        }
	        //��û����
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
	        //dfs��¼ʣ�ൺ��
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
	        book[x][y] = 0;  //���
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
