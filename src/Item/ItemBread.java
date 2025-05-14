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
        return Category.Bread;
    }
    @Override
    public String getCategoryString() {
        return Category.Bread.toString();
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

    @Override
    public String infoToString() {
        return "Item information" +
                "\n\tID:\t" + getID() +
                "\n\tName:\t" + getName() +
                "\n\tPrice:\t" + getPrice() +
                "\n\tColor:\t" + getColor() +
                "\n\tWeight:\t" + getWeight();
    }

}
