package BubbleSort;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorRendererF extends JLabel implements TableCellRenderer {

    public ColorRendererF() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(Color.orange);
        setText(table.getValueAt(row, column).toString());
        return this;
    }
}
