package _2021_B1;
import java.util.*;
public class _09˫������demo{
	public static class pair{
		int x=0;
		int y=0;
		pair(int a,int b) {
			x=a;
			y=b;
		}
	}
	public static void main(String args[]) {
		int n,m;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		pair[] pairs= new pair[n+1];
		int top=0;
		int item[]=new int[n+1];
//		for(int i=1;i<=n;i++) {
//			item[i]=i;
//		}
		int p,q;
		for(int i=0;i<m;i++) {//��¼��Ч����
			p=scan.nextInt();
			q=scan.nextInt();
//			System.out.println("��"+i+"���������: "+"p: "+p+"  q: "+q);
			if(p==1&&top>0) {//top����0��Ϊ�˱�֤��һ�β���Ϊ 0����
				while(top>0&&pairs[top].x==1) {//top��¼��һ������
					//������������ͬ�Ĳ�����ȡ��Χ����Ǹ�
					if(pairs[top].y<=q) 
						q=pairs[top].y;
					--top;//����һ��������q��ֵ����ǰ��q������top�ƶ�����һ����������һ��
				}
				//�����ڵ���ͬ�����ķ�ΧС�ڵ�ǰ��Χ����top���£�����С��Χ
				while(top>=2&&pairs[top-1].y>=q) {
					top-=2;//ɾ��һ���������0������1������
				}
				pairs[++top]=new pair(1,q);//topʼ��ͣ����Ҫ��¼������ǰһ��
//				System.out.println("top: "+top+"  ����1  x: "+pairs[top].x+"  y: "+pairs[top].y);
				}
			if(p==0){
				while(top>0&&pairs[top].x==0) {
					if(pairs[top].y>=q)
						q=pairs[top].y;
					--top;
					}
				while(top>=2&&pairs[top-1].y<=q)//������=�����������ͬ��ֵ
					top-=2;
				pairs[++top]=new pair(0,q);      
//				System.out.println("top:  "+top+"  ����0  x: "+pairs[top].x+"  y: "+pairs[top].y);
				}
		}
		
		int k=n;
		int l=1,r=n;
		for(int i=1;i<=top;i++) {
			if(pairs[i].x==0) {
				while(l<=r&&pairs[i].y<r)
					item[r--]=k--;
			}
			if(pairs[i].x==1) {
				while(l<=r&&pairs[i].y>l)
					item[l++]=k--;
			}
		}
		if(top%2==0) {//Ϊ����1
			while(l<=r)
				item[r--]=k--;
		}
		else {//Ϊ����0
			while(l<=r)
				item[l++]=k--;
		}
		for(int i=1;i<=n;i++) {
			System.out.print(item[i]+" ");
		}
	}
}