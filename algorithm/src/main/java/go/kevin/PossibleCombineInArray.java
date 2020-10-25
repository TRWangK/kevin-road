package go.kevin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 77
 * @author Tianrui Wang
 * @date 2020-09-08 11:33
 **/
public class PossibleCombineInArray {
	public static void main(String[] args) {
		
		System.out.println(solution(5,3));

	}

	public static List<List<Integer>> solution(int n, int k){
		List<List<Integer>> result = new ArrayList<>();
		Deque<Integer> temp = new ArrayDeque<>();
		if( k > n ){
			return result;
		}

		backTracing(n, k, 1, result, temp);
		return result;
	}

	public static void backTracing(int n, int k, int startIndex, List<List<Integer>> result, Deque<Integer> temp){
		if(k > n){
			return;
		}

		if(temp.size() == k){
			result.add(new ArrayList<>(temp));
			return;
		}

		for( int i = startIndex; i <= n; i++ ){
			temp.addLast(i);
			backTracing(n, k, i + 1, result, temp);
			temp.removeLast();
		}

	}
}
