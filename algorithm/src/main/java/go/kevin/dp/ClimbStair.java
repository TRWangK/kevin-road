package go.kevin.dp;

/**
 * 70. 爬楼梯
 * @author Tianrui Wang
 * @date 2022-02-08 18:32
 **/
public class ClimbStair {

	public static void main(String[] args) {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(5));
	}

	public static int climbStairs(int n) {

		// 状态转移方程
		// f(i) = f(i-1) + f(i-2)
		if (n < 2){
			return 1;
		}

		int[] f = new int[n+1];
		f[0] = 1;
		f[1] = 1;

		for (int i = 2; i <= n; i++){
			f[i] = f[i-1] + f[i-2];
		}

		return f[n];
	}
}
