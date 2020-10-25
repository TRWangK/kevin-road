package go.kevin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 216
 * @author Tianrui Wang
 * @date 2020-09-09 17:03
 **/
public class ArrayGroupSumEqualsTarget3 {

	public static void main(String[] args) {

		// 思路: 把条件想象成从1-9的正序数组 选出k个和为n的数, 此情况下不会重复
		int[] origin = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println(combinationSum3(3, 9));

	}

	public static List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>(3);
		backTracing(k, n, 1, result, list);
		return result;
	}

	public static void backTracing(int k, int target, int index, List<List<Integer>> result, List<Integer> list){

		if(target == 0 ){
			if( k == 0){
				result.add(new ArrayList<>(list));
			}
			return;
		}

		if(k == 0){
			return;
		}

		for( int i = index; i < 10; i++ ){
			if(target - index < 0){
				break;
			}
			list.add(i);
			backTracing(k-1, target - i, i + 1, result, list);
			list.remove(list.size() - 1);
		}

	}

}
