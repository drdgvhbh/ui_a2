package viewModels;

import models.Model;

public class MenuListViewModel implements IViewModel {
    private MenuItemViewModel menuItemViewModel;
    private Model model;

    public MenuListViewModel(Model model) {
        this.model = model;
        menuItemViewModel = new MenuItemViewModel(model);
    }

    public MenuItemViewModel getMenuItemViewModel() {
        return menuItemViewModel;
    }

}
