package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * 83. 删除排序链表中的重复元素
 * @author Tianrui Wang
 * @date 2021-08-30 22:48
 **/
public class RemoveDuplicateNode {
	public static void main(String[] args) {
		ListNode head = LinkedListUtil.getLinkListNode(1,1,2,3,3);
		LinkedListUtil.printAllNode(deleteDuplicates(head));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}

		ListNode now = head;
		ListNode pre = null;

		while (now != null){

			if (pre != null && pre.val == now.val){
				pre.next = now.next;
			}else {
				pre = now;
			}

			now = now.next;
		}

		return head;
	}
}
