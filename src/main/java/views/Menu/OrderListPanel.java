package views.Menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import viewModels.MenuItemViewModel;
import viewModels.OrderListViewModel;
import views.IView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderListPanel extends JPanel implements IView<OrderListViewModel> {
    private static final Logger logger = LogManager.getLogger(
        OrderListPanel.class.getName());
    private String title;
    private Map<String, Integer> itemQuantity;
    private Map<String, Double> itemPricing;
    private List<AbstractMenuItem> orderList;
    private OrderListViewModel viewModel;

    public OrderListPanel(String title, Map<String, Double> itemPricing) {
        super();
        this.title = title;
        this.itemPricing = itemPricing;
        this.orderList = new ArrayList<>();
        this.itemQuantity = new HashMap<>();
        this.buildGUI();

    }

    private void buildGUI() {
        this.removeAll();
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
        for (Map.Entry<String, Integer> item : itemQuantity.entrySet()) {
            if (!itemPricing.containsKey(item.getKey())) {
                logger.error(
                    "Cannot add item with name {} to order without a price",
                    item.getKey());
                throw new IllegalStateException();
            }
            final int rowCopy = row;
            AbstractMenuItem menuItem = new RemoveMenuItem(
                item.getValue() + "x " + item.getKey(),
                item.getValue() * itemPricing.get(item.getKey()));

            this.add(menuItem, new GridBagConstraints() {{
                gridx = 0;
                gridy = rowCopy;
                anchor = GridBagConstraints.NORTH;
            }});
            orderList.add(menuItem);
            row++;
        }

        final int rowCopy = ++row;
        this.add(new JPanel(), new GridBagConstraints() {{
            gridx = 0;
            gridy = rowCopy;
            anchor = GridBagConstraints.NORTH;
            weighty = GridBagConstraints.VERTICAL;
        }});
        for (AbstractMenuItem m : orderList) {
            m.bind(viewModel.getMenuItemViewModel());
        }
        this.revalidate();
    }

    @Override
    public void bind(OrderListViewModel viewModel) {
        this.viewModel= viewModel;
        viewModel.getItemListChanged().subscribe(x -> {
            this.itemQuantity = x;
            this.buildGUI();
        });
        logger.debug("{}'s view model bound.", this.getClass().getName());
    }
}