package store.system;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;

public class StoreSystem { // basic class "controller"

    public static ArrayList<Item> items = new ArrayList(); // store all items at the store
    public static int[] carts; // store the carts at the store 
    public static ArrayList<Customer> customers = new ArrayList(); // store all customers at the store
    public static ArrayList<Sale> sales = new ArrayList(); // store all sales for all customers 

    public static void main(String[] args) {
        test(); // add 3 items and 1 customer to test the program directly
        intializeCarts(25); // set the mumbers of carts att the store 
        mainMenu();
    }

    public static void mainMenu() {
        String menu = " Store System Menu\n "
                + "1.Add a new Item to Store \n "
                + "2.Add a new Customer to Store \n "
                + "3.Add an Item to Customer shopping cart\n "
                + "4.Remove an Item from Customer shopping cart\n "
                + "5.View the Items in Customer shopping cart\n "
                + "6.End shopping and go to checkout\n "
                + "7.Empty Customer shopping cart\n "
                + "8.Exit the program";

        while (true) {
            int choisedNum = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
            switch (choisedNum) {
                case 1: {
                    addItem();
                    break;
                }
                case 2: {
                    addCustomer();
                    break;
                }
                case 3: {
                    addItemsToCustomerShoppingCart();
                    break;
                }
                case 4: {
                    String ID = JOptionPane.showInputDialog(null, "Enter The Customer ID Please ...");
                    int id = Integer.parseInt(ID);
                    removeAnItemFromCustomerShoppingCart(id);
                    break;
                }
                case 5: {
                    String ID = JOptionPane.showInputDialog(null, "Enter The Customer ID Please ...");
                    int id = Integer.parseInt(ID);
                    viewTheItemsInTheShoppingCart(id);
                    break;
                }
                case 6: {
                    String ID = JOptionPane.showInputDialog(null, "Enter The Customer ID Please ...");
                    int id = Integer.parseInt(ID);
                    checkOut(id);
                    break;
                }
                case 7: {
                    String ID = JOptionPane.showInputDialog(null, "Enter The Customer ID Please ...");
                    int id = Integer.parseInt(ID);
                    emptyTheCustomerShoppingCart(id);
                    break;
                }
                case 8: {
                    System.exit(0);
                }
            }
        }
    }
    /* addItem is used to add a new Item to the store /note: the ItemId is uniq and can't be repeated so the user will  
    not be able to add the same id for another item , and if he insert the same quantity then the new quantity
    will be added to the current quantity at the store*/
    private static void addItem() {
        int loopNum = -1;
        do {
            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField quantity = new JTextField();
            JTextField price = new JTextField();
            JTextField type = new JTextField();
            JTextField companyName = new JTextField();
            JTextField screenSize = new JTextField();
            JTextField color = new JTextField();
            JTextField processorSpeed = new JTextField();
            JTextField hardSpace = new JTextField();
            JTextField ramSize = new JTextField();

            Object[] message = {"Enter Item Number: ", id, "Enter Item Name: ", name, "Enter Item quantity: ", quantity, "Enter Item Price: ", price, "Enter Item Type: (L/Laptop  M/Mobile  G/TVGame  T/Tablet): ", type};
            int test = JOptionPane.showConfirmDialog(null, message);

            Object[] Mobiles = {"Enter The Company Name: ", companyName, "Enter The Screen Size: ", screenSize, "Enter The Color: ", color};
            Object[] Laptops = {"Enter The Company Name: ", companyName, "Enter The Screen Size: ", screenSize, "Enter The ProcessorSpeed: ", processorSpeed, "Enter The HardSpace: ", hardSpace, "Enter The RamSize: ", ramSize};
            Object[] TVGames = {"Enter The Company Name: ", companyName, "Enter The HardSpace: ", hardSpace, "Enter The Color: ", color};
            Object[] Tablets = {"Enter The Company Name: ", companyName, "Enter The Screen Size: ", screenSize};

            int result = 1;

            if (type.getText().toUpperCase().equals("L")) {
                result = JOptionPane.showConfirmDialog(null, Laptops);
            }
            if (type.getText().toUpperCase().equals("M")) {
                result = JOptionPane.showConfirmDialog(null, Mobiles);
            }
            if (type.getText().toUpperCase().equals("G")) {
                result = JOptionPane.showConfirmDialog(null, TVGames);
            }
            if (type.getText().toUpperCase().equals("T")) {
                result = JOptionPane.showConfirmDialog(null, Tablets);
            }
            if (test == JOptionPane.YES_OPTION && result == JOptionPane.YES_OPTION) {
                int ID = Integer.parseInt(id.getText());
                String Name = name.getText();
                int Quant = Integer.parseInt(quantity.getText());
                int Price = Integer.parseInt(price.getText());
                String Type = type.getText().toUpperCase();
                String CompanyName = companyName.getText();
                String ScreenSize = screenSize.getText();
                String Color = color.getText();
                String ProcessorSpeed = processorSpeed.getText();
                String HardSpace = hardSpace.getText();
                String RamSize = ramSize.getText();

                int idIndex = searchForItem(ID);
                if (idIndex != -1) {
                    JOptionPane.showMessageDialog(null, "This Item is already in the System !!! ");
                } else {
                    int nameIndex = searchForItem(Name);
                    if (nameIndex != -1) {
                        JOptionPane.showMessageDialog(null, "The new amount will be added to this Item .. ");
                        items.get(nameIndex).addQuantity(Quant);
                    } else {
                        switch (Type) {
                            case "L": {
                                items.add(new Laptop(ID, Quant, Price, Name, CompanyName, ScreenSize, ProcessorSpeed, HardSpace, RamSize));
                                break;
                            }
                            case "M": {
                                items.add(new Mobile(ID, Quant, Price, Name, CompanyName, ScreenSize, Color));
                                break;
                            }
                            case "G": {
                                items.add(new TVGame(ID, Quant, Price, Name, CompanyName, HardSpace, Color));
                                break;
                            }
                            case "T": {
                                items.add(new Tablet(ID, Quant, Price, Name, CompanyName, ScreenSize));
                                break;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "The Item successfully inserted to The Store ... ");
                    }
                }
                String temp = JOptionPane.showInputDialog(null, "Do you want to add another Item ? Y/N ");
                if (temp.toUpperCase().equals("Y")) {
                    loopNum = 1;
                } else {
                    loopNum = 0;
                }
            }
        } while (loopNum == 1);

    }
    
    // search for item at the store by its id and return its index at the arrayList if it is exist at the store
    private static int searchForItem(int ID) { 
        int index = 0;
        for (Item i : items) {
            if (ID == i.getId()) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
    
    // search for customer at the store by its id and return its index at the arrayList if it is exist at the store
    private static int searchForCustomer(int ID) { // search for item at the store by its id and return its index at the arrayList
        int index = 0;
        for (Customer i : customers) {
            if (ID == i.getId()) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
    
    // search for item at the store by its name and return its index at the arrayList if it is exist at the store
    private static int searchForItem(String Name) {
        int index = 0;
        for (Item i : items) {
            if (Name.equals(i.getName())) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
    
    /* addCustomer is used to add a new customer to the store /note: the CustomerId is uniq and can't be repeated so the user will  
    not be able to add the same id for another user */
    private static void addCustomer() {
        int loopNum = -1;
        do {
            JTextField id = new JTextField();
            JTextField name = new JTextField();

            Object[] message = {"Enter The Customer ID: ", id, "Enter The Customer Name: ", name};
            int yes = JOptionPane.showConfirmDialog(null, message);
            if (yes == JOptionPane.YES_OPTION) {
                int ID = Integer.parseInt(id.getText());
                int idIndex = searchForCustomer(ID);
                if (idIndex != -1) {
                    JOptionPane.showMessageDialog(null, "This Customer is already in the System !!! ");
                } else {
                    int index = searchForCart(ID);
                    if (index != -1) {
                        customers.add(new Customer(ID, index, name.getText()));
                        JOptionPane.showMessageDialog(null, "The Customer successfully inserted to The Store ...");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry The Carts Full !!!");
                    }
                }
                String temp = JOptionPane.showInputDialog(null, "Do you want to add another Customer ? Y/N ");
                if (temp.toUpperCase().equals("Y")) {
                    loopNum = 1;
                } else {
                    loopNum = 0;
                }
            }
        } while (loopNum == 1);
    }
    
    //set the mumbers of carts att the store
    private static void intializeCarts(int length) {
        carts = new int[length];
        for (int i = 0; i < length; i++) {
            carts[i] = -1;
        }
    }
    
    // search for empty cart at the store and save the customer id in its index at the arraylist
    private static int searchForCart(int id) {
        for (int i = 0; i < carts.length; i++) {
            if (carts[i] == -1) {
                carts[i] = id;
                return i;
            }
        }
        return -1;
    }
    
    // add items to customer shopping cart
    private static void addItemsToCustomerShoppingCart() {
        int loopNum = 0;

        do {
            String customerId = JOptionPane.showInputDialog(null, "Enter the Customer Number");
            int id = Integer.parseInt(customerId);
            int index = searchForCustomer(id);

            if (index != -1) {
                int num = addItemToCart(index);
                if (num == 0) {
                    return;
                } else {

                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry The Customer is not Registered at The System !!!");
            }
            String temp = JOptionPane.showInputDialog(null, "Do You Want To Try Again ?? Y/N");
            if (temp.toUpperCase().equals("Y")) {
                loopNum = 1;
            } else {
                loopNum = 0;
            }
        } while (loopNum == 1);
    }
    
    // it takes the index of the customer in the arraylist and used in the addItemsToCustomerShoppingCart method to add the item
    private static int addItemToCart(int index) {
        int loopVar = -1;
        do {
            String Data = customers.get(index).getInfo() + "\n The Available Items in the store: \n";
            for (Item i : items) {
                Data += i.getInfo();
            }
            Data += "....................................... \n"
                    + "0. Return to a main menu \n"
                    + "Enter The  ItemID which you want: ";

            String numberChoose = JOptionPane.showInputDialog(null, Data);
            int choosedNum = Integer.parseInt(numberChoose);

            if (choosedNum == 0) {
                return 0;
            } else {
                int itemIndex = searchForItem(choosedNum);
                String choose = items.get(itemIndex).getInfo() + "\nEnter The Quantity please .. \n";
                String temp = JOptionPane.showInputDialog(null, choose);
                int quant = Integer.parseInt(temp);
                if (items.get(itemIndex).getQuantity() >= quant && quant > 0) {
                    sales.add(new Sale(customers.get(index).getId(), choosedNum, items.get(itemIndex).getPrice(), quant, items.get(itemIndex).getName()));
                    int newQuant = items.get(itemIndex).getQuantity() - quant;
                    items.get(itemIndex).setQuantity(newQuant);
                    JOptionPane.showMessageDialog(null, "The Item is added to the cart sucssfully");
                    return 0;
                }

                String yesMessage = JOptionPane.showInputDialog(null, "Sorry the requaired quantity is not available!! , The available quantity is [ " + items.get(itemIndex).getQuantity() + "], Try Again \n "
                        + "Do You want To Add Another Item To Your Shooping Cart (Y/N)\n");
                if (yesMessage.toUpperCase().equals("Y")) {
                    loopVar = 1;
                } else {
                    loopVar = 0;
                }
            }
        } while (loopVar == 1);

        return -1;
    }
    
    // it takes the customer id and view all the items in the shopping cart and the user can remove any item he want
    private static void removeAnItemFromCustomerShoppingCart(int id) {
        int customerIndex = searchForCustomer(id);
        ArrayList<Sale> newSales = new ArrayList();
        if (customerIndex != -1) {
            String Data = customers.get(customerIndex).getInfo();
            for (Sale s : sales) {
                if (s.getCustomerId() == id) {
                    Data += s.getInfo();
                }
            }
            String Data1 = "What Do You Want To Modify ? \n"
                    + "R. Remove An Item From The Shopping Cart. \n"
                    + "M. Return To The Main Menu. \n"
                    + "Enter Your Choice [R: Remove, M: Main Menu]:";
            String choice = JOptionPane.showInputDialog(null, Data + "\n" + Data1);
            if (choice.toUpperCase().equals("M")) {
                return;
            } else if (choice.toUpperCase().equals("R")) {
                Data += "\n Enter The Item Name Which You Want To Remove .. ";
                String choiceItem = JOptionPane.showInputDialog(null, Data);
                int itemIndex = searchForItem(choiceItem);
                if (itemIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Sorry you inserted a wrong name !!");
                } else {
                    for (Sale s : sales) {
                        if (s.itemName.equals(choiceItem)) {
                            items.get(itemIndex).addQuantity(s.getQuantity());
                        } else {
                            newSales.add(s);
                        }
                    }
                    sales = newSales;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sorry The Customer is not Found !!");
        }
    }
    
    // it takes the customer id and views all items at the shoppingcart
    private static void viewTheItemsInTheShoppingCart(int id) {
        int customerIndex = searchForCustomer(id);

        if (customerIndex != -1) {
            String Data = customers.get(customerIndex).getInfo();
            for (Sale s : sales) {
                if (s.getCustomerId() == id) {
                    Data += s.getInfo();
                }
            }
            JOptionPane.showMessageDialog(null, Data);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry The Customer is not Found !!");
        }
    }
    
    // it takes the customer id and removes all items at the shoppingcart
    private static void emptyTheCustomerShoppingCart(int id) {
        int itemIndex = 0;
        ArrayList<Sale> newSales = new ArrayList();
        for (Sale s : sales) {
            if (s.customerId == id) {
                itemIndex = searchForItem(s.itemId);
                items.get(itemIndex).addQuantity(s.getQuantity());
            } else {
                newSales.add(s);
            }
        }
        sales = newSales;
    }

    private static void test() {
        items.add(new Mobile(1, 100, 3000, "S4", "Samsung", "4", "Black"));
        items.add(new Mobile(2, 100, 7000, "S8", "Samsung", "7", "Black"));
        items.add(new Mobile(3, 100, 9000, "iphone X", "Apple", "6", "Black"));
        customers.add(new Customer(1, 0, "Khaled"));
    }
    
    // it takes the customer id and makes a checkout to calculate the total price for the items inside the shopping cart
    private static void checkOut(int id) {
        int customerIndex = searchForCustomer(id);
        int totalPrice = 0;
        if (customerIndex != -1) {
            String Data = customers.get(customerIndex).getInfo();
            for (Sale s : sales) {
                if (s.getCustomerId() == id) {
                    Data += s.getInfo();
                    totalPrice += (s.getItemPrice() * s.getQuantity());
                }
            }
            Data += "\n\n The TotalPrice is: " + totalPrice + "\n Thank You For Shopping From Our Store ..";
            JOptionPane.showMessageDialog(null, Data);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry The Customer is not Found !!");
        }
    }
}
