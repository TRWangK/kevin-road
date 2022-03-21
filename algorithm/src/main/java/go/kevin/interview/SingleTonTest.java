package go.kevin.interview;

/**
 * @author Tianrui Wang
 * @date 2022-03-16 16:18
 **/
public class SingleTonTest {

	private static volatile SingleTonTest singleTontest;

	private SingleTonTest(){}

	public static SingleTonTest getSingleTonTest(){
		if(singleTontest == null){
			synchronized (SingleTonTest.class){
				if(singleTontest == null){
					singleTontest = new SingleTonTest();
					return singleTontest;
				}else {
					return singleTontest;
				}
			}
		}else {
			return singleTontest;
		}
	}

}
