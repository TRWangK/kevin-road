package go.kevin.dp;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * @author Tianrui Wang
 * @date 2021-09-28 22:21
 **/
public class BuyAndSellStockWithCoolDown {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {

		// 状态转移方程 f[i][j]
		// i表示 第几天
		// j表示 0未持有股票且处于冷冻期 1未持有股票且未处于冷冻期 2持有股票
		// f[i][0] = f[i-1][2] + price[i];
		// f[i][1] = max( f[i-1][0], f[i-1][1] )
		// f[i][2] = max( (f[i-1][1] - price[i]), f[i-1][2] )

		if (prices.length < 2){
			return 0;
		}

		int length = prices.length;
		int[][] f = new int[length][3];
		f[0][0] = 0;
		f[0][1] = 0;
		f[0][2] = -prices[0];

		for (int i = 1; i < length; i++){
			f[i][0] = f[i-1][2] + prices[i];
			f[i][1] = Math.max(f[i-1][0], f[i-1][1]);
			f[i][2] = Math.max((f[i-1][1] - prices[i]), f[i-1][2]);
		}

		return Math.max(f[length-1][0], f[length-1][1]);
	}

}
