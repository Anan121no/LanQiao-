package _2021_C;
import java.util.Scanner;

public class _0Ë«ÏòÅÅĞò {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		for (int i = 0; i < m; i++) {
			int control = in.nextInt();
			int index = in.nextInt();
			if (control == 0) {
				for (int j = 0; j < index-1; j++) {
					for (int k = 0; k < index-1-j; k++) {
						if (arr[k]<arr[k+1]) {
							int t = arr[k];
							arr[k] = arr[k+1];
							arr[k+1] = t;
						}
					}
				}
				
//			System.out.println("0"+Arrays.toString(arr));
			}
			else if (control == 1) {
				for(int j=0;j<arr.length-index;j++)
					for(int k=index-1;k<=arr.length-index-j;k++)
					{
						if(arr[k]>arr[k+1])
	                     {
						int t=arr[k];
						arr[k]=arr[k+1];
						arr[k+1]=t;
						}
					}
			}
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}
