package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kristen Brown
 * */
public class Screen {
    private JFrame frame;
    private Player player;
    private Screen nextScreen;

    public Screen(Player player) {
        frame = new JFrame("Group 47");
        this.player = player;
    }

    public void toggleVisibility(boolean val) {
        frame.setVisible(val);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Player getPlayer() {
        return player;
    }

    public Screen getNextScreen() {
        return nextScreen;
    }

    public void setNextScreen(Screen nextScreen) {
        this.nextScreen = nextScreen;
    }

    public void setNextScreen(Screen firstScreen, Screen secondScreen, boolean toggleFirstScreen) {
        if (toggleFirstScreen) {
            this.nextScreen = firstScreen;
        } else {
            this.nextScreen = secondScreen;
        }
    }

    /**
     * Transfers to config screen once user presses start
     */
    public class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            toggleVisibility(false);
            nextScreen.toggleVisibility(true);
        }
    }


}
