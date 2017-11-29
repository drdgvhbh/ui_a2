package Views;

import ViewModels.IViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static java.util.Map.entry;

public class View extends JFrame implements IView {
    @Override
    public void bind(IViewModel viewModel) {

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
        MenuListPanel menuTitle = new MenuListPanel("Food", foodList);
        menuListContainer.add(menuTitle, BorderLayout.CENTER);
        menuListContainer.add(new MenuListPanel("Drinks", drinkList), BorderLayout.CENTER);

        mainPanel.add(menuListContainer);

    }
}
