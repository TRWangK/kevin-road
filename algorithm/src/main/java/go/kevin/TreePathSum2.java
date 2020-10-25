package go.kevin;

import go.kevin.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 113
 * @author Tianrui Wang
 * @date 2020-09-27 10:01
 **/
public class TreePathSum2 {
	public static void main(String[] args) {

	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<>();
		Deque<Integer> list = new LinkedList<>();

		recur( result, list, root, sum );
		return result;
	}

	private static void recur( List<List<Integer>> result, Deque<Integer> list, TreeNode nowNode, int nowSum ){

		if(nowNode == null){
			return;
		}

		list.addLast(nowNode.val);
		nowSum = nowSum - nowNode.val;

		if(nowNode.left == null && nowNode.right == null && nowSum == 0) {
			result.add(new ArrayList<>(list));
			list.removeLast();
			return;
		}

		recur(result, list, nowNode.left, nowSum);
		recur(result, list, nowNode.right, nowSum);
		list.removeLast();
	}

}
