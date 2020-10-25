package go.kevin;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Tianrui Wang
 * @date 2020-09-16 20:23
 **/
public class LinkedListLRU {
	private static final int MAX_SIZE = 6;
	private static final LinkedList<Integer> list = new LinkedList();

	public static void main(String[] args) {
		Integer[] example = {1,2,3,4,5,6};
		list.addAll(Arrays.asList(example));
		
		System.out.println( get(3) );
		System.out.println(list);
		System.out.println( add(7) );
		System.out.println(list);
	}

	public static synchronized Integer get(Integer data){
		int size = list.size();
		for(int i = 0; i < size; i++){
			if( data.equals(list.get(i)) ){
				Integer temp = list.get(i);
				list.remove(list.get(i));
				list.addFirst(temp);
				return temp;
			}
		}
		return -1;
	}
	public static synchronized boolean add(Integer data){
		if(data == null){
			return false;
		}
		if(list.size() >= MAX_SIZE){
			list.removeLast();
		}
		list.addFirst(data);
		return true;
	}

}
