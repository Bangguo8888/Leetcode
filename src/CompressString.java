/**
 * Created by bangguo on 2018/4/4.
 */
public class CompressString {
    public String compress(String input) {
        // Write your solution here
        if(input == null || input.length() < 2) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0;
        int j = 1;
        int count = 1;
        char cur = input.charAt(0);
        while (j < array.length) {
            if (array[j] == cur) {
                count++;
            } else {
                if (count == 1) {
                    array[i++] = cur;
                } else {
                    array[i++] = cur;
                    array[i++] = (char)('0' + count);
                }
                count = 1;
                cur = array[j];
            }
            j++;
        }
        array[i++] = cur;
        if (count > 1) {
            array[i++] = (char)('0' + count);
        }
        return new String(array, 0 , i);
    }

    public static void main(String[] args) {
        String str = new String("aabcccffffeeghiiikkk");
        CompressString solution = new CompressString();
        String result = solution.compress(str);
        System.out.println(result);
    }
}
