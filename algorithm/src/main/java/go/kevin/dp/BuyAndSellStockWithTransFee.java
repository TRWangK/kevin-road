package go.kevin.dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 * @author Tianrui Wang
 * @date 2021-09-28 22:21
 **/
public class BuyAndSellStockWithTransFee {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices, 2));

		int[] prices2 = {1,3,7,5,10,3};
		System.out.println(maxProfit(prices2, 3));
	}

	public static int maxProfit(int[] prices, int fee) {

		// 状态转移方程 f[i][j]
		// i表示 第几天
		// j表示 0未持有股票 1持有股票
		// f[i][0] = max( f[i-1][0], (f[i-1][1] + prices[i]) );
		// f[i][1] = max( (f[i-1][0] - prices[i] - 2), f[i-1][1] )

		if (prices.length < 2){
			return 0;
		}

		int length = prices.length;
		int[][] f = new int[length][3];
		f[0][0] = 0;
		f[0][1] = -prices[0] - fee;

		for (int i = 1; i < length; i++){
			f[i][0] = Math.max(f[i-1][0], (f[i-1][1] + prices[i]));
			f[i][1] = Math.max((f[i-1][0] - prices[i] - fee), f[i-1][1]);
		}

		return f[length-1][0];
	}

}
