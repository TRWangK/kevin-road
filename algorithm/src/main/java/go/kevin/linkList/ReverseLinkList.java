package go.kevin.linkList;

import go.kevin.entity.ListNode;

/**
 * 206. 反转链表
 * @author Tianrui Wang
 * @date 2021-05-09 15:28
 **/
public class ReverseLinkList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head = reverseList2(head);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}

	}

	/**
	 * 迭代法
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}

		ListNode pre = null;
		ListNode now = head;

		while (now != null){
			ListNode next = now.next;
			now.next = pre;
			pre	= now;
			now = next;
		}
		return pre;
	}

	public static ListNode reverseList2(ListNode head) {
		if (head.next == null){
			return head;
		}
		ListNode newHead = reverseList2(head.next);

		head.next.next = head;
		head.next = null;

		return newHead;

	}
}
