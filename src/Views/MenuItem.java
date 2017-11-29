package Views;

import javax.swing.*;
import java.awt.*;

class MenuItem extends JPanel {
    MenuItem(String name, double price) {
        super();
        this.add(new JButton("+1"));
        this.add(new JLabel(name));
        this.add(new JLabel("$" + price));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
