package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @author Tianrui Wang
 * @date 2021-09-04 16:45
 **/
public class BuildTreeByPreAndInOrder {

	public static void main(String[] args) {
		int[] pre = {3,9,20,15,7};
		int[] inOrder = {9,3,15,20,7};
		TreeNode root = buildTree(pre, inOrder);
		TreeUtil.printTreeByLevel(root);
	}

	/**
	 * 分治 递归
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return recur(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private static TreeNode recur(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
		if (preStart > preEnd || inStart > inEnd){
			return null;
		}

		// 左序遍历的第一个 是root的值
		int rootValue = preorder[preStart];
		TreeNode root = new TreeNode(rootValue);

		// 找到root在inOrder的位置, 左侧是左子树, 右侧是右子树
		int position = findRootPosition(inorder, inStart, inEnd, rootValue);

		// 左子树 节点数量
		int leftCount = position - inStart;

		// 分治
		TreeNode leftNode = recur(preorder, inorder, preStart + 1, preStart + leftCount, inStart, position - 1 );
		TreeNode rightNode = recur(preorder, inorder, preStart + leftCount + 1, preEnd, position + 1, inEnd);
		root.left = leftNode;
		root.right = rightNode;
		return root;
	}

	private static int findRootPosition(int[] inorder, int start, int end, int rootValue){
		if (start > end){
			return -1;
		}

		for (int i = start; i <= end; i++){
			if (inorder[i] == rootValue){
				return i;
			}
		}
		return -1;
	}


}
