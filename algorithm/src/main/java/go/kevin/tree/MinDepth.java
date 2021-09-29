package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

/**
 * 111. 二叉树的最小深度
 * @author Tianrui Wang
 * @date 2021-09-29 23:32
 **/
public class MinDepth {

	public static void main(String[] args) {

		TreeNode root = TreeUtil.buildTree(3,9,20,null,null,15,7);
		System.out.println(minDepth(root));

	}

	public static int minDepth(TreeNode root) {
		if (root == null){
			return 0;
		}
		return recur(root, 1, Integer.MAX_VALUE);
	}

	private static int recur(TreeNode node, int curLevel, int min) {

		if (node.left == null && node.right == null) {
			min = Math.min(curLevel, min);
			return min;
		}

		if (node.left != null) {
			min = recur(node.left, curLevel+1, min);
		}
		if (node.right != null) {
			min = recur(node.right, curLevel+1, min);
		}
		return min;
	}

	public static int minDepth2(TreeNode root) {
		if (root == null){
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		if (root.left == null) {
			return minDepth2(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth2(root.left) + 1;
		}

		return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
	}


}
