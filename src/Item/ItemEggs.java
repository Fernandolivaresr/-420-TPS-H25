package Item;

public class ItemEggs extends Item {

    private String color;
    private int number;

    public ItemEggs(int ID, String name, double price, String color, int number) {
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
        return super.infoToString() + "\nColor: " + color + "\nNumber: " + number;
    }



}
