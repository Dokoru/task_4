package BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public List<SortState> sort(int[] array) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        List<SortState> states = new ArrayList<SortState>();
        states.add(new SortState(arrayCopy, 0, 0));
        int size = array.length;
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
                arrayCopy = copy(array);
                states.add(new SortState(arrayCopy, i, j));
            }
        }
        return states;
    }

    public int[] copy(int[] array) {
        int size = array.length;
        int[] arrayCopy = new int[size];
        System.arraycopy(array, 0, arrayCopy, 0, size);
        return arrayCopy;
    }
}
