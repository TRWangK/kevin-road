package go.kevin.string;

/**
 * 5. 最长回文子串
 * @author Tianrui Wang
 * @date 2021-09-21 16:11
 **/
public class LongestPalindromic {

	public static void main(String[] args) {
		String s1 = "babad";
		String s2 = "cbbd";
		String s3 = "a";
		String s4 = "abccccba";
		System.out.println(longestPalindrome2(s1));
		System.out.println(longestPalindrome2(s2));
		System.out.println(longestPalindrome2(s3));
		System.out.println(longestPalindrome2(s4));
	}

	/**
	 * 中心扩散法
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1){
			return "";
		}

		int left, right;
		int maxLength = 0;
		int maxStart = 0;

		for (int i = 0; i < s.length(); i++){

			int length = 1;
			left = i - 1;
			right = i + 1;

			while (left >= 0 && s.charAt(i) == s.charAt(left)){
				left--;
				length++;

			}

			while (right < s.length() && s.charAt(i) == s.charAt(right)){
				right++;
				length++;
			}

			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
				left--;
				right++;
				length+=2;
			}

			if (maxLength < length){
				maxLength = length;
				maxStart = left;
			}
		}

		return s.substring(maxStart + 1, maxStart + maxLength + 1);
	}


	/**
	 * 动态规划
	 * 中心扩散法虽然好理解 但是有多次重复计算.
	 * 通过二维数组 boolean dp[l][r]  记录从l到r这段字符串是否是回文字符串
	 * 相当于减少了很多重复计算
	 *
	 * 状态转移方程:  dp[l][r] = dp[l+1][r-1] && s[l] == s[right];
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		if (s == null || s.length() < 1){
			return "";
		}

		int maxLength = 0;
		int maxStart = 0;
		int maxEnd = 0;

		int strLen = s.length();
		boolean[][] dp = new boolean[strLen][strLen];

		for (int r = 1; r < strLen; r++){

			for (int l = 0; l < r; l++){

				// dp[l][r] = s[l] == s[right] && dp[l+1][r-1];
				if (s.charAt(l) == s.charAt(r) && ( dp[l+1][r-1] || r - l <= 2 )){
					dp[l][r] = true;
					if (r - l > maxLength){
						maxLength = r-l;
						maxStart = l;
						maxEnd = r;
					}
				}
			}

		}

		return s.substring(maxStart, maxEnd+1);
	}
}
