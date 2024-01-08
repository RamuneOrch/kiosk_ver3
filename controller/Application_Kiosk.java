package sparta.java_project.kiosk_ver3.controller;

import sparta.java_project.MenuList;
import sparta.java_project.kiosk_ver3.data.Menu;
import sparta.java_project.kiosk_ver3.data.MenuData;
import sparta.java_project.kiosk_ver3.data.Product;
import sparta.java_project.kiosk_ver3.service.KioskService;
import sparta.java_project.kiosk_ver3.view.Input;
import sparta.java_project.kiosk_ver3.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Application_Kiosk {
    private final Output output = new Output();
    private final MenuData menuData = new MenuData();
    private final List<Menu> menuList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private final List<Product> cart = new ArrayList<>();
    private final KioskService kioskService = new KioskService();
    boolean loopCheck = true;

    public void start() {
        initCafeData();
        showInfo();
    }
    public void initCafeData() {
        menuData.menuList(menuList);
        menuData.addProductList(productList);
    }

    public void showInfo() {
        while(loopCheck){
            output.printWelcomeCafe();
            output.printMenuAndOrder(menuList);
            printShowProduct(Input.sc.nextInt());
        }
    }

    public void printShowProduct(int checkNumber) {
        this.loopCheck = kioskService.checkPrint(checkNumber, output, productList, loopCheck, cart);
    }
}
