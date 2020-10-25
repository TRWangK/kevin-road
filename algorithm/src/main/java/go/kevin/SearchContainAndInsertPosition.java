package go.kevin;

/**
 * leetcode 35
 * @author Tianrui Wang
 * @date 2020-09-08 15:25
 **/
public class SearchContainAndInsertPosition {

	public static void main(String[] args) {

		int[] nums = {1,3,5};
		System.out.println(solution(nums, 4));

	}

	public static int solution(int[] nums, int target){

		if(nums.length < 1){
			return -1;
		}

		int middle = nums.length >> 1;

		if( nums[middle] <= target){
			for(int i = middle; i < nums.length; i++ ){
				if(nums[i] >= target){
					return i;
				}
			}
			return nums.length;
		}else {
			for(int i = middle; i >= 0; i--){
				if( nums[i] == target ){
					return i;
				}else if( nums[i] < target ){
					return i + 1;
				}
			}
			return 0;
		}
	}


}
