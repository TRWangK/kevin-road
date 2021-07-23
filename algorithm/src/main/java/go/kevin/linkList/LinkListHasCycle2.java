package go.kevin.linkList;

import go.kevin.entity.ListNode;

/**
 * leetcode 142. 环形链表 II
 * @author Tianrui Wang
 * @date 2021-06-05 15:36
 **/
public class LinkListHasCycle2 {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = head;
		/*head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		head.next.next.next.next = head.next;*/

		System.out.println(detectCycle(head).val);
	}


	/**
	 * 首先快慢指针 确定是否有环
	 * 确定有环的一刻, fast 与 slow相遇， 二者走过的距离有以下关系:
	 * a表示链表环外长度, b表示链表环长度
	 *
	 * fastLength = 2 slowLength;
	 * fastLength = slowLength + (nb);
	 * fastLength = 2 nb;
	 * slowLength = nb;
	 *
	 * k表示每次走到入环点走过的距离
	 * k = a + nb;
	 *
	 * 由此可知 当快慢节点交汇时, 慢节点走过的距离slowLength = nb, 也就是说慢节点刚好再走 a 距离 就走到了交汇点
	 * 此时派一个指针从头节点出发 走 a 距离, 会与慢节点相遇, 相遇点即为入环点
	 *
	 * @param head
	 * @return
	 */

	public static ListNode detectCycle(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;


		while (slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast){
				ListNode slowSecond = head;
				while (slow != slowSecond){
					slow = slow.next;
					slowSecond = slowSecond.next;
				}
				return slowSecond;
			}
		}

		return null;
	}

}
