/**
 * Created by bangguo on 2018/2/18.
 */
import java.util.*;
public class Permutation2 {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add(new String(""));
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(n,n,sb,result);
        return result;
    }

    private void helper(int l, int r, StringBuilder sb, List<String> result) {
        if (l == 0 && r == 0) {
            result.add(new String(sb));
            return ;
        }
        if (l > 0) {
            sb.append('(');
            helper(l - 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r > 0 && r > l) {
            sb.append(')');
            helper(l, r - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 4;
        Permutation2 solution = new Permutation2();
        List<String> result = solution.validParentheses(k);


    }
}
