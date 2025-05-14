package Inventaire;

import Item.Item;

public class InventoryManager {

    private InventoryDatabase inventoryDatabase;

    //public methodes
    public InventoryManager() {}
    public void addNewBreadItem(int ID, String name, double price, String color, int weight) {}
    public void addNewEggsItem(int ID, String name, double price, String color, int number) {}
    public void addNewMilkItem(int ID, String name, double price, double fat, double liters) {}
    public void removeItem(int ID){}
    public void increaseItemQuantity(int ID, int quantity){}
    public void decreaseItemQuantity(int ID, int quantity){}


    public Item getItem(int ID){
        return null;
    }
    public Item[] getArrayOfItems(){
        return null;
    }

}

