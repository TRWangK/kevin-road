package go.kevin.linkList;

import com.google.common.collect.Lists;
import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * leetcode 203. 移除链表元素
 * @author Tianrui Wang
 * @date 2021-06-05 17:23
 **/
public class RemoveLinkListElement {

	public static void main(String[] args) {

		ListNode head = LinkedListUtil.getLinkListNode(Lists.newArrayList(7,7,7,7));
		LinkedListUtil.printAllNode(removeElements(head, 7));

	}

	public static ListNode removeElements(ListNode head, int val) {

		ListNode sentinel = new ListNode(-1);
		sentinel.next = head;

		ListNode now = sentinel;

		while (now.next != null){

			if (now.next.val == val){
				now.next = now.next.next;
			} else {
				now = now.next;
			}

		}

		return sentinel.next;
	}


}
