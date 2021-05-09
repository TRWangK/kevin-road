package go.kevin.sword;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * @author Tianrui Wang
 * @date 2021-03-03 00:09
 **/
public class MinRotationArray {
	/**
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如，[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1
	 * @param args
	 */
	public static void main(String[] args) {
		int[] example1 = {3,4,5,1,2};
		int[] example2 = {2,2,2,0,1};
		System.out.println(minArray(example1));
		System.out.println(minArray(example2));
	}

	/**
	 * 二分查找
	 * @param numbers
	 * @return
	 */
	public static int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right){
			int pivot = (left + right) / 2;

			if (numbers[pivot] < numbers[right]){
				right = pivot;
			} else if (numbers[pivot] > numbers[right]){
				left = pivot + 1;
			} else {
				right -= 1;
			}
		}

		return numbers[left];
	}
}
