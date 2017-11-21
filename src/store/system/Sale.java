package store.system;

public class Sale {

    int customerId, itemId, quantity , itemPrice;
    String itemName;

    public Sale(int customerId, int itemId, int itemPrice , int quantity, String itemName) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getInfo() { //Get all information to use it at print 
        return "The Item ID is:  " + this.itemId + ", The Item Name is: " + this.itemName + ", The Quantity is: " + this.quantity + "\n";
    }
}
