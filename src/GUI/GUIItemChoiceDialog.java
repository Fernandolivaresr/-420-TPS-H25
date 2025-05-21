package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Item.*;

/**
 * Boîte de dialogue permettant à l'utilisateur de choisir une catégorie d'article.
 */
public class GUIItemChoiceDialog extends JDialog {
    private JFrame frame;
    private Category chosenCategory;

    /**
     * Constructeur de la boîte de dialogue de sélection de catégorie.
     *
     * @param frame La fenêtre parente à laquelle cette boîte de dialogue est liée
     */
    public GUIItemChoiceDialog(JFrame frame) {
        super(frame, "Choisir un type", Dialog.ModalityType.DOCUMENT_MODAL);
        this.frame = frame;

        chosenCategory = Category.Unknown;
        createAndShowGUI();
    }

    Category getChosenCategory() {
        return chosenCategory;
    }

    private void createAndShowGUI() {
        setLayout(new BorderLayout());

        JButton cancelButton = new JButton("Annuler");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosenCategory = Category.Unknown;
                setVisible(false);
            }
        });
        add(cancelButton, BorderLayout.SOUTH);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new GridLayout(3, 1));
        add(contentPane, BorderLayout.CENTER);

        JButton breadButton = new JButton("Pain");
        breadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosenCategory = Category.Bread;
                setVisible(false);
            }
        });
        contentPane.add(breadButton);

        JButton eggsButton = new JButton("Oeufs");
        eggsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosenCategory = Category.Eggs;
                setVisible(false);
            }
        });
        contentPane.add(eggsButton);

        JButton milkButton = new JButton("Lait");
        milkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosenCategory = Category.Milk;
                setVisible(false);
            }
        });
        contentPane.add(milkButton);

        pack();
    }
}
