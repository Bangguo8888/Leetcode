/**
 * Created by bangguo on 2018/2/2.
 */
public class PracticeSelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length <=1) {
            return array;
        }

        int current = 0;
        while (current < array.length) {
            int min = array[current];
            int min_index = current;
            for(int i = current; i < array.length; i++) {
                if (array[i] < min) {
                    min_index = i;
                    min = array[i];
                }
            }
            swap(array,min_index,current);
        }
        return array;
    }

    public void swap(int[] array, int left, int right) {
        int temp;
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
