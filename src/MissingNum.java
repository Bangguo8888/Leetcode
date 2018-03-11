/**
 * Created by bangguo on 2018/2/20.
 */
import java.util.HashSet;
public class MissingNum {
    public int missing(int[] array) {
        // Write your solution here
        int n = array.length + 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : array) {
            set.add(i);
        }
        for(int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 100000;
    }
    public static void main(String[] args) {
        int[] array = new int[] {1,3,4};
        MissingNum solution = new MissingNum();
        int result = solution.missing(array);
        System.out.println(result);

    }
}

