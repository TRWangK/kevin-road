package go.kevin.linkList;

import com.google.common.collect.Lists;
import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * leetcode 237. 删除链表中的节点
 * @author Tianrui Wang
 * @date 2021-06-05 17:52
 **/
public class RemoveLinkListNode {

	public static void main(String[] args) {

		ListNode head = LinkedListUtil.getLinkListNode(1, 2, 3, 4);
		deleteNode(head.next.next);
		LinkedListUtil.printAllNode(head);

	}

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
