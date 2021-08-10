package go.kevin.linkList;

import go.kevin.entity.ListNode;

/**
 * leetcode 92. 反转链表 II
 * @author Tianrui Wang
 * @date 2021-05-27 23:33
 **/
public class ReverseLinkList2 {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head = reverseBetween(head, 1, 4);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}

	}


	public static ListNode reverseBetween(ListNode head, int left, int right) {

		int position = 1;
		ListNode now = head;
		ListNode pre = null;

		// 先遍历左侧区间, 找到左连接点
		while (position < left){
			pre = now;
			now = now.next;
			position++;
		}
		ListNode leftConnection = pre;
		ListNode rightConnection = now;

		while (position <= right){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
			position++;
		}

		rightConnection.next = now;

		if (leftConnection == null){
			return pre;
		}else {
			leftConnection.next = pre;
			return head;
		}

	}
}
