package BubbleSort;

import BubbleSort.util.JTableUtils;
import BubbleSort.util.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Sort extends JFrame {
    private JTable arrayTable;
    private JPanel mainPanel;
    private JButton forwardButton;
    private JButton backButton;
    private JLabel labelTime;
    private JLabel labelI;
    private JLabel labelJ;
    private JLabel iValue;
    private JLabel jValue;
    private JButton stopButton;
    private JFormattedTextField timeField;
    private JButton startButton;
    private int[] array;
    private List<SortState> states = new ArrayList<SortState>();
    private Timer timer;
    private int count;
    private BubbleSort bubbleSort = new BubbleSort();
    private int time = -1;

    public Sort() {
        this.setTitle("BubbleSort");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(arrayTable, 40, false, true, false, true);
        arrayTable.setRowHeight(25);
        array = new int[]{9, 6, 1, -1, 10, 7, 0, 5, 3, 1};
        JTableUtils.writeArrayToJTable(arrayTable, array);

        startButton.addActionListener(actionEvent -> {
            try {
                array = JTableUtils.readIntArrayFromJTable(arrayTable);
                states.clear();
                states = bubbleSort.sort(array);
                count = 0;
                timeField.setValue("0 sec");
                timer.start();
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        forwardButton.addActionListener(actionEvent -> {
            try {
                if (count < states.size() - 1) {
                    count++;
                    updateView();
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        backButton.addActionListener(actionEvent -> {
            try {
                if (count > 0) {
                    count--;
                    updateView();
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        stopButton.addActionListener(actionEvent -> {
            try {
                timer.stop();
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        timer = new Timer(1000, actionEvent -> {
            if (count < states.size()) {
                updateView();
                count++;
                time++;
                timeField.setValue(time + " sec");
            } else {
                timer.stop();
            }
        });
    }

    public void updateView() {
        JTableUtils.writeArrayToJTable(arrayTable, states.get(count).getArray());
        int i = states.get(count).getI();
        iValue.setText(String.valueOf(i));
        int j = states.get(count).getJ();
        jValue.setText(String.valueOf(j));
        if (j > 0) {
            arrayTable.getColumnModel().getColumn(j).setCellRenderer(new ColorRenderer());
            arrayTable.getColumnModel().getColumn(j - 1).setCellRenderer(new ColorRenderer());
        }
    }
}