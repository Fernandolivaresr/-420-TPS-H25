package Item;

/**
 * Classe représentant un article de type œufs.
 * Hérite de la classe abstraite Item et ajoute des attributs spécifiques comme la couleur et le nombre.
 */
public class ItemEggs extends Item {

    private String color;
    private int number;

    /**
     * Constructeur pour créer un article de type œufs avec ses propriétés spécifiques.
     * @param ID L'identifiant unique de l'article
     * @param name Le nom de l'article
     * @param price Le prix de l'article
     * @param color La couleur de l'article
     * @param number Le nombre de l'article
     */
    public ItemEggs(int ID, String name, double price, String color, int number) {
        super(ID, name, price);
        this.color = color;
        this.number = number;
    }

    /**
     * Retourne la catégorie de l'article.
     * @return La catégorie "Eggs"
     */
    @Override
    public Category getCategory() {
        return Category.Eggs;
    }

    /**
     * Retourne la catégorie de l'article sous forme de chaîne.
     * @return "Eggs"
     */
    @Override
    public String getCategoryString() {
        return Category.Eggs.toString();
    }

    /**
     * Obtient la couleur de l'article
     * @return La couleur de l'article
     */
    public String getColor() {
        return color;
    }

    /**
     * Modifie la couleur de l'article
     * @param color La nouvelle couleur à assigner
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtient le nombre de l'article
     * @return Le nombre de l'article
     */
    public int getNumber() {
        return number;
    }

    /**
     * Modifie le nombre de l'article
     * @param number Le nouveau nombre à assigner
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Méthode utilitaire pour afficher les informations complètes de l'article,
     * @return Une chaîne formatée contenant les informations de l'article
     */
    @Override
    public String infoToString() {
        return super.infoToString() +
                "\n\tColor:\t" + getColor() +
                "\n\tNumber:\t" + getNumber();
    }



}
