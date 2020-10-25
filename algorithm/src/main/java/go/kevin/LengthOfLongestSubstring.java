package go.kevin;

import java.util.HashSet;

/**
 * @author Tianrui Wang
 * @date 2020-09-02 16:17
 **/
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring2(s));
	}


	public static int lengthOfLongestSubstring(String s) {

		StringBuffer stringBuffer = new StringBuffer();
		int max = 0;
		char[] charArray = s.toCharArray();

		for( int i = 0; i < charArray.length; i++ ){
			String c = charArray[i] + "";

			if(stringBuffer.indexOf(c) >= 0){
				stringBuffer = stringBuffer.delete(0, stringBuffer.indexOf(c) + 1);
				//stringBuffer = new StringBuffer( stringBuffer.substring(stringBuffer.indexOf(c)) );
			}

			stringBuffer.append(c);
			if(stringBuffer.length() > max){
				max = stringBuffer.length();
			}
		}

		return max;
	}

	public static int lengthOfLongestSubstring2(String s) {

		HashSet<Character> hashSet = new HashSet<>();
		int max = 0;
		int length = s.length();
		int r = -1;

		for( int x = 0; x < length; x++ ){
			if(x != 0){
				hashSet.remove(s.charAt( x-1 ));
			}

			while ( r+1 < length && !hashSet.contains( s.charAt( r+1 ) ) ){
				hashSet.add(s.charAt(r+1));
				r++;
			}

			max = Math.max( max, hashSet.size() );
		}

		return max;
	}


}
