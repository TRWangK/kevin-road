package go.kevin.tree;

import go.kevin.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * @author Tianrui Wang
 * @date 2021-08-10 23:05
 **/
public class LevelOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(levelOrder(root));
	}

	/**
	 * 广度优先算法
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null){
			return result;
		}

		Queue<TreeNode> currentLevel = new LinkedList<>();
		currentLevel.add(root);

		while (!currentLevel.isEmpty()){

			//当前层 节点数量
			int size = currentLevel.size();

			//当前层 节点值集合
			List<Integer> levelResult = new ArrayList<>();

			//遍历当前层节点, 加入层节点值集合, 并记录下一层所有节点.
			for (int i = 0; i < size; i++){
				TreeNode node = currentLevel.poll();
				if (node.left != null){
					currentLevel.add(node.left);
				}
				if (node.right != null){
					currentLevel.add(node.right);
				}

				levelResult.add(node.val);
			}

			result.add(levelResult);
		}

		return result;
	}
}
