package viewModels;

import javafx.collections.MapChangeListener;
import models.Model;
import rx.subjects.PublishSubject;

import java.util.Map;

public class OrderListViewModel {
    private Model model;
    private MenuItemViewModel menuItemViewModel;
    private PublishSubject<Map<String, Integer>> itemListChanged;

    public OrderListViewModel(Model model) {
        this.model = model;
        menuItemViewModel = new MenuItemViewModel(model);

        itemListChanged = PublishSubject.create();
        model.getItems().addListener(
            (MapChangeListener<String, Integer>) change -> {
                itemListChanged.onNext(model.getItems());
            });
    }

    public MenuItemViewModel getMenuItemViewModel() {
        return menuItemViewModel;
    }
    public PublishSubject<Map<String, Integer>> getItemListChanged() {
        return this.itemListChanged;
    }
}
