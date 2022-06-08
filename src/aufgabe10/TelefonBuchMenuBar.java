// O. Bittel
// 10.03.2017

package aufgabe10;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.List;


public class TelefonBuchMenuBar
        extends JMenuBar implements ActionListener {

    private final TelefonBuch telBuch;
    private final JMenuItem TelBuchLesen;
    private final JMenuItem TelBuchSpeichern;
    private final JMenuItem TelBuchBeenden;
    private final JFileChooser fc;
    private final JTextArea taAusgabe;

    public TelefonBuchMenuBar(TelefonBuch tb, JTextArea ta) {
        telBuch = tb;
        taAusgabe = ta;

        JMenu menuDatei = new JMenu("Datei");
        fc = new JFileChooser();
        TelBuchLesen = new JMenuItem("TelefonBuch lesen");
        TelBuchSpeichern = new JMenuItem("TelefonBuch speichern");
        TelBuchBeenden = new JMenuItem("TelefonBuch beenden");
        JSeparator sep = new JSeparator();

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // TelBuchLesen.setMnemonic(KeyEvent.VK_1);
        TelBuchLesen.addActionListener(this);
        // TelBuchSpeichern.setMnemonic(KeyEvent.VK_2);
        TelBuchSpeichern.addActionListener(this);
        // TelBuchBeenden.setMnemonic(KeyEvent.VK_3);
        TelBuchBeenden.addActionListener(this);

        this.add(menuDatei);
        menuDatei.add(TelBuchLesen);
        menuDatei.add(TelBuchSpeichern);
        menuDatei.add(sep);
        menuDatei.add(TelBuchBeenden);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == TelBuchLesen) {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                telBuch.read(file);

                List<String> list = telBuch.prefixSearch("");
                taAusgabe.setText("");
                for (String eintrag : list) {
                    taAusgabe.append(eintrag + "\n");
                }
            }
        } else if (e.getSource() == TelBuchSpeichern) {
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                telBuch.save(file);
            }
        } else if (e.getSource() == TelBuchBeenden) {
            int n = JOptionPane.showConfirmDialog(
                    this,
                    "TelefonBuch wirklich verlassen? Änderungen gehen verloren.",
                    "Beenden",
                    JOptionPane.YES_NO_OPTION
            );
            if (n == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
}

