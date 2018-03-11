/**
 * Created by bangguo on 2018/2/25.
 */
import java.util.ArrayList;
public class StringReplace {
    public String replace(String input, String s, String t) {
        if (input == null || input.length() < s.length()) {
            return input;
        }
        char[] array = input.toCharArray();
        String result;
        if (t.length() <= s.length()) {
            result = replaceShorter(array, s, t);
        } else {
            result = replaceLonger(array, s, t);
        }
        return result;
    }

    private String replaceShorter(char[] array, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (fast <= array.length - s.length() && equalString(array, fast, s)) {
                replaceSub(array, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                array[slow++] = array[fast++];
            }
        }
        return new String(array,0, slow);
    }

    public String replaceLonger(char[] array, String s, String t) {
        ArrayList<Integer> endIndex = findIndex(array, s);
        char[] resultArray = new char[array.length + endIndex.size() * (t.length() - s.length())];
        int slow = resultArray.length - 1;
        int fast = array.length - 1;
        int recordIndex = endIndex.size() - 1;
        while (fast >=0) {
            if (recordIndex < 0 || fast != endIndex.get(recordIndex)) {
                resultArray[slow--] = array[fast--];
            } else {
                replaceSub(resultArray, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                recordIndex--;
            }
        }
        return new String(resultArray);

    }

    private ArrayList<Integer> findIndex(char[] array, String s) {
        ArrayList<Integer> endIndex = new ArrayList<Integer>();
        int i = 0;
        while (i <= array.length - s.length()) {
            if (equalString(array, i, s)) {
                endIndex.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return endIndex;

    }

    private void replaceSub(char[] array, int index, String t) {
        for (int i = 0; i < t.length(); i++) {
            array[index + i] = t.charAt(i);
        }
    }

    private boolean equalString(char[] array, int index, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (array[index + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = new String("aaa");
        String s = "aa";
        String t = "bbb";
        StringReplace solution = new StringReplace();
        String result = solution.replace(input, s, t);
        System.out.println(result);
    }
}
