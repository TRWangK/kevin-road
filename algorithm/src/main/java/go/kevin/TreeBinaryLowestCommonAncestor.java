package go.kevin;

import go.kevin.entity.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * leetcode 235
 * @author Tianrui Wang
 * @date 2020-09-27 09:19
 **/
public class TreeBinaryLowestCommonAncestor {
	public static void main(String[] args) {

	}

	/**
	 * 解法一: 两次查找, 分别记录两个node的寻找路径
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		LinkedList<TreeNode> pLink = new LinkedList<>();
		LinkedList<TreeNode> qLink = new LinkedList<>();
		recur(pLink, root, p);
		recur(qLink, root, q);

		TreeNode ancestor = root;

		for (int i = 0; i < pLink.size() && i < qLink.size(); i++){
			if( pLink.get(i) == qLink.get(i) ){
				ancestor = pLink.get(i);
			}else {
				break;
			}
		}

		return ancestor;
	}

	private static void recur( LinkedList<TreeNode> fatherLink, TreeNode node, TreeNode target ){

		fatherLink.addLast(node);
		if(node.val == target.val){
			return;
		}else if(node.val > target.val){
			recur(fatherLink, node.left, target);
		}else {
			recur(fatherLink, node.right, target);
		}
	}


	/**
	 * 解法二, 一次查找, 同时查找两个结点
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		while (true){
			if(root.val > Math.max(p.val, q.val)){
				root = root.left;
			}else if(root.val < Math.min(p.val, q.val)){
				root = root.right;
			}else {
				return root;
			}
		}
	}

}
