package Views;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

class MenuListPanel extends JPanel {
    MenuListPanel(String title, Map<String, Double> items) {
        super();
        Font textFont = new Font("Tahoma", Font.BOLD, 18);

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);

        JLabel leftLabel = new JLabel(title);
        leftLabel.setFont(textFont);
        leftLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(leftLabel, new GridBagConstraints() {{
            gridx = 0;
            gridy = 0;
            anchor = CENTER;
            weightx = GridBagConstraints.HORIZONTAL;

        }});

        this.add(new JPanel(), new GridBagConstraints() {{
            gridx = 0;
            gridy = 1;
            anchor = GridBagConstraints.NORTH;
            weighty = 0.05;
        }});

        int row = 2;
        for (Map.Entry<String, Double> item : items.entrySet()) {
            final int rowCopy = row;
            MenuItem menuItem = new MenuItem(item.getKey(), item.getValue());
            this.add(menuItem, new GridBagConstraints() {{
                gridx = 0;
                gridy = rowCopy;
                anchor = GridBagConstraints.NORTH;
            }});
            row++;
        }

        final int rowCopy = ++row;
        this.add(new JPanel(), new GridBagConstraints() {{
            gridx = 0;
            gridy = rowCopy;
            anchor = GridBagConstraints.NORTH;
            weighty = GridBagConstraints.VERTICAL;
        }});
    }
}
