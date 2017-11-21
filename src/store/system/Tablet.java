
package store.system;

public class Tablet extends Item {
    private String companyName;
    private String screenSize;

    public Tablet(int id, int quantity, int price, String name , String companyName, String screenSize) {
        super(id, quantity, price, name);
        this.companyName = companyName;
        this.screenSize = screenSize;
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
    
    @Override
    public String getInfo() //Get all information to use it at print 
    {
                return "ID: " + super.getId() + "     Name: " +super.getName()+ "     Quantity: "+ super.getQuantity()+"     Price: " + super.getPrice() + "     CompanyName: " + this.companyName + "     ScreenSize: " + this.screenSize + "\n";

    }
}
