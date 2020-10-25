package go.kevin.topk;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Tianrui Wang
 * @date 2020-09-07 15:53
 **/
public class TopKSmallestNums {

	public static void main(String[] args) {

	}

	/**
	 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
	 */
	public static int[] solution(int[] nums, int k){

		if (nums.length < 1 || k < 1 || nums.length < k){
			return new int[0];
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>( (o1, o2) -> o2 - o1);

		for(int i : nums){
			if( queue.size() < k ){
				queue.offer(i);
			}else {
				if(queue.peek() > i){
					queue.poll();
					queue.offer(i);
				}
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++){
			result[i] = queue.poll();
		}

		return result;

	}

}
