package go.kevin.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * @author Tianrui Wang
 * @date 2021-09-21 17:48
 **/
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] result = merge(intervals);
		for (int[] nums : result){
			System.out.print(Arrays.toString(nums) + " ");
		}
	}

	public static int[][] merge(int[][] intervals) {

		quickSort(intervals, 0, intervals.length - 1);

		List<int[]> merged = new ArrayList<>();

		for (int i = 0; i < intervals.length; i++){

			int left = intervals[i][0];
			int right = intervals[i][1];

			if (merged.size() == 0){
				merged.add(new int[]{left, right});
				continue;
			}

			int[] pre = merged.get(merged.size() - 1);

			if (pre[1] < left){
				merged.add(new int[]{left, right});
			}else {
				pre[1] = Math.max(pre[1], right);
			}

		}

		return merged.toArray(new int[merged.size()][]);
	}

	private static void quickSort(int[][] intervals, int start, int end){

		if (start >= end){
			return;
		}

		int randomIndex = start + (int) (Math.random() * (end - start + 1));
		int base = intervals[randomIndex][0];

		int smallerIndex = start - 1;
		int biggerIndex = end + 1;
		int left = start;

		while (left < biggerIndex){

			if (intervals[left][0] == base){
				left++;
				continue;
			}

			if (intervals[left][0] < base){
				smallerIndex++;
				swap(intervals, smallerIndex, left);
				left++;
			}else if (intervals[left][0] > base){
				biggerIndex--;
				swap(intervals, biggerIndex, left);

			}
		}

		quickSort(intervals, start, smallerIndex);
		quickSort(intervals, biggerIndex, end);
	}

	private static void swap(int[][] intervals, int a, int b){
		int[] temp = intervals[a];
		intervals[a] = intervals[b];
		intervals[b] = temp;
	}
}
