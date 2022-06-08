// O. Bittel
// 10.03.2017

package aufgabe10;

import javax.swing.*;

public class TelefonBuchGUI extends JFrame {

    public JTextArea taAusgabe;

    public TelefonBuchGUI() {
        // TelefonBuch anlegen:
        TelefonBuch telBuch = new TelefonBuch();

        taAusgabe = new JTextArea(20, 2);

        // Menuleiste einbauen:
        JMenuBar menuBar = new TelefonBuchMenuBar(telBuch, taAusgabe);
        this.setJMenuBar(menuBar);

        // mainPanel mit Umrandung versehen und das
        // Einfuegen- und  SuchenLoeschenPanel einbauen:
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel einfuegenPanel = new TelefonBuchEinfuegenPanel(telBuch, taAusgabe);
        JPanel suchenPanel = new TelefonBuchSuchenLoeschenPanel(telBuch, taAusgabe);
        taAusgabe.setEditable(false);
        JScrollPane ausgabeScrollPane = new JScrollPane(taAusgabe);

        /* telBuch.read(new File("TelBuchMit420Namen.txt"));

        for (String eintrag : telBuch.prefixSearch("")) {
            taAusgabe.append(eintrag + "\n");
        } */

        mainPanel.add(einfuegenPanel);
        mainPanel.add(suchenPanel);
        mainPanel.add(ausgabeScrollPane);

        this.setContentPane(mainPanel);

        // Sonstige Eigenschaften des Hauptfenster setzen:
        this.setTitle("Telefonbuch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelefonBuchGUI();
    }
}
