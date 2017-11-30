package viewModels;

public class MenuListViewModel implements IViewModel {
    private MenuItemViewModel menuItemViewModel;

    public MenuListViewModel() {
        menuItemViewModel = new MenuItemViewModel();
    }

    public MenuItemViewModel getMenuItemViewModel() {
        return menuItemViewModel;
    }
}
