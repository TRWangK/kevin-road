package go.kevin;

import go.kevin.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianrui Wang
 * @date 2020-09-08 16:23
 **/
public class ValidBinarySearchTree {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left	= new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left	= new TreeNode(4);
		root.right.right = new TreeNode(6);

		root.right.right.right = new TreeNode(3);
		
		System.out.println(isValidBST(root));

	}

	static boolean isOrNot = true;

	public static boolean isValidBST(TreeNode root){
		if(root == null){
			return true;
		}
		isOrNot = true;
		solution(root, Long.MIN_VALUE, Long.MAX_VALUE);
		return isOrNot;
	}

	public static void solution(TreeNode node, long min, long max){

		if (node.left != null){
			if(node.left.val >= node.val || node.left.val >= max || node.left.val <= min){
				isOrNot = false;
				return;
			}
			solution(node.left, min, node.val);
		}

		if(node.right != null){
			if(node.right.val <= node.val || node.right.val <= min ||node.right.val >= max){
				isOrNot = false;
				return;
			}
			solution(node.right, node.val, max);
		}
		Map<String, String> map = new HashMap<>();
		map.equals(new HashMap<>());

	}
}
