package go.kevin;

import go.kevin.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 559 + leetcode 104
 * @author Tianrui Wang
 * @date 2020-09-27 11:15
 **/
public class TreeNMaxDeep {
	public static void main(String[] args) {

	}

	/**
	 * 解一: 广度优先算法, 层统计
	 * @param root
	 * @return
	 */
	public static int maxDepth(Node root) {

		if (root == null){
			return 0;
		}

		Queue<Node> queue = new LinkedList();
		queue.add(root);
		int deep = 0;

		while (!queue.isEmpty()){
			deep++;
			int size = queue.size();

			for( int i = 0; i < size; i++ ){
				Node node = queue.poll();
				if (node.children != null && node.children.size() > 0){
					node.children.forEach( n -> {
						queue.add(n);
					} );
				}
			}
		}

		return deep;
	}

	/**
	 * 解二: 叶子结点回溯, 递归到叶子节点后回溯, 每层加一
	 * @param root
	 * @return
	 */
	public static int maxDepth2(Node root){

		if (root == null){
			return 0;
		}

		int max = 1;

		for(Node node : root.children){
			max = Math.max(max, maxDepth2(node) + 1);
		}

		return max;
	}
}
