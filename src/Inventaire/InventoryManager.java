package Inventaire;

import Exceptions.ExceptionItemAlreadyExists;
import Exceptions.ExceptionItemNotFound;
import Item.*;


public class InventoryManager {

    private InventoryDatabase inventoryDatabase;

    //public methodes
    public InventoryManager() {
        inventoryDatabase = new InventoryDatabase();
    }
    public void addNewBreadItem(int ID, String name, double price, String color, int weight) throws ExceptionItemAlreadyExists {
        ItemBread itemBread = new ItemBread(ID, name, price, color, weight);
        if (inventoryDatabase.findById(itemBread.getID()) == null) {
            inventoryDatabase.insert(itemBread);
        } else {
            throw new ExceptionItemAlreadyExists(itemBread.getID());
        }
    }
    public void addNewEggsItem(int ID, String name, double price, String color, int number) {
        ItemEggs itemEggs = new ItemEggs(ID, name, price, color, number);
        if (inventoryDatabase.findById(itemEggs.getID()) == null) {
            inventoryDatabase.insert(itemEggs);
        } else {
            throw new ExceptionItemAlreadyExists(itemEggs.getID());
        }
    }
    public void addNewMilkItem(int ID, String name, double price, double fat, double liters) {
        ItemMilk itemMilk = new ItemMilk(ID, name, price, fat, liters);
        if (inventoryDatabase.findById(itemMilk.getID()) == null) {
            inventoryDatabase.insert(itemMilk);
        } else {
            throw new ExceptionItemAlreadyExists(itemMilk.getID());
        }

    }
    public void removeItem(int ID) throws ExceptionItemNotFound {

        if (inventoryDatabase.findById(ID) == null) {
            throw new ExceptionItemNotFound(ID);
        }else{
            inventoryDatabase.remove(ID);
        }
    }
    public void increaseItemQuantity(int ID, int quantity){}
    public void decreaseItemQuantity(int ID, int quantity){}


    public Item getItem(int ID){
        return inventoryDatabase.findById(ID);
    }
    public Item[] getArrayOfItems(){
        return null;
    }

}

