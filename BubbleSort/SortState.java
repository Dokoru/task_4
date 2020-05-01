package BubbleSort;

public class SortState {

    private int[] array;
    private int i;
    private int j;

    public SortState(int[] array, int i, int j) {
        this.array = array;
        this.i = i;
        this.j = j;
    }

    public int[] getArray() {
        return array;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

}
