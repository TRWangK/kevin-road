package go.kevin;

/**
 * @author Tianrui Wang
 * @date 2022-05-10 00:27
 **/
public class Wedding {

	public static void main(String[] args) {

		/**
		 * 定亲
		 * 流程
		 * 		选定黄道吉日
		 * 		亲友见面
		 * 		男方给聘礼 - 订婚八样礼 三金 梳子 剪刀 镜子 算盘 都斗 铜盆 行李箱
		 * 		互相给对方长辈敬茶 长辈回个红包
		 * 		戴订婚戒指
		 * 		改口叫爸妈
		 *
		 * 	钻戒 10000
		 * 	三金 戒指 耳环 项链
		 * 		戒指 6g 3000
		 * 		项链 10g 5000
		 *		耳环 5g 2500
		 *		总计 11000
		 *		注意事项: 需要叫上女方一起去挑 表示重视和尊重
		 *	对戒 5000
		 *  彩礼 100000
		 *  婚纱摄影 6000
		 *  其他 5000 (喜帖 婚礼MV 计划外)
		 *  总计 137000
 		 */
		int diamond = 10000;
		int gold = 11000;
		int pairRing = 5000;
		//int cashGift = 31800;
		int cashGift = 100000;
		int dressPhoto = 6000;
		int preOther = 5000;
		int pre = diamond + gold + pairRing + cashGift + dressPhoto + preOther;
		System.out.println("婚前" + pre);

		/**
		 * 结婚当天
		 * 	服装
		 * 		女 3套 婚纱 中式 其他 3000
		 * 		男 1套 西服 2000
		 *
		 * 	车队
		 * 		奔驰S600  2000 * 1 = 2000
		 * 		奔驰E200  500 * 8 = 	4000
		 * 		注意事项: 现场看车以防照骗, 问清费用有没有过桥费等其他
		 *
		 *	婚宴
		 *		场地+菜肴 60000
		 *		布置 2000 主要是花
		 *		酒水 8000
		 *		其他 10000 (红包 小吃 糖 烟 伴手礼 蛋糕 突发情况)
		 *		份子钱 -30000 (假设100人平均每人300)
		 *
		 *	远方亲友下榻 4500 (15间300标准)
		 *
		 *	化妆 1000
		 *  摄影 1000 * 2
		 *  司仪 1000 - 2000
		 *  音响 1000
		 *  	注意: 以上为不请策划
		 *  总计 81500
		 */
		int custom = 5000;
		int carTeam = 6000;
		int feast = 80000;
		int guestHotel = 4500;
		int director = 6000;
		int other = 10000;
		int gift = -30000;
		int theDay = custom + carTeam + feast + guestHotel + director + other + gift;
		System.out.println("当天" + theDay);

		int total = pre + theDay;
		System.out.println(total);
	}

}
