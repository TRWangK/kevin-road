package go.kevin.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author Tianrui Wang
 * @date 2021-09-12 13:50
 **/
public class QuickSort {

	public static void main(String[] args) {
		int[] example = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		//quickSortOne(example, 0, example.length-1);
		quickSortTwo(example, 0, example.length-1);
		System.out.println("result: " + Arrays.toString(example));

	}

	/**
	 * 快排1.0 思路参考SortColors 荷兰国旗问题
	 * @param nums
	 */
	public static void quickSortOne(int[] nums, int start, int end){

		if (start >= end){
			return;
		}

		int target = nums[start];
		int smallerIndex = start-1;
		int biggerIndex = end+1;
		System.out.println("target: " + target + " smallerIndex: " + smallerIndex + " biggerIndex:" + biggerIndex);

		for (int i = start; i < biggerIndex; i++){
			if (nums[i] < target){
				smallerIndex++;
				swap(nums, smallerIndex, i);
			}else if(nums[i] > target){
				biggerIndex--;
				swap(nums, biggerIndex, i);
				i--;
			}
		}
		System.out.println(Arrays.toString(nums) + " smallerIndex: " + smallerIndex + " biggerIndex:" + biggerIndex);
		System.out.println("-");

		quickSortOne(nums, 0, smallerIndex);
		quickSortOne(nums, biggerIndex, end);
	}

	/**
	 * 快排2.0  在1.0基础上 基准比较值随机获取, 不再指定第一个
	 * @param nums
	 * @param start
	 * @param end
	 */
	public static void quickSortTwo(int[] nums, int start, int end){
		if (start >= end){
			return;
		}

		int smallerIndex = start - 1;
		int biggerIndex = end + 1;

		int randomIndex = start + (int) (Math.random() * (end - start + 1));
		int base = nums[randomIndex];
		System.out.println("base: " + base + " smallerIndex: " + smallerIndex + " biggerIndex:" + biggerIndex + " randomIndex:" + randomIndex);

		for (int i = start; i < biggerIndex; i++){
			if (nums[i] < base){
				smallerIndex++;
				swap(nums, smallerIndex, i);
			}else if (nums[i] > base){
				biggerIndex--;
				swap(nums, biggerIndex, i);
				i--;
			}
		}

		quickSortTwo(nums, start, smallerIndex);
		quickSortTwo(nums, biggerIndex, end);
	}


	private static void swap(int[] nums, int index1, int index2){
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
