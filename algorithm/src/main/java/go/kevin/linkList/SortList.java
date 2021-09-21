package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * 148. 排序链表
 * @author Tianrui Wang
 * @date 2021-08-29 16:36
 **/
public class SortList {
	public static void main(String[] args) {

		ListNode head = LinkedListUtil.getLinkListNode(4,2,1,3);
		ListNode head2 = LinkedListUtil.getLinkListNode(-1,5,3,4,0);
		LinkedListUtil.printAllNode(sortList2(head2));

		//LinkedListUtil.printAllNode(findMiddle(head2, null));

	}

	/**
	 * 自顶而下 拆分链表 归并排序
	 */
	public static ListNode sortList(ListNode head) {
		return splitList(head, null);
	}

	private static ListNode splitList(ListNode head, ListNode tail){

		if (head == null){
			return head;
		}

		if (head.next == tail){
			head.next = null;
			return head;
		}


		ListNode middle = findMiddle(head, tail);

		ListNode node1 = splitList(head, middle);
		ListNode node2 = splitList(middle, tail);

		return mergeSort(node1, node2);
	}

	private static ListNode findMiddle(ListNode head, ListNode tail){
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next != tail){
			fast = fast.next;
			slow = slow.next;

			if (fast.next != null && fast.next != tail){
				fast = fast.next;
			}
		}
		return slow;
	}

	private static ListNode mergeSort(ListNode node1, ListNode node2){

		ListNode sentinel = new ListNode(-1);
		ListNode pre = sentinel;

		ListNode now1 = node1, now2 = node2;

		while (now1 != null && now2 != null){
			if (now1.val <= now2.val){
				pre.next = now1;
				now1 = now1.next;
			}else {
				pre.next = now2;
				now2 = now2.next;
			}
			pre = pre.next;
		}

		if (now1 != null){
			pre.next = now1;
		}else {
			pre.next = now2;
		}

		return sentinel.next;
	}


	/**
	 * TODO 自底而上 归并排序
	 */
	public static ListNode sortList2(ListNode head) {
		if (head == null){
			return head;
		}

		// 获取链表总长度
		ListNode node = head;
		int length = 0;
		while (node != null){
			length++;
			node = node.next;
		}


		ListNode sentinel = new ListNode(-1);
		sentinel.next = head;
		for (int subLength = 1; subLength < length; subLength = subLength << 1){

			ListNode pre = sentinel;
			ListNode now = sentinel.next;

			for (int i = 1; i < subLength; i++){
				now = now.next;
			}

		}





		return splitList(head, null);
	}



}
