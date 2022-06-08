// O. Bittel
// 10.03.2017

package aufgabe10;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class TelefonBuchMenuBar
        extends JMenuBar implements ActionListener {

    private TelefonBuch telBuch;
    JMenu MenuDatei;
    JMenuItem TelBuchLesen;
    JMenuItem TelBuchSpeichern;
    JMenuItem TelBuchBeenden;
    JFileChooser fc;

    public TelefonBuchMenuBar(TelefonBuch tb) {
        telBuch = tb;
        MenuDatei = new JMenu("Datei");
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

        this.add(MenuDatei);
        MenuDatei.add(TelBuchLesen);
        MenuDatei.add(TelBuchSpeichern);
        MenuDatei.add(sep);
        MenuDatei.add(TelBuchBeenden);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == TelBuchLesen) {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                telBuch.read(file);
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

