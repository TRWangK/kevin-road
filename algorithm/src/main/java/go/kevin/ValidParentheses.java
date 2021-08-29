package go.kevin;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * @author Tianrui Wang
 * @date 2021-08-17 00:13
 **/
public class ValidParentheses {

	public static void main(String[] args) {
		String s = "{[]()}";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {

		Map<Character, Character> map = new HashMap<>();
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');

		Deque<Character> stack = new LinkedList<>();

		for(int i = 0; i < s.length(); i++){
			char x = s.charAt(i);

			//如果是右括号
			if(map.containsKey(x)){
				if (stack.isEmpty() || map.get(x) != stack.pop()){
					return false;
				}
			}else {
				stack.push(x);
			}
		}

		return stack.isEmpty();
	}

}
