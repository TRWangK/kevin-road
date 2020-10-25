package go.kevin;

import go.kevin.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * leetcode 501
 * @author Tianrui Wang
 * @date 2020-09-24 16:59
 **/
public class TreeFindMost {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(-1);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(2);

		System.out.println(findMode(root));

	}

	public static int[] findMode(TreeNode root) {

		if(root == null){
			return new int[0];
		}

		List<Integer> answer = new ArrayList<>();
		int maxCount = 0;
		int nowNum = root.val;
		int count = 0;

		Stack<TreeNode> stack = new Stack<>();

		while ( root != null || !stack.isEmpty() ){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else {
				TreeNode temp = stack.pop();
				if(temp.val == nowNum){
					count++;
				}else {
					nowNum = temp.val;
					count = 1;
				}

				if(count == maxCount){
					answer.add(nowNum);
				}
				if(count > maxCount){
					maxCount = count;
					answer.clear();
					answer.add(nowNum);
				}

				root = temp.right;
			}
		}

		int[] result = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++){
			result[i] = answer.get(i);
		}
		return result;
	}


	class Solution {
		int base, count, maxCount;
		List<Integer> answer = new ArrayList<Integer>();

		public int[] findMode(TreeNode root) {
			TreeNode cur = root, pre = null;
			while (cur != null) {
				if (cur.left == null) {
					update(cur.val);
					cur = cur.right;
					continue;
				}
				pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				} else {
					pre.right = null;
					update(cur.val);
					cur = cur.right;
				}
			}
			int[] mode = new int[answer.size()];
			for (int i = 0; i < answer.size(); ++i) {
				mode[i] = answer.get(i);
			}
			return mode;
		}

		public void update(int x) {
			if (x == base) {
				++count;
			} else {
				count = 1;
				base = x;
			}
			if (count == maxCount) {
				answer.add(base);
			}
			if (count > maxCount) {
				maxCount = count;
				answer.clear();
				answer.add(base);
			}
		}
	}
}