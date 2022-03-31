package _2018_A;

import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * 小h前往美国参加了蓝桥杯国际赛。小h的女朋友发现小h上午十点出发，上午十二点到达美国，于是感叹到“现在飞机飞得真快，两小时就能到美国了”。
小h对超音速飞行感到十分恐惧。仔细观察后发现飞机的起降时间都是当地时间。由于北京和美国东部有12小时时差，故飞机总共需要14小时的飞行时间。
不久后小h的女朋友去中东交换。小h并不知道中东与北京的时差。但是小h得到了女朋友来回航班的起降时间。小h想知道女朋友的航班飞行时间是多少。
【问题描述】
对于一个可能跨时区的航班，给定来回程的起降时间。假设飞机来回飞行时间相同，求飞机的飞行时间。
【输入格式】
从标准输入读入数据。
一个输入包含多组数据。
输入第一行为一个正整数T，表示输入数据组数。
每组数据包含两行，第一行为去程的 起降 时间，第二行为回程的 起降 时间。
起降时间的格式如下
h1:m1:s1 h2:m2:s2
或
h1:m1:s1 h3:m3:s3 (+1)
或
h1:m1:s1 h4:m4:s4 (+2)
表示该航班在当地时间h1时m1分s1秒起飞，
第一种格式表示在当地时间 当日 h2时m2分s2秒降落
第二种格式表示在当地时间 次日 h3时m3分s3秒降落。
第三种格式表示在当地时间 第三天 h4时m4分s4秒降落。
对于此题目中的所有以 hⓂ️s 形式给出的时间, 保证 ( 0<=h<=23, 0<=m,s<=59 ).
【输出格式】
输出到标准输出。
对于每一组数据输出一行一个时间hh:mm:ss，表示飞行时间为hh小时mm分ss秒。
注意，当时间为一位数时，要补齐前导零。如三小时四分五秒应写为03:04:05。
【样例输入】
3
17:48:19 21:57:24
11:05:18 15:14:23
17:21:07 00:31:46 (+1)
23:02:41 16:13:20 (+1)
10:19:19 20:41:24
22:19:04 16:41:09 (+1)
【样例输出】
04:09:05
12:10:39
14:22:05
————————————————
版权声明：本文为CSDN博主「郝大侠001」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/jmkmlm123456/article/details/87639598
 */
public class _06航班时间 {
	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int legth=Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < legth; i++) {
            int[] res=new int[2];
            for (int j = 0; j < 2; j++) {
                int h=scanner.useDelimiter(":").nextInt();
                int m=scanner.useDelimiter(":").nextInt();
                int s=scanner.useDelimiter(Pattern.compile("\\s|:")).nextInt();
                int h2=scanner.useDelimiter(Pattern.compile("\\s|:")).nextInt();
                int m2=scanner.useDelimiter(":").nextInt();
                int s2=scanner.useDelimiter(Pattern.compile("\\s|:|\\n")).nextInt();
                String end=scanner.nextLine();
                int day=0;
                if (!end.isEmpty())day=end.charAt(3)-'0';
                res[j]=(h2+day*24)*3600+m2*60+s2-h*3600-m*60-s;
            }
            res[0]=(res[0]+res[1])/2;
            System.out.printf("%02d:%02d:%02d\n",res[0]/3600,(res[0]%3600)/60,res[0]%60);
        }
    }
}
