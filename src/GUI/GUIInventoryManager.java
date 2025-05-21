package GUI;

import Exceptions.ExceptionItemNotFound;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import Inventaire.*;
import Item.*;

/**
 * Classe graphique pour la gestion d'inventaire.
 * Permet d'afficher et de manipuler une liste d'objets Item à l'aide de l'interface Swing.
 */

public class GUIInventoryManager extends JFrame {
    private InventoryManager inventoryManager;
    private DefaultListModel<Item> itemsListModel;
    private JList itemsList;
    private int nextID;

    /**
     * Constructeur principal de l'interface graphique.
     * Initialise l'application avec un gestionnaire d'inventaire donné, prépare l'interface graphique,
     * et initialise le prochain ID d'article à 100.
     * @param inventoryManager Le gestionnaire d'inventaire à utiliser pour gérer les articles
     */
    public GUIInventoryManager(InventoryManager inventoryManager) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.inventoryManager = inventoryManager;
        nextID = 100;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        add(createTitlePane(), BorderLayout.NORTH);
        add(createContentPane(), BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(border());
        contentPane.setLayout(new BorderLayout());

        contentPane.add(createItemActions(), BorderLayout.NORTH);
        contentPane.add(createItemsList(), BorderLayout.CENTER);
        contentPane.add(createNewButton(), BorderLayout.SOUTH);

        return contentPane;
    }

    private JPanel createTitlePane() {
        JPanel titlePane = new JPanel();
        titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.Y_AXIS));
        titlePane.setBorder(border());

        JLabel title = new JLabel("Gestionnaire d'inventaire", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBorder(titleBorder());
        titlePane.add(title);
        titlePane.add(new JSeparator());

        return titlePane;
    }

    private JScrollPane createItemsList()
    {
        itemsListModel = new DefaultListModel<>();

        for (Item item : inventoryManager.getArrayOfItems()) {
            itemsListModel.addElement(item);
        }

        itemsList = new JList(itemsListModel);
        itemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroller = new JScrollPane(itemsList);

        return listScroller;
    }

    private JPanel createItemActions() {
        JPanel itemButtons = new JPanel();
        itemButtons.setLayout(new BoxLayout(itemButtons, BoxLayout.X_AXIS));

        itemButtons.add(createViewButton());
        itemButtons.add(createIncreaseButton());
        itemButtons.add(createDecreaseButton());
        itemButtons.add(createEditButton());
        itemButtons.add(createDeleteButton());

        return itemButtons;
    }

    private JButton createViewButton() {
        JButton button = new JButton(new ImageIcon("icons/view.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //DONE
                GUIItemDialog guiItemDialog = new GUIItemDialog(this, item, false);
                guiItemDialog.setVisible(true);

            }
        });

        return button;
    }

    private JButton createIncreaseButton() {
        JButton button = new JButton(new ImageIcon("icons/increase.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //DONE
                inventoryManager.increaseItemQuantity(item.getID(), 1);
            }
        });

        return button;
    }

    private JButton createDecreaseButton() {
        JButton button = new JButton(new ImageIcon("icons/decrease.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //DONE
                try{
                    inventoryManager.decreaseItemQuantity(item.getID(), 1);
                }catch (Exception e){
                    showErrorDialog("Stock Insuffisant");
                }
            }
        });

        return button;
    }

    private JButton createEditButton() {
        JButton button = new JButton(new ImageIcon("icons/edit.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item) itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            } else {
                //DONE
                GUIItemDialog guiItemDialog = new GUIItemDialog(this, item, true);
                guiItemDialog.setVisible(true);
            }
        });

        return button;
    }

    private JButton createDeleteButton() {
        JButton button = new JButton(new ImageIcon("icons/delete.png"));
        button.setBorder(buttonBorder());

        button.addActionListener(event -> {
            Item item = (Item)itemsList.getSelectedValue();
            if (item == null) {
                showSelectErrorDialog();
            }
            else {

                try{
                    inventoryManager.removeItem(item.getID());
                    itemsListModel.removeElement(item);
                }catch(ExceptionItemNotFound e){
                    showErrorDialog("Item n'existe pas");
                }
                //
                // DONE -- Ajoutez le code nécessaire pour supprimer un item ainsi que la gestion des
                //         erreurs pour afficher un dialogue d'erreur si jamais on essaye d'effacer un
                //         item qui n'existe pas
                //

            }
        });

        return button;
    }

    private JPanel createNewButton() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton newItemButton = new JButton(new ImageIcon("icons/new.png"));
        newItemButton.addActionListener(event -> {
            GUIItemChoiceDialog guiItemChoiceDialog = new GUIItemChoiceDialog(this);

            guiItemChoiceDialog.addComponentListener(new ComponentListener() {
                @Override
                public void componentResized(ComponentEvent e) { }

                @Override
                public void componentMoved(ComponentEvent e) { }

                @Override
                public void componentShown(ComponentEvent e) { }

                @Override
                public void componentHidden(ComponentEvent e) {
                    Category category = guiItemChoiceDialog.getChosenCategory();
                    if (category != null) {


                        Item newItem = switch (category) {
                            case Bread -> new ItemBread(100, "aucune description", 0, "-", 0);
                            case Eggs -> new ItemEggs(200, "aucune description", 0, "-", 0);
                            case Milk -> new ItemMilk(300, "aucune description", 0, 0, 0);
                            default -> null;
                        };

                        if (newItem != null) {

                            GUIItemDialog guiItemDialog = new GUIItemDialog(GUIInventoryManager.this, newItem, true);
                            guiItemDialog.setVisible(true);

                            itemsListModel.addElement(newItem);
                        }

                    }
                }
            });

            guiItemChoiceDialog.setVisible(true);
        });

        newItemButton.setBorder(buttonNewBorder());
        buttonPanel.add(newItemButton);

        return buttonPanel;
    }

    private void showSelectErrorDialog() {

        showErrorDialog("SVP choisir un item");
    }

    private void showErrorDialog(String message) {
        GUIErrorDialog dialog = new GUIErrorDialog(this, message);
        dialog.setVisible(true);
    }

    private Border border() {

        return BorderFactory.createEmptyBorder(5, 10, 10, 10);
    }

    private Border titleBorder() {

        return BorderFactory.createEmptyBorder(5, 0, 10, 10);
    }

    private Border buttonNewBorder() {
        return BorderFactory.createEmptyBorder(5, 0, 0, 0);
    }

    private Border buttonBorder() {

        return BorderFactory.createEmptyBorder(0, 5, 10 , 5);
    }




}