/**
 * Created by bangguo on 2018/3/31.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        // Write your solution here
        String str = new String("1");
        for (int i = 0 ; i < n; i++) {
            str = say(str);
        }
        return str;
    }

    private String say(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int count = 1;
        char cur = s.charAt(0);
        while (i < s.length()) {
            if (s.charAt(i) != cur) {
                sb.append(count);
                sb.append(cur);
                cur = s.charAt(i);
                count = 1;
                i++;
            } else {
                count++;
                i++;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 9;
        CountAndSay solution = new CountAndSay();
        String str = solution.countAndSay(n);
        System.out.println(str);
    }
}

