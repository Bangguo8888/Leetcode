/**
 * Created by bangguo on 2018/3/7.
 */
import java.util.*;
public class TwoSum {
    public List<Pair> findPair(int[] array, int target) {
        List<Pair> result = new ArrayList<>();
        if (array == null || array.length <= 1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer index = map.get(array[i]);
            if (index == null) {
                map.put(target - array[i], i);
            } else {
                result.add(new Pair(array[i],array[index]));
            }
        }
        return result;

    }

    class Pair {
        Integer num1;
        Integer num2;
        public Pair(Integer num1, Integer num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,7,8,9,10};
        int target = 9;
        TwoSum solution = new TwoSum();
        List<Pair> result = solution.findPair(array, target);
        for (Pair pair : result) {
            System.out.println("(" + pair.num1.toString() + "," + pair.num2.toString() + ")\n" );
        }
    }
}
