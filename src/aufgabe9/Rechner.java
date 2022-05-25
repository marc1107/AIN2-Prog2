package aufgabe9;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Rechner extends JFrame implements ActionListener {
    JTextField tfOperandX;
    JTextField tfOperandY;
    JTextField tfResultat;
    JRadioButton rbDeg;
    JRadioButton rbRad;
    JCheckBox chLightDisplay;
    JButton bPlus;
    JButton bMal;
    JButton bMinus;
    JButton bGeteilt;
    JButton bSin;
    JButton bCos;
    JButton bHoch;
    JButton bLog;
    JButton bClear;

    public static void main(String[] args) {
        new Rechner();
    }

    public Rechner() {
        this.setTitle("Taschenrechner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Programm zentriert starten
        this.setLocationRelativeTo(null);

        // Felder für erstes Panel
        JLabel lblOperandX = new JLabel("Operand x");
        tfOperandX = new JTextField("0");
        JLabel lblOperandY = new JLabel("Operand x");
        tfOperandY = new JTextField("0");
        JLabel lblResultat = new JLabel("Resultat");
        tfResultat = new JTextField("0");
        tfResultat.setEditable(false);

        // erstes Panel
        JPanel pNumbers = new JPanel();
        pNumbers.setLayout(new GridLayout(3, 2));
        pNumbers.setBorder(BorderFactory.createLineBorder(Color.black));

        // Felder in erstes Panel einfügen
        pNumbers.add(lblOperandX);
        pNumbers.add(tfOperandX);
        pNumbers.add(lblOperandY);
        pNumbers.add(tfOperandY);
        pNumbers.add(lblResultat);
        pNumbers.add(tfResultat);


        // Felder für zweites Panel
        rbDeg = new JRadioButton("Deg");
        rbRad = new JRadioButton("Rad");
        chLightDisplay = new JCheckBox("Helles Display");
        rbDeg.setSelected(true);
        chLightDisplay.setSelected(true);
        chLightDisplay.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(rbDeg);
        group.add(rbRad);

        // zweites Panel
        JPanel pConfig = new JPanel();
        pConfig.setLayout(new GridLayout(1, 3));

        // Felder in zweites Panel einfügen
        pConfig.add(rbDeg);
        pConfig.add(rbRad);
        pConfig.add(chLightDisplay);


        // Felder für drittes Panel
        bPlus = new JButton("+");
        bMal = new JButton("*");
        bMinus = new JButton("-");
        bGeteilt = new JButton("/");
        bSin = new JButton("sin");
        bCos = new JButton("cos");
        bHoch = new JButton("x^y");
        bLog = new JButton("log2");

        // Listener
        bPlus.addActionListener(this);
        bMal.addActionListener(this);
        bMinus.addActionListener(this);
        bGeteilt.addActionListener(this);
        bSin.addActionListener(this);
        bCos.addActionListener(this);
        bHoch.addActionListener(this);
        bLog.addActionListener(this);

        // drittes Panel
        JPanel pOperators = new JPanel();
        pOperators.setLayout(new GridLayout(2, 4));
        pOperators.setBorder(BorderFactory.createLineBorder(Color.black));

        // Felder in drittes Panel einfügen
        pOperators.add(bPlus);
        pOperators.add(bMal);
        pOperators.add(bMinus);
        pOperators.add(bGeteilt);
        pOperators.add(bSin);
        pOperators.add(bCos);
        pOperators.add(bHoch);
        pOperators.add(bLog);


        // Feld für viertes Panel
        bClear = new JButton("Clear");
        bClear.addActionListener(this);

        // viertes Panel
        JPanel pClear = new JPanel();

        // Feld in viertes Panel einfügen
        pClear.add(bClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Panels und Buttons hinzufügen
        mainPanel.add(pNumbers);
        mainPanel.add(pConfig);
        mainPanel.add(pOperators);
        mainPanel.add(pClear);

        this.add(mainPanel);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chLightDisplay) {
            if (chLightDisplay.isSelected()) {
                tfOperandX.setBackground(Color.WHITE);
                tfOperandY.setBackground(Color.WHITE);
                tfResultat.setBackground(Color.WHITE);
                tfOperandX.setForeground(Color.BLACK);
                tfOperandY.setForeground(Color.BLACK);
                tfResultat.setForeground(Color.BLACK);
            } else {
                tfOperandX.setBackground(Color.BLACK);
                tfOperandY.setBackground(Color.BLACK);
                tfResultat.setBackground(Color.BLACK);
                tfOperandX.setForeground(Color.YELLOW);
                tfOperandY.setForeground(Color.YELLOW);
                tfResultat.setForeground(Color.YELLOW);
            }

        } else if (e.getSource() == bClear) {
            tfOperandX.setText("0");
            tfOperandY.setText("0");
            tfResultat.setText("0");

        } else {
            double operandX;
            double operandY;

            try {
                operandX = Double.parseDouble(tfOperandX.getText());
                operandY = Double.parseDouble(tfOperandY.getText());
            } catch (NumberFormatException exception) {
                System.out.println("Operanden müssen im Format Zahl oder Zahl.Zahl eingegeben werden!");
                return;
            }

            if (e.getSource() == bPlus) {
                tfResultat.setText(String.format(Locale.US, "%.6f", operandX + operandY));

            } else if (e.getSource() == bMal) {
                tfResultat.setText(String.format(Locale.US, "%.6f", operandX * operandY));

            } else if (e.getSource() == bMinus) {
                tfResultat.setText(String.format(Locale.US, "%.6f", operandX - operandY));

            } else if (e.getSource() == bGeteilt) {
                if (operandY != 0)
                    tfResultat.setText(String.format(Locale.US, "%.6f", operandX / operandY));
                else
                    System.out.println("Durch 0 teilen ist nicht drin!");

            } else if (e.getSource() == bSin) {
                tfOperandY.setText("0");
                double sin;
                if (rbDeg.isSelected()) {
                    // In Grad angegeben
                    sin = Math.sin(Math.toRadians(operandX));
                } else {
                    // In Radian angegeben
                    sin = Math.sin(operandX);
                }
                tfResultat.setText(String.format(Locale.US, "%.6f", sin));

            } else if (e.getSource() == bCos) {
                tfOperandY.setText("0");
                double cos;
                if (rbDeg.isSelected()) {
                    // In Grad angegeben
                    cos = Math.cos(Math.toRadians(operandX));
                } else {
                    // In Radian angegeben
                    cos = Math.cos(operandX);
                }
                tfResultat.setText(String.format(Locale.US, "%.6f", cos));

            } else if (e.getSource() == bHoch) {
                tfResultat.setText(String.format(Locale.US, "%.6f", Math.pow(operandX, operandY)));

            } else if (e.getSource() == bLog) {
                tfOperandY.setText("0");
                double log = Math.log(operandX) / Math.log(2);
                tfResultat.setText(String.format(String.format(Locale.US, "%.6f", log)));
            }
        }
    }
}
