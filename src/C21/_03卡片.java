package C21;

import java.util.HashMap;

/*
 * 小蓝有很多数字卡片，每张卡片上都是数字 0 到 9。
小蓝准备用这些卡片来拼一些数，他想从 1 开始拼出正整数，每拼一个，就保存起来，卡片就不能用来拼其它数了。
小蓝想知道自己能从 1 拼到多少。
例如，当小蓝有 30 张卡片，其中 0 到 9 各 3 张，则小蓝可以拼出 1 到 10，
但是拼 11 时卡片 1 已经只有一张了，不够拼出 11。
现在小蓝手里有 0 到 9 的卡片各 2021 张，共 20210 张，请问小蓝可以从 1
拼到多少？
提示：建议使用计算机编程解决问题。

 */
public class _03卡片 {
	public static void main(String[] args) {
		 HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i = 0;i < 10;i++) map.put(i,2021);
	        int start = 1;
	        while(true){
	            String tmp = start + "";
	            for (char item : tmp.toCharArray()) {
	                if (map.get(item - 48) != 0) map.put(item - 48, map.get(item - 48) - 1);
	                else {
	                    System.out.println(start - 1);
	                    return;
	                };
	            }
	            start++;
	        }
	}
}
