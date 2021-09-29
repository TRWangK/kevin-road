package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 *  左 右 中
 * @author Tianrui Wang
 * @date 2021-09-04 14:55
 **/
public class PostOrderTravel {

	public static void main(String[] args) {

		TreeNode root = TreeUtil.buildTree(1,null,2,3,null);
		TreeNode root2 = TreeUtil.buildTree(3,9,4,null,null,5,7);
		System.out.println(postorderTraversal2(root2));

	}

	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		recur(root, result);
		return result;
	}

	private static void recur(TreeNode node, List<Integer> result){
		if (node == null){
			return;
		}
		recur(node.left, result);
		recur(node.right, result);
		result.add(node.val);
	}

	/**
	 * 迭代
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null){
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;

		while (root != null  || !stack.isEmpty()){

			while (root != null){
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();

			if (root.right == null || root.right == pre){
				result.add(root.val);
				pre = root;
				root = null;
			}else {
				stack.push(root);
				root = root.right;
			}
		}

		return result;
	}

	/**
	 * 借助前序'遍历 和 额外的栈 实现后序遍历
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null){
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> resultStack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()){

			TreeNode node = stack.pop();
			resultStack.push(node);
			if (node.left != null){
				stack.push(node.left);
			}
			if (node.right != null){
				stack.push(node.right);
			}

		}

		while (!resultStack.isEmpty()){
			result.add(resultStack.pop().val);
		}

		return result;
	}
}
