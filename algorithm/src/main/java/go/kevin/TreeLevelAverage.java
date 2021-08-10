package go.kevin;

import go.kevin.entity.TreeNode;

import java.util.*;

/**
 * leetcode 637
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * @author Tianrui Wang
 * @date 2020-09-15 15:36
 **/
public class TreeLevelAverage {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		long start = System.currentTimeMillis();
		System.out.println(averageOfLevels(root));
		System.out.println(System.currentTimeMillis() - start);

		start = System.currentTimeMillis();
		System.out.println(averageOfLevels2(root));
		System.out.println(System.currentTimeMillis() - start);

	}

	/**
	 * 思路: 广度优先搜索
	 * 创建一个队列, 从root结点开始, 保存下一层的结点, 每次只遍历当前层数大小的次数
	 * @param root
	 * @return
	 */
	public static List<Double> averageOfLevels(TreeNode root) {

		List<Double> result = new ArrayList<>();
		if(root == null){
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()){

			double total = 0;
			int size = queue.size();

			for(int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				total += node.val;

				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
			}

			result.add( total / size );
		}
		return result;
	}

	/**
	 * 深度优先搜索
	 * @param root
	 * @return
	 */
	public static List<Double> averageOfLevels2(TreeNode root) {

		List<Double> result = new ArrayList<>();
		if(root == null){
			return result;
		}

		List<Double> totalPerLevel = new ArrayList<>();
		List<Integer> countPerLevel = new ArrayList<>();

		backTracing(root, 1, totalPerLevel, countPerLevel);

		for (int i = 0; i < totalPerLevel.size(); i++){
			result.add(totalPerLevel.get(i) / countPerLevel.get(i));
		}
		return result;
	}

	private static void backTracing(TreeNode node, int level, List<Double> totalPerLevel, List<Integer> countPerLevel){

		if(node == null){
			return;
		}

		//如果大小小于level 说明之前没有到过这一层, 需要设置初始值
		if(countPerLevel.size() < level){
			countPerLevel.add(level-1, 1);
			totalPerLevel.add(level-1, node.val * 1.0D);
		}else {
			countPerLevel.set(level-1, countPerLevel.get(level-1) + 1);
			totalPerLevel.set(level-1, totalPerLevel.get(level-1) + node.val);
		}

		backTracing(node.left, level + 1, totalPerLevel, countPerLevel);
		backTracing(node.right, level + 1, totalPerLevel, countPerLevel);

	}
}
