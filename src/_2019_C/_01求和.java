package _2019_C;
/*
 * 小明对数位中含有 2、0、1、9 的数字很感兴趣，
 * 在 1 到 40 中这样的数包 括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
 *  请问，在 1 到 2019 中，所有这样的数的和是多少？
 */
public class _01求和 {
	private static int sum = 0;

	public static void main(String[] args) {
		for (int i = 1; i <= 2019; i++) {
			String s = i + "";
			boolean check = false;
			for (int j = 0; j < s.length(); j++) {
				char a = s.charAt(j);
				if (a=='2'||a=='0'||a=='1'||a=='9') {
					check = true;
				}
			}
			if (check) {
				sum  += i;
			}
		}
		System.out.println(sum);
		long sum=0;
        for(int i=1;i<=2019;i++){
            String temp=i+"";
            if(temp.contains("2")||temp.contains("0")||temp.contains("1")||temp.contains("9"))
                sum+=i;

        }
        System.out.println(sum);
	}
}
