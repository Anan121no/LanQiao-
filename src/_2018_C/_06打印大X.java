package _2018_C;
/*
 * 如下的程序目的是在控制台打印输出大X。
可以控制两个参数：图形的高度，以及笔宽。
用程序中的测试数据输出效果：
(如果显示有问题，可以参看p1.png)

高度=15, 笔宽=3

***           ***
 ***         ***
  ***       ***
   ***     ***
    ***   ***
     *** ***
      *****
       ***
      *****
     *** ***
    ***   ***
   ***     ***
  ***       ***
 ***         ***
***           ***
高度=8, 笔宽=5

*****  *****
 **********
  ********
   ******
   ******
  ********
 **********
*****  *****
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109007981
 */
public class _06打印大X {
	static void f(int h, int w){
        System.out.println(String.format("高度=%d, 笔宽=%d",h,w));
        int a1 = 0;
        int a2 = h - 1;
        
        for(int k=0; k<h; k++){
            int p = Math.min(a1,a2);
            int q = Math.max(a1+w,a2+w);
            
            for(int i=0; i<p; i++) System.out.print(" ");
            
            if(q-p<w*2){
                while(p++<q) System.out.print("*"); ; //填空
            }
            else{
                for(int i=0; i<w; i++) System.out.print("*");
                for(int i=0; i<q-p-w*2; i++) System.out.print(" ");
                for(int i=0; i<w; i++) System.out.print("*");
            }
            System.out.println();
            a1++;
            a2--;
        }
    }
    
    public static void main(String[] args){
        f(15,3);
        f(8,5);
    }
}
