package go.kevin.sword;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * @author Tianrui Wang
 * @date 2021-02-25 23:14
 **/
public class Fibonacci {

	/**
	 * 写一个函数，输入 n ，求斐波那契数列的第 n 项（即 F(N)）
	 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
	 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 45;
		System.out.println(fib(n));
	}

	public static int fib(int n) {
		if (n <= 1){
			return n;
		}

		int prePre = 0; int pre = 1; int sum = 0;
		for (int i = 2; i <= n; i++){
			sum = (prePre + pre) % 1000000007;
			prePre = pre;
			pre = sum;
		}
		return sum;
	}
}
