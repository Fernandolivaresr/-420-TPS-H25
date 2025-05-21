package Inventaire;

import Exceptions.ExceptionInsufficientQuantityInStock;
import Exceptions.ExceptionItemAlreadyExists;
import Exceptions.ExceptionItemNotFound;
import Item.*;

/**
 * Fournit une interface de gestion des articles dans la base de données d'inventaire.
 */
public class InventoryManager {

    private final InventoryDatabase inventoryDatabase;

    /**
     * Constructeur par défaut. Initialise une base de données vide.
     */
    public InventoryManager() {
        inventoryDatabase = new InventoryDatabase();
    }

    /**
     * Ajoute un nouvel article de type pain.
     *
     * @param ID Identifiant unique
     * @param name Nom de l'article
     * @param price Prix de l'article
     * @param color Couleur du pain
     * @param weight Poids du pain
     * @throws ExceptionItemAlreadyExists Si un article avec le même ID existe déjà
     */
    public void addNewBreadItem(int ID, String name, double price, String color, int weight) throws ExceptionItemAlreadyExists {
        ItemBread itemBread = new ItemBread(ID, name, price, color, weight);
        if (inventoryDatabase.findById(ID) == null) {
            inventoryDatabase.insert(itemBread);
        } else {
            throw new ExceptionItemAlreadyExists(itemBread.getID());
        }
    }

    /**
     * Ajoute un nouvel article de type œufs.
     *
     * @param ID Identifiant unique
     * @param name Nom de l'article
     * @param price Prix de l'article
     * @param color Couleur
     * @param number Nombre d'œufs
     * @throws ExceptionItemAlreadyExists Si un article avec le même ID existe déjà
     */
    public void addNewEggsItem(int ID, String name, double price, String color, int number) {
        ItemEggs itemEggs = new ItemEggs(ID, name, price, color, number);
        if (inventoryDatabase.findById(ID) == null) {
            inventoryDatabase.insert(itemEggs);
        } else {
            throw new ExceptionItemAlreadyExists(itemEggs.getID());
        }
    }

    /**
     * Ajoute un nouvel article de type lait.
     *
     * @param ID Identifiant unique
     * @param name Nom de l'article
     * @param price Prix
     * @param fat Taux de gras
     * @param liters Quantité en litres
     * @throws ExceptionItemAlreadyExists Si un article avec le même ID existe déjà
     */
    public void addNewMilkItem(int ID, String name, double price, double fat, double liters) {
        ItemMilk itemMilk = new ItemMilk(ID, name, price, fat, liters);
        if (inventoryDatabase.findById(ID) == null) {
            inventoryDatabase.insert(itemMilk);
        } else {
            throw new ExceptionItemAlreadyExists(itemMilk.getID());
        }

    }

    /**
     * Supprime un article de l'inventaire selon son ID.
     *
     * @param ID Identifiant de l'article à supprimer
     * @throws ExceptionItemNotFound Si l'article n'est pas trouvé
     */
    public void removeItem(int ID) throws ExceptionItemNotFound {

        if (inventoryDatabase.findById(ID) != null) {
            inventoryDatabase.remove(ID);
            /*System.out.println("Item deleted");*/
        }else{
            throw new ExceptionItemNotFound(ID);
        }
    }

    /**
     * Augmente la quantité d'un article existant.
     *
     * @param ID Identifiant de l'article
     * @param quantity Quantité à ajouter
     * @throws ExceptionItemNotFound Si l'article n'existe pas
     */
    public void increaseItemQuantity(int ID, int quantity) throws ExceptionItemNotFound {
        Item inventoryItem = inventoryDatabase.findById(ID);
        if (inventoryItem != null) {
            inventoryItem.increaseQuantityInStock(quantity);
        } else {
            throw new ExceptionItemNotFound(ID);
        }
    }

    /**
     * Diminue la quantité d'un article existant.
     *
     * @param ID Identifiant de l'article
     * @param quantity Quantité à retirer
     * @throws ExceptionItemNotFound Si l'article n'existe pas
     * @throws ExceptionInsufficientQuantityInStock Si la quantité en stock est insuffisante
     */
    public void decreaseItemQuantity(int ID, int quantity) throws ExceptionItemNotFound, ExceptionInsufficientQuantityInStock {
        Item inventoryItem = inventoryDatabase.findById(ID);
        if (inventoryItem != null) {
            if (inventoryItem.getQuantityInStock() >= quantity) {
                inventoryItem.decreaseQuantityInStock(quantity);
            }else {
                throw new ExceptionInsufficientQuantityInStock(quantity);
            }
        } else {
            throw new ExceptionItemNotFound(ID);
        }
    }

    /**
     * Retourne un article selon son ID.
     *
     * @param ID Identifiant de l'article
     * @return L'article trouvé, ou null
     */
    public Item getItem(int ID){
        return inventoryDatabase.findById(ID);
    }

    /**
     * Retourne tous les articles sous forme de tableau.
     *
     * @return Un tableau contenant tous les articles
     */
    public Item[] getArrayOfItems(){
        return inventoryDatabase.getArrayOfItems();
    }

}

