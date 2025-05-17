package Inventaire;

import Exceptions.ExceptionInsufficientQuantityInStock;
import Exceptions.ExceptionItemAlreadyExists;
import Exceptions.ExceptionItemNotFound;
import Item.*;


public class InventoryManager {

    private final InventoryDatabase inventoryDatabase;

    public InventoryManager() {
        inventoryDatabase = new InventoryDatabase();
    }
    public void addNewBreadItem(int ID, String name, double price, String color, int weight) throws ExceptionItemAlreadyExists {
        ItemBread itemBread = new ItemBread(ID, name, price, color, weight);
        if (inventoryDatabase.findById(ID) == null) {
            inventoryDatabase.insert(itemBread);
        } else {
            throw new ExceptionItemAlreadyExists(itemBread.getID());
        }
    }
    public void addNewEggsItem(int ID, String name, double price, String color, int number) {
        ItemEggs itemEggs = new ItemEggs(ID, name, price, color, number);
        if (inventoryDatabase.findById(ID) == null) {
            inventoryDatabase.insert(itemEggs);
        } else {
            throw new ExceptionItemAlreadyExists(itemEggs.getID());
        }
    }
    public void addNewMilkItem(int ID, String name, double price, double fat, double liters) {
        ItemMilk itemMilk = new ItemMilk(ID, name, price, fat, liters);
        if (inventoryDatabase.findById(ID) == null) {
            inventoryDatabase.insert(itemMilk);
        } else {
            throw new ExceptionItemAlreadyExists(itemMilk.getID());
        }

    }
    public void removeItem(int ID) throws ExceptionItemNotFound {

        if (inventoryDatabase.findById(ID) != null) {
            inventoryDatabase.remove(ID);
            /*System.out.println("Item deleted");*/
        }else{
            throw new ExceptionItemNotFound(ID);
        }
    }
    public void increaseItemQuantity(int ID, int quantity) throws ExceptionItemNotFound {
        Item inventoryItem = inventoryDatabase.findById(ID);
        if (inventoryItem != null) {
            inventoryItem.increaseQuantityInStock(quantity);
        } else {
            throw new ExceptionItemNotFound(ID);
        }
    }

    public void decreaseItemQuantity(int ID, int quantity) throws ExceptionItemNotFound, ExceptionInsufficientQuantityInStock {
        Item inventoryItem = inventoryDatabase.findById(ID);
        if (inventoryItem != null) {
            if (inventoryItem.getQuantityInStock() > quantity) {
                inventoryItem.decreaseQuantityInStock(quantity);
            }else {
                throw new ExceptionInsufficientQuantityInStock(quantity);
            }
        } else {
            throw new ExceptionItemNotFound(ID);
        }
    }

    public Item getItem(int ID){
        return inventoryDatabase.findById(ID);
    }

    public Item[] getArrayOfItems(){
        return inventoryDatabase.getArrayOfItems();
    }

}

