package go.kevin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author Tianrui Wang
 * @date 2021-09-09 23:27
 **/
public class SumThree {

	public static void main(String[] args) {
		int[] arg = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(arg));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums.length <= 2){
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++){

			// 有序数组, 第一个值>0 后面的值不可能小于0了
			if (nums[i] > 0){
				break;
			}

			// 去除重复情况
			if (i > 0 && nums[i] == nums[i-1]){
				continue;
			}

			int left = i + 1;
			int right = nums.length - 1;
			int target = -nums[i];

			while (left < right){

				if (nums[left] + nums[right] == target){
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					left++;
					right--;

					// 去除重复情况
					while (left < right && nums[left] == nums[left - 1]) left++;
					while (left < right && nums[right] == nums[right + 1]) right--;

				}else if (nums[left] + nums[right] < target){
					left++;
				}else {
					right--;
				}

			}

		}

		return result;
	}


}
