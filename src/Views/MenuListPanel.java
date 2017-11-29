package Views;

import javax.swing.*;
import java.awt.*;

class MenuListPanel extends JPanel {
    MenuListPanel(String title) {
        super();
        Font textFont = new Font("Tahoma", Font.BOLD, 18);

        GridBagLayout gridBagLayout = new GridBagLayout();
/*/       gridBagLayout.columnWidths = new int[]{0};*/
        gridBagLayout.rowHeights = new int[]{1};
/*        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};*/
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

        MenuItem item = new MenuItem("Club Sandwich", 3.99);
        this.add(item, new GridBagConstraints() {{
            gridx = 0;
            gridy = 1;
            anchor = GridBagConstraints.NORTH;
            weighty = GridBagConstraints.VERTICAL;
        }});

    }
}
