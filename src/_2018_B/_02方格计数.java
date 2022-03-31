package _2018_B;
/*
 * 如图p1.png所示，在二维平面上有无数个1x1的小方格。
在这里插入图片描述

我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
你能计算出这个圆里有多少个完整的小方格吗？

注意：需要提交的是一个整数，不要填写任何多余内容。
 */
public class _02方格计数 {
	public static void main(String[] args){
        int num=0,r=1000;
        //i  和 j  抽象成每个正方形右顶点的坐标
        //这样每个正方形都可以遍历的到
        for(int i=1;i<=1000;i++)
        	for(int j=1;j<=1000;j++)
        		if(i*i+j*j<=1000000)
        			num++;
        System.out.println(num*4);  //刚只是第一象限的遍历
    }
}
