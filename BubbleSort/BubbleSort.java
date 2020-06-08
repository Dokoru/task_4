package BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static List<SortState> sort(int[] array) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        List<SortState> states = new ArrayList<SortState>();
        int size = arrayCopy.length;
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (arrayCopy[j - 1] > arrayCopy[j]) {
                    temp = arrayCopy[j - 1];
                    arrayCopy[j - 1] = arrayCopy[j];
                    arrayCopy[j] = temp;
                    states.add(new SortState(j - 1, j));
                }
            }
        }
        return states;
    }
}
