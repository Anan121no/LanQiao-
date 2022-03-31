package _2018_B;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/*
 * С��ά����һ������Ա��̳���������ռ���һ��"����"��־����־����N�С�����ÿһ�еĸ�ʽ�ǣ�
ts id
��ʾ��tsʱ�̱��id�������յ�һ��"��"��
����С����ͳ������Щ����������"����"�����һ��������������һ������ΪD��ʱ������յ�������K���ޣ�С������Ϊ�����������"����"��
������˵���������ĳ��ʱ��T���������[T, T+D)���ʱ����(ע��������ҿ�����)�յ�������K���ޣ�����������"����"��
������־���������С��ͳ�Ƴ���������"����"�����ӱ�š�
�������ʽ��
��һ�а�����������N��D��K��
����N��ÿ��һ����־��������������ts��id��
����50%�����ݣ�1 <= K <= N <= 1000
����100%�����ݣ�1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000
�������ʽ��
����С�����˳���������id��ÿ��idһ�С�
������������
7 10 2
0 1
0 10
10 10
10 1
9 1
100 3
100 3
�����������
1
3
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU���� < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ����������롭�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
����˼·
���õ��˽ṹ�� ���ýṹ�����洢��Щ����
Ȼ��������� �ź���
��ѭ��һ��Ϳ��Լ������� ����
��������������������������������
��Ȩ����������ΪCSDN����������ѧϰһ�����ԡ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_45756224/article/details/104999114
 */
	/**
	 * @author sjf
	 * @date 2020/3/8 18:01
	 */
	class log {

	     int ts;
	     int id;

	    public log(int ts, int id) {
	        this.ts = ts;
	        this.id = id;
	    }


	    @Override
	    public String toString() {
	        return "log{" +
	                "ts=" + ts +
	                ", id=" + id +
	                '}';
	    }
	}

	public class _08��־ͳ�� {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N , K , D;
	        N = sc.nextInt();
	        D = sc.nextInt();
	        K = sc.nextInt();

	        ArrayList<log> log1 = new ArrayList<>();

	        for (int i = 0; i < N; i++) {
	            int tst = sc.nextInt();
	            int idt = sc.nextInt();
	            log1.add(new log(tst,idt));
	        }

	        Collections.sort(log1, new Comparator<log>() {
	            @Override
	            public int compare(log o1, log o2) {
	                //���ȿ� id �Ĵ�С
	                int result = o1.id - o2.id;
	                //id��С��ͬ �� ʱ��
	                if(result == 0){
	                    result = o1.ts - o2.ts;
	                }
	                return result;
	            }
	        });

	        //System.out.println(log1);
	        //[log{ts=0, id=1}, log{ts=9, id=1}, log{ts=10, id=1}, log{ts=100, id=3}, log{ts=100, id=3}, log{ts=0, id=10}, log{ts=10, id=10}]

	        int previousid = log1.get(0).id;
	        int flag= 0;
	        for (int i = 0; i < N-K+1; i++) {
	            //��¼ÿ�ε� id
	            int idtemp = log1.get(i).id;
	            if(log1.get(i+K-1).id == previousid && log1.get(i+K-1).id == idtemp && flag == 0){
	                //����ھ���  K ������ȵ�id ��ô�ж� ts �Ĺ�ϵ
	                if(log1.get(i).ts+D > log1.get(i+K-1).ts) {
	                    flag = 1;
	                    System.out.println(idtemp);
	                }
	            }
	            else if(log1.get(i).id != previousid ){
	                previousid = idtemp;  //��ʼһ���µ����ӵļ��
	                flag = 0;
	                i--;  // �˻�һ�� �������֮����Ǹ� i++��
	            }

	        }
		 }
}
