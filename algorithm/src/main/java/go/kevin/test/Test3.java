package go.kevin.test;

import java.util.Stack;

/**
 * @author Tianrui Wang
 * @date 2020-09-23 20:20
 **/
public class Test3 {
	public static void main(String[] args) {
		/**
		 * a-z .
		 * abc...d.e..fgh
		 * 字符串反转  block不反转
		 */

		String example = "abc...d.e..fgh";
		//String example = "abcdef";
		//String example = ".....";
		System.out.println(solution(example));

	}

	public static String solution(String str){

		if(str == null || str.length() == 0){
			return null;
		}

		StringBuffer stringBuffer = new StringBuffer();
		Stack<Character> stack = new Stack<>();

		char[] chars = str.toCharArray();

		for( int i = chars.length - 1; i >= 0; i-- ){
			if( chars[i] == '.'){
				while (!stack.isEmpty()){
					stringBuffer.append(stack.pop());
				}
				stringBuffer.append(chars[i]);
			}else if( chars[i] != '.'){
				stack.push(chars[i]);
			}
		}

		while (!stack.isEmpty()){
			stringBuffer.append(stack.pop());
		}

		return stringBuffer.toString();
	}
}
