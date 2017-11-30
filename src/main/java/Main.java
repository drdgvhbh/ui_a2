
import viewModels.ViewModel;
import views.View;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        ViewModel viewModel = new ViewModel();
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            view.bind(viewModel);
            view.setVisible(true);
        });
    }
}
