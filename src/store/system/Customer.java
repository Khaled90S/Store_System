package store.system;

public class Customer {

    private int id, cartNum;
    private String name;

    public Customer(int id, int cartNum, String name) {
        this.id = id;
        this.cartNum = cartNum;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartNum() {
        return cartNum;
    }

    public void setCartNum(int cartNum) {
        this.cartNum = cartNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() { //Get all information to use it at print 
        return "The Customer ID is : " + this.id + "     The Customer Name is: " + this.name + "\n";
    }

}
