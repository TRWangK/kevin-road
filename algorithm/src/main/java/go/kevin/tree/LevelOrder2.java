package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 * @author Tianrui Wang
 * @date 2021-09-04 16:23
 **/
public class LevelOrder2 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.buildTree(3,9,20,null,null,15,7);
		System.out.println(levelOrderBottom(root));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null){
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		recur(queue, result);
		return result;
	}

	private static void recur(Queue<TreeNode> queue, List<List<Integer>> result){

		int size = queue.size();
		if (size == 0){
			return;
		}

		List<Integer> levelResult = new ArrayList<>(size);
		for (int i = 0; i < size; i++){
			TreeNode node = queue.poll();
			levelResult.add(node.val);

			if (node.left != null){
				queue.offer(node.left);
			}
			if (node.right != null){
				queue.offer(node.right);
			}
		}

		recur(queue, result);
		result.add(levelResult);
	}

}
