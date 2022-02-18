package go.kevin.sort;

import java.util.Arrays;

/**
 * @author Tianrui Wang
 * @date 2020-09-11 17:31
 **/
public class EightTypesSort {
	public static void main(String[] args) {

		int[] example = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

		//chooseSort(Arrays.copyOf(example, example.length));
		//bubbleSort(Arrays.copyOf(example, example.length));
		//insertionSort(Arrays.copyOf(example, example.length));
		//quickSort( Arrays.copyOf(example, example.length), 0, example.length - 1 );
		//mergeSort( Arrays.copyOf(example, example.length), 0, example.length - 1 );
		heapSort(Arrays.copyOf(example, example.length));
	}

	/**
	 * 1.选择排序:
	 * 从第一位开始遍历整个数组, 找到最小的数, 放到数组最前
	 * 从第二位开始遍历整个数组, 找到第二小的数, 放到数组第二位
	 * ....
	 * 直到最后一位
	 * <p>
	 * 时间复杂度O(n2) 空间复杂度O(1)
	 */
	public static void chooseSort(int[] nums) {
		int length = nums.length;

		for (int i = 0; i < length; i++) {

			int minIndex = i;
			for (int j = i; j < length; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}

			swap(nums, i, minIndex);
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 2.冒泡排序
	 * 从第一位开始, 两两比较, 小的交换到前面, 大的置后
	 * 第一轮遍历保证最大值放到了最后一位
	 * 第二轮遍历保证第二大的值放到了倒数第二位
	 * ....
	 * <p>
	 * 时间复杂度O(n2) 空间复杂度O(1)
	 */
	public static void bubbleSort(int[] nums) {
		int length = nums.length;

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (nums[j + 1] < nums[j]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 3.插入排序
	 * 将数据分为已排序和未排序两个区间, 初始已排序区间只有数组第一个元素.
	 * 每次外循环取未排序区间第一个数, 在内循环中与已排序区间数倒序遍历比较,
	 * 找到合适的插入位置插入, 循环时已排序区间比当前数大的数都后移一位.
	 */
	public static void insertionSort(int[] nums) {
		int length = nums.length;
		for (int i = 1; i < length; i++) {

			int value = nums[i];

			for (int j = i - 1; j >= 0; j--) {
				// 在未排序区间中寻找插入位置, 比当前数大的数都后移一位
				if (nums[j] > value) {
					nums[j + 1] = nums[j];
					if (j == 0) {
						nums[j] = value;
					}
				} else {
					// 找到了插入位置, 插入并出循环
					nums[j + 1] = value;
					break;
				}
			}
		}

		System.out.println(Arrays.toString(nums));
	}


	/**
	 * 4.快速排序
	 */
	public static void quickSort(int[] nums, int start, int end) {

		if (start >= end) {
			return;
		}

		int smallerIndex = start - 1;
		int biggerIndex = end + 1;
		int base = nums[start];

		for (int i = start; i < biggerIndex; i++) {

			if (nums[i] < base) {
				smallerIndex++;
				swap(nums, smallerIndex, i);
			} else if (nums[i] > base) {
				biggerIndex--;
				swap(nums, biggerIndex, i);
				i--;
			}
		}

		quickSort(nums, start, smallerIndex);
		quickSort(nums, biggerIndex, end);
		System.out.println(Arrays.toString(nums));
	}


	public static void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	/**
	 * 5.归并排序
	 * 分治思想, 将一个数组拆分为两个, 直到无法再分
	 * 然后一一返回, 进行合并和排序.
	 * 递归.
	 *
	 * @param nums
	 * @return
	 */
	public static void mergeSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}

		int middle = (start + end) >> 1;
		mergeSort(nums, start, middle);
		mergeSort(nums, middle + 1, end);
		merge(nums, start, middle, end);
		System.out.println(Arrays.toString(nums));
	}

	public static void merge(int[] nums, int start, int middle, int end) {

		int[] helper = new int[end - start + 1];
		int index = 0;
		int left = start;
		int right = middle + 1;

		while (left <= middle && right <= end) {
			if (nums[left] <= nums[right]) {
				helper[index] = nums[left];
				left++;
			} else {
				helper[index] = nums[right];
				right++;
			}
			index++;
		}

		while (left <= middle) {
			helper[index++] = nums[left++];
		}

		while (right <= end) {
			helper[index++] = nums[right++];
		}

		for (int i = 0; i < helper.length; i++) {
			nums[start + i] = helper[i];
		}

	}

	/**
	 * 6.堆排序
	 * 大顶堆
	 *
	 * @param nums
	 * @return
	 */
	public static void heapSort(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			Heap.insertHeap(nums[i]);
		}

		int i = nums.length - 1;
		while (Heap.heapSize > 0) {
			nums[i--] = Heap.poll();
		}

		System.out.println(Arrays.toString(nums));
	}


	/**
	 * 实现一个大顶堆(数组模拟)
	 */
	static class Heap {
		private static int[] heap = new int[100];
		private static int heapSize = 0;

		/**
		 * 插入堆
		 *
		 * @param value
		 */
		public static void insertHeap(int value) {
			//插入堆最后一个节点
			int index = heapSize++;
			heap[index] = value;

			int parentIndex = (index - 1) / 2;
			while (heap[parentIndex] < heap[index]) {
				swap(heap, parentIndex, index);
				index = parentIndex;
				parentIndex = (index - 1) / 2;
			}
		}

		/**
		 * 取出最大值(根节点)
		 *
		 * @return
		 */
		public static int poll() {

			if (heapSize < 1) {
				return -1;
			}

			int result = heap[0];

			//把最后一个节点 当作新的根节点
			heap[0] = heap[--heapSize];

			int index = 0;
			int leftSonIndex = index * 2 + 1;
			int rightSonIndex = index * 2 + 2;

			while (leftSonIndex < heapSize) {
				int maxSonIndex;

				// 如果有右节点 && 右节点大于左节点
				if (rightSonIndex < heapSize && heap[rightSonIndex] > heap[leftSonIndex]) {
					maxSonIndex = rightSonIndex;
				} else {
					maxSonIndex = leftSonIndex;
				}

				// 如果父节点大于子节点, 结束循环
				if (heap[index] >= heap[maxSonIndex]) {
					break;
				}

				swap(heap, index, maxSonIndex);
				index = maxSonIndex;
				leftSonIndex = index * 2 + 1;
				rightSonIndex = index * 2 + 2;
			}

			return result;
		}
	}

}
