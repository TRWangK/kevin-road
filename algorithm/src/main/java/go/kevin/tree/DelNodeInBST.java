package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

/**
 * 450. 删除二叉搜索树中的节点
 * @author Tianrui Wang
 * @date 2021-10-06 18:23
 **/
public class DelNodeInBST {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.buildTree(5,3,6,2,4,null,7);
		TreeUtil.printTreeByLevel(deleteNode(root,3));
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null){
			return null;
		}

		// 二分查找, 定位目标节点
		if (key < root.val){
			root.left = deleteNode(root.left, key);
		}else if (key > root.val){
			root.right = deleteNode(root.right, key);
		// 找到了
		}else {
			// 如果是叶子节点, 直接删除
			if (root.left == null && root.right == null){
				return null;
			}
			// 如果没有左子树, 直接返回右子树
			if (root.left == null){
				return root.right;
			}
			// 如果没有右子树, 直接返回左子树
			if (root.right == null){
				return root.left;
			}

			//如果左右都有
			TreeNode rightMinNode = findRightMin(root.right);
			root.val = rightMinNode.val;
			root.right = deleteNode(root.right, rightMinNode.val);
		}

		return root;
	}

	//寻找右子树的最小节点
	private static TreeNode findRightMin(TreeNode root) {
		while (root.left != null){
			root = root.left;
		}
		return root;
	}

	//寻找左子树的最大节点
	private static TreeNode findLeftMax(TreeNode root) {
		while (root.right != null){
			root = root.right;
		}
		return root;
	}
}
