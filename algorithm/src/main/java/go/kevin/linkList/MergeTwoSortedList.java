package go.kevin.linkList;

import go.kevin.entity.ListNode;

/**
 * leetcode 21. 合并两个有序链表
 * @author Tianrui Wang
 * @date 2021-05-09 16:48
 **/
public class MergeTwoSortedList {

	public static void main(String[] args) {

	}

	/**
	 * 迭代
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		// 哨兵头节点
		ListNode head = new ListNode(-1);
		ListNode now = head;
		while (l1 != null && l2!= null){
			if (l1.val <= l2.val){
				now.next = l1;
				l1 = l1.next;
			}else {
				now.next = l2;
				l2 = l2.next;
			}
			now = now.next;
		}

		// 最多有一个链表未完全合并, 拼上即可
		now.next = l1 == null ? l2 : l1;
		return head.next;
	}

	/**
	 * 递归
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null){
			return l2;
		}

		if (l2 == null){
			return l1;
		}

		if (l1.val <= l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
