package Views;

import ViewModels.IViewModel;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements IView {
    @Override
    public void bind(IViewModel viewModel) {

    }

    public View() {
        super();
        this.setTitle("Restaurant App");
        this.setBounds(0, 0, 450, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        this.getContentPane().add(mainPanel);

        mainPanel.add(new TitlePanel("Menu"), BorderLayout.NORTH);

        JPanel menuListContainer = new JPanel();
        menuListContainer.setLayout(new GridLayout(1, 2));
        MenuListPanel asdf = new MenuListPanel("Food");
        asdf.setBorder(BorderFactory.createLineBorder(Color.black));
        menuListContainer.add(asdf, BorderLayout.CENTER);
        menuListContainer.add(new MenuListPanel("Drinks"), BorderLayout.CENTER);

        mainPanel.add(menuListContainer);

    }
}
