package Item;

public abstract class Item {

    private int ID;
    private String name;
    private double price;
    private int quantityInStock = 0;

    public Item(int ID, String Name, double price) {
        this.ID = ID;
        this.name = Name;
        this.price = price;
    }

    private Category category;

    //abstract
    public abstract Category getCategory();
    public abstract String getCategoryString();

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void increaseQuantityInStock() {
        quantityInStock++;
    }
    public void decreaseQuantityInStock() {
        quantityInStock--;
    }

    public String infoToString() {
        return "Item information: " +
                "\n\tID:\t"+ ID +
                "\n\tName: " + name +
                "\n\tPrice: " + price +
                "\n\tIn Stock: " + quantityInStock;
    }

    @Override
    public String toString() {
        return infoToString();
    }

}