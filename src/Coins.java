/**
 * Created by bangguo on 2018/2/18.
 */
import java.util.*;
public class Coins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(target, 0, coins, results , cur);
        return results;
    }

    public void helper(int moneyLeft, int level, int[] coins, List<List<Integer>> results, List<Integer> cur ) {
        if (level == coins.length - 1) {
            if (moneyLeft % coins[level] == 0) {
                cur.add(moneyLeft/coins[level]);
                //results.add(new ArrayList<>(cur));
                results.add(cur);
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int branches = moneyLeft / coins[level];
        for (int i = 0; i <= branches; i++) {
            cur.add(i);
            helper(moneyLeft - i * coins[level], level + 1, coins, results, cur);
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String[] args) {
        int target = 10;
        int[] coins = new int[] {1,2,3,5};
        Coins solution = new Coins();
        List<List<Integer>> result = solution.combinations(target, coins);
        System.out.println("kjh");

    }
}
