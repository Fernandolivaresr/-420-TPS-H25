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

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String infoToString() {
        return "ID:\t" + getID() + "\nName:\t" + getName() + "\nPrice:\t" + getPrice() + "\nColor:\t" + getColor() + "\nNumber:\t" + getNumber();
    }



}
