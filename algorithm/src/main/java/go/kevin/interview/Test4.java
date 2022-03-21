package go.kevin.interview;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianrui Wang
 * @date 2022-02-28 19:17
 **/
public class Test4 {

	/**
	 * N个有序数组取 topK
	 * N = 3 , K = 4
	 * <p>
	 * [10，9， 8， 7]
	 * [9, 6, 5, 3]
	 * [7,2,1]
	 * <p>
	 * 返回 10， 9， 9， 8
	 */

	public static void main(String[] args) {

		int[] a = {10, 9, 8, 7};
		int[] b = {9, 6, 5, 3};
		int[] c = {7, 2, 1};
		int[][] numsArray = new int[3][];
		numsArray[0] = a;
		numsArray[1] = b;
		numsArray[2] = c;

		int[] result = nTopK(numsArray, 4);
		for (int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}

	}

	public static int[] nTopK(int[][] numsArray, int k) {
		int n = numsArray.length;

		Map<Integer, Integer> dict = new HashMap<>(n);
		for (int i = 0; i < n; i++) {
			dict.put(i, 0);
		}

		int[] result = new int[k];

		for (int i = 1; i <= k; i++) {
			int levelMax = Integer.MIN_VALUE;
			Integer arrayIndex = 0;
			Integer numsIndex = 0;
			for (int j = 0; j < n; j++) {
				int index = dict.get(j);
				if (index < numsArray[j].length && numsArray[j][index] > levelMax) {
					levelMax = numsArray[j][index];
					arrayIndex = j;
					numsIndex = index;
				}
			}
			dict.put(arrayIndex, ++numsIndex);
			result[i - 1] = levelMax;
		}

		return result;
	}

}
