package go.kevin.sword;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * @author Tianrui Wang
 * @date 2021-02-24 23:55
 **/
public class CQueue {
	/**
	 * 用两个栈实现一个队列。队列的声明如下，
	 * 请实现它的两个函数 appendTail 和 deleteHead ，
	 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
	 */
	private Stack<Integer> fromStack;
	private Stack<Integer> toStack;

	public CQueue() {
		this.fromStack = new Stack<>();
		this.toStack = new Stack<>();
	}

	public void appendTail(int value) {
		this.fromStack.push(value);
	}

	public int deleteHead() {
		if (toStack.size() == 0){
			while (fromStack.size() > 0){
				toStack.push(fromStack.pop());
			}
		}

		if (toStack.size() == 0){
			return -1;
		}
		return toStack.pop();
	}
}
