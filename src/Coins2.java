/**
 * Created by bangguo on 2018/3/13.
 */
import java.util.*;
public class Coins2 {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here.
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(target, coins, 0, result, temp);
        return result;
    }

    private void dfs(int target, int[] coins, int index, List<List<Integer>> result, List<Integer> temp) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                temp.add(target/coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        for (int i = 0; i <= target / coins[index]; i++) {
            temp.add(i);
            dfs(target - i * coins[index], coins, index + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int target = 5;
        int[] coins = {2,1,3,4};
        Coins2 solution = new Coins2();
        List<List<Integer>> result = solution.combinations(target, coins);
        System.out.println(result);

    }
}

