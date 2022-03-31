package _2019_B;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到
40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
请问，在 1 到 n 中，所有这样的数的和是多少？
【输入格式】
输入一行包含两个整数 n。
【输出格式】
输出一行，包含一个整数，表示满足条件的数的和。
【样例输入】
40
【样例输出】
574
【评测用例规模与约定】
对于 20% 的评测用例，1 ≤ n ≤ 10。
对于 50% 的评测用例，1 ≤ n ≤ 100。
对于 80% 的评测用例，1 ≤ n ≤ 1000。
对于所有评测用例，1 ≤ n ≤ 10000。

解题思路
同试题D 数的分解原理类似，评测用例为10000以内，所以将10000以内的包括2、0、1、9的数打表即可。
————————————————
版权声明：本文为CSDN博主「非洲的小白」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_42957844/article/details/88840580
 */
public class _06特别数的和 {
	 public static void main(String[] args) {
	        Scanner reader = new Scanner(System.in);
	        
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int sum = 0;//记录满足条件的数的和。
	        for(int i=1; i<=10000; i++){
	            String s = String.valueOf(i);
	            char c[] = s.toCharArray();
	            for(int j=0; j<c.length; j++){
	                if('2'==c[j] || '0'==c[j] || '1'==c[j] || '9'==c[j]){
	                    map.put(i, 1);
	                    break;
	                }
	            }
	        }
	        
	        int n = reader.nextInt();
	        for(int i=1; i<=n; i++){
	            if(map.containsKey(i))
	                sum+=i;
	        }
	        System.out.println(sum);
	        reader.close();
	    }
}
