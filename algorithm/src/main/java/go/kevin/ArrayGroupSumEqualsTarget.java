package go.kevin;

import java.util.*;

/**
 * leetcode 39
 * @author Tianrui Wang
 * @date 2020-09-09 17:03
 **/
public class ArrayGroupSumEqualsTarget {

	public static void main(String[] args) {

		int[] candidates = {2,3,6,7};
		System.out.println(solution(candidates, 7));

	}

	public static List<List<Integer>> solution(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backTracing(candidates, target, 0, result, list);
		return result;
	}

	public static void backTracing(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> list){

		if(index == candidates.length){
			return;
		}

		if(target == 0){
			result.add( new ArrayList<>(list) );
			return;
		}

		if( target - candidates[index] >= 0 ){
			list.add(candidates[index]);
			backTracing(candidates, target - candidates[index], index, result, list);
			list.remove( list.size() - 1 );
		}

		backTracing(candidates, target, index + 1, result, list);

	}

}
