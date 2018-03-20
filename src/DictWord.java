/**
 * Created by bangguo on 2018/3/13.
 */
import java.util.HashSet;
public class DictWord {
    public boolean canBreak(String input, String[] dict) {

        HashSet set = getSet(dict);
        boolean[] canBreak = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (set.contains(input.substring(0, i + 1))) {
                canBreak[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && set.contains(input.substring(j + 1, i + 1))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[input.length() - 1];
    }

    private HashSet getSet(String[] dict) {
        HashSet set = new HashSet();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }

    public static void main(String[] args) {
        String input = new String("abcdddef");
        String[] dict = new String[] {"abc","ab","cd","de","def"};
        DictWord solution = new DictWord();
        boolean result = solution.canBreak(input, dict);
        System.out.println(result);
    }
}

