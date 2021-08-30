package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 82. 删除排序链表中的重复元素 II
 * @author Tianrui Wang
 * @date 2021-08-30 22:48
 **/
public class RemoveDuplicateNode2 {
	public static void main(String[] args) {
		ListNode head = LinkedListUtil.getLinkListNode(1,2,3,3,4,4,5);
		LinkedListUtil.printAllNode(deleteDuplicates(head));
	}

	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null){
			return head;
		}

		ListNode sentinel = new ListNode(-1);
		sentinel.next = head;

		ListNode now = sentinel;

		while (now.next != null && now.next.next != null){

			if (now.next.val == now.next.next.val){
				int duplicateValue = now.next.val;
				while (now.next != null && now.next.val == duplicateValue){
					now.next = now.next.next;
				}
			}else {
				now = now.next;
			}

		}

		return sentinel.next;
	}
}
