package go.kevin.linkList;

import go.kevin.entity.ListNode;

/**
 * leetcode 23. 合并K个升序链表
 * @author Tianrui Wang
 * @date 2021-05-26 23:10
 **/
public class MergeKSortedList {

	public static void main(String[] args) {

	}

	public static ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}


	/**
	 * 分治法 两两合并 再将结果两两合并
	 * @param lists
	 * @param left
	 * @param right
	 * @return
	 */
	public static ListNode merge(ListNode[] lists, int left, int right){
		if (left > right){
			return null;
		}
		if (left == right){
			return lists[left];
		}

		int mid = (left + right) >> 1;

		//一分为二 直到不能再分 两两合并
		return mergeTwoList( merge(lists, left, mid), merge(lists, mid + 1, right) );
	}


	public static ListNode mergeTwoList(ListNode l1 , ListNode l2){
		ListNode head = new ListNode(-1);
		ListNode now = head;
		while (l1 != null && l2 != null){
			if (l1.val <= l2.val){
				now.next = l1;
				l1 = l1.next;
			} else {
				now.next = l2;
				l2 = l2.next;
			}
			now = now.next;
		}

		now.next = l1 == null ? l2 : l1;
		return head.next;
	}
}
