package Inventaire;

import Item.Item;

public class InventoryDatabaseNode {

    //default --> visible pour tout le package
    //[item]--next-->null
    Item item;
    InventoryDatabaseNode next;

    //public methodes
    public InventoryDatabaseNode(Item item, InventoryDatabaseNode next) {
        this.item = item;
        this.next = next;
    }

}
