/**
 * Created by bangguo on 2018/1/30.
 */
public class Fibonacci {
    public long fibonacciI(int K) {
        if (K <= 0) {
            return 0;
        } else if (K == 1){
            return 1;
        } else {
            return fibonacciI(K - 1) + fibonacciI(K - 2);
        }
    }

    public long fibonacciII(int K) {
        if (K <= 0){
            return 0;
        }
        long a = 0;
        long b = 1;
        long temp;
        while(K > 1) {
            temp = a + b;
            a = b;
            b = temp;
            K--;
        }
        return b;
    }

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();

        long result = solution.fibonacciI(10);
        System.out.println(result);

        result = solution.fibonacciII(10);
        System.out.println(result);
    }
}
