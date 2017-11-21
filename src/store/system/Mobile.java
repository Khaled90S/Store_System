
package store.system;

public class Mobile extends Item{
    private String companyName;
    private String screenSize;
    private String color;

    public Mobile(int id, int quantity, int price, String name , String companyName, String screenSize, String color) {
        super(id, quantity, price, name);
        this.companyName = companyName;
        this.screenSize = screenSize;
        this.color = color;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String getInfo() //Get all information to use it at print 
    {
                return "ID: " + super.getId() + "     Name: " +super.getName()+ "     Quantity: "+ super.getQuantity()+"     Price: " + super.getPrice() + "     CompanyName: " + this.companyName + "     ScreenSize: " + this.screenSize + "     Color: " + this.color + "\n";

    }
}
