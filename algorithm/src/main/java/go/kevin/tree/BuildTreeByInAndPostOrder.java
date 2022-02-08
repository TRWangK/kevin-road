package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * @author Tianrui Wang
 * @date 2021-09-04 17:05
 **/
public class BuildTreeByInAndPostOrder {

	public static void main(String[] args) {
		int[] inOrder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = buildTree(inOrder, postorder);
		TreeUtil.printTreeByLevel(root);
	}

	/**
	 * 分治 递归   思路参考
	 * @see go.kevin.tree.BuildTreeByPreAndInOrder
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return recur(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	private static TreeNode recur(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd){
			return null;
		}

		// 对于后序遍历(左右中)来说, 最后一个值是根节点的值
		int rootValue = postorder[postEnd];
		TreeNode root = new TreeNode(rootValue);

		int position = findRootPosition(inorder, inStart, inEnd, rootValue);
		int rightCount = inEnd - position;

		TreeNode left = recur(inorder, postorder, inStart, position-1, postStart, postEnd - rightCount - 1);
		TreeNode right = recur(inorder, postorder, position+1, inEnd, postEnd - rightCount,postEnd-1);
		root.left = left;
		root.right = right;
		return root;
	}

	private static int findRootPosition(int[] inorder, int inStart, int inEnd, int rootValue){
		if (inStart > inEnd){
			return -1;
		}

		for (int i = inStart; i <= inEnd; i++){
			if (inorder[i] == rootValue){
				return i;
			}
		}

		return -1;
	}
}
