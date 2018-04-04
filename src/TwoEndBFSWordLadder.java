import java.util.*;

/**
 * Created by bangguo on 2018/3/20.
 */
public class TwoEndBFSWordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        startSet.add(beginWord);
        visited.add(beginWord);
        endSet.add(endWord);
        visited.add(endWord);
        int length = 1;
        while (startSet.size() > 0) {
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            length++;
            Set<String> tempSet = new HashSet<>();
            for (String str : startSet) {
                char[] array = str.toCharArray();
                boolean inEndSet = getNextSet(array, visited, endSet, tempSet, wordSet);
                if (inEndSet) {
                    return length;
                }
            }
            startSet = tempSet;
        }
        return 0;
    }

    private boolean getNextSet(char[] array, Set<String> visited, Set<String> endSet, Set<String> tempSet, Set<String> wordSet) {
        for (int i = 0; i < array.length; i++) {
            char old = array[i];
            for (char c = 'a'; c <= 'z'; c++) {
                array[i] = c;
                String temp = new String(array);
                if (endSet.contains(temp)) {
                    return true;
                }
                if (wordSet.contains(temp) && !visited.contains(temp)) {
                    tempSet.add(temp);
                    visited.add(temp);
                }
            }
            array[i] = old;
        }
        return false;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"));
        //List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dog"));
        TwoEndBFSWordLadder solution = new TwoEndBFSWordLadder();
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);

    }
}
