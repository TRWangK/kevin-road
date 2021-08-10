package go.kevin.entity;

import lombok.Data;

/**
 * @author Tianrui Wang
 * @date 2020-09-08 16:24
 **/
@Data
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { this.val = x; }
}
