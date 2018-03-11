/**
 * Created by bangguo on 2018/1/27.
 */
import java.util.Arrays;
public class QuickSort {
    public int[] quickSort(int[] array){
        if (array == null || array.length <= 1) {
            return array;
        }
        quicksort(array, 0, array.length - 1);
        return array;
    }

    public void quicksort(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int i = left;
        int j = right - 1;
        while(i <= j){
            if (array[i] < pivot){
                i++;
            }else{
                swap(array, i, j--);
            }
        }
        swap(array, i, right);
        quicksort(array, left,i - 1);
        quicksort(array, i + 1, right);
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args){
        int[] array = new int[] {2,5,1,7,4};
        array = new int[] {2};
        QuickSort solution = new QuickSort();
        array = solution.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
