package main.java;

import javax.swing.*;
import java.awt.event.*;

/**
 * Kristen
 * V1.01
 */
public class CurrPlayerDispScreen extends Screen {

    private JPanel panelContainer;
    private JPanel playerSummaryPanel;
    private JPanel confirmPanel;
    private JLabel playerDetails;
    private JButton confirmButton;


    /**
     * instantiates screen
     *
     * @param player       current player
     */
    public CurrPlayerDispScreen(Player player) {
        super(player);

        // Create and setup window
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(1000, 800);
        getFrame().setLocationRelativeTo(null);

        // Add components
        // Create text in window
        playerDetails = new JLabel();
        playerDetails.setText(textCreator());

        // Button to initiate universe
        confirmButton = new JButton("Travel to starting region!");
        confirmButton.addActionListener(new ButtonClickListener());

        // Initialize panels
        panelContainer = new JPanel();
        playerSummaryPanel = new JPanel();
        confirmPanel = new JPanel();

        // Add components to panels
        playerSummaryPanel.add(playerDetails);
        confirmPanel.add(confirmButton);

        panelContainer.add(playerSummaryPanel);
        panelContainer.add(confirmPanel);

        // Render screen
        getFrame().add(panelContainer);
    }

    /**
     * creates the text to go inside the box using the currPlayers stats
     *
     * @return Formatted text to go inside box
     */
    private String textCreator() {
        //NOTE: format this later with font, size ect...
        String textLabel =
                String.format(
                                "<html><body>Player name: %s<br> "
                                + " Difficulty Level: %s<br> "
                                + " Pilot Points: %s<br> "
                                + " Fighter Points: %s<br> "
                                + " Merchant Points: %s<br> "
                                + " Engineer Points: %s<br> "
                                + " Credits: %s</html></body>",
                        getPlayer().getName(),
                        getPlayer().getDifficulty(),
                        getPlayer().getPilotPoints(),
                        getPlayer().getFighterPoints(),
                        getPlayer().getMerchantPoints(),
                        getPlayer().getEngineerPoints(),
                        getPlayer().getCredits());
        return textLabel;
    }

    @Override
    public void toggleVisibility(boolean val) {
        getFrame().setVisible(val);
        playerDetails.setText(textCreator());
    }

    /*private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Instantiate universe
            Universe universe = Universe.getInstance();
            toggleVisibility(false);
            getNextScreen().toggleVisibility(true);
        }
    }*/
}
