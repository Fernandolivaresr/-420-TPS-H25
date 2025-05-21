import Exceptions.ExceptionInsufficientQuantityInStock;
import Exceptions.ExceptionItemAlreadyExists;
import Exceptions.ExceptionItemNotFound;
import GUI.GUIInventoryManager;
import Inventaire.InventoryManager;
import Item.*;

import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.*;

/**
 * Classe principale utilisée pour tester les fonctionnalités de gestion d’inventaire.
 * Elle inclut des méthodes utilitaires pour lire et écrire un inventaire à partir d’un fichier
 */
public class TestingMain  {

    /**
     * Méthode principale.
     *
     * @param args Arguments de la ligne de commande
     * @throws Exception En cas d’erreur pendant les tests
     */
    public static void main(String[] args) throws Exception {

        //https://github.com/Fernandolivaresr/-420-TPS-H25

        InventoryManager inventoryManager = new InventoryManager();
        lireInventaire("items.in",inventoryManager);                                          // 9 points
        System.out.println("\n=> TEST Création de nouveaux items");                                 // 6 points
        inventoryManager.addNewBreadItem(10, "Pain brun riche", 2.45, "brun", 200);
        inventoryManager.addNewBreadItem(11, "Pain blanc traditionnel", 1.50, "blanc", 200);
        inventoryManager.addNewEggsItem(12, "Oeufs de poules en liberté", 3.50, "Brun", 12);
        inventoryManager.addNewMilkItem(13, "Lait bio très gras", 8.45, 3.8, 2);

        System.out.println("\n=> TEST Trouver un item et afficher l'information sur cet item");     // 6 points
        Item item1 = inventoryManager.getItem(10);
        System.out.println(item1.infoToString());

        System.out.println("\n=> TEST Création d'un item avec un ID existant");                     // 6 points
        try {
            inventoryManager.addNewBreadItem(10, "Pain bio", 5, "brun", 400);
        } catch (ExceptionItemAlreadyExists e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=> TEST Enlever un item");                                            // 6 points
        inventoryManager.removeItem(10);

        System.out.println("\n=> TEST Enlever un item non existant (catch exception)");             // 6 points
        try {
            inventoryManager.removeItem(10);
        } catch (ExceptionItemNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=> TEST Incrémenter la quantité d'un item");                          // 8 points
        try {
            inventoryManager.increaseItemQuantity(10, 18);
        } catch (ExceptionItemNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            inventoryManager.increaseItemQuantity(11, 3);
        } catch (ExceptionItemNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            inventoryManager.increaseItemQuantity(12, 4);
        } catch (ExceptionItemNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            inventoryManager.increaseItemQuantity(13, 23);
        } catch (ExceptionItemNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=> TEST Incrementer la quantité d'un item et afficher les nouvelles informations"); // 6 points
        inventoryManager.increaseItemQuantity(11, 25);
        Item item2 = inventoryManager.getItem(11);
        System.out.println(item2.infoToString());

        System.out.println("\n=> TEST Incrementer la quantité d'un item et afficher les nouvelles informations");// 6 points
        inventoryManager.increaseItemQuantity(11, 3);
        Item item3 = inventoryManager.getItem(11);
        System.out.println(item3.infoToString());

        System.out.println("\n=> Décrementer la quantité d'un item non existant (catch exception)");// 6 points
        try {
            inventoryManager.decreaseItemQuantity(10, 1);
        } catch (ExceptionItemNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=> TEST Trop décrémenter la quantité d'un item (catch exception)");   // 6 points
        try {
            inventoryManager.decreaseItemQuantity(11, 32);
         } catch (ExceptionInsufficientQuantityInStock e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=> TEST Récupérer le array de items");// points
        Item[] items = inventoryManager.getArrayOfItems();
        for (Item item : items) {
            System.out.println(item.infoToString());
        }
        ecrireInventaire("items.out",inventoryManager);                                       // 9 points
        GUIInventoryManager GUIInventoryManager = new GUIInventoryManager(inventoryManager);   // 20 points

    }

    /**
     * Lit un fichier contenant des données d’inventaire, analyse chaque ligne à l’aide d’expressions régulières,
     * puis ajoute les articles correspondants à l’objet InventoryManager
     *
     * @param fichier Le chemin du fichier à lire
     * @param inventoryManager L’instance de gestionnaire d’inventaire à mettre à jour
     */
    private static void lireInventaire(String fichier, InventoryManager inventoryManager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Extraire les infos avec regex
                Pattern pattern = Pattern.compile("Catégorie \\[(\\w+)] ID \\[(\\d+)] Nom \\[(.+?)] Prix \\[(\\d+(?:\\.\\d+)?)].*");
                Matcher matcher = pattern.matcher(line);

                if (!matcher.find()) continue;
                String categorie = matcher.group(1);
                int id = Integer.parseInt(matcher.group(2));
                String nom = matcher.group(3);
                double prix = Double.parseDouble(matcher.group(4));

                switch (categorie) {
                    case "Milk":
                        Pattern milkPattern = Pattern.compile("Gras \\[(\\d+(?:\\.\\d+)?)].*Litres \\[(\\d+(?:\\.\\d+)?)].*");
                        Matcher milkMatcher = milkPattern.matcher(line);
                        if (milkMatcher.find()) {
                            double fat = Double.parseDouble(milkMatcher.group(1));
                            double liters = Double.parseDouble(milkMatcher.group(2));
                            inventoryManager.addNewMilkItem(id, nom, prix, fat, liters);
                        }
                        break;
                    case "Eggs":
                        Pattern eggsPattern = Pattern.compile("Couleur \\[(.+?)] Nombre \\[(\\d+)]");
                        Matcher eggsMatcher = eggsPattern.matcher(line);
                        if (eggsMatcher.find()) {
                            String couleur = eggsMatcher.group(1);
                            int nb = Integer.parseInt(eggsMatcher.group(2));
                            inventoryManager.addNewEggsItem(id, nom, prix, couleur, nb);
                        }
                        break;
                    case "Bread":
                        Pattern breadPattern = Pattern.compile("Couleur \\[(.+?)] Poids \\[(\\d+)]");
                        Matcher breadMatcher = breadPattern.matcher(line);
                        if (breadMatcher.find()) {
                            String couleur = breadMatcher.group(1);
                            int poids = Integer.parseInt(breadMatcher.group(2));
                            inventoryManager.addNewBreadItem(id, nom, prix, couleur, poids);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }

    /**
     * Écrit le contenu actuel de l’inventaire dans un fichier.
     * Chaque ligne représente un article formaté selon sa catégorie.
     *
     * @param fichier Le chemin du fichier dans lequel écrire
     * @param inventoryManager Le gestionnaire d’inventaire contenant les articles à sauvegarder
     */
    private static void ecrireInventaire(String fichier, InventoryManager inventoryManager){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            Item[] items = inventoryManager.getArrayOfItems();

            for (Item item : items) {
                String line = "";
                switch (item.getCategory()) {
                    case Milk:
                        ItemMilk milk = (ItemMilk) item;
                        line = String.format("Catégorie [Milk] ID [%d] Nom [%s] Prix [%.2f] Gras [%.1f] Litres [%.1f]",
                                milk.getID(), milk.getName(), milk.getPrice(), milk.getFat(), milk.getLiters());
                        break;
                    case Eggs:
                        ItemEggs eggs = (ItemEggs) item;
                        line = String.format("Catégorie [Eggs] ID [%d] Nom [%s] Prix [%.2f] Couleur [%s] Nombre [%d]",
                                eggs.getID(), eggs.getName(), eggs.getPrice(), eggs.getColor(), eggs.getNumber());
                        break;
                    case Bread:
                        ItemBread bread = (ItemBread) item;
                        line = String.format("Catégorie [Bread] ID [%d] Nom [%s] Prix [%.2f] Couleur [%s] Poids [%.0f]",
                                bread.getID(), bread.getName(), bread.getPrice(), bread.getColor(), bread.getWeight());
                        break;
                }
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erreur d’écriture du fichier : " + e.getMessage());
        }
    }
}
