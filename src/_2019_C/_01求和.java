package _2019_C;
/*
 * С������λ�к��� 2��0��1��9 �����ֺܸ���Ȥ��
 * �� 1 �� 40 ������������ �� 1��2��9��10 �� 32��39 �� 40���� 28 �������ǵĺ��� 574��
 *  ���ʣ��� 1 �� 2019 �У��������������ĺ��Ƕ��٣�
 */
public class _01��� {
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
