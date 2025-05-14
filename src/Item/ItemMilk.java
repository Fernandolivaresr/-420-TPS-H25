package Item;

public class ItemMilk extends Item {

    private double fat;
    private double liters;

    public ItemMilk(int ID, String name, double price, double fat, double liters) {
        super(ID, name, price);
        this.fat = fat;
        this.liters = liters;
    }

    @Override
    public Category getCategory() {
        return Category.Milk;
    }
    @Override
    public String getCategoryString() {
        return Category.Milk.toString();
    }


    public double getFat(){
        return fat;
    }
    public void setFat(double fat){
        this.fat = fat;
    }

    public double getLiters(){
        return liters;
    }
    public void setLiters(double liters){
        this.liters = liters;
    }

    @Override
    public String infoToString() {
        return "Item information"+
                "\n\tID:\t" + getID() +
                "\n\tName:\t" + getName() +
                "\n\tPrice:\t" + getPrice() +
                "\n\tFat:\t" + getFat() +
                "\n\tLiters:\t" + getLiters();
    }

}
