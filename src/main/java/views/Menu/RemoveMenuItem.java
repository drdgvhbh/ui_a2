package views.Menu;

public class RemoveMenuItem extends AbstractMenuItem {
    RemoveMenuItem(String name, double price) {
        super(name, price);
        this.getButton().setText("-1");
    }
}
