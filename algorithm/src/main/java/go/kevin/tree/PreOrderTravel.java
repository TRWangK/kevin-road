package go.kevin.tree;

import go.kevin.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * @author Tianrui Wang
 * @date 2021-08-19 22:52
 **/
public class PreOrderTravel {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(99);

		System.out.println(preorderTraversal(root));

	}


	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		recur(root, result);
		return result;
	}

	// 递归
	private static void recur(TreeNode node, List<Integer> result){
		if (node == null){
			return;
		}

		result.add(node.val);
		recur(node.left, result);
		recur(node.right, result);
	}

	// 栈迭代
	private static void doStack(TreeNode node, List<Integer> result){
		if (node == null){
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);

		while (!stack.isEmpty()){
			TreeNode nowNode = stack.pop();
			result.add(nowNode.val);

			if (nowNode.right != null){
				stack.push(nowNode.right);
			}
			if (nowNode.left != null){
				stack.push(nowNode.left);
			}
		}

	}
}
