package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * @author Tianrui Wang
 * @date 2021-09-04 16:06
 **/
public class InOrderTravel {
	public static void main(String[] args) {
		TreeNode root = TreeUtil.buildTree(1,null,2,3,null);
		TreeNode root2 = TreeUtil.buildTree(3,9,4,null,null,5,7);
		System.out.println(inorderTraversal(root2));
		System.out.println(inorderTraversal2(root2));
	}

	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		recur(root, result);
		return result;
	}

	private static void recur(TreeNode node, List<Integer> result){
		if (node == null){
			return;
		}

		recur(node.left, result);
		result.add(node.val);
		recur(node.right, result);
	}

	/**
	 * 迭代
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null){
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();

		while ( !stack.isEmpty() || root != null ){

			//依次把左边界压入栈
			while (root != null){
				stack.push(root);
				root = root.left;
			}

			// 没有左节点了, pop上一个节点, 并查找他的右节点
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}

		return result;
	}
}
