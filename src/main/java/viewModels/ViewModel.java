package viewModels;

import javafx.collections.MapChangeListener;
import models.Model;
import rx.subjects.PublishSubject;

import java.util.Map;

public class ViewModel implements IViewModel {
    private final MenuListViewModel menuListViewModel;
    private final OrderListViewModel orderListViewModel;

    public ViewModel(Model model) {
        this.menuListViewModel = new MenuListViewModel(model);
        this.orderListViewModel = new OrderListViewModel(model);
    }

    public MenuListViewModel getMenuListViewModel() {
        return menuListViewModel;
    }

    public OrderListViewModel getOrderListViewModel() {
        return orderListViewModel;
    }
}
