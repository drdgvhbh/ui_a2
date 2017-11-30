package views.Menu;

import java.awt.event.ActionEvent;

public class ItemActionEvent<T1 extends String, T2 extends Double> extends ActionEvent {
    private T1 item1;
    private T2 item2;

    private ItemActionEvent(Object source, int id, String command) {
        super(source, id, command);
    }

    public ItemActionEvent(Object source, int id, T1 item1, T2 item2) {
        super(source, id, "");
        this.item1 = item1;
        this.item2 = item2;
    }
}
