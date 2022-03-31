package _2020_C1;
/*
 * 小明要做一个跑步训练。
初始时，小明充满体力，体力值计为 10000。如果小明跑步，每分钟损耗
600 的体力。如果小明休息，每分钟增加 300 的体力。体力的损耗和增加都是
均匀变化的。
小明打算跑一分钟、休息一分钟、再跑一分钟、再休息一分钟……如此循
环。如果某个时刻小明的体力到达 0，他就停止锻炼。
请问小明在多久后停止锻炼。为了使答案为整数，请以秒为单位输出答案。
答案中只填写数，不填写单位。
答案提交
这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
3880
————————————————
版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_43449564/article/details/109094410
 */
public class _03跑步训练 {
	public static void main(String[] args) {
		int tili = 10000;
		int time = 0;
		int num = 0;
		while (tili>0) {
			tili -= 600;
			time++;
			if (tili<=0) {
				num = tili/10;
				break;
			}
			tili += 300;
			time++;
		}
		System.out.println(time*60+num);
		System.out.println(num);
	}
}
