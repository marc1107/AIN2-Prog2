// O. Bittel
// 10.03.2017

package aufgabe10;

import aufgabe10.TelefonBuch;

import javax.swing.*;

public class TelefonBuchGUI extends JFrame {

    private TelefonBuch telBuch;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        telBuch = new TelefonBuch();

        // Menuleiste einbauen:
        // ...

        // mainPanel mit Umrandung versehen und das
        // Einfuegen- und  SuchenLoeschenPanel einbauen:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        // ...
        this.setContentPane(mainPanel);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelefonBuchGUI();
    }
}
