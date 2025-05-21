package Item;

/**
 * Classe représentant un article de type pain.
 * Hérite de la classe abstraite Item et ajoute des attributs spécifiques comme la couleur et le poids.
 */
public class ItemBread extends Item {

    private String color;
    private double weight;

    /**
     * Constructeur pour créer un article de type pain avec ses propriétés spécifiques.
     * @param ID L'identifiant unique de l'article
     * @param name Le nom de l'article
     * @param price Le prix de l'article
     * @param color La couleur de l'article
     * @param weight Le poids de l'article
     */
    public ItemBread(int ID, String name, double price, String color, int weight) {
        super(ID, name, price);
        this.color = color;
        this.weight = weight;
    }

    /**
     * Retourne la catégorie de l'article.
     * @return La catégorie Bread
     */
    @Override
    public Category getCategory() {
        return Category.Bread;
    }

    /**
     * Retourne la catégorie de l'article sous forme de chaîne.
     * @return "Bread"
     */
    @Override
    public String getCategoryString() {
        return Category.Bread.toString();
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
     * Obtient le poids de l'article
     * @return Le poids de l'article
     */
    public double getWeight() {
        return weight;
    }


    /**
     * Modifie le poids de l'article
     * @param weight Le nouveau poids à assigner
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Méthode utilitaire pour afficher les informations complètes de l'article,
     * @return Une chaîne formatée contenant les informations de l'article
     */
    @Override
    public String infoToString() {
        return super.infoToString() +
                "\n\tColor:\t" + getColor() +
                "\n\tWeight:\t" + getWeight();
    }

}
