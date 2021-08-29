package go.kevin.linkList;

import go.kevin.entity.ListNode;
import go.kevin.linkList.util.LinkedListUtil;

/**
 * 160. 相交链表
 * @author Tianrui Wang
 * @date 2021-08-29 11:29
 **/
public class IntersectionTwoLinkedLists {

	public static void main(String[] args) {
		ListNode headA = LinkedListUtil.getLinkListNode(4,1);
		ListNode headB = LinkedListUtil.getLinkListNode(5,0,1);
		ListNode headC = LinkedListUtil.getLinkListNode(8,4,5);

		headA.next.next = headC;
		headB.next.next.next = headC;
		LinkedListUtil.printAllNode(headA);
		LinkedListUtil.printAllNode(headB);
		LinkedListUtil.printAllNode(getIntersectionNode(headA, headB));
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null){
			return null;
		}

		ListNode pA = headA; ListNode pB = headB;
		while (pA != pB){
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}

		return pA;
	}

}
