package go.kevin;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;

/**
 * leetcode 401
 * @author Tianrui Wang
 * @date 2020-09-08 14:20
 **/
public class BinaryWatch {

	public static void main(String[] args) {
		
		System.out.println(allPossibility(1));

	}

	public static List<String> result = new LinkedList<>();

	public static List<String> allPossibility(int lightingNum){
		if(lightingNum > 10){
			return null;
		}
		result.clear();
		backTracing(lightingNum, 0, 0, 1, 1, new ArrayDeque(), new ArrayDeque());
		return result;
	}

	public static void backTracing(int lightingNum, int hour, int minute, int hourIndex, int minuteIndex,  Deque hours, Deque minutes){

		if(hours.size() + minutes.size() == lightingNum){
			if(hour <= 11 && minute <= 59){
				result.add(String.format("%d:%02d", hour, minute));
			}
			return;
		}

		for(int i = hourIndex; i <= 8; i = i << 1){
			hours.addLast(hour + i);
			backTracing(lightingNum, hour + i, minute, i << 1, minuteIndex, hours, minutes);
			hours.removeLast();
		}

		for(int i = minuteIndex; i <= 32; i = i << 1){
			minutes.addLast(minute + i);
			backTracing(lightingNum, hour, minute+i, 16, i << 1, hours, minutes);
			minutes.removeLast();
		}
	}
}
