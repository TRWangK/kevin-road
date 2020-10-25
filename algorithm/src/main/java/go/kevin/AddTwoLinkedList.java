package go.kevin;

import go.kevin.entity.ListNode;

/**
 * @author Tianrui Wang
 * @date 2020-09-02 15:32
 **/
public class AddTwoLinkedList {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode startNode = new ListNode(0);
		ListNode currNode = startNode;
		int plus = 0;

		while ( l1 != null || l2 != null){

			int value = plus;

			if(l1 != null){
				value += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				value += l2.val;
				l2 = l2.next;
			}

			ListNode nextNode = new ListNode(value % 10);
			plus = value / 10;
			currNode.next = nextNode;
			currNode = nextNode;
		}

		if(plus > 0){
			currNode.next = new ListNode(plus);
		}

		return startNode.next;
	}
}
