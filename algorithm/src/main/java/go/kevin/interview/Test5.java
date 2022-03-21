package go.kevin.interview;

/**
 * @author Tianrui Wang
 * @date 2022-02-28 19:37
 **/
public class Test5 {

	/**
	 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	 *
	 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
	 * 输出：7
	 * 解释：因为路径 1→3→1→1→1 的总和最小。
	 *
	 * 不申请额外空间
	 *
	 * 1 3 1
	 * 1 5 1
	 * 4 2 1
	 *
	 * 1 4 1
	 * 2 5 1
	 * 4 2 1
	 *
	 * 1 4 1
	 * 2 7 1
	 * 4 2 1
	 *
	 *
	 */

	public static void main(String[] args) {

		//数字总和为最小
		//方程
		//f[m][n] =  Min(f[m-1][n], f[m][n-1]) + nums[m][n]

		//初始化



	}

	public static int resolution(int[][] graph){

		int m = graph[0].length;
		int n = graph.length;

		int x = 0;
		int y = 0;

		/**
		 *
		 * 1 3
		 * 3 6
		 * 4 11
		 *
		 * 1 9 9
		 * 1 1 1
		 * 9 9 1
		 *
		 * int[][] f;
		 */
		while (x < m || y < n){

			if (x < m - 1){
				graph[x+1][y] = graph[x][y] + graph[x+1][y];
				x++;
			}
			if (y < n - 1){
				graph[x][y+1] = graph[x][y] + graph[x][y+1];
				y++;
			}

			graph[x][y] = Math.min(graph[x-1][y], graph[x][y-1]) + graph[x][y];
		}

		return graph[m-1][n-1];
	}


}
