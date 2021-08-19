package go.kevin.tree;

import go.kevin.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * @author Tianrui Wang
 * @date 2021-08-19 23:07
 **/
public class TreeRightSideView {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		System.out.println(rightSideView(root));

	}

	/**
	 * 广度优先算法, 取每一层的最右边节点
	 * @param root
	 * @return
	 */
	public static List<Integer> rightSideView(TreeNode root) {
		if (root == null){
			return new LinkedList<>();
		}

		LinkedList<Integer> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()){
			int size = queue.size();

			for (int i = 1; i <= size; i++){
				TreeNode node = queue.poll();

				if (node.left != null){
					queue.add(node.left);
				}
				if (node.right != null){
					queue.add(node.right);
				}

				// 最右边的节点
				if (i == size){
					result.add(node.val);
				}
			}
		}

		return result;
	}

}
