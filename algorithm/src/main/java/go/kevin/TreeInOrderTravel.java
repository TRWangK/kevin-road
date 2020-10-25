package go.kevin;

import go.kevin.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 94
 * @author Tianrui Wang
 * @date 2020-09-15 16:26
 **/
public class TreeInOrderTravel {

	public static void main(String[] args) {

	}

	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> result = new LinkedList<>();
		back(root, result);
		return result;
	}

	private static void back(TreeNode node, List<Integer> result){
		if(node == null){
			return;
		}
		back(node.left, result);
		result.add(node.val);
		back(node.right, result);
	}

	/**
	 * 栈 迭代
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null || !stack.isEmpty()){
			if(root != null){
				stack.add(root);
				root = root.left;
			}else {
				TreeNode temp = stack.pop();
				result.add(temp.val);
				root = temp.right;
			}
		}
		return result;
	}


	public static List<Integer> inorderTraversal3(TreeNode root){
		List<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();

		while ( root != null || !stack.isEmpty() ){
			if(root != null){
				stack.add(root);
				root = root.left;
			}else {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}

}
