package go.kevin.linkList;

import go.kevin.entity.ListNode;

/**
 * leetcode 141. 环形链表
 * @author Tianrui Wang
 * @date 2021-06-05 15:22
 **/
public class LinkListHasCycle {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		head.next.next.next.next = head.next;
		
		System.out.println(hasCycle(head));

	}

	/**
	 * 快慢指针
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;

		while (slow!= null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast){
				return true;
			}
		}

		return false;
	}
}
