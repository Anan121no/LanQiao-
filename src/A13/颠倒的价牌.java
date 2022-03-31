package A13;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 小李的店里专卖其它店中下架的样品电视机，可称为：样品电视专卖店。
    其标价都是4位数字（即千元不等）。
    小李为了标价清晰、方便，使用了预制的类似数码管的标价签，只要用颜色笔涂数字就可以了（参见p1.jpg）。
    这种价牌有个特点，对一些数字，倒过来看也是合理的数字。如：1 2 5 6 8 9 0 都可以。这样一来，如果牌子挂倒了，有可能完全变成了另一个价格，比如：1958 倒着挂就是：8561，差了几千元啊!! 
    当然，多数情况不能倒读，比如，1110 就不能倒过来，因为0不能作为开始数字。
   有一天，悲剧终于发生了。某个店员不小心把店里的某两个价格牌给挂倒了。并且这两个价格牌的电视机都卖出去了!
    庆幸的是价格出入不大，其中一个价牌赔了2百多，另一个价牌却赚了8百多，综合起来，反而多赚了558元。
    请根据这些信息计算：赔钱的那个价牌正确的价格应该是多少？
答案是一个4位的整数，请通过浏览器直接提交该数字。
注意：不要提交解答过程，或其它辅助说明类的内容。
 */
//答案9088
//运用面向对象
public class 颠倒的价牌 {
	public static void main(String[] args) {
//		System.out.println(reverse("9088"));
		ArrayList<Price> a1 = new ArrayList<Price>();
		ArrayList<Price> a2 = new ArrayList<Price>();
		for (int i = 1000; i < 10000; i++) {
			String s = "" + i;
			if (s.contains("3")||s.contains("4")||s.contains("7")) {
				continue;
			}
			String re_s = reverse(s);
			int i1 = Integer.parseInt(re_s);//字符串转换成整型
			int plus = i1 - i;
			if (plus<-200&&plus>-300) {
				a1.add(new Price(i,plus));
			}
			if (plus<900&&plus>800) {
				a2.add(new Price(i,plus));
			}
		}
		for (Price p1:a1) {
			for (Price p2 : a2) {
				if (p1.plus+p2.plus==558) {
					System.out.println(p1.p+" "+p1.plus);
					System.out.println(p2.p+" "+p2.plus);
				}
			}
		}
	}
	private static String reverse(String s) {
		// TODO Auto-generated method stub
		char[] ans = new char[s.length()];
		for (int i = s.length()-1,j = 0; i >= 0;i--,j++) {
			char c = s.charAt(i);
			if (c=='6') {
				ans[j]='9';
			}else if (c=='9') {
				ans[j]='6';
			}else {
				ans[j] = c;
			}
		}
		return new String(ans);
	}
	private static class Price{
		int p;//原价
		int plus;//颠倒价
		public Price(int p, int plus) {
			this.p = p;
			this.plus = plus;
		}
		
	}
}




/*朴素暴力
*
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Price> list1 = new ArrayList<Price>();
		List<Price> list2 = new ArrayList<Price>();
		
		for(int i=1000;i<=9999;i++) {
			String str = ""+i;
			if(str.contains("3")||str.contains("4")||str.contains("7")) continue;
			if(i%10==0)continue;
			int sub = i-reverse(str);
			if(sub>=200 && sub<300) {
				Price price = new Price(i,reverse(str),sub);
				list1.add(price);
			}
			else if(sub>=-900&&sub<-800) {
				Price price = new Price(i,reverse(str),sub);
				list2.add(price);
			}
		}
		for(int ii=0;ii<list1.size();ii++) {
			for(int j=0;j<list2.size();j++) {
				if(list1.get(ii).sub+list2.get(j).sub==-558) {
					System.out.print(list1.get(ii).price+" "+list1.get(ii).rPrive+" "+list1.get(ii).sub+" ");
					System.out.println(list2.get(j).price+" "+list2.get(j).rPrive+" "+list2.get(j).sub+" ");
				}
			}
		}
		//9088
	}
	private static int reverse(String num) {
		char[] arr = num.toCharArray();
		char[] arr1 = new char[arr.length];
		for(int i=0;i<arr.length;i++) {
			arr1[i] = arr[arr.length-1-i];
			if(arr1[i]=='6')
				arr1[i]= '9';
			else if(arr1[i]=='9')
				arr1[i] = '6';
		}
		String s = new String(arr1);
		int n = Integer.valueOf(s);
		return n;
	}
	public static class Price{
		int price;
		int rPrive;
		int sub;
		public Price(int price, int rPrive, int sub) {
			this.price = price;
			this.rPrive = rPrive;
			this.sub = sub;
		}
		
	}

}
*/