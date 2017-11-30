package views.Menu;

import viewModels.MenuListViewModel;
import views.IView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class MenuListPanel extends JPanel implements IView<MenuListViewModel> {
    private java.util.List<AbstractMenuItem> menuItems;
    private String title;
    private Map<String, Double> items;

    public MenuListPanel(String title, Map<String, Double> items) {
        super();
        this.title = title;
        this.items = items;
        buildGUI();
    }

    protected void buildGUI() {
        menuItems = new ArrayList<>();

        Font textFont = new Font("Tahoma", Font.BOLD, 18);

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);

        JLabel labelTitle = new JLabel(title);
        labelTitle.setFont(textFont);
        this.add(labelTitle, new GridBagConstraints() {{
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
            AbstractMenuItem menuItem = new AddMenuItem(
                item.getKey(),
                item.getValue());

            this.add(menuItem, new GridBagConstraints() {{
                gridx = 0;
                gridy = rowCopy;
                anchor = GridBagConstraints.NORTH;
            }});
            menuItems.add(menuItem);
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

    @Override
    public void bind(MenuListViewModel viewModel) {
        for (AbstractMenuItem m : menuItems) {
            m.bind(viewModel.getMenuItemViewModel());
        }
    }

    protected  Map<String, Double> getItems() {
        return this.items;
    }

    protected void setItems(Map<String, Double> items) {
        this.items = items;
    }
}
