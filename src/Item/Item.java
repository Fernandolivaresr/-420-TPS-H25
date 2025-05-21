package Item;
/**
 * Classe abstraite représentant un article avec un identifiant, un nom, un prix et une quantité en stock.
 * Sous-classes : ItemBread, ItemEggs, ItemMilk
 */
public abstract class Item {
    private int ID;
    private String name;
    private double price;
    private int quantityInStock;

    /**
     * Constructeur pour créer un nouvel item avec un ID, un nom et un prix.
     * La quantité en stock est initialisée à 0.
     * @param ID L'identifiant unique de l'article
     * @param Name Le nom de l'article
     * @param price Le prix de l'article
     */
    public Item(int ID, String Name, double price) {
        this.ID = ID;
        this.name = Name;
        this.price = price;
        this.quantityInStock = 0;
    }

    /**
     * Méthode abstraite pour obtenir la catégorie de l'article.
     * @return La catégorie associée à l'article
     */
    public abstract Category getCategory();
    /**
     * Méthode abstraite pour obtenir la catégorie sous forme de chaîne.
     * @return Le nom de la catégorie
     */
    public abstract String getCategoryString();

    /**
     * Obtient l'ID de l'article.
     * @return L'ID de l'article
     */
    public int getID() {
        return ID;
    }

    /**
     * Modifie l'ID de l'article.
     * @param ID Le nouvel ID à assigner
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Obtient le nom de l'article.
     * @return Le nom de l'article
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom de l'article
     * @param name Le nouvel nom à assigner
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient le prix de l'article
     * @return le prix de l'article
     */
    public double getPrice() {
        return price;
    }

    /**
     * Modifie le prix de l'article.
     * @param price Le nouveau prix à assigner
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Obtient la quantité d'articles en stock.
     * @return La quantité en stock
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Modifie la quantité d'articles en stock.
     * @param quantityInStock La nouvelle quantité à assigner
     */
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Augmente la quantité en stock de l'article.
     * @param quantity La quantité à ajouter au stock
     */
    public void increaseQuantityInStock(int quantity) {
        quantityInStock += quantity;
    }

    /**
     * Diminue la quantité en stock de l'article.
     * @param quantity La quantité à retirer du stock
     */
    public void decreaseQuantityInStock(int quantity) {
        quantityInStock -= quantity;
    }

    /**
     * Méthode pour afficher les informations de l'article.
     * @return Une chaîne contenant les informations de l'article
     */
    public String infoToString() {
        return "Item information: " +
                "\n\tID:\t"+ ID +
                "\n\tName:\t" + name +
                "\n\tPrice:\t" + price +
                "\n\tIn Stock:\t" + getQuantityInStock();
    }

    /**
     * Méthode toString pour afficher un résumé de l'article.
     * @return Une chaîne contenant l'ID, la catégorie, le nom et la quantité
     */
    @Override
    public String toString() {
        return getID() + " : " + getCategory() + " - " + getName() + " (" + getQuantityInStock() + ")";
    }
}