package go.kevin;

import java.util.Arrays;

/**
 * leetcode 242
 * @author Tianrui Wang
 * @date 2020-09-11 11:07
 **/
public class Anagram {
	public static void main(String[] args) {

		String s = "anagram";
		String t = "nagaram";
		//System.out.println(isAnagram(s, t));
		System.out.println(isAnagram2(s, t));

	}

	public static boolean isAnagram(String s, String t){

		if (s.length() != t.length()){
			return false;
		}

		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();

		Arrays.sort(sChars);
		Arrays.sort(tChars);

		return Arrays.equals(sChars, tChars);
	}

	public static boolean isAnagram2(String s, String t){
		if (s.length() != t.length()){
			return false;
		}
		int length = s.length();
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();

		int[] hash = new int[26];

		for(int i = 0; i < length; i++){
			hash[ sChars[i] - 'a' ] = hash[ sChars[i] - 'a' ] + 1;
			hash[ tChars[i] - 'a' ] = hash[ tChars[i] - 'a' ] - 1;
		}

		for(int i = 0; i < 26; i++){
			if( hash[i] != 0 ){
				return false;
			}
		}
		return true;
	}

}
