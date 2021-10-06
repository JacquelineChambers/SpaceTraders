package main.java;

import java.awt.event.*;
import javax.swing.*;

//sets initial start screen
class StartScreen extends Screen {
    private JButton button;

    public StartScreen(Player player) {
        super(player);

        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(1000, 800);
        getFrame().setLocationRelativeTo(null);

        button = new JButton("Start Game!");
        button.addActionListener(new ButtonClickListener());
        getFrame().getContentPane().add(button);
    }

   /* public void toggleVisibility(boolean val) {
        getFrame().setVisible(val);
    }

    /**
     * Transfers to config screen once user presses start
     */
   /* private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            toggleVisibility(false);
            configScreen.toggleVisibility(true);
        }
    }
    */
}