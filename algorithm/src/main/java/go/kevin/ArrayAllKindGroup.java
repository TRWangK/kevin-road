package go.kevin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 47
 * @author Tianrui Wang
 * @date 2020-09-18 15:28
 **/
public class ArrayAllKindGroup {

	public static void main(String[] args) {

		int[] example = {1,1,3};
		System.out.println(permuteUnique(example));

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new LinkedList<>();

		Arrays.sort(nums);

		//记录哪一个元素已经被选了
		boolean[] isChosen = new boolean[nums.length];
		backTracing(nums, 0, isChosen, results, result);
		return results;
	}


	public static void backTracing(int[] nums, int index, boolean[] isChosen, List<List<Integer>> results, List<Integer> result){

		if(index == nums.length){
			results.add(new ArrayList<>(result));
			return;
		}

		for(int i = 0; i < nums.length; i++){
			if(isChosen[i]){
				continue;
			}
			if(i >= 1 && nums[i] == nums[i-1] && !isChosen[i-1]){
				continue;
			}

			isChosen[i] = true;
			result.add(nums[i]);
			backTracing(nums, index+1, isChosen, results, result);
			isChosen[i] = false;
			result.remove(index);
		}
	}
}
