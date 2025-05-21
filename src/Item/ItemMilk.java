package Item;

/**
 * Classe représentant un article de type lait.
 * Hérite de la classe abstraite Item et ajoute des attributs spécifiques tels que les litres et taux de gras.
 */
public class ItemMilk extends Item {

    private double fat;
    private double liters;

    /**
     * Constructeur pour créer un article de type lait avec ses propriétés spécifiques.
     * @param ID L'identifiant unique de l'article
     * @param name Le nom de l'article
     * @param price Le prix de l'article
     * @param fat Taux de gras de l'article
     * @param liters Les litres de l'article
     */
    public ItemMilk(int ID, String name, double price, double fat, double liters) {
        super(ID, name, price);
        this.fat = fat;
        this.liters = liters;
    }

    /**
     * Retourne la catégorie de l'article.
     * @return La catégorie "Milk"
     */
    @Override
    public Category getCategory() {
        return Category.Milk;
    }

    /**
     * Retourne la catégorie de l'article sous forme de chaîne.
     * @return "Milk"
     */
    @Override
    public String getCategoryString() {
        return Category.Milk.toString();
    }

    /**
     * Obtient taux de gras
     * @return Taux de gras
     */
    public double getFat(){
        return fat;
    }

    /**
     * Modifie taux de gras
     * @param fat La nouvelle Taux de gras à assigner
     */
    public void setFat(double fat){
        this.fat = fat;
    }

    /**
     * Obtient les litres de l'article
     * @return Les litres de l'article
     */
    public double getLiters(){
        return liters;
    }

    /**
     * Modifie les litres de l'article
     * @param liters Les nouveaux litres à assigner
     */
    public void setLiters(double liters){
        this.liters = liters;
    }

    /**
     * Méthode utilitaire pour afficher les informations complètes de l'article,
     * @return Une chaîne formatée contenant les informations de l'article
     */
    @Override
    public String infoToString() {
        return super.infoToString() +
                "\n\tFat:\t" + getFat() +
                "\n\tLiters:\t" + getLiters();
    }

}
