package _2017_C;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * С��ʱ�������ֽ����Ϸ��
��һ�ֽ���������������Ϸ������ܼ򵥣�ȴ������С���ѡ�
�����������£�
����μ���Ϸ��С������A��B����Ϸ��ʼ��ʱ�����ǵõ��������ֽ���������£�
A����[K, 8, X, K, A, 2, A, 9, 5, A]
B����[2, 7, K, 5, J, 5, Q, 6, K, 4]
���е�X��ʾ��10�������Ǻ�����ֽ�ƵĻ�ɫ��
��A����ʼ��A��B˫���������ơ�
���ֵ�ĳһ������ʱ�������Լ���ֽ�ƶ��е�ͷ������һ�ţ��ŵ����ϣ�����ѹ��������һ��ֽ���ϣ�����еĻ�����
�����У���Ϸ���̣�
A��K��B��2��A��8��B��7��A��X����ʱ���ϵ�����Ϊ��
K,2,8,7,X
���ֵ�B����ʱ��������K�����ϵ�ֽ�������е�K��ͬ����Ѱ���K���ڵ��Լ�����K֮���ֽ�ƶ�Ӯ�����������Լ��ƵĶ�β��ע�⣺Ϊ�˲������㣬�����Ƶ�˳���������ϵ�˳���෴�ġ�
��ʱ��A��B˫����������Ϊ��
A����[K, A, 2, A, 9, 5, A]
B����[5, J, 5, Q, 6, K, 4, K, X, 7, 8, 2, K]
Ӯ�Ƶ�һ���������ơ�Ҳ����B���ų�5��A��K��B��J��A��A��B��5����Ӯ���ˡ�
5,K,J,A,5
��ʱ˫�������ƣ�
A����[2, A, 9, 5, A]
B����[Q, 6, K, 4, K, X, 7, 8, 2, K, 5, A, J, K, 5]
ע�⣺�����ʱ��Ӯ�Ƶ�һ�������ܰ����ϵ��ƶ�Ӯ�ߣ�����������ͬ�Ƶ㼰���м�Ĳ��֡�
��������Σ�����Ӯ�Ƶ�һ���������ƣ��е�ʱ���һ������Ӯ�ˣ�Ҳ������ġ�
��ĳһ�������������һ���ƣ����޷���������Ӯȡ��ʱ����Ϸ����������
���ڱ����ĳ�ʼ��������£����A���������B����������Ϊ��
9K2A62KAX58K57KJ5
��������������֪˫����ʼ���򣬼�����Ϸ����ʱ��Ӯ��һ����������򡣵���Ϸ�޷�����ʱ�����-1��
����Ϊ2�У�2�������ֱ��ʾA��B˫����ʼ����������С�
���Ϊ1�У�1��������ʾA�ȳ��ƣ����Ӯ��һ�����������
���磬
���룺
96J5A898QA
6278A7Q973
�����Ӧ�������
2J9A7QA6Q6889977
�ٱ��磬
���룺
25663K6X
7448
J88A5KJXX45A
�����Ӧ�������
6KAJ458KXAX885XJ645
����Լ��������Ĵ��ĳ��Ȳ�����30
�����л�˵��
����ɾ��ǰ�ߵģ���Ҫ�����ӡ� ��������飬��Ҫ��һ�����ģ�����汣������Ϸ����ǰ�������õ�����ı�Ե��
�����л�˵��
������Ҳ����������ÿ�β���������һ���µĴ���
ĬĬ�л�˵��
��һ�㶼��֨�������ǵ��͵Ķ��нṹ����̬������ã�û�У��Լ���һ���£�
�ö���ģ�����룬��ջģ����������
1
AcWing������Եص�
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _08���� {
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
            //index��������A��
            if(index%2!=0&&a.size()!=0){
                char paia=a.poll();

                //�������Ƿ��������
                if(zhuo.contains(paia)){
                    //�������ƾʹ����Ȼ��һ������
                    zhuo.add(paia);
                while (zhuo.contains(paia)){
                    a.offer(zhuo.pop());
                }
                //Ӯ�Ƽ�����
                    continue;
                }
                //û�������ҲҪ�����
                else {
                    zhuo.add(paia);
                }
                if(a.size()==0){
                    flag=2;//��flag==2ʱ��ʾa���Ƴ�����
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
                    //Ӯ�Ƽ�����
                    continue;
                }
                else {
                    zhuo.add(paib);
                }
                //�鿴�Ƿ����
                if(b.size()==0){
                    flag=1;//��flag==1ʱ��ʾb���Ƴ�����
                    break;
                }
            }
            index++;
        }
        if(flag==0){//û��Ӯ��
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
