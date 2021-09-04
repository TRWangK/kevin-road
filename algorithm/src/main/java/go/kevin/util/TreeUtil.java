package go.kevin.util;

import go.kevin.entity.TreeNode;

import java.util.*;

/**
 * @author Tianrui Wang
 * @date 2021-09-04 13:24
 **/
public class TreeUtil {

	public static TreeNode buildTree(Integer... values){

		int length = values.length;

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(values[0]);
		queue.offer( root );

		int position = 1;
		while (!queue.isEmpty() && position < length){
			int size = queue.size();
			if (size * 2 > length - position){
				throw new IllegalArgumentException();
			}

			for (int i = 0; i < size; i++){
				TreeNode node = queue.poll();

				Integer leftValue = values[position++];
				Integer rightValue = values[position++];
				if (leftValue != null){
					TreeNode left = new TreeNode(leftValue);
					node.left = left;
					queue.offer(left);
				}

				if (rightValue != null){
					TreeNode right = new TreeNode(rightValue);
					node.right = right;
					queue.offer(node.right);
				}
			}
		}

		return root;
	}

	public static void printTreeByLevel(TreeNode root){
		if (root == null){
			return;
		}
		List<List<Integer>> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()){

			int size = queue.size();
			List<Integer> levelResult = new LinkedList<>();

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
			result.add(levelResult);
		}

		System.out.println(result);
	}


	public static void main(String[] args) {
		TreeNode root = buildTree(3,9,20,null,null,15,7);
		printTreeByLevel(root);
	}


}
