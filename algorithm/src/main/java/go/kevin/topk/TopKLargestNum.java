package go.kevin.topk;

import java.util.PriorityQueue;

/**
 * @author Tianrui Wang
 * @date 2020-09-07 15:28
 **/
public class TopKLargestNum {

	public static void main(String[] args) {

	}

	public static int solution(int[] nums, int k){

		PriorityQueue<Integer> queue = new PriorityQueue<>( (o1, o2) -> o1 - o2);

		for (int i : nums){
			if(queue.size() == k){
				if(queue.peek() < i){
					queue.poll();
					queue.offer(i);
				}
			}else {
				queue.offer(i);
			}
		}

		return queue.poll();
	}
}
