package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

/**
 * 101. 对称二叉树
 * @author Tianrui Wang
 * @date 2021-09-08 23:16
 **/
public class SymmetricTree {

	public static void main(String[] args) {

		TreeNode root = TreeUtil.buildTree(1,2,2,3,4,4,3);
		TreeNode root2 = TreeUtil.buildTree(1,2,2,null,3,null,3);
		TreeNode root3 = TreeUtil.buildTree(1,2,2,2,null,2,null);
		System.out.println(isSymmetric(root));
		System.out.println(isSymmetric(root2));
		System.out.println(isSymmetric(root3));

	}

	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		if (root == null){
			return false;
		}

		return recur(root.left, root.right);
	}

	private static boolean recur(TreeNode p, TreeNode q){

		if (p == null && q == null){
			return true;
		}
		if (p == null || q == null){
			return false;
		}
		if (p.val != q.val){
			return false;
		}

		// 先比较p的左子和q的右子, 再比较p的右子和q的左子
		return recur(p.left, q.right) && recur(p.right, q.left);
	}
	
}
