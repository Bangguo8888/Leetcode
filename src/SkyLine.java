/**
 * Created by bangguo on 2018/3/31.
 */
import java.util.*;
public class SkyLine {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] building : buildings) {
            buildingPoints.add(new int[] {building[0], -building[2]});
            buildingPoints.add(new int[] {building[1], building[2]});
        }
        Collections.sort(buildingPoints, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);
        int preMax = 0;
        List<int[]> result = new ArrayList<>();
        for (int[] b : buildingPoints) {
            if (b[1] < 0) {
                maxHeap.add(-b[1]);
            } else {
                maxHeap.remove(b[1]);
            }
            int curHight = maxHeap.peek();
            if (curHight != preMax) {
                result.add(new int[] {b[0], curHight});
                preMax = curHight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] b = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        SkyLine solution = new SkyLine();
        List<int[]> result = solution.getSkyline(b);
        System.out.println(result);
    }
}
