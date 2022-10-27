package gdi;

public class Sorting {

    void insertionsort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    int value = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[j] = value;
                }
            }
        }
    }
    
    void quicksort(int[] array) {
        qicksort2(array, 0, array.length-1);
    }

    void qicksort2(int[] array, int from, int to) {
        if(to-from<=0) {
            return;
        }
        int pivot = array[to];
        int left = from-1;
        int right = to;
        while(left<right) {
            left++;
            while(array[left] < pivot) {
                left++;
            }
            right--;
            while(left < right && array[right] >= pivot) {
                right--;
            }
            int value = array[left];
            array[left] = array[right];
            array[right] = value;
        }
        int value = array[left];
        array[left] = array[right];
        array[right] = value;
        array[to] = array[left];
        array[left] = pivot;
        qicksort2(array, from, left-1);
        qicksort2(array, left+1, to);
    }
    
}
