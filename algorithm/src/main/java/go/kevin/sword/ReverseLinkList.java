package go.kevin.sword;

import go.kevin.entity.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * @author Tianrui Wang
 * @date 2021-02-22 22:28
 **/
public class ReverseLinkList {

	public static void main(String[] args) {

		ListNode root = new ListNode(1);
		root.next = new ListNode(3);
		root.next.next = new ListNode(2);

		int[] result = reversePrint(root);
		for (int i : result){
			System.out.println(i);
		}


	}

	public static int[] reversePrint(ListNode head) {

		Stack<Integer> stack = new Stack<>();
		while (head != null){
			stack.push(head.val);
			head = head.next;
		}

		int[] result = new int[stack.size()];
		for (int i = 0; i < result.length; i++){
			result[i] = stack.pop();
		}

		return result;
	}
}
