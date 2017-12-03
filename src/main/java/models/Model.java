package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;

public class Model {
    // Item-Quantity
    private ObservableMap<String, Integer> items;

    private Map<String, Double> itemPrices;

    private double totalPrice;

    public Model() {
        items = FXCollections.observableMap(new HashMap<String, Integer>());
        this.itemPrices = new HashMap<>();
    }

    public ObservableMap<String, Integer> getItems() {
        return items;
    }

    public Map<String, Double> getItemPrices() {
        return itemPrices;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
