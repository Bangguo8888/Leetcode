/**
 * Created by bangguo on 2018/1/30.
 */
import java.util.Arrays;
public class Kcloset {
    public int[] kClosest(int[] array, int target, int k) {
        if (k == 0 || array == null || array.length == 0) {
            return new int[] {};
        }
        int left = 0;
        int right = array.length - 1;
        int closet;
        int[] result = new int[k];
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            closet = left;
        } else {
            closet = right;
        }
        result[0] = array[closet];
        left = closet - 1;
        right = closet + 1;

        int current = 1;
        while (current < k){
            if (left < 0) {
                result[current++] =  array[right++];
            } else if (right > array.length - 1) {
                result[current++] = array[left--];
            } else{
                if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                    result[current++] = array[left--];
                } else {
                    result[current++] = array[right++];
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,4,6,8};
        int target = 3;
        int k = 3;
        Kcloset solution = new Kcloset();
        int[] result = solution.kClosest(array, target, k);
        System.out.println(Arrays.toString(result));
    }

}
