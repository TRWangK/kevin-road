package go.kevin.entity;

import java.util.List;

/**
 * @author Tianrui Wang
 * @date 2020-09-27 11:12
 **/
public class Node {

	public int val;

	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}

}
