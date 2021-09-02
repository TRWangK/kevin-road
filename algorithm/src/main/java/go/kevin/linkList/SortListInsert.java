package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * 147. 对链表进行插入排序
 * @author Tianrui Wang
 * @date 2021-08-29 16:36
 **/
public class SortListInsert {
	public static void main(String[] args) {

		ListNode head2 = LinkedListUtil.getLinkListNode(-1,5,3,4,0);
		LinkedListUtil.printAllNode(insertionSortList(head2));

	}

	public static ListNode insertionSortList(ListNode head){

		if (head == null || head.next == null){
			return head;
		}

		ListNode sentinel = new ListNode(-1);
		ListNode now = head;

		//遍历每一个节点
		while (now != null){

			ListNode next = now.next;

			// 插入排序
			ListNode resultPre = sentinel;

			// 遍历有序链表 找到其中 比当前节点 大的节点
			while (resultPre.next != null && resultPre.next.val < now.val){
				resultPre = resultPre.next;
			}

			// 插入点位
			ListNode resultNext = resultPre.next;
			resultPre.next = now;
			now.next = resultNext;

			now = next;
		}

		return sentinel.next;
	}

}
