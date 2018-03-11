import java.util.Arrays;

/**
 * Created by bangguo on 2018/1/27.
 */

public class SelectionSort {
    public int[] selectionSort(int[] array) {
        // Write your solution here.
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }
    public void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        SelectionSort solution = new SelectionSort();

        int[] array = null;
        array = solution.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[0];
        array = solution.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1,2,3,4};
        array = solution.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {4,3,2,1};
        array = solution.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {2,4,1,5,3};
        array = solution.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}