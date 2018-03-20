/**
 * Created by bangguo on 2018/3/19.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n > 2 && k <= 1) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int[] ways = new int[2];
        ways[0] = k;
        ways[1] = k * k;
        for (int i = 2; i < n; i++) {
            ways[i % 2] = (k - 1) * ways[(i - 1) % 2] + (k - 1) * ways[(i - 2) % 2];
        }
        return ways[(n - 1) % 2];
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        PaintFence solution = new PaintFence();
        int result = solution.numWays(n, k);
        System.out.println(result);
    }
}
