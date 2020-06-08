package BubbleSort;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ColorRendererT extends JLabel implements TableCellRenderer {

    public ColorRendererT() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(Color.cyan);
        setText(table.getValueAt(row, column).toString());
        return this;
    }
}
