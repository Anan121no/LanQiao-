package _2015_A;

import java.awt.List;
import java.util.Vector;

/*
 * ������������������ʱ�����ѭ��С������ѭ�����ֳ�Ϊ��ѭ���ڡ�
���磬11/13=6=>0.846153846153.....  ��ѭ����Ϊ[846153] ����6λ��
����ķ������������ѭ���ڵĳ��ȡ�
����ϸ�Ķ����룬����д���߲���ȱ�ٵĴ��롣
    public static int f(int n, int m)
    {
        n = n % m;    
        Vector v = new Vector();
        
        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) return 0;
            if(v.indexOf(n)>=0)  _________________________________ ;  //���
        }
    }
 */
public class _04ѭ���ڳ��� {
	public static void main(String[] args) {
		int n = 11,m = 13;
		System.out.println(f(n, m));
//		List list = new List();
	}
    public static int f(int n, int m)
    {
        n = n % m;    
        Vector v = new Vector();
        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) return 0;
            if(v.indexOf(n)>=0)  return v.size()-v.indexOf(n);  //���
        }
    }
}
