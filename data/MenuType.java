package sparta.java_project.kiosk_ver3.data;

public enum MenuType {
    COFFEE(1),
    DRINK(2),
    DESSERT(3);

    private final int menuType;

    MenuType(int menuType){
        this.menuType = menuType;
    }

    public int getMenuType() {
        return menuType;
    }
}
