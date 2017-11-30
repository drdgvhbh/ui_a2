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
    private final PublishSubject<ActionEvent> removeButtonClick;


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
        this.removeButtonClick = PublishSubject.create();
    }

    public Observer<Pair<String, Double>> getAddButtonClick() {
           return this.addButtonClick;
    }

    public PublishSubject<ActionEvent> getRemoveButtonClick() {
        return removeButtonClick;
    }
}
