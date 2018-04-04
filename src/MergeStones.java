/**
 * Created by bangguo on 2018/4/3.
 */
public class MergeStones {
    public int minCost(int[] stones) {
        // Write your solution here
        int[][] min = new int[stones.length][stones.length];
        int[][] subSum = new int[stones.length][stones.length];
        for (int j = 0; j < stones.length; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    subSum[i][j] = stones[j];
                    min[i][j] = 0;
                } else {
                    subSum[i][j] = subSum[i][j - 1] + stones[j];
                    min[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j] + subSum[i][j]);
                    }
                }
            }
        }
        return min[0][stones.length - 1];
    }

    public static void main(String[] args) {
        int[] stones = new int[] {4,2,2,2,4};
        MergeStones solution = new MergeStones();
        int result = solution.minCost(stones);
        System.out.println(result);
    }
}
