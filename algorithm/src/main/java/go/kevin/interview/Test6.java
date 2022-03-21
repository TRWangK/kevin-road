package go.kevin.interview;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Tianrui Wang
 * @date 2022-03-01 18:25
 **/
public class Test6 {


	static class FooBar {

		private AtomicInteger time = new AtomicInteger(0);

		public void foo() {
			int fooTime = 0;
			for (int i = 0; i < 3; i++) {
				try{
					while (true){
						if (time.get() == fooTime){
							System.out.print("foo");
							fooTime += 2;
							time.incrementAndGet();
							break;
						}
					}
					/*this.notify();
					this.wait();*/
				}catch(Exception e){
				    e.printStackTrace();
				}

			}
		}

		public void bar() {
			int barTime = 1;
			for (int i = 0; i < 3; i++) {
				try{

					while (true){
						if (time.get() == barTime){
							System.out.print("bar");
							barTime += 2;
							time.getAndIncrement();
							break;
						}

					}

					/*this.wait();
					System.out.print("bar");
					this.notify();*/

				}catch(Exception e){
				    e.printStackTrace();
				}
			}
		}

		public FooBar FooBar(){
			return new FooBar();
		}
	}

	public static void main(String[] args) {
		FooBar fooBar = new FooBar();
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {

				fooBar.foo();
			}
		});

		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				fooBar.bar();
			}
		});
		a.start();
		b.start();
	}

	/**
	 *
	 class FooBar {
	 public void foo() {
	     for (int i = 0; i < n; i++) {
	       print("foo");
	     }
	 }

	 public void bar() {
	     for (int i = 0; i < n; i++) {
	       print("bar");
	     }
	 }
	 }
	 两个不同的线程将会共用一个 FooBar 实例：

	 线程 A 将会调用 foo() 方法，而
	 线程 B 将会调用 bar() 方法
	 请设计修改程序，以确保 "foobar" 被输出 n 次。

	 给你一个类：
	 
	 两个不同的线程将会共用一个 FooBar 实例：

	 线程 A 将会调用 foo() 方法，而
	 线程 B 将会调用 bar() 方法
	 请设计修改程序，以确保 "foobar" 被输出 n 次。

	 示例 1：

	 输入：n = 1
	 输出："foobar"
	 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
	 示例 2：

	 输入：n = 2
	 输出："foobarfoobar"
	 解释："foobar" 将被输出两次。
	  

	 提示：

	 1 <= n <= 1000

	 来源：力扣（LeetCode）
	 链接：https://leetcode-cn.com/problems/print-foobar-alternately
	 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

	 */
	
}
