package go.kevin.sort;

import java.util.Arrays;

/**
 * 912. 排序数组
 * @author Tianrui Wang
 * @date 2021-09-02 23:17
 **/
public class SortAnArray {

	public static void main(String[] args) {

		int[] nums = {5,1,1,2,0,0};

		System.out.println(Arrays.toString(sortArray(nums)));

	}


	public static int[] sortArray(int[] nums) {
		//quickSort(nums, 0, nums.length-1);
		mergeSort(nums, 0, nums.length-1);
		return nums;
	}

	/**
	 * 快排
	 * @param nums
	 * @return
	 */
	public static void quickSort(int[] nums, int start, int end){

		if(start >= end){
			return;
		}

		int left = start;
		int right = end;
		int base = nums[start];

		while (left < right){

			while (right > left && nums[right] >= base){
				right--;
			}
			nums[left] = nums[right];

			while (left < right && nums[left] <= base){
				left++;
			}
			nums[right] = nums[left];
		}

		nums[left] = base;
		System.out.println("一轮结束: " + Arrays.toString(nums) + " left: " + left);

		quickSort(nums, start, left);
		quickSort(nums, left+1, end);
	}

	/**
	 * 归并排序
	 * @param nums
	 * @return
	 */
	public static void mergeSort(int[] nums, int start, int end) {
		if (start == end){
			return;
		}

		int middle = (start + end) >> 1;
		mergeSort(nums, start, middle);
		mergeSort(nums, middle+1, end);
		merge(nums, start, middle, end);
	}

	private static void merge(int[] nums, int start, int middle, int end){

		int[] helper = new int[end-start+1];
		int index = 0;
		int left = start;
		int right = middle + 1;

		while (left <= middle && right <= end){
			if (nums[left] <= nums[right]){
				helper[index++] = nums[left++];
			}else {
				helper[index++] = nums[right++];
			}
		}

		while (left <= middle){
			helper[index++] = nums[left++];
		}

		while (right <= end){
			helper[index++] = nums[right++];
		}

		for (int i = 0; i < helper.length; i++){
			nums[start++] = helper[i];
		}
	}

}
