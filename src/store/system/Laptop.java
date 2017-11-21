package store.system;

public class Laptop extends Item{
    private String companyName;
    private String screenSize;
    private String processorSpeed;
    private String hardSpace;
    private String ramSize;

    public Laptop(int id, int quantity, int price, String name , String companyName, String screenSize, String processorSpeed, String hardSpace, String ramSize) {
        super(id, quantity, price, name);
        this.companyName = companyName;
        this.screenSize = screenSize;
        this.processorSpeed = processorSpeed;
        this.hardSpace = hardSpace;
        this.ramSize = ramSize;
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

    public String getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(String processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public String getHardSpace() {
        return hardSpace;
    }

    public void setHardSpace(String hardSpace) {
        this.hardSpace = hardSpace;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }
    
    @Override
    public String getInfo() //Get all information to use it at print 
    {
                return "ID: " + super.getId() + "     Name: " +super.getName()+ "     Quantity: "+ super.getQuantity()+"     Price: " + super.getPrice() + "     CompanyName: " + this.companyName + "     ScreenSize: " + this.screenSize + "     ProcessorSpeed: " + this.processorSpeed + "     HardSpace: " + this.hardSpace + "     RamSize: " + this.ramSize + "\n";

    }
    
}
