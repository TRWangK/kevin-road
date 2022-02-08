package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

/**
 * 129. 求根节点到叶节点数字之和
 * @author Tianrui Wang
 * @date 2021-09-05 15:41
 **/
public class SumRootToLeaf {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.buildTree(4,9,0,5,1,null,null);
		System.out.println(sumNumbers(root));
	}

	public static int sumNumbers(TreeNode root) {
		return recur(root, 0);
	}

	private static int recur(TreeNode node, int sum){
		if (node == null){
			return 0;
		}

		sum = sum * 10 + node.val;

		if (node.left == null && node.right == null){
			return sum;
		}else {
			return recur(node.left, sum) + recur(node.right, sum);
		}
	}
}
