package _2014_B;
import java.util.HashSet;
import java.util.Set;
/*
 * AA223344，一共4对扑克牌。请你把它们排成一行。
要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。
4A3A2432， 2342A3A4
请填写出所有符合要求的排列中，字典序最小的那个。
例如：
22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。
请通过浏览器提交答案。“A”一定不要用小写字母a，也不要用“1”代替。字符间一定不要留空格。
【答案】：2342A3A4
解析：简单全排列+check
只有两种结果，输出可直接看出结果
2342A3A4
4A3A2432
 */
public class _07扑克排序 {
		//因为Java全排列是自己打的，会有很多重复，所以加了个set
		static Set<String> set = new HashSet<>();
		//check方法判断
		private static boolean check(String s) 
		{
			if( s.lastIndexOf('A')-s.indexOf('A')==2&&
				s.lastIndexOf('2')-s.indexOf('2')==3&&
				s.lastIndexOf('3')-s.indexOf('3')==4&&
				s.lastIndexOf('4')-s.indexOf('4')==5)
				return true;
			return false;
		}
		//全排列
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
				//交换
				//dfs
				//交换

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
			dfs(ch,0);//从0开始
			for(String ss:set)
			{
				System.out.println(ss);
			}
			
		}
	}
