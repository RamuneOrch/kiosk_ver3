package sparta.java_project.kiosk_ver3.data;

import sparta.java_project.keyoskVer2.category.Item;

import java.util.List;

public class MenuData {

    private final int COFFEE_TYPE = MenuType.COFFEE.getMenuType();
    private final int DRINK_TYPE = MenuType.DRINK.getMenuType();
    private final int DESSERT_TYPE = MenuType.DESSERT.getMenuType();

    public void menuList(List<Menu> menuList){
        menuList.add(new Menu("Coffee","잠이 안오게 하는 마법의 물약",COFFEE_TYPE));
        menuList.add(new Menu("Drink","맛있는 물약",DRINK_TYPE));
        menuList.add(new Menu("Dessert","빵 이외 여러개의 것들",DESSERT_TYPE));
    }

    public void addProductList(List<Product> productList){

        // coffee
        productList.add(new Product("아메리카노",3500,"물이랑 커피 섞은거",1,COFFEE_TYPE));
        productList.add(new Product("카푸치노",4000,"에스프레소랑 커피 섞은거",1,COFFEE_TYPE));
        productList.add(new Product("초코라떼",3800,"초코랑 커피 섞은거",1,COFFEE_TYPE));
        productList.add(new Product("딸기라떼",3500,"딸기랑 커피 섞은거",1,COFFEE_TYPE));
        productList.add(new Product("바닐라라떼",4500,"바나나랑 커피 섞은거",1,COFFEE_TYPE));

        // drink
        productList.add(new Product("레몬에이드", 3800, "레몬이 들어감", 1,DRINK_TYPE));
        productList.add(new Product("자몽에이드", 4300, "자몽이 들어감", 1,DRINK_TYPE));
        productList.add(new Product("블루레몬에이드", 4000, "블루 레몬이 들어감", 1,DRINK_TYPE));
        productList.add(new Product("유자에이드", 4200, "유자가 들어감", 1,DRINK_TYPE));
        productList.add(new Product("딸기에이드", 4000, "딸기가 들어감", 1,DRINK_TYPE));

        // dessert
        productList.add(new Product("딸기케이크", 3500, "딸기가 들어감", 1,DESSERT_TYPE));
        productList.add(new Product("티라미수", 7500, "티라미수임", 1,DESSERT_TYPE));
        productList.add(new Product("초코파운드", 6500, "초코가 들어감", 1,DESSERT_TYPE));
        productList.add(new Product("마카롱", 3500, "마카롱임", 1,DESSERT_TYPE));
        productList.add(new Product("버터와플", 8500, "버터랑 와플", 1,DESSERT_TYPE));
    }
}
