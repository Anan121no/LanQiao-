package _2017_C;
import java.util.*;
/*
 * X��������г��������ܣ�һ����������ɫ����ɫ�ͺ�ɫ��
X����ľ���ϲ�������Ƿ���һ�Ų豭��������Թ۲�����������ȥ��
����ͼ����һ�ű��ӣ���ߵ�һ���ǿ��ŵģ��ұߵı��ӣ�ÿ�������һֻ���ܡ�
1
2
3
*WWWBBB

���У�W��ĸ��ʾ��ɫ���ܣ�B��ʾ��ɫ���ܣ�*��ʾ�ձ��ӡ�

X�ǵ����ܺ���Щ�ã�����ֻ��3������֮һ��
1. �������ڵĿձ����
2. ����1ֻ���������ܣ����ʲô��ɫ�������ձ����
3. ����2ֻ���������ܣ����ʲô��ɫ�������ձ����

������ͼ�ľ��棬ֻҪ1�����Ϳ�������ͼ���棺
1
2
3
4
5
6
7
8
WWW*BBB

��������������֪��ʼ���棬ѯ��������Ҫ����������������һ��Ŀ����档

����Ϊ2�У�2��������ʾ��ʼ�����Ŀ����档
���Ҫ��Ϊһ����������ʾ������Ҫ���ٲ�����������

���磺
���룺

*WWBB
WWBB*
1
2
�����Ӧ�������

2

�����磬
���룺

WWW*BBB
BBB*WWW
1
2
�����Ӧ�������

10

����Լ��������Ĵ��ĳ��Ȳ�����15

�����л�˵��
���μ��Լ���һ�ô�����
������Ծ��
�Ҿͷ����µ�֦����
��������ǵ� 5 �����֦,
Ŷ��������֦��Ҷï��

1.BFSֱ���ѣ��ҵ�ÿ�����������ĵ�������״̬��������У���ĳһ��״̬
���ַ�������Ŀ�����Ľ���ֵһ������ֱ�������

2.Ϊ�˷��㶨��һ���࣬������¼��ǰ״̬���ַ������ͱ�ɵ�ǰ״̬����
С����

3.�����������������Ե㳬ʱ�ˣ����Ҿ��û�ͦ����⣬ȫ���õĶ��У�
�ö���BFS���ö���ȥ�أ�


1
2
3
4
5
6
7
8
9
10

��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _09���������� {
	static Queue<Node> queue=new LinkedList<Node>();
    static Queue<String>map=new LinkedList<String >();
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String first=input.next();
        String end=input.next();
        Node start=new Node(first,0);
        BFS(start,end);
    }
    public static void BFS(Node first,String end){
        queue.offer(first);//�����һ����
        while(queue.size()!=0){
            Node temp=queue.poll();
            //BFS�ҵ��˾�����Сֵ
            if(temp.now.equals(end)){
                System.out.println(temp.step);
                break;
            }
            //û�ҵ���������
            //����������
            char []temparr=temp.now.toCharArray();
            for(int i=0;i<temparr.length;i++){
                if(temparr[i]=='*')continue;
                //�ҵ�ÿ���������������Ŀձ���
                for(int j=-3;j<=3;j++){

                    if((i+j>=0&&i+j<end.length())&&temparr[i+j]=='*'&&j!=0){
                        swap(temparr,i,i+j);//�ҵ�֮�󽻻���ע��֮��Ҫ������
                        String tempstring=new String(temparr);
                        if(!map.contains(tempstring)){
                            queue.offer(new Node(tempstring,temp.step+1));
                            map.offer(tempstring);
                        }
                        swap(temparr,i,i+j);//�����ڻ���
                    }
                }
            }

        }
        return;

    }
    public static void swap(char []temparr,int x,int y){
        char temp=temparr[x];
        temparr[x]=temparr[y];
        temparr[y]=temp;
    }
}

class Node{
    String now;
    int step;
    public Node(String now ,int step){
        this.now=now;
        this.step=step;
    }
}
