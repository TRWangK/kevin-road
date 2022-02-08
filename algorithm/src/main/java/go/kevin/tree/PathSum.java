package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.Stack;

/**
 * 112. 路径总和
 * @author Tianrui Wang
 * @date 2021-09-05 15:54
 **/
public class PathSum {

	public static void main(String[] args) {

		TreeNode root = TreeUtil.buildTree(5,4,8,11,null,13,4,7,2,null,null,null,1);
		System.out.println(hasPathSum(root, 22));

	}

	/**
	 * 递归
	 * @param root
	 * @param targetSum
	 * @return
	 */
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null){
			return false;
		}

		if (root.left == null && root.right == null){
			return targetSum == root.val;
		}

		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}
}
