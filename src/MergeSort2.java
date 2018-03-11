/**
 * Created by bangguo on 2018/2/25.
 */
public class MergeSort2 {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        if (array == null || array.length < 2) {
            return array;
        }
        int[] result = helper(array, 0, array.length - 1);
        return result;
    }

    private int[] helper(int[] array, int left, int right) {
        if (left == right) {
            return new int[] {array[left]};
        }
        int mid = left + (right - left)/2;
        int[] result1 = helper(array, left, mid);
        int[] result2 = helper(array, mid + 1, right);
        int[] result = merge(result1, result2);
        return result;
    }

    private int[] merge(int[] result1, int[] result2) {
        int i = 0;
        int j = 0;
        int cur = 0;
        int[] result = new int[result1.length + result2.length];
        while (i < result1.length || j < result2.length) {
            if (j >= result2.length || (i < result1.length && result1[i] <= result2[j])) {
                result[cur++] = result1[i++];
            } else {
                result[cur++] = result2[j++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,3,2,1,9,7,6,5};
        MergeSort2 solution = new MergeSort2();
        int[] result = solution.mergeSort(array);
        System.out.println(result.toString());
    }
}

