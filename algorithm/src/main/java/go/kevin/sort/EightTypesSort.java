package go.kevin.sort;

import java.util.Arrays;

/**
 * @author Tianrui Wang
 * @date 2020-09-11 17:31
 **/
public class EightTypesSort {
	public static void main(String[] args) {

		int[] example = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};

		//chooseSort( Arrays.copyOf(example, example.length) );
		//bubbleSort( Arrays.copyOf(example, example.length) );
		//quickSort( Arrays.copyOf(example, example.length) );
		mergeSort( Arrays.copyOf(example, example.length) );

	}

	/**
	 * 1.选择排序:
	 * 从第一位开始遍历整个数组, 找到最小的数, 放到数组最前
	 * 从第二位开始遍历整个数组, 找到第二小的数, 放到数组第二位
	 * ....
	 * 直到最后一位
	 *
	 * 时间复杂度O(n2) 空间复杂度O(1)
	 */
	public static int[] chooseSort(int[] nums){

		int min = 0, tempIndex = 0;

		for(int x = 0; x < nums.length; x++){

			min = nums[x];
			tempIndex = x;

			for (int y = x + 1; y < nums.length; y++){
				if(nums[y] < min){
					min = nums[y];
					tempIndex = y;
				}
			}

			if(tempIndex != x){
				int temp = nums[x];
				nums[x] = nums[tempIndex];
				nums[tempIndex] = temp;
			}

		}

		System.out.println("choose: " + Arrays.toString(nums));
		return nums;
	}

	/**
	 * 2.冒泡排序
	 *  从第一位开始, 两两比较, 小的交换到前面, 大的置后
	 *  第一轮遍历保证最大值放到了最后一位
	 *  第二轮遍历保证第二大的值放到了倒数第二位
	 *  ....
	 *
	 *  时间复杂度O(n2) 空间复杂度O(1)
	 */
	public static int[] bubbleSort(int[] nums){

		for (int x = 0; x < nums.length - 1; x++){
			for (int y = 0; y < nums.length - 1 - x; y++ ){
				if(nums[y] > nums[y+1]){
					int temp = nums[y];
					nums[y] = nums[y+1];
					nums[y+1] = temp;
				}
			}
		}

		System.out.println("bubble: " + Arrays.toString(nums));
		return nums;
	}

	/**
	 * 3.插入排序
	 */
	public static int[] insertSort(int[] nums){
		return nums;
	}


	/**
	 * 4.快速排序
	 */
	public static int[] quickSort(int[] nums){
		quickSortR(nums, 0, nums.length - 1);
		System.out.println("quick: " + Arrays.toString(nums));
		return nums;
	}
	private static void quickSortR(int[] array, int start, int end){

		if(start >= end){
			return;
		}

		int left = start;
		int right = end;
		int base = array[start];

		while (left < right){

			while (right > left && array[right] >= base ){
				right--;
			}
			array[left] = array[right];

			while (left < right && array[left] <= base){
				left++;
			}
			array[right] = array[left];
			System.out.println(Arrays.toString(array));
		}

		array[left] = base;
		System.out.println("一轮结束: " + Arrays.toString(array));
		quickSortR(array, start, left);
		quickSortR(array, left+1, end);

	}

	public static int[] mergeSort(int[] nums){

		if(nums.length <= 1){
			return nums;
		}

		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		int middle = numsCopy.length / 2;

		int[] left = Arrays.copyOfRange(numsCopy, 0, middle);
		int[] right = Arrays.copyOfRange(numsCopy, middle, numsCopy.length);

		return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right){

		int[] result = new int[left.length + right.length];


		return result;
	}

}
