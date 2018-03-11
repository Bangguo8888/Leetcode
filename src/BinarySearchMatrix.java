/**
 * Created by bangguo on 2018/1/30.
 */
import java.util.Arrays;
public class BinarySearchMatrix {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here.
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int r = mid/col;
            int c = mid%col;
            if (matrix[r][c] == target) {
                return new int[] {r,c};
            } else if (matrix[r][c] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int [][] matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
        int target = 1;
        BinarySearchMatrix solution = new BinarySearchMatrix();
        int[] result = solution.search(matrix, target);
        System.out.println(Arrays.toString(result));
    }
}
