package go.kevin.dp;

import java.util.Arrays;

/**
 * 0-1 背包问题
 * @author Tianrui Wang
 * @date 2021-07-28 21:44
 **/
public class Bag {

	public static void main(String[] args) {
		int[] wt = {2,1,3};
		int[] val = {4,2,3};
		System.out.println(knapsack(4, 3, wt, val));
	}

	/**
	 * 一个可装载重量cap的背包, 和n个的物品, 每个物品有相应的价值和重量, 取装包最优解
	 * @param cap 背包容量
	 * @param n 物品数量
	 * @param wt 每件物品重量
	 * @param val 每件物品价值
	 * @return
	 */
	public static int knapsack(int cap, int n, int[] wt, int[] val) {

		//根据状态 创建状态数组
		//int[n][cap] 代表 从n个物品中选择 塞到cap容量背包 的最大组合价值
		int[][] dp = new int[n+1][cap+1];
		Arrays.fill(dp[0], 0);

		for (int i = 1; i <= n; i++){
			for (int c = 1; c <= cap; c++){
				if (wt[i-1] > c){
					dp[i][c] = dp[i-1][c];
					continue;
				}

				// 放入 或 不放入
				dp[i][c] = Math.max(
						dp[i-1][c - wt[i-1]] + val[i-1],
						dp[i-1][c - wt[i-1]]
				);
			}
		}

		return dp[n][cap];
	}
}
