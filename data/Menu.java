package sparta.java_project.kiosk_ver3.data;

public class Menu {
    private final String name;
    private final String description;
    private final int menuType;
    public Menu(String name, String description,int menuType){
        this.name = name;
        this.description = description;
        this.menuType = menuType;
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getMenuType() {
        return menuType;
    }
}
