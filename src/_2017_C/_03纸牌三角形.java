package _2017_C;
import java.util.Scanner;
/*
 * A,2,3,4,5,6,7,8,9 ��9��ֽ���ų�һ���������Σ�A��1���㣩��Ҫ��ÿ���ߵĺ���ȡ�
��ͼ����һ���ŷ�
�������ŷ����ܻ��кܶࡣ
���������ת���������ͬ����ͬһ�֣�һ���ж����ֲ�ͬ���ŷ��أ�
������㲢�ύ�����֡�
ע�⣺��Ҫ�ύ����һ����������Ҫ�ύ�κζ������ݡ�
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108864145
1.����������Ҫ��ÿ���ߵĺ���ȣ�����൱�����һ���ж�������
2.������һ���������ж��Ƿ������ߵĺ��Ƿ���ȣ�
3.��ȫ�������1~9��ȫ���У�ÿ�ֽ�����������У���дһ���ж�
�������Ƿ���������1�����������ͼ�1��
4.���Ľ���ǰ����ظ��ģ���Ŀ˵����ת���������ͬ����ͬһ�֣�
һ����������������ε����������е��κ�һ���������תȥ�ؽ��
Ҫ����3������������һ�����2��
��������������������������������
��Ȩ����������ΪCSDN�������򡹵�ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/qq_44844588/article/details/108864145
 */
public class _03ֽ�������� {
	 public static int ans=0;
	    public static void main(String[] args) {
	        Scanner input=new Scanner(System.in);
	        int arr[]=new int[10];
	        int visted[]=new int[10];
	        dfs(1,arr,visted);
	        System.out.print(ans/6);

	    }
	    public static void dfs(int level,int []arr ,int []visted)
	    {
	        if(level>9){
	            //�ж��Ƿ�Ϊ�ȱ�������
	            int bound1=arr[1]+arr[2]+arr[3]+arr[4];
	            int bound2=arr[4]+arr[5]+arr[6]+arr[7];
	            int bound3=arr[7]+arr[8]+arr[9]+arr[1];
	            //ȥ��
	            if(bound1==bound2&&bound1==bound3){
	                ans++;
	            }
	            return;
	        }
	        //ȫ����
	        for(int i=1;i<=9;i++){
	            if(visted[i]==0){
	                visted[i]=1;
	                arr[level]=i;
	                dfs(level+1,arr,visted);
	                visted[i]=0;
	            }
	        }
	    }
}
