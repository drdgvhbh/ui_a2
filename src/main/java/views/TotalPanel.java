package views;

import viewModels.OrderListViewModel;
import viewModels.ViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;

public class TotalPanel extends JPanel implements IView<OrderListViewModel> {
    private String price;
    private String text;

    TotalPanel(String text ) {
        super();
        price = "$0.00";
        this.text = text;
        this.buildGUI();

    }

    private void buildGUI() {
        this.removeAll();
        this.setLayout(new GridLayout(2, 1));
        JLabel label = new JLabel(text);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        label.setVerticalAlignment(SwingConstants.NORTH);
        label.setPreferredSize(new Dimension(425, 50));
/*        this.setBorder(BorderFactory.createLineBorder(Color.black));*/
        label.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBorder(new EmptyBorder(0, 0, 0, 25));
        this.add(label);
        JLabel total = new JLabel(price);
        total.setFont(new Font("Tahoma", Font.BOLD, 18));
        total.setVerticalAlignment(SwingConstants.NORTH);
        total.setPreferredSize(new Dimension(425, 50));
/*        this.setBorder(BorderFactory.createLineBorder(Color.black));*/
        total.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
        total.setHorizontalAlignment(JLabel.RIGHT);
        total.setBorder(new EmptyBorder(0, 0, 0, 25));
        this.add(total);
        this.revalidate();
    }

    @Override
    public void bind(OrderListViewModel viewModel) {
        viewModel.getItemPriceChanged().subscribe(x -> {
           System.out.println(x);
           price = "$" + new DecimalFormat(
               "#.00").format(x);
            buildGUI();
        });
    }
}
