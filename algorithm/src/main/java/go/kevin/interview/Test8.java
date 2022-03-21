package go.kevin.interview;

import go.kevin.entity.ListNode;

/**
 * @author Tianrui Wang
 * @date 2022-03-08 18:27
 **/
public class Test8 {

	/**
	 * 给出两个 非空 的链表用来表示两个非负的整数。
	 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
	 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 示例：
	 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * 输出：7 -> 0 -> 8
	 * 原因：342 + 465 = 807
	 */

	public static void main(String[] args) {
		/*ListNode l = new ListNode(2);
		l.next = new ListNode(4);
		l.next.next = new ListNode(3);

		ListNode r = new ListNode(5);
		r.next = new ListNode(6);
		r.next.next = new ListNode(4);

		ListNode node = merge(l, r);
		while (node != null){
			System.out.println(node.val);
			node = node.next;
		}*/

		/*ListNode l = new ListNode(2);
		l.next = new ListNode(4);
		l.next.next = new ListNode(3);

		ListNode r = new ListNode(5);
		r.next = new ListNode(6);

		ListNode node = merge(l, r);
		while (node != null){
			System.out.println(node.val);
			node = node.next;
		}*/

	}

	public static ListNode merge(ListNode a, ListNode b){

		ListNode sentinel = new ListNode(-1);
		ListNode pre = sentinel;
		ListNode aNow = a;
		ListNode bNow = b;
		int plus = 0;

		while (aNow != null || bNow != null){
			int val = plus;
			if (aNow == null){
				val += bNow.val;
				bNow = bNow.next;
			}else if (bNow == null){
				val += aNow.val;
				aNow = aNow.next;
			}else{
				val = aNow.val + bNow.val + plus;
				aNow = aNow.next;
				bNow = bNow.next;
			}
			pre.next = new ListNode( val % 10 );
			pre = pre.next;
			plus = val / 10;
		}

		return sentinel.next;
	}
}
