package _2014_B;
import java.util.HashSet;
import java.util.Set;
/*
 * AA223344��һ��4���˿��ơ�����������ų�һ�С�
Ҫ������A�м���1���ƣ�����2֮����2���ƣ�����3֮����3���ƣ�����4֮����4���ơ�
4A3A2432�� 2342A3A4
����д�����з���Ҫ��������У��ֵ�����С���Ǹ���
���磺
22AA3344 �� A2A23344 �ֵ���С����Ȼ�����Ƕ���������Ҫ��Ĵ𰸡�
��ͨ��������ύ�𰸡���A��һ����Ҫ��Сд��ĸa��Ҳ��Ҫ�á�1�����档�ַ���һ����Ҫ���ո�
���𰸡���2342A3A4
��������ȫ����+check
ֻ�����ֽ���������ֱ�ӿ������
2342A3A4
4A3A2432
 */
public class _07�˿����� {
		//��ΪJavaȫ�������Լ���ģ����кܶ��ظ������Լ��˸�set
		static Set<String> set = new HashSet<>();
		//check�����ж�
		private static boolean check(String s) 
		{
			if( s.lastIndexOf('A')-s.indexOf('A')==2&&
				s.lastIndexOf('2')-s.indexOf('2')==3&&
				s.lastIndexOf('3')-s.indexOf('3')==4&&
				s.lastIndexOf('4')-s.indexOf('4')==5)
				return true;
			return false;
		}
		//ȫ����
		private static void dfs(char[]ch,int t) {
			if(t==ch.length)
			{
				String ss=new String(ch);
				if(check(ss)==true)
					set.add(ss);
				return ;
			}
			for(int i=t;i<ch.length;i++)
			{
				//����
				//dfs
				//����

				char k=ch[t];
				ch[t]=ch[i];
				ch[i]=k;
				
				dfs(ch, t+1);
				
				k=ch[t];
				ch[t]=ch[i];
				ch[i]=k;				
			}
			return;			
		}
		public static void main(String[] args) 
		{			
			char[]ch={'A','A','2','2','3','3','4','4'};
			dfs(ch,0);//��0��ʼ
			for(String ss:set)
			{
				System.out.println(ss);
			}
			
		}
	}
