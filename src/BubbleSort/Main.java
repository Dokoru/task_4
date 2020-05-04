package BubbleSort;

import BubbleSort.util.SwingUtils;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(() -> new Sort().setVisible(true));
    }
}
