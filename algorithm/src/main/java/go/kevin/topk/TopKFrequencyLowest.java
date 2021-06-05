package go.kevin.topk;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @author Tianrui Wang
 * @date 2021-02-18 22:06
 **/
public class TopKFrequencyLowest {


	public static void main(String[] args) {
		int[] examples = {3,4,3,3};
		int[] examples2 = {9,1,7,9,7,9,7};
		System.out.println( singleNumber(examples2) );
	}

	/**
	 *  题干: 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
	 *  题解: 若一个数字出现了3次, 那么他的二进制位中的0和1也必然出现了3次, 那么将二进制位累加起来, 每一位都可以被3整除.
	 *  	因此在有一个数字只出现了一次的情况下, 将所有数字的二进制位每一位累加后取余, 所获得的二进制数字就是那个只出现一次的数字.
	 */
	public static int singleNumber(int[] nums){
		if (nums.length < 1){
			return -1;
		}
		int result = 0;
		int[] bitSum = new int[32];
		for (int num : nums){
			int bitMask = 1;
			for(int i = 31; i >=0; i--){

				/**
				 * 当bitMask=1时 其二进制为 0001
				 *  因此若num & bitMask != 0 说明二者必有一位都为1
				 *  而已知bitMask只有一位为1 则证明num在该位上也为1
				 */
				if((num & bitMask) != 0){
					bitSum[i] = bitSum[i] + 1;
				}

				// bitMask左移一位, 右侧补零 保证二进制中只有一个1
				bitMask = bitMask << 1;
			}
		}

		for (int i = 0; i < 32; i++){
			result = result << 1;
			result += bitSum[i] % 3;
		}

		return result;
	}
}
