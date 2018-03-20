/**
 * Created by bangguo on 2018/3/16.
 */
public class isPalinrome {
    public boolean isPalindrome(int x) {
        int originalX = x;
        if (x < 0) {
            return false;
        } else if (x >= 10 && x % 10 == 0) {
            return false;
        }
        int newx = 0;
        while (x != 0) {
            newx = newx * 10 + x % 10;
            x /= 10;
        }
        if (newx == originalX) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x >=10 && x % 10 == 0)) {
            return false;
        }
        int slow = x;
        int fast = x;
        int reverseHalf = 0;
        while(fast != 0) {
            reverseHalf = reverseHalf * 10 + slow % 10;
            slow /= 10;
            fast /= 100;
        }
        return slow == reverseHalf || slow == reverseHalf / 10;

    }

    public static void main(String[] args) {
        isPalinrome solution = new isPalinrome();

        System.out.println(solution.isPalindrome(1221));
        System.out.println(solution.isPalindrome2(1221));

        System.out.println(solution.isPalindrome(12321));
        System.out.println(solution.isPalindrome2(12321));

        System.out.println(solution.isPalindrome(4));
        System.out.println(solution.isPalindrome2(4));

        System.out.println(solution.isPalindrome(41221));
        System.out.println(solution.isPalindrome2(41221));


    }
}

