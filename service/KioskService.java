package sparta.java_project.kiosk_ver3.service;

import sparta.java_project.kiosk_ver3.data.Product;
import sparta.java_project.kiosk_ver3.view.Input;
import sparta.java_project.kiosk_ver3.view.Output;

import java.util.List;

public class KioskService {
    public boolean checkPrint(int checkNumber, Output output, List<Product> productList, boolean loopCheck, List<Product> cart){
        double totalPrice = 0;
        switch (checkNumber) {
            case 1, 2, 3:
                totalPrice = output.printProduct(productList,checkNumber,cart);
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
            output.printOrderComplete();
            cart.clear();
        }
    }
    public void cancelOrder(Output output, List<Product> cart){
        output.printCancel();
        cart.clear();
    }
}
