package go.kevin.interview;

import go.kevin.interview.SingleTonTest;

/**
 * @author Tianrui Wang
 * @date 2022-03-16 15:35
 **/
public class ReverseListByGroup {

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode now = head;
		for(int i = 2; i <= 8; i++){
			now.next = new ListNode(i);
			now = now.next;
		}

		ListNode result = reverseListByGroup(head, 3);
		while(result != null){
			System.out.print(result.value);
			result = result.next;
		}

		SingleTonTest.getSingleTonTest();

	}

	public static ListNode reverseListByGroup(ListNode head, int k){

		ListNode sentinel = new ListNode(-1);
		sentinel.next = head;
		recur(sentinel, k);
		return sentinel.next;
	}


	public static int recur(ListNode node, int k){
		//遍历到最后一个节点后递归
		if(node.next == null){
			return 1;
		}

		int num = recur(node.next, k);
		if(num >= k){
			// 反转
			ListNode nowHead = node.next;
			ListNode nowTail = node;
			for(int i = 0; i < k; i++){
				nowTail = nowTail.next;
			}

			// k范围内 首尾节点 -> 反转
			ListNode newHead = reverseList(nowHead, nowTail);
			node.next = newHead;
			return 1;
		}else{
			return num + 1;
		}
	}

	public static ListNode reverseList(ListNode node, ListNode tail){
		if (node == null || tail == null){
			return null;
		}

		ListNode tailNext = tail.next;
		ListNode pre = null;
		ListNode now = node;

		while(now != null && now != tail){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
		}

		now.next = pre;
		pre = now;
		node.next = tailNext;
		return pre;
	}

	static class ListNode{
		public int value;

		public ListNode next;

		public ListNode(int value){
			this.value = value;
		}
	}

}
