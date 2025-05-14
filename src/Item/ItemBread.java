package Item;

public class ItemBread extends Item {

    private String color;
    private double weight;

    public ItemBread(int ID, String name, double price, String color, int weight) {
        super(ID, name, price);
        this.color = color;
        this.weight = weight;
    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public String getCategoryString() {
        return "";
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String infoToString() {
        return "ID:\t" + getID() + "\nName:\t" + getName() + "\nPrice:\t" + getPrice() + "\nColor:\t" + getColor() + "\nWeight:\t" + getWeight();
    }

}
