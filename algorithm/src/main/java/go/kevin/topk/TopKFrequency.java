package go.kevin.topk;

import java.util.*;

/**
 * @author Tianrui Wang
 * @date 2020-09-07 14:25
 **/
public class TopKFrequency {
	public static void main(String[] args) {

		int[] example = {4,1,-1,2,-1,2,3};

	}

	public static int[] solution(int[] nums, int k){

		if(nums.length < 1 || k < 1){
			return null;
		}

		Map<Integer, Integer> map = new HashMap<>();

		//遍历统计频率 O(n)
		for(int i = 0; i < nums.length; i++){
			int num = nums[i];

			if (map.get(num) == null){
				map.put(num, 1);
			}else {
				map.put(num, map.get(num) + 1);
			}
		}

		//创建一个大小为k的最小堆
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
				(o1, o2) -> o1[1] - o2[1]
		);

		//每次将堆顶(最小频率) 与新元素比较 O(nlogK)
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			int num = entry.getKey();
			int times = entry.getValue();

			if(queue.size() == k){
				if (queue.peek()[1] < times){
					queue.poll();
					queue.offer(new int[]{num, times});
				}
			}else{
				queue.offer(new int[]{num, times});
			}
		}

		//O(1)
		int[] result = new int[k];
		for (int i = 0; i < k; ++i) {
			result[i] = queue.poll()[0];
		}

		return result;

	}


}
