package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class EncounterScreen extends Screen {
    private Player player;
    private NPC npc;
    private EncounterFrequency encounterFreq;
    private Bandit bandit;
    private Police police;
    private Trader trader;
    private CargoDispScreen cargoDispScreen;

    private JPanel panelContainer;
    private JPanel interactionTextPanel;
    private JPanel npcDialoguePanel;
    private JPanel optionPanel;
    private JPanel iconPanel;

    private JLabel openingText;
    private JLabel npcDialogueText;
    private JLabel iconLabel;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    private Dimension minIconSize = new Dimension(600, 600);
    private Dimension prefIconSize = new Dimension(600, 1200);


    public EncounterScreen(Player player, EncounterFrequency encounterFreq) {
        super(player);
        this.player = player;
        this.encounterFreq = encounterFreq;
        //encounterFreq.randEnc();
        //this.npc = encounterFreq.getNPC();

        // Create and setup window
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(1000, 800);
        getFrame().setLocationRelativeTo(null);

        // Add components
        openingText = new JLabel();
        npcDialogueText = new JLabel();
        iconLabel = new JLabel();
        //iconLabel.setPreferredSize(prefIconSize);
        //iconLabel.setMinimumSize(minIconSize);

        // Initialize panels
        panelContainer = new JPanel();
        interactionTextPanel = new JPanel();
        npcDialoguePanel = new JPanel();
        optionPanel = new JPanel();
        iconPanel = new JPanel();
    }

    private void loadBanditScreen() {
        openingText.setText("You've encountered a bandit!");
        npcDialogueText.setText("Give me " + bandit.getDemand() + " credits!");

        //Create image
        ImageIcon icon = new ImageIcon(
                EncounterScreen.class.getResource("/lib/bandit3-logo.jpg"));
        iconLabel.setIcon(icon);

        // Create components
        button1 = new JButton("Pay");
        button2 = new JButton("Flee");
        button3 = new JButton("Fight");

        button1.addActionListener(new BanditPay());
        button2.addActionListener(new BanditFlee());
        button3.addActionListener(new BanditFight());

        // Add components to panels
        optionPanel.add(button1);
        optionPanel.add(button2);
        optionPanel.add(button3);
    }

    private void loadPoliceScreen() {
        openingText.setText("You've encountered the police!");
        npcDialogueText.setText("You have stolen goods. Hand them over!");


        //Create image
        ImageIcon icon = new ImageIcon(
                EncounterScreen.class.getResource("/lib/cop2-logo.jpg"));
        iconLabel.setIcon(icon);



        // Create components
        button1 = new JButton("Forfeit");
        button2 = new JButton("Flee");
        button3 = new JButton("Fight");

        button1.addActionListener(new PoliceForfeit());
        button2.addActionListener(new PoliceFlee());
        button3.addActionListener(new PoliceFight());

        // Add components to panels
        optionPanel.add(button1);
        optionPanel.add(button2);
        optionPanel.add(button3);


    }

    private void loadTraderScreen() {
        openingText.setText("You've encountered a trader!");
        npcDialogueText.setText("Hello! I have "
            + trader.getItem().getName() + " !");

        //Create image
        ImageIcon icon = new ImageIcon(
                EncounterScreen.class.getResource("/lib/trader2-logo.jpg"));
        iconLabel.setIcon(icon);

        // Create components
        // add text box for the user to enter quantity
        button1 = new JButton("Buy");
        button2 = new JButton("Negotiate");
        button3 = new JButton("Rob");
        button4 = new JButton("Ignore");

        button1.addActionListener(new TraderBuy());
        button2.addActionListener(new TraderNegotiate());
        button3.addActionListener(new TraderRob());
        button4.addActionListener(new TraderIgnore());

        // Add components to panels
        optionPanel.add(button1);
        optionPanel.add(button2);
        optionPanel.add(button3);
        optionPanel.add(button4);

    }

    private boolean checkForGameOver() {
        if (this.player.getShip().getHealth() == 0) {
            Screen prevNextScreen = getNextScreen();
            setNextScreen(ScreenContainer.getInstance().getGameOverScreen());
            toggleVisibility(false);
            getNextScreen().toggleVisibility(true);
            setNextScreen(prevNextScreen);
            return true;
        } else {
            return false;
        }
    }
    private void transferToReg() {
        if (checkForGameOver()) {
            return;
        }
        toggleVisibility(false);
        optionPanel.removeAll();
        cargoDispScreen = new CargoDispScreen();
        RegionScreen nextScreen = new RegionScreen(getPlayer(),
                player.getCurrentRegion(), cargoDispScreen);
        ScreenContainer.getInstance().setRegionScreen(nextScreen);
        setNextScreen(nextScreen);
        getNextScreen().toggleVisibility(true);
    }
    private void transferToPrev() {
        if (checkForGameOver()) {
            return;
        }
        toggleVisibility(false);
        optionPanel.removeAll();
        getPlayer().setCurrentRegion(ScreenContainer.getInstance().getPrevRegion());
        cargoDispScreen = new CargoDispScreen();
        RegionScreen nextScreen = new RegionScreen(getPlayer(),
                getPlayer().getCurrentRegion(), cargoDispScreen);
        ScreenContainer.getInstance().setRegionScreen(nextScreen);
        setNextScreen(nextScreen);
        getNextScreen().toggleVisibility(true);
    }

    public boolean getToggleEncounter() {
        return encounterFreq.doesAppear();
    }

    public EncounterFrequency getEncounterFreq() {
        return encounterFreq;
    }

    public void setNPC(NPC npc) {
        this.npc = npc;
        renderEncScreen();
    }

    public void renderEncScreen() {
        // Customize screen components based on NPC type
        if (npc instanceof Bandit) {
            bandit = (Bandit) npc;
            loadBanditScreen();
        } else if (npc instanceof Police) {
            police = (Police) npc;
            loadPoliceScreen();
        } else if (npc instanceof Trader) {
            trader = (Trader) npc;
            loadTraderScreen();
        } else {
            transferToReg();
        }

        // Add components to panels
        interactionTextPanel.add(openingText);
        npcDialoguePanel.add(npcDialogueText);
        iconPanel.add(iconLabel);

        // Add panels to panel container
        panelContainer.add(interactionTextPanel);
        panelContainer.add(npcDialoguePanel);
        panelContainer.add(optionPanel);
        panelContainer.add(iconLabel);

        // Render screen
        getFrame().add(panelContainer);
    }

    ///////////////////////// BANDIT ACTIONS //////////////////////////////////

    class BanditPay implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bandit.pay(player);
            transferToReg();
        }
    }

    class BanditFlee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bandit.flee(player);
            transferToReg();
        }
    }

    class BanditFight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bandit.fight(player);
            transferToReg();
        }
    }

    ///////////////////////// POLICE ACTIONS //////////////////////////////////

    class PoliceForfeit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            police.forfeit(player);
            transferToReg();
        }
    }

    class PoliceFlee implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (police.flee(player)) {
                // show window that says player escaped
                transferToReg();
            } else {
                //System.out.println(getPlayer().getCurrentRegion().getName());
                // show that they didn't escape
                transferToPrev();
            }
        }
    }

    class PoliceFight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (police.fight(player)) {
                // show window that says player won
                transferToReg();
            } else {
                // tell player they went to jail and lost goods and money
                transferToReg();
            }
        }
    }

    ///////////////////////// TRADER ACTIONS //////////////////////////////////

    class TraderBuy implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // temp default 1 item
            trader.payTrader(player, 1);
            transferToReg();
        }
    }

    class TraderNegotiate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Item temp = trader.getItem();
            trader.negotiateWithTrader(player);

            transferToReg();
        }
    }

    class TraderRob implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            trader.robTrader(player);
            transferToReg();
        }
    }

    class TraderIgnore implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // exit interaction screen and go to region
            transferToReg();
        }
    }

    //////////////////////////// Helper Methods ////////////////////////////////

}
