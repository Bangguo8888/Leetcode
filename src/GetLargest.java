import java.util.Arrays;

/**
 * Created by bangguo on 2018/1/31.
 */
public class GetLargest {
    public int getLargest(int[] array){
        if (array.length == 1) {
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left)/2;
            if (array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (array[left] > array[right]) {
            return array[left];
        } else {
            return array[right];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,3,7,23,100,99,86,44,32,2};
        GetLargest solution = new GetLargest();
        int result = solution.getLargest(array);
        System.out.println(result);

        array = new int[] {10};
        result = solution.getLargest(array);
        System.out.println(result);

        array = new int[] {9,20};
        result = solution.getLargest(array);
        System.out.println(result);

        array = new int[] {30,9};
        result = solution.getLargest(array);
        System.out.println(result);



    }
}
