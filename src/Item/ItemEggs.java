package Item;

public class ItemEggs extends Item {

    private String color;
    private int number;

    public ItemEggs(int ID, String name, double price, String color, int number) {
        super(ID, name, price);
        this.color = color;
        this.number = number;
    }

    @Override
    public Category getCategory() {
        return Category.Eggs;
    }
    @Override
    public String getCategoryString() {
        return Category.Eggs.toString();
    }


    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String infoToString() {
        return "Item information"+
                "\n\tID:\t" + getID() +
                "\n\tName:\t" + getName() +
                "\n\tPrice:\t" + getPrice() +
                "\n\tColor:\t" + getColor() +
                "\n\tNumber:\t" + getNumber();
    }



}
