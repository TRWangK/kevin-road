package go.kevin.linkList.util;

import go.kevin.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tianrui Wang
 * @date 2021-06-05 17:29
 **/
public class LinkedListUtil {

	public static ListNode getLinkListNode (Integer... valueList){

		ListNode sentinel = new ListNode(-1);
		ListNode now = sentinel;

		for (Integer value : valueList){
			now.next = new ListNode(-1);
			now = now.next;
			now.val = value;
		}

		return sentinel.next;
	}

	public static void printAllNode (ListNode node){
		List<Integer> result = new ArrayList<>();
		while (node != null){
			result.add(node.val);
			node = node.next;
		}
		System.out.println(result);
	}


	public static void main(String[] args) {
		ListNode listNode = getLinkListNode(1,2,3);
		printAllNode(listNode);
	}
}
