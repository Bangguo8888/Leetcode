/**
 * Created by bangguo on 2018/2/14.
 */
import java.util.PriorityQueue;
import java.util.Comparator;
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                } else {
                    return c1.value < c2.value ? -1 : 1;
                }
            }
        });

        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Cell curCell = minHeap.poll();
            if (curCell.row + 1 < rows && !visited[curCell.row + 1][curCell.col]) {
                minHeap.offer(new Cell(curCell.row + 1,curCell.col,matrix[curCell.row + 1][curCell.col]));
                visited[curCell.row + 1][curCell.col] = true;
            }
            if (curCell.col + 1 < cols && !visited[curCell.row][curCell.col + 1]) {
                minHeap.offer(new Cell(curCell.row,curCell.col + 1,matrix[curCell.row][curCell.col + 1]));
                visited[curCell.row][curCell.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    static class Cell {
        int value;
        int row;
        int col;
        Cell(int row, int col, int value) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
        int k = 16;
        KthSmallest solution = new KthSmallest();
        int result = solution.kthSmallest(matrix,k);
        System.out.println(result);

    }
}
