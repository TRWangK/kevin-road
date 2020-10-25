package go.kevin;

import java.util.*;

/**
 * leetcode 40
 * @author Tianrui Wang
 * @date 2020-09-09 17:03
 **/
public class ArrayGroupSumEqualsTarget2 {

	public static void main(String[] args) {

		int[] candidates = {10,1,2,7,6,1,5};
		System.out.println(solution(candidates, 8));

	}

	public static List<List<Integer>> solution(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		backTracing(candidates, target, 0, result, list);
		return result;
	}

	public static void backTracing(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list){

		if(target == 0){
			result.add(new ArrayList<>(list));
			return;
		}

		for( int i = index; i < candidates.length; i++ ){

			if(target - candidates[i] < 0){
				break;
			}

			if(i > index && candidates[i] == candidates[i-1] ){
				continue;
			}

			list.add(candidates[i]);
			System.out.println("递归前 - target = " + target + " - num: " + candidates[index] + " - list: " + list);
			backTracing(candidates, target - candidates[i], i + 1, result, list);
			list.remove(list.size() - 1);
			System.out.println("递归后 - target = " + target + " - list: " + list);
		}

	}

}
