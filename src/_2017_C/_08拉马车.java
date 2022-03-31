package _2017_C;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * 小的时候，你玩过纸牌游戏吗？
有一种叫做“拉马车”的游戏，规则很简单，却很吸引小朋友。
其规则简述如下：
假设参加游戏的小朋友是A和B，游戏开始的时候，他们得到的随机的纸牌序列如下：
A方：[K, 8, X, K, A, 2, A, 9, 5, A]
B方：[2, 7, K, 5, J, 5, Q, 6, K, 4]
其中的X表示“10”，我们忽略了纸牌的花色。
从A方开始，A、B双方轮流出牌。
当轮到某一方出牌时，他从自己的纸牌队列的头部拿走一张，放到桌上，并且压在最上面一张纸牌上（如果有的话）。
此例中，游戏过程：
A出K，B出2，A出8，B出7，A出X，此时桌上的序列为：
K,2,8,7,X
当轮到B出牌时，他的牌K与桌上的纸牌序列中的K相同，则把包括K在内的以及两个K之间的纸牌都赢回来，放入自己牌的队尾。注意：为了操作方便，放入牌的顺序是与桌上的顺序相反的。
此时，A、B双方的手里牌为：
A方：[K, A, 2, A, 9, 5, A]
B方：[5, J, 5, Q, 6, K, 4, K, X, 7, 8, 2, K]
赢牌的一方继续出牌。也就是B接着出5，A出K，B出J，A出A，B出5，又赢牌了。
5,K,J,A,5
此时双方手里牌：
A方：[2, A, 9, 5, A]
B方：[Q, 6, K, 4, K, X, 7, 8, 2, K, 5, A, J, K, 5]
注意：更多的时候赢牌的一方并不能把桌上的牌都赢走，而是拿走相同牌点及其中间的部分。
但无论如何，都是赢牌的一方继续出牌，有的时候刚一出牌又赢了，也是允许的。
当某一方出掉手里最后一张牌，但无法从桌面上赢取牌时，游戏立即结束。
对于本例的初始手牌情况下，最后A会输掉，而B最后的手里牌为：
9K2A62KAX58K57KJ5
本题的任务就是已知双方初始牌序，计算游戏结束时，赢的一方手里的牌序。当游戏无法结束时，输出-1。
输入为2行，2个串，分别表示A、B双方初始手里的牌序列。
输出为1行，1个串，表示A先出牌，最后赢的一方手里的牌序。
例如，
输入：
96J5A898QA
6278A7Q973
则程序应该输出：
2J9A7QA6Q6889977
再比如，
输入：
25663K6X
7448
J88A5KJXX45A
则程序应该输出：
6KAJ458KXAX885XJ645
我们约定，输入的串的长度不超过30
笨笨有话说：
不断删除前边的，又要后边添加… 如果用数组，需要开一个大点的，请佛祖保佑在游戏结束前，不会用到数组的边缘。
歪歪有话说：
反正串也不长，不如每次操作都返回一个新的串。
默默有话说：
我一般都不吱声，这是典型的队列结构，动态数组最好，没有？自己造一个呗！
用队列模拟输入，用栈模拟打出来的牌
1
AcWing此题测试地点
————————————————
版权声明：本文为CSDN博主「滘」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _08拉马车 {
	public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String A=input.next();
        String B=input.next();
        Queue<Character> a=new LinkedList<>();
        Queue<Character> b=new LinkedList<>();
        for(int i=0;i<A.length();i++){
            a.offer(A.charAt(i));
        }
        for(int i=0;i<B.length();i++){
            b.offer(B.charAt(i));
        }
        Stack<Character> zhuo=new Stack<>();
        int flag=0;
        int index=1;
        while (index<100000){
            //index奇数就是A出
            if(index%2!=0&&a.size()!=0){
                char paia=a.poll();

                //牌桌上是否有这个数
                if(zhuo.contains(paia)){
                    //有这张牌就打出，然后一起收走
                    zhuo.add(paia);
                while (zhuo.contains(paia)){
                    a.offer(zhuo.pop());
                }
                //赢牌继续出
                    continue;
                }
                //没有这个牌也要打出来
                else {
                    zhuo.add(paia);
                }
                if(a.size()==0){
                    flag=2;//设flag==2时表示a的牌出完了
                    break;
                }


            }
            else if(index%2==0&&b.size()!=0){
                char paib=b.poll();

                if(zhuo.contains(paib)) {
                    zhuo.add(paib);
                    while (zhuo.contains(paib)) {
                        b.offer(zhuo.pop());
                    }
                    //赢牌继续出
                    continue;
                }
                else {
                    zhuo.add(paib);
                }
                //查看是否打完
                if(b.size()==0){
                    flag=1;//设flag==1时表示b的牌出完了
                    break;
                }
            }
            index++;
        }
        if(flag==0){//没有赢家
            System.out.println("-1");
        }
        else if(flag==1){
            while (a.size()!=0){
                System.out.print(a.poll());
            }
        }
        else if(flag==2){
            while (b.size()!=0)
                System.out.print(b.poll());
        }
    }
}
