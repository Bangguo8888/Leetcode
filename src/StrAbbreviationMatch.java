/**
 * Created by bangguo on 2018/3/8.
 */
public class StrAbbreviationMatch {
    public boolean match(String input, String pattern) {
        // Write your solution here
        if (input == null && pattern == null) {
            return true;
        }
        if (input == null || pattern == null) {
            return false;
        }
        if (input.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (input.length() == 0 || pattern.length() == 0) {
            return false;
        }

        int i = 0;
        int j = 0;
        while(i < input.length() && j < pattern.length()) {
            char c = pattern.charAt(j);
            if (c < '0' || c >'9') {
                if (c != input.charAt(i)){
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else {
                int count = 0;
                while (j < pattern.length() && pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
                    count = count * 10 + pattern.charAt(j) - '0';
                    j++;
                }
                i += count;
            }
        }
        if (j == pattern.length() && i == input.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String input = new String("iloveyou");
        String pattern = new String("i2ve3");
        StrAbbreviationMatch solution = new StrAbbreviationMatch();
        boolean result = solution.match(input, pattern);
        System.out.println(result);

    }
}

