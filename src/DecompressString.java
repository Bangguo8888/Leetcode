/**
 * Created by bangguo on 2018/2/25.
 */
public class DecompressString {
    public String decompress(String input) {
        // Write your solution here
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while(i < input.length()) {
            if (input.charAt(i) != '0') {
                for (int count = 0; count < (int)(input.charAt(i)); count++) {
                    sb.append(input.charAt(i - 1));
                }
            }
            i += 2;
        }
        return new String(sb);
    }

    public static void main (String[] args) {
        String input = new String("x2y0i0z3");
        DecompressString solution = new DecompressString();
        String result = solution.decompress(input);
        System.out.println(result);
    }
}

