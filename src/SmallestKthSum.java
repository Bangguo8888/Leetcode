/**
 * Created by bangguo on 2018/3/24.
 */
import java.util.*;
public class SmallestKthSum {
    public int findSmallestKthSum(int[] a, int[] b, int k) {
        Queue<Node> minHeap = new PriorityQueue(a.length + b.length, new Comparator<Node>() {
            @Override
            public int compare(Node one, Node two) {
                if (one.val == two.val) {
                    return 0;
                } else {
                    return one.val < two.val ? -1 : 1;
                }
            }
        });
        Node cur = new Node(0, 0, a[0] + b[0]);
        minHeap.offer(cur);
        while (!minHeap.isEmpty() && k > 0) {
            cur = minHeap.poll();
            System.out.println(Arrays.asList(cur.row, cur.col, a[cur.row] + b[cur.col]));
            k--;
            if (cur.row + 1 < a.length) {
                minHeap.offer(new Node(cur.row + 1, cur.col, a[cur.row + 1] + b[cur.col]));
            }
            if (cur.col + 1 < b.length) {
                minHeap.offer(new Node(cur.row, cur.col + 1, a[cur.row] + b[cur.col + 1]));
            }
        }
        return cur.val;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,3,4,6,8,12,16};
        int[] b = new int[] {2,4,7,8,9,10,14};
        SmallestKthSum solution = new SmallestKthSum();
        int result = solution.findSmallestKthSum(a,b,10);
        System.out.println(result);

    }
}