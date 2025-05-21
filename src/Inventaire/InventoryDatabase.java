package Inventaire;

import Exceptions.ExceptionItemNotFound;
import Item.*;

/**
 * Gère une base de données d'objets Item
 */
public class InventoryDatabase {

    private int itemsCount;
    private InventoryDatabaseNode first;

    /**
     * Constructeur par défaut. Initialise une base de données vide.
     */
    public InventoryDatabase() {}

    /**
     * Insère un nouvel item au début de la base de données.
     *
     * @param item L'article à insérer
     */
    public void insert(Item item){
        //liste chaînée simple
        InventoryDatabaseNode newNode = new InventoryDatabaseNode(item, first);
        first = newNode;
        itemsCount++;
    }

    /**
     * Recherche un article par son ID.
     *
     * @param ID L'identifiant de l'article recherché
     * @return L'article correspondant ou null s'il n'est pas trouvé
     */
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

    /**
     * Supprime un article de la base de données selon son ID.
     *
     * @param ID L'identifiant de l'article à supprimer
     */
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

    /**
     * Retourne tous les articles de la base de données sous forme de tableau.
     *
     * @return Un tableau contenant tous les articles
     */
    public Item[] getArrayOfItems(){
        Item [] items = new Item[itemsCount];
        InventoryDatabaseNode current = first;
        int i = 0;
        while (current != null) {
            items[i++] = current.item;
            current = current.next;
        }
        return items;
    }
}