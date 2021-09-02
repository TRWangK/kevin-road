package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * 24. 两两交换链表中的节点
 * @author Tianrui Wang
 * @date 2021-09-02 00:14
 **/
public class SwapNodeByPairs {

	public static void main(String[] args) {
		ListNode head = LinkedListUtil.getLinkListNode(1,2,3,4);
		ListNode head2 = LinkedListUtil.getLinkListNode(1);

		LinkedListUtil.printAllNode(swapPairs(head));
		LinkedListUtil.printAllNode(swapPairs(head2));
	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}

		ListNode sentinel = new ListNode(-1);
		sentinel.next = head;

		ListNode pre = sentinel;

		while (pre.next != null && pre.next.next != null){
			ListNode left = pre.next;
			ListNode right = pre.next.next;

			ListNode next = right.next;

			pre.next = right;
			right.next = left;
			left.next = next;
			pre = left;

		}

		return sentinel.next;
	}


}
