package go.kevin.sword;

import go.kevin.entity.TreeNode;

import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 * @author Tianrui Wang
 * @date 2021-02-23 23:01
 **/
public class RebuildTree {

	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
	}

	int[] preorder;
	HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

	/**
	 * 思路: 前序遍历的第一个值为根节点,
	 * 		中序遍历中 可以通过根节点划分 左右子树  左子树 | 根 | 右子树
	 * 		前序遍历中 可以根据左右子树的节点数划分为 	根 | 左子树 | 右子树
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		for (int i = 0; i < inorder.length; i++){
			inorderIndexMap.put(inorder[i], i);
		}

		return recur(0, 0, inorder.length - 1);
	}

	private TreeNode recur(int rootPreIndex, int leftIndex, int rightIndex){
		if (leftIndex > rightIndex){
			return null;
		}
		TreeNode node = new TreeNode( preorder[rootPreIndex] );
		int rootInorderIndex = inorderIndexMap.get(node.val);

		node.left = recur(rootPreIndex + 1, leftIndex, rootInorderIndex - 1);
		node.right = recur((rootPreIndex + rootInorderIndex - leftIndex + 1), rootInorderIndex + 1 , rightIndex);
		return node;
	}
}
