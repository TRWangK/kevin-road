package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历 (Z字形遍历)
 * @author Tianrui Wang
 * @date 2021-09-04 13:22
 **/
public class ZLevelOrder {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.buildTree(3,9,20,null,null,15,7);
		System.out.println(zigzagLevelOrder(root));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null){
			return new ArrayList<>();
		}

		List<List<Integer>> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		boolean asc = true;

		while (!queue.isEmpty()){

			Deque<Integer> levelResult = new LinkedList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode node = queue.poll();

				if (asc){
					levelResult.offerLast(node.val);
				}else {
					levelResult.offerFirst(node.val);
				}

				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}

			asc = !asc;
			result.add(new LinkedList<Integer>(levelResult));
		}
		return result;
	}
}
