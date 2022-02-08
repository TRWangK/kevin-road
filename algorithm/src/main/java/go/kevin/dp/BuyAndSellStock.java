package go.kevin.dp;

/**
 * 121. 买卖股票的最佳时机
 * @author Tianrui Wang
 * @date 2021-09-28 22:21
 **/
public class BuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {

		// 状态转移方程
		// f(i) = max( f(i-1), (prices[n] - minPrice) )

		if (prices.length < 2){
			return 0;
		}

		int minPrice = prices[0];
		int max = 0;

		for (int i = 1; i < prices.length; i++){
			if (prices[i] < minPrice){
				minPrice = prices[i];
			}
			max = Math.max(max, prices[i] - minPrice);
		}

		return max;
	}

}
