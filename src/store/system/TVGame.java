package store.system;

public class TVGame extends Item{
    private String companyName;
    private String hardSpace;
    private String color;

    public TVGame(int id, int quantity, int price, String name , String companyName, String hardSpace, String color) {
        super(id, quantity, price, name);
        this.companyName = companyName;
        this.hardSpace = hardSpace;
        this.color = color;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHardSpace() {
        return hardSpace;
    }

    public void setHardSpace(String hardSpace) {
        this.hardSpace = hardSpace;
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
        return "ID: " + super.getId() + "     Name: " +super.getName()+ "     Quantity: "+ super.getQuantity()+"     Price: " + super.getPrice() + "     CompanyName: " + this.companyName + "     HardSpace: " + this.hardSpace + "     Color: " + this.color + "\n";
    }
    
}
