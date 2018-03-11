/**
 * Created by bangguo on 2018/2/18.
 */
import java.util.*;
public class Permutation {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] charArray = set.toCharArray();

        helper(charArray, 0, result);
        return result;
    }

    private void helper(char[] charArray, int index, List<String> result) {
        if (index == charArray.length - 1) {
            result.add(new String(charArray));
            return;
        }
        for (int i = index; i < charArray.length; i ++) {
            swap(charArray, index, i);
            helper(charArray, index + 1, result);
            swap(charArray, index, i);
        }

    }

    private void swap(char[] charArray, int left, int right) {
        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;
    }

    public static void main(String[] args) {
        String str = new String("abcde");
        Permutation solution = new Permutation();
        List<String> result = solution.permutations(str);
    }
}
