package Item;

public class ItemMilk extends Item {

    private double fat;
    private double liters;

    public ItemMilk(int ID, String name, double price, double fat, double liters) {
        super(ID, name, price);
    }

    @Override
    public Category getCategory() {
        return null;
    }
    @Override
    public String getCategoryString() {
        return "";
    }


    public double getFat(){
        return 0;
    }
    public void setFat(double fat){}

    public double getLiters(){
        return 0;
    }
    public void setLiters(double liters){

    }

    public String infoToString() {
        return null;
    }

}
