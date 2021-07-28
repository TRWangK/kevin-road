package go.kevin.dp;

import java.util.Arrays;

/**
 * leetcode 322 零钱兑换
 * @author Tianrui Wang
 * @date 2021-07-28 16:34
 **/
public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		System.out.println(coinChange(coins, 11));
	}

	// 暴力递归 + 备忘录
	public static int coinChange(int[] coins, int amount) {
		int[] map = new int[amount+1];
		return dp(coins, amount, map);
	}

	static int dp(int[] coins, int amount, int[] map){
		if (amount < 0){
			return -1;
		}
		if (amount == 0){
			return 0;
		}

		if (map[amount] != 0){
			return map[amount];
		}

		int min = Integer.MAX_VALUE;
		for (int i : coins){
			int count = dp(coins, amount - i, map) + 1;
			if (count < 1){
				continue;
			}
			min = Math.min(count, min);
		}
		map[amount] = min == Integer.MAX_VALUE ? -1 : min;
		return map[amount];
	}

	// 动态规划
	public int realDp(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 0; i < dp.length; i++){
			for (int coin : coins){
				if (i - coin < 0){
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}
