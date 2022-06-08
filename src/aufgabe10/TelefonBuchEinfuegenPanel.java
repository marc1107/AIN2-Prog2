// O. Bittel
// 10.03.2017

package aufgabe10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.border.*;

public class TelefonBuchEinfuegenPanel
        extends JPanel implements ActionListener {

    private final TelefonBuch telBuch;
    private final JTextField tfEinfuegenName;
    private final JTextField tfEinfuegenZusatz;
    private final JTextField tfEinfuegenTelNr;
    private final JButton buttonEinfuegen;
    private final JTextArea taAusgabe;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb, JTextArea ta) {
        telBuch = tb;
        taAusgabe = ta;
        
		JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("Name"));
		panel1.add(new JLabel("Zusatz"));
		panel1.add(new JLabel("TelefonNummer"));
		
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1)); 
        tfEinfuegenName = new JTextField("", 20);
        panel2.add(tfEinfuegenName);
        tfEinfuegenZusatz = new JTextField("", 20);
        panel2.add(tfEinfuegenZusatz);
        tfEinfuegenTelNr = new JTextField("", 20);
        panel2.add(tfEinfuegenTelNr);

        Border border = BorderFactory.createTitledBorder("Einfügen");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        buttonEinfuegen = new JButton("Einfügen");
        this.add(buttonEinfuegen);
        buttonEinfuegen.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonEinfuegen) {
            if (!tfEinfuegenName.getText().equals("") && !tfEinfuegenTelNr.getText().equals("")
            && !tfEinfuegenZusatz.getText().equals("")) {
                if (!telBuch.insert(tfEinfuegenName.getText(), tfEinfuegenZusatz.getText(),
                        tfEinfuegenTelNr.getText())) {
                            JOptionPane.showMessageDialog(
                                    this,
                                    "Name mit Zusatz bereits vorhanden!"
                            );
                } else {
                    List<String> list = telBuch.prefixSearch("");
                    taAusgabe.setText("");
                    for (String eintrag : list) {
                        taAusgabe.append(eintrag + "\n");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Bitte Name, Zusatz und Telefonnummer eingeben!"
                );
            }
        }
    }
}
