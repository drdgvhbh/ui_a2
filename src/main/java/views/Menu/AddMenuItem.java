package views.Menu;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import rx.observables.SwingObservable;
import viewModels.MenuItemViewModel;

public class AddMenuItem extends AbstractMenuItem {
    AddMenuItem(String name, double price) {
        super(name, price);
        this.getButton().setText("+1");
    }

    @Override
    public void bind(MenuItemViewModel viewModel) {
        super.bind(viewModel);
        SwingObservable.fromButtonAction(this.getButton()).subscribe(x -> {
            Pair<String, Double> pair = new ImmutablePair<>(this.getItemName(), this.getItemPrice());
            viewModel.getAddButtonClick().onNext(pair);
            viewModel.getAddButtonClick().onCompleted();
        });
        SwingObservable.fromButtonAction(this.getButton()).subscribe(viewModel.getRemoveButtonClick());
    }
}
