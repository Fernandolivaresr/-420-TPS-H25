package Inventaire;

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
    public void remove(int ID){}
    public Item[] getArrayOfItems(){
        return null;
    }
}