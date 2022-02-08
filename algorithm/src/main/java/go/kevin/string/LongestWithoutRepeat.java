package go.kevin.string;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * @author Tianrui Wang
 * @date 2021-09-09 22:45
 **/
public class LongestWithoutRepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(""));
		System.out.println(lengthOfLongestSubstring(" "));
	}

	/**
	 * 滑动窗口
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() < 1){
			return 0;
		}

		HashSet<Character> set = new HashSet<>();
		int max = 0;
		int r = -1;

		for (int i = 0; i < s.length(); i++){

			if (i > 0){
				set.remove(s.charAt(i-1));
			}


			while (r+1 < s.length() && !set.contains(s.charAt(r+1))){
				set.add(s.charAt(r+1));
				r++;
			}

			max = Math.max(max, set.size());
		}
		return max;
	}

}
