/**
 * Created by bangguo on 2018/3/17.
 */
import java.util.*;
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null) {
            return result;
        }
        char[] array = S.toCharArray();
        letterCasePermutation(array, 0, result);
        return result;
    }

    private void letterCasePermutation(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        if (array[index] >= '0' && array[index] <= '9') {
            letterCasePermutation(array, index + 1, result);
        } else {
            letterCasePermutation(array, index + 1, result);
            char c = array[index];
            if (c >= 'A' && c <= 'Z') {
                array[index] = (char)(c + 'a' - 'A');
                letterCasePermutation(array, index + 1, result);
                array[index] = c;
            } else {
                array[index] = (char)(c + 'A' - 'a');
                letterCasePermutation(array, index + 1, result);
                array[index] = c;
            }
        }
    }
}

