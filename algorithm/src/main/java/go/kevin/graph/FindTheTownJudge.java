package go.kevin.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 997. 找到小镇的法官
 * @author Tianrui Wang
 * @date 2021-05-09 16:08
 **/
public class FindTheTownJudge {

	public static void main(String[] args) {

		int n = 1;
		int[] a = {1,3};
		int[] b = {1,4};
		int[] c = {2,3};
		int[] d = {2,4};
		int[] e = {4,3};
		//int[][] trust = {a, b, c, d, e};
		int[][] trust = new int[0][0];

		System.out.println(findJudge(n, trust));
	}

	/**
	 * 用两个数组存储 1.每个人信任他人的次数 2.每个人被信任的次数
	 * @param N
	 * @param trust
	 * @return
	 */
	public static int findJudge(int N, int[][] trust) {
		if (N == 0){
			return -1;
		}

		int[] trustOther = new int[N + 1];
		int[] trustedCount = new int[N + 1];

		for (int[] trustPair : trust){
			trustOther[trustPair[0]] += 1;
			trustedCount[trustPair[1]] += 1;
		}

		for (int i = 1; i <= N; i++){
			if (trustOther[i] == 0 && trustedCount[i] == N - 1){
				return i;
			}
		}

		return -1;
	}

	/**
	 * 出度: 每个人信任他人的次数 入度: 每个人被信任的次数
	 *
	 * 法官: 出度 = 0, 入度 = n-1, 出度入度之和为 n-1
	 * 平民: 出度 >= 0, 入度 <= n-1, 但不会同时满足0和n-1, 因此出度入度之和无论如何都 < n-1
	 *
	 * 因此可以用一个数据来 记录每个人的出度入度之和
	 *
	 * @param N
	 * @param trust
	 * @return
	 */
	public static int findJudge2(int N, int[][] trust) {
		int[] cnt = new int[N+1];

		for (int[] trustPair : trust){
			cnt[trustPair[0]] -= 1;
			cnt[trustPair[1]] += 1;
		}

		for (int i = 1; i <= N; ++i) {
			if (cnt[i] == N-1) {
				return i;
			}
		}

		return -1;
	}
}
