package go.kevin.linkList.util;

import com.google.common.collect.Lists;
import go.kevin.entity.ListNode;

import java.util.List;

/**
 * @author Tianrui Wang
 * @date 2021-06-05 17:29
 **/
public class LinkedListUtil {

	public static ListNode getLinkListNode (List<Integer> valueList){

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
		while (node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}


	public static void main(String[] args) {
		ListNode listNode = getLinkListNode(Lists.newArrayList(1,2,3,4,5));
		printAllNode(listNode);
	}
}
