package go.kevin.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tianrui Wang
 * @date 2022-03-15 11:43
 **/
public class Test9 {

	/**
	 *
	 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
	 *
	 * 输入：nums = [1,1,2]
	 * 输出：
	 * [[1,1,2],
	 *  [1,2,1],
	 *  [2,1,1]]
	 *
	 *  输入：nums = [1,2,3]
	 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	 */

	public static void main(String[] args) {

		int[] nums = {1, 2, 3};
		recur(nums, new LinkedList<>(), new LinkedList<>());
		System.out.println(finalResult);
	}

	private static List<List<Integer>> finalResult = new ArrayList<>();

	public static void recur(int[] nums, LinkedList<Integer> choosed, LinkedList<Integer> result){
		if (choosed.size() >= nums.length){
			finalResult.add(new ArrayList<>(result));
			return;
		}

		for (int i = 0; i < nums.length; i++){
			if (choosed.contains(i)){
				continue;
			}
			choosed.addLast(i);
			result.addLast(nums[i]);
			recur(nums, choosed, result);
			choosed.removeLast();
			result.removeLast();
		}
	}


}
