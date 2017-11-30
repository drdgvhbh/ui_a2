package views.Menu;
import rx.observables.SwingObservable;
import viewModels.MenuItemViewModel;
import views.IView;

import javax.swing.*;
import java.awt.*;

abstract class AbstractMenuItem extends JPanel implements IView<MenuItemViewModel> {
    private JButton button;
    private String itemName;
    private double itemPrice;

    AbstractMenuItem(String name, double price) {
        super();
        this.itemName = name;
        this.itemPrice = price;

        button = new JButton("");
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

   protected JButton getButton() {
        return this.button;
   }

   protected String getItemName() {
        return this.itemName;
   }

   protected double getItemPrice() {
        return this.itemPrice;
   }

    @Override
    public void bind(MenuItemViewModel viewModel) {
    }
}
