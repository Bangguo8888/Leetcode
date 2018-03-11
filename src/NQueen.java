/**
 * Created by bangguo on 2018/3/8.
 */
import java.util.*;
public class NQueen {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        List<List<Integer>> result = new ArrayList<>();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        placeQueen(array, 0, result, set1, set2);
        return result;
    }

    private void placeQueen(int[] array, int position, List<List<Integer>> result, Set<Integer> set1, Set<Integer> set2) {
        if (position == array.length) {
            List<Integer> temp = copy(array);
            result.add(temp);
            return;
        }
        for (int i = position; i < array.length; i++) {
            swap(array, position, i);
            if (check(array, position, set1, set2)) {
                placeQueen(array, position + 1, result, set1, set2);
                set1.remove(array[position] + position);
                set2.remove(position - array[position]);
            }
            swap(array, position, i);
        }

    }

    private List<Integer> copy(int[] array) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.length ; i++) {
            temp.add(array[i]);
        }
        return temp;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private boolean check(int[] array, int position, Set set1, Set set2) {
        int sum = position + array[position];
        int diff = position - array[position];
        if (set1.contains(sum) || set2.contains(diff)) {
            return false;
        } else {
            set1.add(sum);
            set2.add(diff);
            return true;
        }

    }

    public static void main(String[] args) {
        int n = 4;
        NQueen solution = new NQueen();
        List<List<Integer>> result = solution.nqueens(n);
    }
}

