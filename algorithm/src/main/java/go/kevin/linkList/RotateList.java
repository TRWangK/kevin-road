package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * 61. 旋转链表
 * @author Tianrui Wang
 * @date 2021-08-31 23:39
 **/
public class RotateList {

	public static void main(String[] args) {

		ListNode head = LinkedListUtil.getLinkListNode(1,2,3,4,5);
		ListNode head2 = LinkedListUtil.getLinkListNode(0,1,2);
		ListNode head3 = LinkedListUtil.getLinkListNode(1,2);
		LinkedListUtil.printAllNode(rotateRight(head, 2));
		LinkedListUtil.printAllNode(rotateRight(head2, 4));
		LinkedListUtil.printAllNode(rotateRight(head3, 1));

	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k < 1){
			return head;
		}

		// 求链表长度, k取余
		int length = 0;
		ListNode now = head;
		while (now != null){
			length++;
			now = now.next;
		}

		k = k % length;
		if (k == 0){
			return head;
		}

		// 快指针 先走k步
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 1; i < k; i++){

			if (fast.next == null){
				fast = head;
			}else {
				fast = fast.next;
			}

		}

		// 找到倒数第k个节点
		ListNode pre = null;
		while (fast.next != null){
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}

		// 如果slow还在头节点, 无需旋转
		if (slow == head){
			return head;
		}

		ListNode newHead = slow;
		ListNode oldTail = fast;
		pre.next = null;
		oldTail.next = head;

		return newHead;
	}

}
