package Views;

import javax.swing.*;
import java.awt.*;

class MenuItem extends JPanel {
    MenuItem(String name, double price) {
        super();

        JButton button = new JButton("+1");
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setPreferredSize(new Dimension(30, 30));
        this.add(button);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setPreferredSize(new Dimension(110, 30));
        this.add(nameLabel);

        JLabel priceLabel = new JLabel("$" + price);
        priceLabel.setPreferredSize(new Dimension(50, 30));
        this.add(priceLabel);
   }

}
