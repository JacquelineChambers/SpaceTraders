package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends Screen {
    private JPanel panel;
    private JLabel label;
    private JButton restartGame;

    public GameOverScreen(Player player) {
        super(player);
        this.panel = new JPanel();
        if (player.getShip().getHealth() <= 0) {
            this.label = new JLabel("YOU LOST THE GAME");
        } else {
            this.label = new JLabel("YOU BOUGHT THE UNIVERSE");
        }
        this.restartGame = new JButton();
        this.restartGame.addActionListener(new RestartGame());
        this.panel.add(label);
        this.panel.add(restartGame);
        getFrame().setSize(1000, 800);
        getFrame().add(panel);
    }

    public void renderGameOverScreen() {
        getFrame().add(this.panel);
    }

    class RestartGame implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            toggleVisibility(false);
            Driver.reset();
        }
    }


}