package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Boîte de dialogue pour afficher un message d'erreur simple à l'utilisateur.
 */
public class GUIErrorDialog extends JDialog {

    /**
     * Constructeur de la boîte de dialogue d'erreur.
     *
     * @param frame La fenêtre parente à laquelle cette boîte de dialogue est liée
     * @param message Le message d'erreur à afficher
     */
    public GUIErrorDialog(JFrame frame, String message) {
        super(frame, "Erreur", Dialog.ModalityType.DOCUMENT_MODAL);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        Container dialogContainer = getContentPane();
        dialogContainer.setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(new JLabel(message));
        dialogContainer.add(labelPanel, BorderLayout.CENTER);

        JPanel okButtonPanel = new JPanel(new FlowLayout());
        okButtonPanel.add(okButton);
        dialogContainer.add(okButtonPanel, BorderLayout.SOUTH);

        pack();
    }

}