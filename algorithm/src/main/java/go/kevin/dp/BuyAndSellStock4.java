package go.kevin.dp;

/**
 * 123. 买卖股票的最佳时机 III
 * @author Tianrui Wang
 * @date 2021-09-28 22:21
 **/
public class BuyAndSellStock4 {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(2, prices));

		int[] prices2 = {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(2, prices2));
	}

	public static int maxProfit(int k, int[] prices) {

		// 状态转移方程 f[i][k][j]
		// i表示第几天, k表示剩余买卖次数, j表示这一天是否持有股票
		// f[i][k][0] = max( f[i-1][k][0], (f[i-1][k][1] + prices[i]) )
		// f[i][k][1] = max( (f[i-1][k+1][0] - prices[i]), f[i-1][k][1] )

		if (prices.length < 2){
			return 0;
		}

		int length = prices.length;
		int[][][] f = new int[length][k+1][2];
		for (int kLeft = k; kLeft >= 0; kLeft--){
			f[0][kLeft][0] = 0;
			f[0][kLeft][1] = -prices[0];
		}

		for (int i = 1; i < length; i++){
			for (int kLeft = k-1; kLeft >=0; kLeft--){
				f[i][kLeft][0] = Math.max(f[i-1][kLeft][0], (f[i-1][kLeft][1] + prices[i]));
				f[i][kLeft][1] = Math.max((f[i-1][kLeft+1][0] - prices[i]), f[i-1][kLeft][1]);
			}
		}

		return f[length-1][0][0];
	}

}
