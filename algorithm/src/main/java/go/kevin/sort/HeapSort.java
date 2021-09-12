package go.kevin.sort;

import java.util.Arrays;

/**
 * 堆排序
 * https://www.bilibili.com/video/BV1kQ4y1h7ok?p=4  3.详解桶排序
 * @author Tianrui Wang
 * @date 2021-09-12 15:08
 **/
public class HeapSort {

	public static void main(String[] args) {

		Heap.insertHeap(3);
		Heap.insertHeap(5);
		Heap.insertHeap(2);
		Heap.insertHeap(4);
		Heap.insertHeap(7);
		System.out.println(Arrays.toString(Heap.heapArray));

		Heap.poll();
		System.out.println(Arrays.toString(Heap.heapArray));

		int[] nums = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		heapSort(nums);

	}

	/**
	 * 堆 = 完全二叉树
	 * 大根堆: 每棵子树的根结点 都是该树的最大值
	 * 小根堆: 每棵子树的根结点 都是该树的最小值
	 * @param nums
	 */
	public static void heapSort(int[] nums){

		// 模拟用户一个个插入数据 构建一个大根堆
		int heapSize = 0;
		for (int i = 0; i < nums.length; i++){

			int index = heapSize;
			heapSize++;

			int parent = (index - 1) / 2;
			while (nums[index] > nums[parent]){
				swap(nums, index, parent);
				index = parent;
				parent = (index - 1) / 2;
			}
		}
		System.out.println("构建大顶堆: " + Arrays.toString(nums) + ", heapSize: " + heapSize);

		while (heapSize > 0){

			// 1.交换 当前堆顶最大值 和 最后一个节点, 使得当前整个堆的最大值来到了数组最后一位, 堆大小-1, 忽视这个节点.
			swap(nums, --heapSize, 0);

			// 2.恢复当前的大顶堆, 使得堆顶又是当前堆的最大值, 重复第一步.
			int index = 0;
			int leftSon = index * 2 + 1;
			int rightSon = index * 2 + 2;

			while (leftSon < heapSize){

				int maxSon = rightSon < heapSize && nums[rightSon] > nums[leftSon] ? rightSon : leftSon;

				if (nums[maxSon] <= nums[index]){
					break;
				}

				swap(nums, maxSon, index);
				index = maxSon;
				leftSon = index * 2 + 1;
				rightSon = index * 2 + 2;
			}

		}
		System.out.println("堆排序结果: " + Arrays.toString(nums));

	}

	private static void swap(int[] nums, int index1, int index2){
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}


	/**
	 * 大顶堆
	 */
	static class Heap{

		private static int[] heapArray = new int[10];
		private static int heapSize = 0;

		/**
		 * 插入 logn
		 * @param num
		 */
		private static void insertHeap(int num){
			int index = heapSize++;
			heapArray[index] = num;

			// 当前节点的父节点 = (index - 1) / 2
			int parent = (index-1) / 2;
			while ( heapArray[index] > heapArray[parent] ){
				swap(heapArray, index, parent);
				index = parent;
				parent = (index-1) / 2;
			}
		}

		/**
		 * 移除并获取堆顶 logn
		 * @return
		 */
		private static int poll(){
			int result = heapArray[0];

			//把完全二叉树最后一个节点 拿上来 当作新的堆顶根结点
			heapArray[0] = heapArray[--heapSize];

			// 当前节点的左子节点 = index * 2 + 1;
			// 当前节点的右子节点 = index * 2 + 2;
			int index = 0;
			int leftSon = index * 2 + 1;
			int rightSon = index * 2 + 2;

			//当还有子节点的时候
			while (leftSon < heapSize){

				// 判断有没有右子节点 并获取最大的子节点
				int maxSon = rightSon < heapSize && heapArray[rightSon] > heapArray[leftSon] ? rightSon : leftSon;

				// 没有更大的子节点了 不用再置换了
				if (heapArray[maxSon] <= heapArray[index]){
					break;
				}

				swap(heapArray, maxSon, index);
				index = maxSon;
				leftSon = index * 2 + 1;
				rightSon = index * 2 + 2;

			}

			return result;
		}

	}

}
