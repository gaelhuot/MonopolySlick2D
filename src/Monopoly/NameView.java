package Monopoly;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jerome on 27/10/2015.
 */

public class NameView extends JFrame {
    JLabel Description;
    JTextField PlayerName;
    JButton  validate;

    public NameView() {
        initattribut();
        creerWidget();
        pack();
        setSize(400,200);                                // Fixe la taille par dfaut
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 400) / 2);
        int y = (int) ((dimension.getHeight() - 200) / 2);
        setLocation(x, y);
        setVisible(true);                                // Affiche la fenetre
        setTitle("Monopoly");

    }
    public void initattribut() {
        Description = new JLabel("", SwingConstants.RIGHT);
        PlayerName = new JTextField();
        PlayerName.setColumns(15);
        PlayerName.setHorizontalAlignment(SwingConstants.CENTER);
        validate = new JButton("Valider");
    }

    public void creerWidget() {
        JPanel pa3 = new JPanel();
        pa3.add(Description);
        JPanel pa4 = new JPanel();
        pa4.add(PlayerName);
        JPanel pan2 = new JPanel();
        pan2.add(validate);
        JPanel pan6 = new JPanel();
        pan6.setLayout(new BoxLayout(pan6, BoxLayout.Y_AXIS));
        pan6.add(pa3);
        pan6.add(pa4);
        JPanel pan8 = new JPanel();
        pan8.setLayout(new BoxLayout(pan8, BoxLayout.Y_AXIS));
        pan8.add(pan6);
        pan8.add(pan2);
        JPanel pan10 = new JPanel();
        pan10.add(pan8);

        setContentPane(pan10);
    }
    public JButton getValidate() {
        return validate;
    }

    public JTextField getPlayerName() {
        return PlayerName;
    }

    public void setDescription(String dsp){
        Description.setText(dsp);
    }
}

