package sparta.java_project.kiosk_ver3.service;

import sparta.java_project.kiosk_ver3.data.Menu;
import sparta.java_project.kiosk_ver3.data.MenuData;
import sparta.java_project.kiosk_ver3.data.Product;
import sparta.java_project.kiosk_ver3.view.Input;
import sparta.java_project.kiosk_ver3.view.Output;

import java.util.ArrayList;
import java.util.List;

public class KioskService {
    private final Output output = new Output();
    private final MenuData menuData = new MenuData();
    private final List<Menu> menuList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private final List<Product> cart = new ArrayList<>();
    boolean loopCheck = true;
    double totalPrice;
    int waitingNumber;
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
        this.loopCheck = checkPrint(checkNumber, output, productList, loopCheck, cart);
    }
    public boolean checkPrint(int checkNumber, Output output, List<Product> productList, boolean loopCheck, List<Product> cart){
        switch (checkNumber) {
            case 1, 2, 3:
                totalPrice = output.printProduct(productList,checkNumber,cart, totalPrice);
                break;
            case 4:
                checkCartEmpty(cart,output,totalPrice);
                break;
            case 5:
                cancelOrder(output,cart);
                break;
            case 9:
                loopCheck = false;
                break;
            default:
                output.printErr();
        }
        return loopCheck;
    }

    public void checkCartEmpty(List<Product> cart,Output output, double totalPrice){
        if(cart.isEmpty()){
            output.emptyCart();
        } else{
            printShowCart(cart,output,totalPrice);
        }
    }
    public void printShowCart(List<Product> cart,Output output,double totalPrice){
        int checkOrder = 1;
        output.printCart(cart,totalPrice);
        clearCart(checkOrder,output,cart);
    }

    public void clearCart(int checkOrder, Output output, List<Product> cart){
        if(Input.sc.nextInt() == checkOrder){
            waitingNumber++;
            output.printOrderComplete(waitingNumber);
            cart.clear();
            totalPrice = 0;
        }
    }
    public void cancelOrder(Output output, List<Product> cart){
        output.printCancel();
        cart.clear();
    }
}
