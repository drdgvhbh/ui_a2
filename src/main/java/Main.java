
import models.Model;
import viewModels.ViewModel;
import views.View;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        ViewModel viewModel = new ViewModel(model);

        SwingUtilities.invokeLater(() -> {
            View view = new View();
            view.bind(viewModel);
            view.setVisible(true);
        });
    }
}
