package views;

import javax.swing.*;
import java.awt.*;

class TitlePanel extends JPanel {
    TitlePanel(String text) {
        super();
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.BOLD, 36));
        label.setVerticalAlignment(SwingConstants.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(600, 100));
        label.setMaximumSize(new Dimension(600, 100));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(label, BorderLayout.CENTER);
    }
}
