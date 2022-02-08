package go.kevin.dp;

/**
 * 198. 打家劫舍
 * @author Tianrui Wang
 * @date 2022-02-08 18:42
 **/
public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		int[] nums2 = {2,7,9,3,1};
		System.out.println(robSimple(nums));
		System.out.println(robSimple(nums2));
	}

	public static int rob(int[] nums) {

		// 状态转移方程 f[i][j]
		// i表示 第几个房间 j表示该房间是否被打劫过 0未打劫 1已打劫
		// f[i][0] = max( f[i-1][0], f[i-1][1] )
		// f[i][1] = f[i-1][0] + nums[i];

		int length = nums.length;
		if (length < 1){
			return 0;
		}else if (length < 2){
			return nums[0];
		}

		int[][] f = new int[length][2];
		f[0][0] = 0;
		f[0][1] = nums[0];

		for (int i = 1; i < length; i++){
			f[i][0] = Math.max( f[i-1][0], f[i-1][1] );
			f[i][1] = f[i-1][0] + nums[i];
		}

		return Math.max(f[length-1][0], f[length-1][1]);
	}

	public static int robSimple(int[] nums) {

		// 状态转移方程
		// f[i] = max(f[i-1], f[i-2] + nums[i])

		int length = nums.length;
		if (length < 1){
			return 0;
		}else if (length < 2){
			return nums[0];
		}

		int[] f = new int[length+1];
		f[0] = 0;
		f[1] = nums[0];

		for (int i = 2; i <= length; i++){
			f[i] = Math.max(f[i-1], (f[i-2] + nums[i-1]) );
		}

		return f[length];
	}
}
