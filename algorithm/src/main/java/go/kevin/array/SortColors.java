package go.kevin.array;

import java.util.Arrays;

/**
 * 75. 颜色分类 (荷兰国旗问题)
 * https://www.bilibili.com/video/BV1kQ4y1h7ok?p=3 2.认识O(nlogn)排序 1:44:00
 * @author Tianrui Wang
 * @date 2021-09-12 13:26
 **/
public class SortColors {

	public static void main(String[] args) {

		int[] nums = {2,0,2,1,1,0};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));

	}

	public static void sortColors(int[] nums) {

		if (nums.length <= 1){
			return;
		}

		// 分别维护 小于1区间 和 大于1区间 的 指针
		int smallerIndex = -1;
		int biggerIndex = nums.length;

		for (int i = 0; i < biggerIndex; i++){

			// 小于1的放到 小于区间后第一个, 小于区间右扩;
			if (nums[i] < 1){
				smallerIndex++;
				swap(nums, smallerIndex, i);
			// 大于1的放到 大于区前第一个, 大于区间左扩;
			}else if (nums[i] > 1){
				biggerIndex--;
				swap(nums, biggerIndex, i);
				i--;
			}
			// 等于1的不动
		}

	}

	private static void swap(int[] nums, int index1, int index2){
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
