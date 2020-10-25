package go.kevin.test;

/**
 * @author Tianrui Wang
 * @date 2020-09-14 19:28
 **/
public class Test2 {

	public static void main(String[] args) {
		int[] nums1 = {1,4,7};
		int[] nums2 = {2,3,9};
		int k = 3;
		System.out.println(findK(nums1, nums2, k));

	}

	//从两个有序整数数组查找第k小的整数
	//有两个升序的整数整数数组a1 、a2，实现一方法从a1、a2中查找第k小的整数并返回。

	public static Integer findK(int[] a1, int[] a2, int k) {

		if(a1.length + a2.length < k){
			return -1;
		}

		if(a1.length < 1){
			return a2[k-1];
		}else if(a2.length < 1){
			return a1[k-1];
		}

		int indexA = 0;
		int indexB = 0;
		int temp = 0;

		for(int i = 0; i < k; i++){
			if(a1[indexA] >= a2[indexB]){
				temp = a2[indexB];
				indexB++;
			}else{
				temp = a1[indexA];
				indexA++;
			}
		}

		return temp;

	}
}
