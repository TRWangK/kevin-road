package go.kevin.sword;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * @author Tianrui Wang
 * @date 2021-02-20 21:43
 **/
public class FindNumberIn2DArray {
	public static void main(String[] args) {

		int[][] examples = new int[5][5];
		examples[0] = new int[]{1,	4,	7,	11,	15};
		examples[1] = new int[]{2,	5,	8,	12,	19};
		examples[2] = new int[]{3,	6,	9, 	16, 22};
		examples[3] = new int[]{10,	13,	14, 17, 24};
		examples[4] = new int[]{18,	21, 23, 26, 30};
		System.out.println(findNumberIn2DArray(examples, 5));
	}

	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length ){
			return false;
		}

		int yLength = matrix.length;
		int xLength = matrix[0].length;

		// 从右上角出发, 向左走减小 向下走增大
		int x = xLength - 1;
		int y = 0;

		while (y < yLength && x >= 0){
			if (matrix[x][y] == target) {
				return true;
			}else if (matrix[x][y] < target){
				y++;
			}else {
				x--;
			}
		}

		return false;
	}

}
