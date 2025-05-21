package Inventaire;

import Item.*;

/**
 * Représente un nœud dans la liste chaînée de la base de données.
 */
public class InventoryDatabaseNode {

    //default --> visible pour tout le package
    //[item]--next-->null
    Item item;
    InventoryDatabaseNode next;

    /**
     * Constructeur du nœud.
     *
     * @param item L'article contenu dans le nœud
     * @param next Le nœud suivant dans la liste
     */
    public InventoryDatabaseNode(Item item, InventoryDatabaseNode next) {
        this.item = item;
        this.next = next;
    }

}
