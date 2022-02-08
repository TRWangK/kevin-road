package go.kevin.sort;

import java.util.Arrays;

/**
 * 179. 最大数
 * 剑指 Offer 45. 把数组排成最小的数
 * @author Tianrui Wang
 * @date 2021-09-21 19:19
 **/
public class LargestNumber {
	public static void main(String[] args) {
		
		int[] nums = {3,30,34,5,9};
		int[] nums1 = {0,0,0,0,0};
		System.out.println(largestNumber(nums));
		System.out.println(largestNumber(nums1));

	}

	/**
	 * 将数组内元素逐个转化为字符串后，直接通过compareTo方法比较
	 * a.compareTo(b)：它是从头开始比较对应字符的大小(ASCII码顺序)
	 * 如果a的第一个字符和b的第一个字符不等，结束比较，返回他们之间的长度差值
	 * 如果a的第一个字符和b的第一个字符相等，则a的第二个字符和b的第二个字符做比较
	 * 以此类推,直至比较的字符或被比较的字符有一方结束。
	 * @param nums
	 * @return
	 */
	public static String largestNumber(int[] nums) {

		if (nums.length < 1){
			return "0";
		}

		String[] strArray = new String[nums.length];
		for (int i = 0; i < nums.length; i++){
			strArray[i] = nums[i] + "";
		}

		Arrays.sort(strArray, (a, b) -> (b + a).compareTo(a + b));

		if(strArray[0].equals("0")){
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (String s : strArray){
			sb.append(s);
		}

		return sb.toString();
	}

	public static String minNumber(int[] nums) {

		int length = nums.length;
		if (length < 1){
			return "0";
		}

		String[] strArray = new String[length];
		for (int i = 0; i < length; i++) {
			strArray[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strArray, (a, b) -> (a+b).compareTo(b+a));

		StringBuilder sb = new StringBuilder();
		for (String s : strArray){
			sb.append(s);
		}

		return sb.toString();
	}
}
