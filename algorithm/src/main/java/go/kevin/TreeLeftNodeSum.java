package go.kevin;

import go.kevin.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 404
 * @author Tianrui Wang
 * @date 2020-09-22 18:09
 **/
public class TreeLeftNodeSum {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(sumOfLeftLeaves(root));

	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null){
			return 0;
		}

		int total = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while ( !queue.isEmpty() ){
			for(int i = 0; i < queue.size(); i++){
				TreeNode node = queue.poll();
				if (node.left != null){
					total += node.left.val;
					queue.add(node.left);
				}
				if (node.right != null){
					queue.add(node.right);
				}
			}
		}

		return total;
	}

}
