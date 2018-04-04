/**
 * Created by bangguo on 2018/4/1.
 */
import java.util.*;
public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        HashMap<String, Integer> ladder = new HashMap<>();
        ladder.put(beginWord, 0);
        HashMap<String, List<String>> neighbors = new HashMap<>();
        bfs(beginWord, endWord, wordList, ladder, neighbors);
        List<String> temp = new LinkedList<>();
        temp.add(endWord);
        dfs(beginWord, endWord, ladder, neighbors, result, temp);
        return result;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, Integer> ladder, HashMap<String, List<String>> neighbors) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 0;
        boolean found = false;
        ladder.put(beginWord, level);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                level = ladder.get(cur);
                List<String> candidates = generate(cur, wordList);
                for (String newWord : candidates) {
                    if (newWord.equals(endWord)) {
                        found = true;
                    }
                    List<String> list = neighbors.get(newWord);
                    if (list == null) {
                        list = new LinkedList<String>();
                    }
                    list.add(cur);
                    neighbors.put(newWord, list);

                    Integer step = ladder.get(newWord);
                    if (step == null) {
                        q.offer(newWord);
                    }
                    if (step == null || step > level + 1) {
                        ladder.put(newWord, level + 1);
                    }
                }
            }
            if (found) {
                break;
            }
        }
    }

    private void dfs(String beginWord, String endWord, HashMap<String, Integer> ladder, HashMap<String, List<String>> neighbors, List<List<String>> result, List<String> temp) {
        if (endWord.equals(beginWord)) {
            result.add(new LinkedList<String>(temp));
            return;
        }
        Integer cur_level = ladder.get(endWord);
        List<String> nei = neighbors.get(endWord);
        if (nei != null && !nei.isEmpty()) {
            for (String s : nei) {
                if (ladder.get(s) == cur_level - 1) {
                    temp.add(0, s);
                    dfs(beginWord, s, ladder, neighbors, result, temp);
                    temp.remove(0);
                }
            }
        }
    }

    private List<String> generate(String cur, List<String> wordList) {
        StringBuilder sb = new StringBuilder(cur);
        List<String> candidates = new LinkedList<String>();
        for (int i = 0; i < cur.length(); i++) {
            char old = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (wordList.contains(newWord)) {
                    candidates.add(newWord);
                }
            }
            sb.setCharAt(i, old);
        }
        return candidates;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        WordLadder2 solution = new WordLadder2();
        List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(result);

    }
}
