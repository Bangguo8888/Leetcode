/**
 * Created by bangguo on 2018/3/16.
 */
public class RomeToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int pre = getDigit(s.charAt(0));
        int total = pre;
        for (int i = 1; i < s.length(); i++) {
            int current = getDigit(s.charAt(i));
            if (pre >= current) {
                total += current;
            } else {
                total += current - 2 * pre;
            }
            pre = current;
        }
        return total;
    }

    private int getDigit(Character c) {
        int data = 0;
        switch (c) {
            case 'I':
                data = 1;
                break;
            case 'V':
                data = 5;
                break;
            case 'X':
                data = 10;
                break;
            case 'L':
                data = 50;
                break;
            case 'C':
                data = 100;
                break;
            case 'D':
                data = 500;
                break;
            case 'M':
                data = 1000;
                break;
        }
        return data;
    }
}

