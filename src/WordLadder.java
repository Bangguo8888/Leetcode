/**
 * Created by bangguo on 2018/3/20.
 */
import java.util.*;
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }
        if (endWord.equals(beginWord)) {
            return length;
        }
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            length += 1;
            for (int i = 0 ; i < size; i++) {
                String cur = queue.poll();
                boolean hasEndWord = getNextString(cur, wordSet, visited, queue, endWord);
                if (hasEndWord) {
                    return length;
                }
            }
        }
        return 0;
    }

    private boolean getNextString(String cur, Set<String> wordSet, Set<String> visited, Queue<String> queue, String endWord) {
        char[] array = cur.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char old  = array[i];
            for (char c = 'a'; c <= 'z'; c++) {
                array[i] = c;
                String temp = new String(array);
                if (wordSet.contains(temp)) {
                    if (temp.equals(endWord)) {
                        return true;
                    }

                    if (wordSet.contains(temp) && !visited.contains(temp)) {
                        visited.add(temp);
                        queue.offer(temp);
                    }
                }

            }
            array[i] = old;
        }
        return false;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        WordLadder solution = new WordLadder();
        int result = solution.ladderLength(beginWord, endWord, wordList);

    }
}

