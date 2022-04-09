// O. Bittel
// 10.03.2017

package aufgabe10;

import aufgabe10.TelefonBuch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TelefonBuchEinfuegenPanel
        extends JPanel implements ActionListener {

    private TelefonBuch telBuch;
    private JTextField tfEinfuegenName;
    private JTextField tfEinfuegenZusatz;
    private JTextField tfEinfuegenTelNr;
    private JButton buttonEinfuegen;

    public TelefonBuchEinfuegenPanel(TelefonBuch tb) {
        telBuch = tb;
        
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
        // ...
    }
}
