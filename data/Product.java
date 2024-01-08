package sparta.java_project.kiosk_ver3.data;

public class Product extends Menu{
    private double price;
    private int count;
    public Product(String name, double price, String description, int count, int menuType){
        super(name, description, menuType);
        this.count = count;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public int getCount(){
        return count;
    }
}
