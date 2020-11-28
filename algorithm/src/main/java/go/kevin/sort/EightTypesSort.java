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
		//insertionSort( Arrays.copyOf(example, example.length));
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
	 *  将数据分为已排序和未排序两个区间, 初始已排序区间只有数组第一个元素.
	 *  每次外循环取未排序区间第一个数, 在内循环中与已排序区间数倒序遍历比较,
	 *  找到合适的插入位置插入, 循环时已排序区间比当前数大的数都后移一位.
	 */
	public static int[] insertionSort(int[] nums){

		for(int x = 1; x < nums.length; x++){

			int tempNum = nums[x];

			for (int y = x - 1; y >= 0; y--){
				// 在未排序区间中寻找插入位置, 比当前数小的数都后移一位
				if(tempNum < nums[y]){
					nums[y+1] = nums[y];

				// 找到了插入位置, 插入并出循环
				}else {
					nums[y+1] = tempNum;
					break;
				}
			}
		}

		System.out.println("insertion: " + Arrays.toString(nums));
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

	/**
	 * 5.归并排序
	 *  分治思想, 将一个数组拆分为两个, 直到无法再分
	 *  然后一一返回, 进行合并和排序.
	 *  递归.
	 * @param nums
	 * @return
	 */
	public static int[] mergeSort(int[] nums){
		nums = splitAndMerge(nums);
		System.out.println( Arrays.toString(nums) );
		return nums;
	}

	private static int[] splitAndMerge(int[] nums){
		if (nums.length <= 1){
			return nums;
		}

		int[] leftArray = splitAndMerge( Arrays.copyOfRange(nums, 0, nums.length / 2 ) ) ;
		int[] rightArray = splitAndMerge( Arrays.copyOfRange(nums, nums.length / 2, nums.length) );

		return merge( leftArray, rightArray );
	}

	private static int[] merge(int[] left, int[] right){

		int[] result = new int[left.length + right.length];
		int x = 0, y = 0;

		for(int i = 0; i < result.length; i++){

			if (y >= right.length || ( x < left.length && left[x] <= right[y] )){
				result[i] = left[x];
				x++;
			}else {
				result[i] = right[y];
				y++;
			}
		}

		return result;
	}

}
