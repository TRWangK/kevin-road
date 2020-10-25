package go.kevin;

import go.kevin.entity.ListNode;

/**
 * leetcode 1171
 * @author Tianrui Wang
 * @date 2020-09-18 17:02
 **/
public class LinkedListRemovePlusZero {
	public static void main(String[] args) {

	}

	public ListNode removeZeroSumSublists(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		while (head != null){



			head = head.next;
		}

		return dummy.next;
	}

}
