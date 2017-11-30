package views;
import rx.observables.SwingObservable;
import viewModels.MenuItemViewModel;

import javax.swing.*;
import java.awt.*;

class MenuItem extends JPanel implements IView<MenuItemViewModel> {
    JButton button;

    MenuItem(String name, double price) {
        super();
        System.out.println("Should I be 4?");

        button = new JButton("+1");
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

    @Override
    public void bind(MenuItemViewModel viewModel) {
        System.out.println("DERP");
        SwingObservable.fromButtonAction(button).asObservable().subscribe(x -> {
            System.out.println("Hello world!");
        });
    }
}
