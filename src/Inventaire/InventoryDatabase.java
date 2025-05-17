package Inventaire;

import Exceptions.ExceptionItemNotFound;
import Item.*;

public class InventoryDatabase {

    private int itemsCount;
    private InventoryDatabaseNode first;

    //public methodes
    public InventoryDatabase() {}
    public void insert(Item item){
        //liste chaînée simple
        InventoryDatabaseNode newNode = new InventoryDatabaseNode(item, first);
        first = newNode;
        itemsCount++;
    }
    public Item findById(int ID){
        InventoryDatabaseNode current = first;
        // Parcourir la liste
        while (current != null) {
            if (current.item.getID() == ID) {
                return current.item; // Item trouve
            }
            current = current.next;
        }
        return null; // Pas trouve
    }
    public void remove(int ID){

        InventoryDatabaseNode current = first;
        InventoryDatabaseNode previous = null;
        //parcourir liste
        while (current != null) {
            if (current.item.getID() == ID) {
                if (previous == null) {
                    // Removing the first node
                    first = current.next;
                } else {
                    previous.next = current.next;
                }
                itemsCount--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
    public Item[] getArrayOfItems(){
        return null;
    }
}