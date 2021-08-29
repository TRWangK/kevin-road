package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

import java.util.Stack;

/**
 * 143. 重排链表
 * @author Tianrui Wang
 * @date 2021-08-29 14:16
 **/
public class ReorderLinkedList {

	public static void main(String[] args) {

		ListNode node1 = LinkedListUtil.getLinkListNode(1,2,3,4);
		ListNode node2 = LinkedListUtil.getLinkListNode(1,2,3,4,5);
		reorderList2(node1);
		reorderList2(node2);

	}

	/**
	 * 偏暴力, 栈存储节点, 从左取一 从栈取一
	 * @param head
	 */
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null){
			return;
		}

		ListNode node = head;
		Stack<ListNode> stack = new Stack<>();

		while (node != null){
			stack.push(node);
			node = node.next;
		}

		int length = stack.size();

		ListNode sentinel = new ListNode(-1);
		sentinel.next = head;


		for (int i = 0; i <= length / 2; i++){
			ListNode next = head.next;
			head.next = stack.pop();
			head.next.next = next;
			head = next;
		}

		if (length % 2 == 1){
			head.next.next = null;
		}else {
			head.next = null;
		}
	}

	/**
	 * 双指针寻找中点, 反转后半链表, 再合并
	 * @param head
	 */
	public static void reorderList2(ListNode head) {
		if (head == null || head.next == null){
			return;
		}

		ListNode middle = findMiddle(head);
		ListNode right = reverseList(middle.next);
		middle.next = null;
		mergeList(head, right);
		LinkedListUtil.printAllNode(head);
	}

	private static ListNode findMiddle(ListNode head){
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	private static ListNode reverseList(ListNode head){

		ListNode pre = null;
		ListNode now = head;

		while (now != null){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
		}
		LinkedListUtil.printAllNode(now);
		return pre;
	}

	private static void mergeList(ListNode left, ListNode right){
		ListNode tempLeftNext = null;
		ListNode tempRightNext = null;

		while (left != null && right != null){
			tempLeftNext = left.next;
			tempRightNext = right.next;

			left.next = right;
			left = tempLeftNext;

			right.next = left;
			right = tempRightNext;
		}
	}

}
