package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 * @author Tianrui Wang
 * @date 2021-08-29 15:02
 **/
public class ReverseListInKGroup {

	public static void main(String[] args) {

		ListNode node1 = LinkedListUtil.getLinkListNode(1,2,3,4,5);
		LinkedListUtil.printAllNode(reverseKGroup2(node1, 3));

	}


	/**
	 * 借助栈, 每次塞入k个节点, 再pop出来, 拼上
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || head.next == null || k == 1){
			return head;
		}

		ListNode sentinel = new ListNode(-1);
		Stack<ListNode> stack = new Stack<>();

		ListNode now = head;
		ListNode pre = sentinel;

		while (true){

			ListNode first = now;

			for (int i = 1; i <= k; i++){
				if (now == null){
					pre.next = first;
					return sentinel.next;
				}
				stack.push(now);
				now = now.next;
			}

			ListNode node = stack.pop();
			pre.next = node;

			while (!stack.isEmpty()){
				node.next = stack.pop();
				node = node.next;
			}

			pre = node;
		}
	}

	/**
	 * 快指针, 先跑到右边界圈定范围, 反转后拼接
	 */
	public static ListNode reverseKGroup2(ListNode head, int k) {

		if (head == null || head.next == null || k == 1){
			return head;
		}

		ListNode sentinel = new ListNode(-1);
		ListNode pre = sentinel;

		ListNode fast = head;

		while (true){

			ListNode first = fast;
			for (int i = 1; i <= k; i++){
				if (fast == null){
					pre.next = first;
					return sentinel.next;
				}

				fast = fast.next;
			}

			pre.next = reverseList(first, fast);
			pre = first;
		}
	}

	private static ListNode reverseList(ListNode head, ListNode end){
		ListNode now = head;
		ListNode pre = null;

		while (now != end){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
		}
		return pre;
	}
}
