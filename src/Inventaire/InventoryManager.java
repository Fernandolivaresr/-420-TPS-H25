package Inventaire;

import Exceptions.ExceptionItemAlreadyExists;
import Item.*;


public class InventoryManager {

    private InventoryDatabase inventoryDatabase;

    //public methodes
    public InventoryManager() {
        inventoryDatabase = new InventoryDatabase();
    }
    public void addNewBreadItem(int ID, String name, double price, String color, int weight) throws ExceptionItemAlreadyExists {

       /* try {*/
            ItemBread itemBread = new ItemBread(ID, name, price, color, weight);
            if (inventoryDatabase.findById(itemBread.getID()) == null) {
                inventoryDatabase.insert(itemBread);
            } else {
                throw new ExceptionItemAlreadyExists(itemBread.getID());
            }
        /*}catch (ExceptionItemAlreadyExists e) {
            System.out.print(e.getMessage());
        }*/
    }
    public void addNewEggsItem(int ID, String name, double price, String color, int number) {
        ItemEggs itemEggs = new ItemEggs(ID, name, price, color, number);
        inventoryDatabase.insert(itemEggs);
    }
    public void addNewMilkItem(int ID, String name, double price, double fat, double liters) {
        ItemMilk itemMilk = new ItemMilk(ID, name, price, fat, liters);
        inventoryDatabase.insert(itemMilk);
    }
    public void removeItem(int ID){}
    public void increaseItemQuantity(int ID, int quantity){}
    public void decreaseItemQuantity(int ID, int quantity){}


    public Item getItem(int ID){
        return inventoryDatabase.findById(ID);
    }
    public Item[] getArrayOfItems(){
        return null;
    }

}

