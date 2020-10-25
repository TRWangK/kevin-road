package go.kevin;

/**
 * @author Tianrui Wang
 * @date 2020-09-01 17:54
 **/
public class CalculateWinner {

	public static void main(String[] args) {

		int[] nums = {1, 5, 233, 7, 8};
		System.out.println(PredictTheWinner(nums));
	}

	public static boolean PredictTheWinner(int[] nums) {
		return addScore(nums, 0, nums.length - 1) > 0;
	}

	public static int addScore(int[] nums, int left, int right){

		if(left == right){
			return nums[left];
		}

		int leftStartScore = nums[left];
		int leftAfter = addScore(nums, left+1, right);

		int rightStartScore = nums[right];
		int rightAfter = addScore(nums, left, right-1);

		return Math.max(leftStartScore-leftAfter, rightStartScore-rightAfter);
	}
}