package views.Menu;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rx.Subscription;
import rx.observables.SwingObservable;
import viewModels.MenuItemViewModel;

public class RemoveMenuItem extends AbstractMenuItem implements AutoCloseable {
    private static final Logger logger = LogManager.getLogger(
        OrderListPanel.class.getName());

    private Subscription sub;
    RemoveMenuItem(String name, double price) {
        super(name, price);
        this.getButton().setText("-1");
    }

    @Override
    public void bind(MenuItemViewModel viewModel) {
        super.bind(viewModel);
        this.sub = SwingObservable.fromButtonAction(this.getButton()).subscribe(x -> {
            Pair<String, Double>
                pair = new ImmutablePair<>(this.getItemName(), this.getItemPrice());
            viewModel.getRemoveButtonClick().onNext(pair);
            viewModel.getRemoveButtonClick().onCompleted();
        });
        logger.debug("{}'s view model bound.", this.getClass().getName());
    }

    @Override
    public void close() throws Exception {
        this.sub.unsubscribe();
    }
}
