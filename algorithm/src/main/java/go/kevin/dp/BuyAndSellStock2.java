package go.kevin.dp;

/**
 * 122. 买卖股票的最佳时机 II
 * @author Tianrui Wang
 * @date 2021-09-28 22:21
 **/
public class BuyAndSellStock2 {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {

		// 状态转移方程
		// f[i][j] = max( f[i-1][0], (f[i-1][1] + price[i]) )
		// i表示第几天, j表示这一天是否持有股票

		if (prices.length < 2){
			return 0;
		}

		int length = prices.length;
		int[][] f = new int[length][2];
		f[0][0] = 0;
		f[0][1] = -prices[0];

		for (int i = 1; i < length; i++){
			f[i][0] = Math.max(f[i-1][0], (f[i-1][1] + prices[i]));
			f[i][1] = Math.max((f[i-1][0] - prices[i]), f[i-1][1]);
		}

		return f[length-1][0];
	}

}
