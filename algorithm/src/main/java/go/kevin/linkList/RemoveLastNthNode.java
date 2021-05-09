package go.kevin.linkList;

import go.kevin.entity.ListNode;

/**
 * leetcode 19. 删除链表的倒数第 N 个结点
 * @author Tianrui Wang
 * @date 2021-05-09 17:24
 **/
public class RemoveLastNthNode {

	public static void main(String[] args) {

	}

	/**
	 * 递归 层层返回当前节点 所对应倒数第几个节点
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int positon = getPositionAndDel(head, n);

		// 如果要删除的是头节点
		if (positon == n){
			return head.next;
		}
		return head;
	}

	public int getPositionAndDel(ListNode node, int n) {
		if (node == null){
			return 0;
		}

		int position = getPositionAndDel(node.next, n) + 1;
		if (position == n + 1){
			node.next = node.next.next;
		}
		return position;
	}

	/**
	 * 快慢指针
	 * 快指针先移动 n 个位置, 然后快慢指针一起移动, 若快指针走到最后一个节点, 则慢指针走到了倒数第n+1个节点
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode fastNode = head;
		ListNode slowNode = head;

		for (int i = 1; i <= n; i++){
			fastNode = fastNode.next;
		}

		// 如果快指针已经走完了 说明删除的是头节点
		if (fastNode == null){
			return head.next;
		}

		while (fastNode.next != null){
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}

		slowNode.next = slowNode.next.next;
		return head;
	}

}
