package viewModels;

import javafx.collections.MapChangeListener;
import models.Model;
import rx.subjects.PublishSubject;

import java.util.Map;

public class OrderListViewModel {
    private Model model;
    private MenuItemViewModel menuItemViewModel;
    private PublishSubject<Map<String, Integer>> itemListChanged;
    private PublishSubject<Double> itemPriceChanged;

    public OrderListViewModel(Model model) {
        this.model = model;
        menuItemViewModel = new MenuItemViewModel(model);

        itemListChanged = PublishSubject.create();
        itemPriceChanged = PublishSubject.create();
        model.getItems().addListener(
            (MapChangeListener<String, Integer>) change -> {
                itemListChanged.onNext(model.getItems());
                double price = 0;
                System.out.println(model.getItemPrices());
                for (Map.Entry<String, Integer> entry : model.getItems().entrySet()) {
                    price += entry.getValue() * model.getItemPrices().get(entry.getKey());
                }
                model.setTotalPrice(price);
                itemPriceChanged.onNext(price);
            });


    }

    public MenuItemViewModel getMenuItemViewModel() {
        return menuItemViewModel;
    }
    public PublishSubject<Map<String, Integer>> getItemListChanged() {
        return this.itemListChanged;
    }

    public PublishSubject<Double> getItemPriceChanged() {
        return this.itemPriceChanged;
    }
}
