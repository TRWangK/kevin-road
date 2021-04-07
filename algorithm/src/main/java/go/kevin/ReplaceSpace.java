package go.kevin;

/**
 * 剑指 Offer 05. 替换空格
 * @author Tianrui Wang
 * @date 2021-02-21 19:50
 **/
public class ReplaceSpace {

	/**
	 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
	 */
	public static void main(String[] args) {
		String example = "We are happy.";
		System.out.println(replaceSpace2(example));

	}

	public static String replaceSpace(String s) {
		String str = "%20";
		StringBuffer result = new StringBuffer();
		for (char c : s.toCharArray()){
			if (c == ' '){
				result.append(str);
			}else {
				result.append(c);
			}
		}

		return result.toString();
	}

	public static String replaceSpace2(String s){
		return s.replace(" ", "%20");
	}
}
