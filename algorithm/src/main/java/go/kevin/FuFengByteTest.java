package go.kevin;

import java.util.ArrayList;
import java.util.List;

/**
 * 福锋字节二面算法
 * @author Tianrui Wang
 * @date 2021-08-28 18:17
 **/
public class FuFengByteTest {

	public static void main(String[] args) {

		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		System.out.println(solution1(a));
		System.out.println(solution2(a));

	}

	/**
	 * 存在数组a [a1, a2, a3, a4, ... an]
	 * sum = a1 * a2 * ... * an
	 * 数组b [b1, b2, b3, ... bn]
	 * b1 = sum / a1; b2 = sum / b2;
	 * 输出数组b
	 *
	 * 条件: 不能使用 除法
	 */

	/**
	 * 暴力
	 */
	public static List<Integer> solution1(int[] a){
		List<Integer> result = new ArrayList<>(a.length);

		for (int x = 0; x < a.length; x++){
			int sum = 1;
			for (int y = 0; y < a.length; y++){
				if (x == y){
					continue;
				}
				sum = sum * a[y];
			}
			result.add(sum);
		}
		return result;
	}

	/**
	 * 减枝
	 */
	public static List<Integer> solution2(int[] a){
		List<Integer> result = new ArrayList<>(a.length);
		int bookMax = 0;
		int bookResult= 1;

		for (int x = 0; x < a.length; x++){
			int sum = bookResult;
			for (int y = bookMax; y < a.length; y++){
				if (x == y){
					bookMax = y;
					bookResult = sum;
					continue;
				}
				sum = sum * a[y];
			}
			result.add(sum);
		}
		return result;
	}
}
