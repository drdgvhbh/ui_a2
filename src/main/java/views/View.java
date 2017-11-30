package views;

import viewModels.ViewModel;
import views.Menu.MenuListPanel;
import views.Menu.OrderListPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class View extends JFrame implements IView<ViewModel> {
    private java.util.List<MenuListPanel> menuListPanels;
    private OrderListPanel orderListPanel;

    @Override
    public void bind(ViewModel viewModel) {
        for (MenuListPanel m : menuListPanels) {
            m.bind(viewModel.getMenuListViewModel());
        }
        this.orderListPanel.bind(viewModel.getOrderListViewModel());
    }

    public View() {
        super();
        Map<String, Double> foodList = Map.ofEntries(
            entry("Club Sandwich", 3.99),
            entry("Sushi Boat", 7.99)
        );
        Map<String, Double> drinkList = Map.ofEntries(
            entry("Coca Cola", 1.25),
            entry("Bubble Tea", 3.99)
        );
        this.menuListPanels = new ArrayList<>(4);

        this.setTitle("Restaurant App");
        this.setBounds(0, 0, 450, 600);
        this.setMinimumSize(new Dimension(450, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        this.getContentPane().add(mainPanel);

        mainPanel.add(new TitlePanel("Menu"), BorderLayout.NORTH);

        JPanel menuListContainer = new JPanel();
        menuListContainer.setLayout(new GridBagLayout());
        mainPanel.add(menuListContainer);

        // Add food and drinks
        this.menuListPanels.add(new MenuListPanel(
            "Food",
            foodList));
        menuListContainer.add(
            this.menuListPanels.get(this.menuListPanels.size() - 1),
            new GridBagConstraints() {{
                gridx = 0;
                gridy = 0;
                anchor = GridBagConstraints.NORTH;
                weighty = GridBagConstraints.VERTICAL;
            }});

        this.menuListPanels.add(new MenuListPanel(
            "Drinks",
            drinkList));
        menuListContainer.add(
            this.menuListPanels.get(this.menuListPanels.size() - 1),
            new GridBagConstraints() {{
                gridx = 1;
                gridy = 0;
                anchor = GridBagConstraints.NORTH;
                weighty = GridBagConstraints.VERTICAL;
            }});

        Map<String, Double> mergedPricing = new HashMap<>(foodList);
        mergedPricing.putAll(drinkList);
        this.orderListPanel = new OrderListPanel("Order", mergedPricing);
        menuListContainer.add(
            this.orderListPanel,
            new GridBagConstraints() {{
                gridx = 0;
                gridy = 1;
                anchor = GridBagConstraints.NORTH;
                gridwidth = 2;
                weightx = GridBagConstraints.HORIZONTAL;
                weighty = GridBagConstraints.VERTICAL;
            }});

    }
}
