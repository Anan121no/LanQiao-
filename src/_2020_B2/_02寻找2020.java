package _2020_B2;

import java.io.*;

/*
 * 小蓝有一个数字矩阵，里面只包含数�? 0 �? 2。小蓝很喜欢 2020，他想找
到这个数字矩阵中有多少个 2020 �?
小蓝只关注三种构�? 2020 的方式：
�? 同一行里面连续四个字符从左到右构�? 2020�?
�? 同一列里面连续四个字符从上到下构�? 2020�?
�? 在一条从左上到右下的斜线上连续四个字符，从左上到右下构成 2020�?
例如，对于下面的矩阵�?
220000
000000
002202
000000
000022
002020
�?共有 5 �? 2020。其�? 1 个是在同�?行里的，1 个是在同�?列里的，3 �?
是斜线上的�??
小蓝的矩阵比上面的矩阵要大，由于太大了，他只好将这个矩阵放在了一
个文件里面，在试题目录下有一个文�? 2020.txt，里面给出了小蓝的矩阵�??
请帮助小蓝确定在他的矩阵中有多少�? 2020�?
【答案提交�??
这是�?道结果填空的题，你只�?要算出结果后提交即可。本题的结果为一
个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分�?
思路�?
16520
定义二维矩阵，遍历每个坐标，以每个坐标为起点分别向右向下向右下三个方向遍历�??
—�?��?��?��?��?��?��?��?��?��?��?��?��?��?��??
版权声明：本文为CSDN博主「胡毛毛_三月」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明�?
原文链接：https://blog.csdn.net/qq_45696377/article/details/109147147
 */
public class _02寻找2020 {
	public static void main(String[] args) throws IOException {         
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\1\\Desktop\\蓝桥\\2020.txt")));
        String[] str=new String[300];
        for(int i=0;i<300;i++) {
        	if(reader.ready()) {
        		str[i]=reader.readLine();
        	}     
        }
        String[][] str_matrix=new String[300][300];
        for(int i=0;i<300;i++) {
        	for(int j=0;j<300;j++) {
        		str_matrix[i][j]=str[i].substring(j,j+1);
        	}
        }
        int sum=0;
        //行检查
        for(int i=0;i<300;i++) {
        	for(int j=0;j<297;j++) {
        		if((str_matrix[i][j]+str_matrix[i][j+1]+str_matrix[i][j+2]+str_matrix[i][j+3]).equals("2020")) {
        			sum=sum+1;
        		}
        	}
        }
        //列检查
        for(int i=0;i<297;i++) {
        	for(int j=0;j<300;j++) {
        		if((str_matrix[i][j]+str_matrix[i+1][j]+str_matrix[i+2][j]+str_matrix[i+3][j]).equals("2020")) {
        			sum++;
        		}
        	}
        }    
        //斜排列检查
        for(int i=0;i<297;i++) {
        	for(int j=0;j<297;j++) {
        		if((str_matrix[i][j]+str_matrix[i+1][j+1]+str_matrix[i+2][j+2]+str_matrix[i+3][j+3]).equals("2020")) {
        			sum++;
        		}
        	}
        }
        System.out.println(sum);
    }
}
