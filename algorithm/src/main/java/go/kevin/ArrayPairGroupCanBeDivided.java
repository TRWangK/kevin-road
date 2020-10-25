package go.kevin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianrui Wang
 * @date 2020-09-07 16:31
 **/
public class ArrayPairGroupCanBeDivided {
	public static void main(String[] args) {

		int[] arr = {-1,1,-2,2,-3,3,-4,4};
		solution(arr, 3);

	}

	public static boolean solution(int[] arr, int k){

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : arr){
			int remainder = ( i % k + k ) % k;
			if(map.get(remainder) == null){
				map.put(remainder, 1);
			}else {
				map.put( remainder, map.get(remainder) + 1 );
			}
		}

		for( Map.Entry<Integer, Integer> entry : map.entrySet() ){

			// 余数
			int remainder = entry.getKey();

			// 余数出现次数
			int count = entry.getValue();

			if( remainder > 0 && map.getOrDefault(k - remainder, 0) != count ){
				return false;
			}
		}

		return (map.getOrDefault(0, 0) % 2 == 0);
	}
}
