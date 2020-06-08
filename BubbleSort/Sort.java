package BubbleSort;

import BubbleSort.util.JTableUtils;
import BubbleSort.util.SwingUtils;

import javax.swing.*;

public class Sort extends JFrame {
    private JTable arrayTable;
    private JPanel mainPanel;
    private JButton forwardButton;
    private JButton backButton;
    private JButton stopButton;
    private JButton startButton;
    private int[] array;
    private Player player;

    public Sort() {
        this.setTitle("BubbleSort");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(arrayTable, 40, false, true, false, true);
        arrayTable.setRowHeight(25);
        array = new int[]{9, 6, 1, -1, 10, 7, 0, 5, 3, 1};
        JTableUtils.writeArrayToJTable(arrayTable, array);
        player = new Player(arrayTable, array, new BubbleSort().sort(array));

        startButton.addActionListener(actionEvent -> {
            try {
                array = JTableUtils.readIntArrayFromJTable(arrayTable);
                player.start();
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        forwardButton.addActionListener(actionEvent -> {
            try {
                player.forward();
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        backButton.addActionListener(actionEvent -> {
            try {
                player.back();
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        stopButton.addActionListener(actionEvent -> {
            try {
                player.stop();
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
    }
}