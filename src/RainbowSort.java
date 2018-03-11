import java.util.Arrays;

/**
 * Created by bangguo on 2018/1/28.
 */
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while(j <= k) {
            if (array[j] == -1) {
                swap(array, i++, j++);
            }else if (array[j] == 0) {
                j++;
            }else {
                swap(array, j, k--);
            }
        }
        return array;
    }
    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = null;
        RainbowSort solution = new RainbowSort();
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {0,-1,1};
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {0,1,-1,-1,0,1,0,-1,1,-1,0,-1};
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));
    }
}
