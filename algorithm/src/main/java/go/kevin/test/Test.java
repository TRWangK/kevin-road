package go.kevin.test;

import go.kevin.entity.ListNode;

/**
 * @author Tianrui Wang
 * @date 2020-09-14 14:13
 **/
public class Test {
	public static void main(String[] args) throws Exception{

		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next.next = root.next.next;

		while (root != null){
			System.out.println(root.val);
			Thread.sleep(500);
			root = root.next;
		}
		
		//System.out.println(solution(root));

		//单链表 环  有环返回环的长度 无环返回0
	}

	public static int solution(ListNode root){

		ListNode fast = root;
		ListNode slow = root;
		ListNode b = null;

		boolean circle = false;

		while(slow != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				circle = true;
				b = fast;
				break;
			}
		}

		ListNode a = root;
		ListNode circleStart = null;

		if(circle){
			while(true){
				a = a.next;
				b = b.next;
				if(a == b){
					circleStart = b;
					break;
				}
			}
			ListNode temp = circleStart;
			int length = 0;
			while (true){
				length++;
				circleStart = circleStart.next;
				if(circleStart == temp){
					return length;
				}
			}
		}

		return 0;
	}
}
