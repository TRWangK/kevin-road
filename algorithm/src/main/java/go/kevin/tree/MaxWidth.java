package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * @author Tianrui Wang
 * @date 2021-10-06 17:57
 **/
public class MaxWidth {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.buildTree(1,3,2,5,3,null,9);
		System.out.println(widthOfBinaryTree(root));
	}

	/**
	 * 宽度优先搜索, 通过node.val记录 节点的位置值, 每层遍历时, 当前层最后一个节点减去第一个节点 就是宽度
	 * @param root
	 * @return
	 */
	public static int widthOfBinaryTree(TreeNode root) {
		int maxWidth = 0;
		if (root == null){
			return maxWidth;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		root.val = 0;
		queue.add(root);

		while (!queue.isEmpty()){

			int levelFirstPos = queue.element().val;
			int levelLastPos = queue.element().val;

			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				levelLastPos = node.val;
				if (node.left != null){
					node.left.val = node.val * 2;
					queue.add(node.left);
				}
				if (node.right != null){
					node.right.val = node.val * 2 + 1;
					queue.add(node.right);
				}
			}

			maxWidth = Math.max(maxWidth, levelLastPos - levelFirstPos + 1);
		}

		return maxWidth;
	}
}
