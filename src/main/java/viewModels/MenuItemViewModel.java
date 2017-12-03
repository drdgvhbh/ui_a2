package viewModels;

import models.Model;
import org.apache.commons.lang3.tuple.Pair;
import rx.Observer;
import rx.subjects.PublishSubject;

import java.awt.event.ActionEvent;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuItemViewModel implements viewModels.IViewModel {
    private static final Logger logger = LogManager.getLogger(
        MenuItemViewModel.class.getName());
    private Model model;
    private final Observer<Pair<String, Double>> addButtonClick;
    private final Observer<Pair<String, Double>> removeButtonClick;


    public MenuItemViewModel(Model model) {
        this.model = model;
        this.addButtonClick = new Observer<>() {
            @Override
            public void onCompleted() {
                logger.debug("[Complete] Done observing add button click events.");
            }

            @Override
            public void onError(Throwable e) {
                logger.error(
                    "[Failure] Failed to observe add button click events",
                    e);
            }

            @Override
            public void onNext(Pair<String, Double> stringDoublePair) {
                logger.info(
                    "Adding {} with price {} to orders",
                    stringDoublePair.getLeft(),
                    stringDoublePair.getRight());
                model.getItemPrices().put(
                    stringDoublePair.getLeft(),
                    stringDoublePair.getRight());
                Map<String, Integer> items = model.getItems();
                if (!items.containsKey(stringDoublePair.getLeft())) {
                    items.put(stringDoublePair.getLeft(), 1);
                } else {
                    items.put(
                        stringDoublePair.getLeft(),
                        items.get(stringDoublePair.getLeft()) + 1);
                }
                logger.debug(items);
            }
        };
        this.removeButtonClick = new Observer<>() {
            @Override
            public void onCompleted() {
                logger.debug(
                    "[Complete] Done observing remove button click events.");
            }

            @Override
            public void onError(Throwable e) {
                logger.error(
                    "[Failure] Failed to observe remove button click events",
                    e);
            }

            @Override
            public void onNext(Pair<String, Double> stringDoublePair) {
                logger.info(
                    "Removing {} with price {} from orders",
                    stringDoublePair.getLeft(),
                    stringDoublePair.getRight());
                Map<String, Integer> items = model.getItems();
                String key = stringDoublePair.getLeft();
                key = key.substring(key.indexOf(' ') + 1);
                if (!items.containsKey(key)) {
                    IllegalStateException exception = new IllegalStateException();
                    logger.error(
                        "Cannot remove an item that is not in the user's order",
                        exception);
                    throw exception;
                } else {
                    items.put(
                        key,
                        items.get(key) - 1);
                }
                if (items.get(key) == 0) {
                    items.remove(key);
                }
                logger.debug(items);
            }
        };
    }

    public Observer<Pair<String, Double>> getAddButtonClick() {
           return this.addButtonClick;
    }

    public Observer<Pair<String, Double>> getRemoveButtonClick() {
        return removeButtonClick;
    }
}
