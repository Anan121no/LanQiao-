package _2019_C;

import java.util.Scanner;

/*
 * С����˾�İ칫����һ�����������ȣ��� N ������������ɣ�����ͼ��ʾ��
�����ڲ����� K ̨ɨ�ػ����ˣ����е� i ̨�ڵ� Ai �����������С� ��֪ɨ�ػ�����ÿ���ӿ����ƶ����������ڵķ����У�������������ɨ�ɾ���
�����дһ�����򣬼���ÿ̨�����˵���ɨ·�ߣ�ʹ��
(1)���������ն����س�������
(2)��ÿ�������������ٱ���ɨһ�飬
(3)���ӻ����˿�ʼ�ж������һ̨�����˹�λ���ѵ�ʱ�����١�
ע���̨�����˿���ͬʱ��ɨͬһ�����������ǲ��ụ��Ӱ�졣
������ٻ��ѵ�ʱ�䡣 ����ͼ��ʾ�������У����ٻ���ʱ���� 6��
��һ̨·�ߣ�2-1-2-3-4-3-2���� ɨ�� 1��2��3��4 ������
�ڶ�̨·�� 5-6-7-6-5����ɨ�� 5��6��7������̨·�� 10-9-8-9-10����ɨ�� 8��9 �� 10��
�������ʽ��
��һ�а����������� N �� K�� ������ K �У�ÿ��һ������ Ai��
�������ʽ��
���һ��������ʾ�𰸡�
���������롿 10 3 5 2 10
����������� 6
������������ģ��Լ����
���� 30% ������������1�� K < N ��10�� ���� 60% ������������
1�� K < N ��1000�� ������������������1�� K < N ��100000��
1�� Ai �� N��
 */
public class _10ɨ�ػ����� {
	public static int n;
    public static int arr[];
    public static boolean clear[];
    public static boolean check(int arr[],int x){
        clear=new boolean[n+1];
        int p=0;
        int flag=0;
        int index=1;
        boolean out=true;
        while(index<=n){
            p=0;
            flag=0;
            while(p<x&&index+p<=n){
                if(index+p<=n&&arr[index+p]>0){
                    if(arr[index+p]==1){    
                        flag++;
                        if(flag==2){
                            break;
                        }
                    }else{
                        flag++;
                        arr[index+p]--;
                        clear[index+p]=true;
                        break;
                    }
                }
                clear[index+p]=true;
                p++;
            }
            if(flag>0){
                index+=p;
            }else{
                return false;
            }
        }
        for(int i=1;i<=n;i++){
            if(!clear[i])return clear[i];
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int k=sc.nextInt();
        arr=new int[n+1];
        for(int i=0;i<k;i++){
            arr[sc.nextInt()]++;
        }
         
        int l=1,r=n,mid=(l+r)/2;
        while(l<=r){
            mid=(l+r)/2;
            boolean cur=check(arr,mid);
            boolean cur1=check(arr,mid-1);
            if(cur&&!cur1){
                break;
            }else if(cur){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        System.out.println((mid-1)*2);
    }
}
