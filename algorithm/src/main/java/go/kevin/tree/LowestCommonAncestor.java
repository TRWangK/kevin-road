package go.kevin.tree;

import go.kevin.entity.TreeNode;
import go.kevin.util.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * @author Tianrui Wang
 * @date 2021-09-05 15:04
 **/
public class LowestCommonAncestor {

	public static void main(String[] args) {

		TreeNode root = TreeUtil.buildTree(3,5,1,6,2,0,8,null,null,7,4, null, null, null, null);

		TreeNode result = lowestCommonAncestor(root, root.left, root.right);
		System.out.println(result);

		TreeNode result2 = lowestCommonAncestor2(root, root.left, root.right);
		System.out.println(result2);

	}


	private static HashMap<TreeNode, TreeNode> map = new HashMap<>();

	/**
	 * HashMap存储所有节点的父节点
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null){
			return null;
		}

		// 遍历, 存储所有节点的父节点
		recur(root, null);

		List<TreeNode> pParent = new ArrayList<>();
		while (p != null){
			pParent.add(p);
			p = map.get(p);
		}

		while (q != null){
			if (pParent.contains(q)){
				return q;
			}
			q = map.get(q);
		}

		map.clear();
		return null;
	}

	private static void recur(TreeNode node, TreeNode parent){
		if (node == null){
			return;
		}

		map.put(node, parent);
		recur(node.left, node);
		recur(node.right, node);
	}

	private static TreeNode commonAncestor = null;

	/**
	 * 递归
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		recur2(root, p, q);
		return commonAncestor;
	}

	private static boolean recur2(TreeNode node, TreeNode p, TreeNode q){
		if (node == null){
			return false;
		}

		boolean lSon = recur2(node.left, p, q);
		boolean rSon = recur2(node.right, p, q);

		if (lSon && rSon){
			commonAncestor = node;
		}else if ( (node == p || node == q) && (lSon || rSon) ){
			commonAncestor = node;
		}

		return lSon || rSon || node == p || node == q;

	}
}
