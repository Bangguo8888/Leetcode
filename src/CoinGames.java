/**
 * Created by bangguo on 2018/3/19.
 */
public class CoinGames {
    public boolean coinGames (int n) {
        if (n == 1 || n == 2) {
            return true;
        }
        boolean[] wins = new boolean[2];
        wins[0] = true;
        wins[1] = true;
        for (int i = 2; i < n; i++) {
            wins[i % 2] = !(wins[(i - 1) % 2] && wins[(i - 2) % 2]);
        }
        return wins[(n - 1) % 2];
    }

    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
        CoinGames solution = new CoinGames();
        for(int i : test) {
            System.out.println("The number of coins " + i + ": " + solution.coinGames(i));

        }

    }
}
