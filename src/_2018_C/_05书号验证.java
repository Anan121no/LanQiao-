package _2018_C;
/*
 * 2004���𣬹���ISBN���ĳ����ˡ�13λ���ʱ�׼���ָ�ϡ���
ԭ��10λ���ǰ��978��Ϊ��Ʒ�����ʶ��У�����Ҳ�ı䡣
У��λ�ļ�Ȩ�㷨��10λISBN���㷨��ͬ�������㷨�ǣ�
��1�ֱ��ISBN��ǰ12λ�е�����λ������߿�ʼ���𣩣���3����ż��λ���˻�֮����10Ϊģ��10��ģֵ�Ĳ�ֵ�ٶ�10ȡģ����ȡ��λ�����֣�
���ɵõ�У��λ��ֵ����ֵ��ΧӦ��Ϊ0~9��

����ĳ���ʵ���˸��㷨������ϸ�Ķ�Դ�룬��дȱʧ�Ĳ��֡�
public class A
{
    static boolean f(String s){
        int k=1;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='-' || c==' ') continue;
            sum += ______________________________;  //���
            k++;
            if(k>12) break; 
        }
        
        return s.charAt(s.length()-1)-'0' == (10-sum % 10)%10;
    }
    
    public static void main(String[] args){
        System.out.println(f("978-7-301-04815-3"));
        System.out.println(f("978-7-115-38821-6"));
    }
}
���ύ

ע�⣺ֻ�ύ��ȱ�Ĵ��룬��Ҫ��д�Ѿ����ڵĴ��롣

(c - ��0��) * (1 == (k & 1)? 1: 3);

��Ŀ�����ĺ�������ûɶ��˵��
��������������������������������
��Ȩ����������ΪCSDN������Ф��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _05�����֤ {
	static boolean f(String s){
        int k=1;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='-' || c==' ') continue;
            sum += (c-'0')*(1==(1&k)?1:3);  //���
            k++;
            if(k>12) break; 
        }
        return s.charAt(s.length()-1)-'0' == (10-sum % 10)%10;
    }
    
    public static void main(String[] args){
        System.out.println(f("978-7-301-04815-3"));
        System.out.println(f("978-7-115-38821-6"));
    }
}
