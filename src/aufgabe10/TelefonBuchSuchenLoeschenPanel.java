// O. Bittel
// 10.03.2017

package aufgabe10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelefonBuchSuchenLoeschenPanel
        extends JPanel implements ActionListener {

    private final TelefonBuch telBuch;
    private final JTextField tfName;
    private final JTextField tfZusatz;
    private final JComboBox funcComboBox;
    private final JButton buttonAnwenden;
    private final JTextArea taAusgabe;

    public TelefonBuchSuchenLoeschenPanel(TelefonBuch tb, JTextArea ta) {
        telBuch = tb;
        taAusgabe = ta;

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(new JLabel("Name"));
        panel1.add(new JLabel("Zusatz"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        tfName = new JTextField("", 20);
        panel2.add(tfName);
        tfZusatz = new JTextField("", 20);
        panel2.add(tfZusatz);

        Border border = BorderFactory.createTitledBorder("Suchen/Löschen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);

        String[] funcStrings = {"Exakte Suche", "Prefix-Suche", "Löschen"};
        funcComboBox = new JComboBox(funcStrings);
        funcComboBox.setSelectedIndex(1);
        this.add(funcComboBox);

        buttonAnwenden = new JButton("Anwenden");
        this.add(buttonAnwenden);
        buttonAnwenden.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAnwenden) {
            if (funcComboBox.getSelectedIndex() == 0) {
                if (!tfName.getText().equals("") && !tfZusatz.getText().equals("")) {
                    String result = telBuch.exactSearch(tfName.getText(), tfZusatz.getText());
                    if (result != null) {
                        taAusgabe.setText(tfName.getText() + " " + tfZusatz.getText() + " " + result);
                    } else {
                        JOptionPane.showMessageDialog(
                                this,
                                "Keinen Eintrag gefunden!"
                        );
                    }
                } else if (!tfName.getText().equals("") && tfZusatz.getText().equals("")) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Zusatz eingeben!"
                    );
                } else {
                    // To Show all entries
                    List<String> list = telBuch.prefixSearch("");
                    taAusgabe.setText("");

                    for (String eintrag : list) {
                        taAusgabe.append(eintrag + "\n");
                    }
                }
            } else if (funcComboBox.getSelectedIndex() == 1) {
                List<String> list = telBuch.prefixSearch(tfName.getText());
                if (list != null) {
                    taAusgabe.setText("");
                    for (String eintrag : list) {
                        taAusgabe.append(eintrag + "\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Keinen Eintrag gefunden!"
                    );
                }
            } else if (funcComboBox.getSelectedIndex() == 2) {
                if (telBuch.remove(tfName.getText(), tfZusatz.getText())) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Löschen erfolgreich!"
                    );
                    taAusgabe.setText("");
                    List<String> list = telBuch.prefixSearch("");
                    for (String eintrag : list) {
                        taAusgabe.append(eintrag + "\n");
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Löschen nicht erfolgreich!"
                    );
                }
            }
        }
    }
}
