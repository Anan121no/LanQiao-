package _2017_C;
import java.util.*;
/*
 * X星球的流行宠物是青蛙，一般有两种颜色：白色和黑色。
X星球的居民喜欢把它们放在一排茶杯里，这样可以观察它们跳来跳去。
如下图，有一排杯子，左边的一个是空着的，右边的杯子，每个里边有一只青蛙。
1
2
3
*WWWBBB

其中，W字母表示白色青蛙，B表示黑色青蛙，*表示空杯子。

X星的青蛙很有些癖好，它们只做3个动作之一：
1. 跳到相邻的空杯子里。
2. 隔着1只其它的青蛙（随便什么颜色）跳到空杯子里。
3. 隔着2只其它的青蛙（随便什么颜色）跳到空杯子里。

对于上图的局面，只要1步，就可跳成下图局面：
1
2
3
4
5
6
7
8
WWW*BBB

本题的任务就是已知初始局面，询问至少需要几步，才能跳成另一个目标局面。

输入为2行，2个串，表示初始局面和目标局面。
输出要求为一个整数，表示至少需要多少步的青蛙跳。

例如：
输入：

*WWBB
WWBB*
1
2
则程序应该输出：

2

再例如，
输入：

WWW*BBB
BBB*WWW
1
2
则程序应该输出：

10

我们约定，输入的串的长度不超过15

笨笨有话说：
我梦见自己是一棵大树，
青蛙跳跃，
我就发出新的枝条，
春风拂动那第 5 层的新枝,
哦，我已是枝繁叶茂。

1.BFS直接搜，找到每个青蛙能跳的到的所有状态，进入队列，若某一个状态
的字符串与题目所给的结束值一样，就直接输出；

2.为了方便定义一个类，用来记录当前状态的字符串，和变成当前状态的最
小次数

3.我这代码最后两个测试点超时了，但我觉得还挺好理解，全都用的队列，
用队列BFS，用队列去重；


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

————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _09青蛙跳杯子 {
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
        queue.offer(first);//存入第一个点
        while(queue.size()!=0){
            Node temp=queue.poll();
            //BFS找到了就是最小值
            if(temp.now.equals(end)){
                System.out.println(temp.step);
                break;
            }
            //没找到继续遍历
            //找所有青蛙
            char []temparr=temp.now.toCharArray();
            for(int i=0;i<temparr.length;i++){
                if(temparr[i]=='*')continue;
                //找到每个青蛙所能跳到的空杯子
                for(int j=-3;j<=3;j++){

                    if((i+j>=0&&i+j<end.length())&&temparr[i+j]=='*'&&j!=0){
                        swap(temparr,i,i+j);//找到之后交换，注意之后还要调回来
                        String tempstring=new String(temparr);
                        if(!map.contains(tempstring)){
                            queue.offer(new Node(tempstring,temp.step+1));
                            map.offer(tempstring);
                        }
                        swap(temparr,i,i+j);//类似于回溯
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
