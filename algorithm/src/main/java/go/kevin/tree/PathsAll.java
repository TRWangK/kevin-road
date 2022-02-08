package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 257. 二叉树的所有路径
 * @author Tianrui Wang
 * @date 2021-09-05 16:59
 **/
public class PathsAll {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.buildTree(1,2,3,null,5,null,null);
		System.out.println(binaryTreePaths(root));
		System.out.println(binaryTreePaths2(root));
		System.out.println(binaryTreePaths3(root));
	}

	/**
	 * 深度优先 递归
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new LinkedList<>();
		recur(root, "", result);
		return result;
	}

	private static void recur(TreeNode node, String path, List<String> result){
		if (node == null){
			return;
		}

		StringBuilder sb = new StringBuilder(path);
		if (sb.length() > 0){
			sb.append("->");
		}
		sb.append(node.val);

		if (node.left == null && node.right == null){
			result.add(sb.toString());
		}

		recur(node.left, sb.toString(), result);
		recur(node.right, sb.toString(), result);
	}

	/**
	 * 深度优先 栈
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths2(TreeNode root) {

		List<String> result = new LinkedList<>();
		if (root == null){
			return result;
		}

		Stack<TreeNode> stack = new Stack<>();
		Stack<String> pathStack = new Stack<>();
		stack.push(root);
		pathStack.push(root.val + "");

		while (!stack.isEmpty()){

			TreeNode node = stack.pop();
			String path = pathStack.pop();

			if (node.left == null && node.right == null){
				result.add(path);
			}

			if (node.right != null){
				stack.push(node.right);
				pathStack.push(path + "->" + node.right.val);
			}
			if (node.left != null){
				stack.push(node.left);
				pathStack.push(path + "->" + node.left.val);
			}

		}

		return result;
	}

	/**
	 * 广度优先
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths3(TreeNode root) {

		List<String> result = new LinkedList<>();
		if (root == null){
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		Queue<String> pathQueue = new LinkedList<>();
		queue.offer(root);
		pathQueue.offer(root.val + "");

		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			String path = pathQueue.poll();

			if (node.left == null && node.right == null){
				result.add(path);
			}

			if (node.left != null){
				queue.offer(node.left);
				pathQueue.offer(path + "->" + node.left.val);
			}
			if (node.right != null){
				queue.offer(node.right);
				pathQueue.offer(path + "->" + node.right.val);
			}
		}

		return result;
	}

}
