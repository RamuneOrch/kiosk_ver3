package sparta.java_project.kiosk_ver3.view;

import sparta.java_project.kiosk_ver3.data.Menu;
import sparta.java_project.kiosk_ver3.data.MenuType;
import sparta.java_project.kiosk_ver3.data.Product;

import java.util.ArrayList;
import java.util.List;

public class Output {

    public void printWelcomeCafe(){
        System.out.println("-------------------------------");
        System.out.println("song의 카페에 오신것을 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 번호를 입력해주세요.");
        System.out.println("           [ Songs Cafe ]");
        System.out.println();
    }

    public void printMenuAndOrder(List<Menu> menuList){
        String format = "%d. %s | %s\n";
        System.out.println("           [ 메뉴 목록 ]");
        for(Menu category : menuList){
            System.out.printf(format,category.getMenuType(),category.getName(),category.getDescription());
        }
        System.out.println();
        System.out.println("           [ 주문 하기 ]");
        int menuListIndex = 1;
        int orderNumber = menuList.size() + menuListIndex;
        System.out.println(orderNumber + ". 주문 | " + (orderNumber+1) +". 취소");
    }

    public double printProduct(List<Product> productList,int productNumberCheck,List<Product> cart){
        printWelcomeCafe();
        List<Product> products = new ArrayList<>();
        String format = "%d. %s | 가격 : %d | %s\n";
        int productNumber =  1;
        for(Product product : productList){
            productNumber = checkProductMenuType(product, productNumberCheck,format, productNumber,products);
        }
        int productCheck = Input.sc.nextInt() - 1;
        return printAddProductComplete(products,productCheck,cart);
    }

    public int checkProductMenuType(Product product, int productNumberCheck,String format, int productNumber, List<Product> products){
        if(product.getMenuType() == productNumberCheck){
            System.out.printf(format,productNumber,product.getName(),(int)product.getPrice(),product.getDescription());
            products.add(product);
            return ++productNumber;
        }
        return productNumber;
    }

    public int printCheckProduct(Product product,int productCheck){
        String format = "|  %s  |  가격 : %d  |  %s  |\n";
        System.out.printf(format,product.getName(),(int)product.getPrice(),product.getDescription());
        System.out.println("위 상품을 추가하시겠습니까?");
        System.out.println("1. 확인                  2. 취소");
        return Input.sc.nextInt();
    }

    public double printAddProductComplete(List<Product> products, int productCheck, List<Product> cart){
        int checkProduct = 1;
        if(printCheckProduct(products.get(productCheck),productCheck) == checkProduct){
            cart.add(products.get(productCheck));
            System.out.println("ㅁ------------------------ㅁ");
            System.out.println("|   상품이 추가 되었습니다!   |");
            System.out.println("ㅁ------------------------ㅁ");
            delay(1000);
        }
        return products.get(productCheck).getPrice();
    }

    public void printCart(List<Product> cart,double totalPrice){
        String format = "|  %s  |  가격 : %d  |  %s  |\n";
        System.out.println("--------------------------------------------------");
        System.out.println("|                  [ 주문 목록 ]                   |");
        System.out.println();
        for(Product product : cart){
            System.out.printf(format,product.getName(),(int)product.getPrice(), product.getDescription());
        }
        System.out.println("--------------------------------------------------");
        System.out.print("총 금액 : ");
        System.out.println(totalPrice);
        System.out.println();
        System.out.println("주문하시겠습니까?");
        System.out.println("1. 확인                  2. 취소");
    }

    public void emptyCart(){
        System.out.println("ㅁ-----------------------ㅁ");
        System.out.println("|   장바구니가 비어있습니다! |");
        System.out.println("|                        |");
        System.out.println("|    상품을 선택해주세요!    |");
        System.out.println("ㅁ-----------------------ㅁ");
        delay(1000);
    }

    public void printOrderComplete(){
        System.out.println("ㅁ------------------------ㅁ");
        System.out.println("|    주문이 완료되었습니다!   |");
        System.out.println("ㅁ------------------------ㅁ");
        System.out.println("3초뒤에 메인메뉴로 돌아갑니다....");
        delay(3000);
    }

    public void printCancel(){
        System.out.println("ㅁ------------------------ㅁ");
        System.out.println("|    주문이 취소되었습니다!   |");
        System.out.println("ㅁ------------------------ㅁ");
        System.out.println("3초뒤에 메인메뉴로 돌아갑니다....");
        delay(3000);
    }

    public void printErr(){
        System.out.println("올바른 숫자를 입력해주세요");
        delay(1000);
    }

    public void delay(int millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
