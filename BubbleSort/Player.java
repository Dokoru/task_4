package BubbleSort;

import BubbleSort.util.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Player {

    private JTable table;
    private int[] array;
    private List<SortState> states;
    int countStates = 0;
    int count = 0;

    public Player(JTable table, int[] array, List<SortState> states) {
        this.table = table;
        this.array = array;
        this.states = states;
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
        if (countStates > 0) {
            count--;
            if (count == states.get(countStates - 1).getI()) {
                swap(countStates - 1);
                countStates--;
            }
        }
    }

    public void back() throws Exception {
        if (countStates > 0) {
            stop();
            timer.start();
        }
        else {
            throw new Exception("NoStepBack");
        }
    }

    public void forward() throws Exception {
        timer.stop();
        if (countStates < states.size() - 2) {
            if (count == states.get(countStates).getI()) {
                swap(countStates);
                countStates++;
            }
            count++;
            timer.start();
        }
        else {
            throw new Exception("NoStepForward");
        }
    }

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (countStates < states.size() - 1) {
                if (count == array.length - 1) {
                    count = 0;
                }
                if (count != states.get(countStates).getI()) {
                    JTableUtils.writeArrayToJTable(table, array);
                    table.getColumnModel().getColumn(count).setCellRenderer(new ColorRendererF());
                    table.getColumnModel().getColumn(count + 1).setCellRenderer(new ColorRendererF());
                }
                else {
                    swap(countStates);
                    JTableUtils.writeArrayToJTable(table, array);
                    table.getColumnModel().getColumn(count).setCellRenderer(new ColorRendererT());
                    table.getColumnModel().getColumn(count + 1).setCellRenderer(new ColorRendererT());
                    countStates++;
                }
                count++;
            }
            else {
                timer.stop();
            }
        }
    });

    private void swap(int countStates) {
        int a = states.get(countStates).getI();
        int b = states.get(countStates).getJ();
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
