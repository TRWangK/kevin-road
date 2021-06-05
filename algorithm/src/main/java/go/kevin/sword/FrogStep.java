package go.kevin.sword;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author Tianrui Wang
 * @date 2021-03-01 23:02
 **/
public class FrogStep {

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(numWays2(2));
		System.out.println(numWays2(7));
		System.out.println(numWays2(0));
		System.out.println(numWays2(44));
	}

	public static int numWays(int n)                                                                                                                                {
		if (n <= 1){
			return 1;
		}
		return numWays(n-1) + numWays(n-2);
	}

	public static int numWays2(int n)                                                                                                                                {
		if (n <= 1){
			return 1;
		}

		int prePre = 1;
		int pre = 1;
		int sum = 0;
		for (int i = 2; i <= n; i++){
			sum = (prePre + pre) % 1000000007;
			prePre = pre;
			pre = sum;
		}
		return sum;

	}
}
