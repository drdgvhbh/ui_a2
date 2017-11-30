package viewModels;

public class ViewModel implements IViewModel {
    private final MenuListViewModel menuListViewModel;

    public ViewModel() {
        this.menuListViewModel = new MenuListViewModel();
    }

    public MenuListViewModel getMenuListViewModel() {
        return menuListViewModel;
    }
}
