import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe implements ActionListener {

    Random random = new Random(); // pour le random
    JFrame frame = new JFrame(); // fenetre
    JPanel title_panel = new JPanel(); // panel pour le titre
    JPanel button_panel = new JPanel(); // panel pour les boutons
    JLabel textField = new JLabel(); // label pour le texte
    JButton[] buttons = new JButton[9]; // tableau de boutons
    boolean player1_turn; // tour du joueur 1

    TicTacToe() { // constructeur

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermer la fenetre
        frame.setSize(800, 800); // taille de la fenetre
        frame.getContentPane().setBackground(new Color(50, 50, 50)); // couleur de fond
        frame.setLayout(new BorderLayout()); // layout de la fenetre
        frame.setVisible(true); // rendre la fenetre visible

        textField.setBackground(new Color(25, 25, 25)); // couleur de fond du texte
        textField.setForeground(new Color(25, 255, 0)); // couleur du texte
        textField.setFont(new Font("Ink Free", Font.BOLD, 75)); // police du texte
        textField.setHorizontalAlignment(JLabel.CENTER); // alignement du texte
        textField.setText("Tic-Tac-Toe"); // texte
        textField.setOpaque(true); // opacité du texte

        title_panel.setLayout(new BorderLayout()); // layout du panel
        title_panel.setBounds(0, 0, 800, 100); // taille du panel

        button_panel.setLayout(new GridLayout(3, 3)); // layout du panel /on fait une grille
        button_panel.setBackground(new Color(150, 150, 150)); // couleur de fond du panel

        for (int i = 0; i < 9; i++) { // boucle pour les boutons
            buttons[i] = new JButton(); // creer un bouton
            button_panel.add(buttons[i]); // ajouter le bouton au panel
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120)); // police du bouton
            buttons[i].setFocusable(false); // ne pas pouvoir selectionner le bouton
            buttons[i].addActionListener(this); // ajouter un action listener
        }

        title_panel.add(textField); // ajouter le texte au panel
        frame.add(title_panel, BorderLayout.NORTH); // ajouter le panel au nord de la fenetre
        frame.add(button_panel); // ajouter le bouton au centre de la fenetre

        firstTurn(); // premier tour
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }

            }
        }

    }

    public void firstTurn() {

        try {
            Thread.sleep(2000); // attendre 2 secondes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) { // si le random est 0
            player1_turn = true; // tour du joueur 1
            textField.setText("X turn"); // texte
        } else { // si le random est 1
            player1_turn = false; // tour du joueur 2
            textField.setText("O turn"); // texte
        }

    }

    public void check() {
        // check X win conditions
        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }

        // check O win conditions
        if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins");
    }
}
