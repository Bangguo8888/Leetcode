/**
 * Created by bangguo on 2018/1/27.
 */
import java.util.Arrays;
public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array,helper,0,array.length - 1);
        return array;

    }
    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for(int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= right ){
            if(helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else{
                array[left++] = helper[rightIndex++];
            }
        }
        while(leftIndex <= mid){
            array[left++] = helper[leftIndex++];
        }
    }

    public static void main(String[] args){
        int[] array = {6,1,8,5};
        MergeSort solution = new MergeSort();
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
