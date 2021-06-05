package go.kevin.sword;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * @author Tianrui Wang
 * @date 2021-02-19 22:29
 **/
public class RepeatNumber {

	/**
	 *  在一个长度为 n 的数组
	 *  nums 里的所有数字都在 0～n-1 的范围内。
	 *  数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		int[] examples = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNumber(examples));
	}

	/**
	 * 解法一: 遍历 Set存储, 已存在直接返回
	 * 解法二: 原地置换, 为每一个萝卜找到他的坑, 如果重复, 返回
	 * @param nums
	 * @return
	 */
	public static int findRepeatNumber(int[] nums) {
		if (nums.length < 1){
			return -1;
		}

		int temp;
		for (int i = 0; i < nums.length; i++){
			// 如果当前坑位存的不是对应的萝卜
			while (nums[i] != i){

				// 判断这跟萝卜应该在的位置是不是已经有了对的萝卜
				if (nums[ nums[i] ] == nums[i]){
					return nums[i];
				}

				temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}

		return -1;
	}
}
