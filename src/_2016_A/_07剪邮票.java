package _2016_A;
/*
 * �硾ͼ1.jpg��, ��12������һ���12��Ф����Ʊ��
������Ҫ���м���5������Ҫ����������ŵġ�
����������һ���ǲ���������
���磬��ͼ2.jpg������ͼ3.jpg���У��ۺ�ɫ��ʾ���־��Ǻϸ�ļ�ȡ��
������㣬һ���ж����ֲ�ͬ�ļ�ȡ������
����д��ʾ������Ŀ��������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
��:116������+��ͨ�飬ȫ��+set����Ӧ��Ҳ�У������ܸ��ӣ�����Ѷ�άתΪһά�����ڴ���
��������������������������������
��Ȩ����������ΪCSDN������һҶ֮�ޡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/weixin_41793113/article/details/88421963
 */
public class _07����Ʊ {
public static void main(String[] args) {
		for(int i=1;i<=12;i++) {
			for(int j=i+1;j<=12;j++) {
				for(int k=j+1;k<=12;k++) {
					for(int x=k+1;x<=12;x++) {
						for(int y=x+1;y<=12;y++) {
							vis[i]=vis[j]=vis[k]=vis[x]=vis[y]=true;
							t=0;
							dfs(i);
							if(t==5)
								ans++;
							vis[i]=vis[j]=vis[k]=vis[x]=vis[y]=false;
						}
					}
				}
			}			
		}
		System.out.println(ans);
	}
	
//	static char[] a = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L'};
//	static HashSet<String> set = new HashSet<>();
	static boolean[] vis = new boolean[13];
	static int ans = 0;
	static int t=0;
	
	static void dfs(int x) {
		vis[x]=false;
		t++;
		if(x!=1 && x!=5 && x!=9 && vis[x-1])
			dfs(x-1);
		if(x!=4 && x!=8 && x!=12 && vis[x+1])
			dfs(x+1);
		if(x!=1 && x!=2 && x!=3 && x!=4 && vis[x-4])
			dfs(x-4);
		if(x!=9 && x!=10 && x!=11 && x!=12 && vis[x+4])
			dfs(x+4);
	}
}
