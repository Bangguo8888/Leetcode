/**
 * Created by bangguo on 2018/2/18.
 */
import java.util.*;
public class Subsets {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = set.toCharArray();
        helper2(charArray, 0, sb, result);
        return result;
    }

    private void helper1(char[] charArray, int index, StringBuilder sb, List<String> result) {
        if (index == charArray.length) {
            result.add(sb.toString());
            return;
        }
        helper1(charArray, index + 1, sb, result);
        helper1(charArray, index + 1, sb.append(charArray[index]), result);
        sb.deleteCharAt(sb.length() - 1);
    }

    public void helper2(char[] charArray, int index, StringBuilder sb, List<String> result) {
        result.add(sb.toString());
        if (index == charArray.length) {
            return;
        }
        for (int i = index; i < charArray.length; i++) {
            sb.append(charArray[i]);
            helper2(charArray, i + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = new String("abcd");
        Subsets solution = new Subsets();
        List<String> result = solution.subSets(str);
        System.out.println(result);
    }
}
