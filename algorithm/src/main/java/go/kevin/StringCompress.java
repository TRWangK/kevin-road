package go.kevin;

/**
 * @author Tianrui Wang
 * @date 2020-09-08 18:35
 **/
public class StringCompress {

	public static void main(String[] args) {
		
		System.out.println(solution("aabcccccaaa"));

	}

	public static String solution( String s ){

		if(s == null || s.length() < 1){
			return "";
		}

		char[] chars = s.toCharArray();
		StringBuffer result = new StringBuffer();

		int count = 1;
		char temp = chars[0];
		for(int i = 1; i < chars.length; i++){
			if(chars[i] == temp){
				count++;
			}else {
				result.append(temp).append(count);
				count = 1;
				temp = chars[i];
			}
		}

		result.append(temp).append(count);

		return result.length() >= s.length() ? s : result.toString();
	}

}
