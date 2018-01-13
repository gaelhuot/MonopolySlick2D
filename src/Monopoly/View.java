package Monopoly;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jerome on 27/10/2015.
 */

public class View extends JFrame {
    JLabel NbJoueur;
    JTextField NbJoueurtxt;
    JButton  Ok;

    public View() {
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
        NbJoueur = new JLabel( "Nombre de joueurs :", SwingConstants.RIGHT);
        NbJoueurtxt = new JTextField();
        NbJoueurtxt.setColumns(15);
        NbJoueurtxt.setHorizontalAlignment(SwingConstants.CENTER);
        Ok = new JButton("Valider");
    }

    public void creerWidget() {
        JPanel pa3 = new JPanel();
        pa3.add(NbJoueur);
        JPanel pa4 = new JPanel();
        pa4.add(NbJoueurtxt);
        JPanel pan2 = new JPanel();
        pan2.add(Ok);
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

    public JButton getOk(){
        return Ok;
    }

    public String getNbjoueurs(){
        return this.NbJoueurtxt.getText();
    }

    public JLabel getNbJoueur(){
        return NbJoueur;
    }

    public void setNbJoueur(String txt){
        NbJoueur.setText(txt);
    }
}

