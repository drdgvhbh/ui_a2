package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;

public class Model {
    // Item-Quantity
    private ObservableMap<String, Integer> items;

    public Model() {
        items = FXCollections.observableMap(new HashMap<String, Integer>());
    }

    public ObservableMap<String, Integer> getItems() {
        return items;
    }
}
