package go.kevin.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author Tianrui Wang
 * @date 2020-09-09 15:26
 **/
public class TestStream {
	public static void main(String[] args) {
		Integer[] array = {3,2,9,9,4,7,6,5,5,8,1};
		List<Integer> list = new ArrayList<>(Arrays.asList(array));

		list = list.stream()
				.filter( x -> x>4 )
				.distinct()
				.sorted( (x1,x2) -> x1 - x2)
				.map( x -> x*x)
				.limit(3)
				.collect(Collectors.toList());

		System.out.println(list);

		/*ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.tryLock();
		lock.unlock();

		AtomicInteger num = new AtomicInteger();
		num.compareAndSet(1, 2);

		Semaphore semaphore = new Semaphore(3);
		semaphore.acquire();*/

	}
}
