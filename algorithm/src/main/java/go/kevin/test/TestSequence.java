package go.kevin.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Tianrui Wang
 * @date 2020-09-10 15:46
 **/
public class TestSequence {
	public static void main(String[] args) {

		int sortSequence = 3;
		int startSequence = sortSequence;


		List<Integer> oldList = new ArrayList<>();
		int test = sortSequence;
		Random random = new Random();
		while (oldList.size() < 10){
			oldList.add(test);
			test = test + random.nextInt(2) + 1;
		}
		System.out.println(oldList);


		int nowSequence = sortSequence;
		int stopIndex = 0;
		for(int i = 0; i < oldList.size(); i++){
			Integer now = oldList.get(i);
			if(now == nowSequence){
				oldList.set(i, now+1>12 ? 9999999 : now+1);
				nowSequence++;
				stopIndex++;
			}else {
				break;
			}
		}
		System.out.println(oldList);

		List<Integer> updateList = new ArrayList<>();
		updateList.add(sortSequence);
		updateList.addAll(oldList.subList(0, stopIndex));
		
		System.out.println(updateList);


	}
}
