package views;

import viewModels.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static java.util.Map.entry;

public class View extends JFrame implements IView<ViewModel> {
    private MenuListPanel foodPanel;
    private MenuListPanel drinksPanel;

    @Override
    public void bind(ViewModel viewModel) {
        this.foodPanel.bind(viewModel.getMenuListViewModel());
        this.drinksPanel.bind(viewModel.getMenuListViewModel());
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
        menuListContainer.setLayout(new GridLayout(1, 2));

        foodPanel = new MenuListPanel("Food", foodList);
        foodPanel.setBorder(BorderFactory.createMatteBorder(
            0,
            0,
            0,
            1, Color.black));
        menuListContainer.add(foodPanel, BorderLayout.CENTER);

        drinksPanel = new MenuListPanel("Drinks", drinkList);
        drinksPanel.setBorder(BorderFactory.createMatteBorder(
            0,
            0,
            0,
            1, Color.black));
        menuListContainer.add(
            drinksPanel,
            BorderLayout.CENTER);

        mainPanel.add(menuListContainer);

    }
}
