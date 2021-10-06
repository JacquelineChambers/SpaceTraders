package main.java;

import java.awt.event.*;
import javax.swing.*;

public class ConfigScreen extends Screen {
    //creates screen attributes
    //private JFrame frame;
    private JTextField characterName;

    private JButton difficultyToggle;
    private JButton confirmButton;
    private JButton merchantPtIncrement;
    private JButton merchantPtDecrement;
    private JButton engineerPtIncrement;
    private JButton engineerPtDecrement;
    private JButton fighterPtIncrement;
    private JButton fighterPtDecrement;
    private JButton pilotPtIncrement;
    private JButton pilotPtDecrement;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panelContainer;

    private JLabel merchantPoints;
    private JLabel engineerPoints;
    private JLabel fighterPoints;
    private JLabel pilotPoints;
    private JLabel difficulty;
    private JLabel characterNameLabel;
    private JLabel merchantValue;
    private JLabel engineerValue;
    private JLabel fighterValue;
    private JLabel pilotValue;

    private int merchantInt = 0;
    private int engineerInt = 0;
    private int fighterInt = 0;
    private int pilotInt = 0;
    private int currPoints = 0;
    private int currDifficulty;
    private boolean on = false;


    public ConfigScreen(Player player) {
        super(player);

        this.panel1 = new JPanel();
        this.panel2 = new JPanel();
        this.panel3 = new JPanel();
        this.panel4 = new JPanel();
        this.panel5 = new JPanel();
        this.panel6 = new JPanel();
        this.panel7 = new JPanel();
        this.panelContainer = new JPanel();
        this.characterNameLabel = new JLabel();
        this.difficulty = new JLabel();
        this.merchantPoints = new JLabel();
        this.engineerPoints = new JLabel();
        this.fighterPoints = new JLabel();
        this.pilotPoints = new JLabel();
        this.characterName = new JTextField(16);
        this.merchantValue = new JLabel();
        this.engineerValue = new JLabel();
        this.fighterValue = new JLabel();
        this.pilotValue = new JLabel();
        this.difficultyToggle = new JButton();
        this.confirmButton = new JButton();
        this.merchantPtIncrement = new JButton();
        this.merchantPtDecrement = new JButton();
        this.engineerPtIncrement = new JButton();
        this.engineerPtDecrement = new JButton();
        this.fighterPtIncrement = new JButton();
        this.fighterPtDecrement = new JButton();
        this.pilotPtIncrement = new JButton();
        this.pilotPtDecrement = new JButton();

        difficultyToggle.setText("Difficulty Setting");
        difficultyToggle.addActionListener(new DifficultyToggleListener());

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new ConfirmButtonListener());
        char up = '\u02C4';
        String upStr = Character.toString((char) up);
        char down = '\u02C5';
        String downStr = Character.toString((char) down);
        this.merchantPtIncrement.setText(upStr);
        this.merchantPtDecrement.setText(downStr);
        this.merchantPtIncrement.addActionListener(new MerchIncrButtonListener());
        this.merchantPtDecrement.addActionListener(new MerchDecButtonListener());

        this.engineerPtIncrement.setText(upStr);
        this.engineerPtDecrement.setText(downStr);
        this.engineerPtIncrement.addActionListener(new EngiIncrButtonListener());
        this.engineerPtDecrement.addActionListener(new EngiDecButtonListener());

        this.fighterPtIncrement.setText(upStr);
        this.fighterPtDecrement.setText(downStr);
        this.fighterPtIncrement.addActionListener(new FightIncrButtonListener());
        this.fighterPtDecrement.addActionListener(new FightDecButtonListener());

        this.pilotPtIncrement.setText(upStr);
        this.pilotPtDecrement.setText(downStr);
        this.pilotPtIncrement.addActionListener(new PilotIncrButtonListener());
        this.pilotPtDecrement.addActionListener(new PilotDecButtonListener());

        player.setDifficulty(1);
        currDifficulty = player.getDifficulty();

        this.characterNameLabel.setText("Your Name: ");
        merchantValue.setText(merchantInt + "");
        fighterValue.setText(fighterInt + "");
        engineerValue.setText(engineerInt + "");
        pilotValue.setText(pilotInt + "");
        merchantValue.setText(merchantInt + "");
        this.difficulty.setText("Points: N/A");
        this.fighterPoints.setText("Fighter Points");
        this.engineerPoints.setText("Engineer Points");
        this.pilotPoints.setText("Pilot Points");
        this.merchantPoints.setText("Merchant Points");

        panel1.add(this.characterNameLabel);
        panel1.add(this.characterName);
        panel7.add(this.difficultyToggle);
        panel7.add(this.difficulty);
        panel2.add(this.fighterPoints);
        panel2.add(this.fighterValue);
        panel2.add(this.fighterPtIncrement);
        panel2.add(this.fighterPtDecrement);
        panel3.add(this.engineerPoints);
        panel3.add(this.engineerValue);
        panel3.add(this.engineerPtIncrement);
        panel3.add(this.engineerPtDecrement);
        panel4.add(this.merchantPoints);
        panel4.add(this.merchantValue);
        panel4.add(this.merchantPtIncrement);
        panel4.add(this.merchantPtDecrement);
        panel5.add(this.pilotPoints);
        panel5.add(this.pilotValue);
        panel5.add(this.pilotPtIncrement);
        panel5.add(this.pilotPtDecrement);
        panel6.add(this.confirmButton);


        panelContainer.add(panel1);
        panelContainer.add(panel7);
        panelContainer.add(panel2);
        panelContainer.add(panel3);
        panelContainer.add(panel4);
        panelContainer.add(panel5);
        panelContainer.add(panel6);


        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(1000, 800);
        getFrame().setLocationRelativeTo(null);
        getFrame().add(panelContainer);

        ScreenContainer.getInstance().setRegListScreen(new RegListScreen(player));

    }

    //checks if the player took too many points, than were allocated
    private boolean checkSumPoints() {
        if (currPoints == 0) {
            JOptionPane.showMessageDialog(getFrame(), "Too many points!");
            return false;
        } else {
            return true;
        }
    }

    //checks if the player added a name
    private boolean checkPlayerName() {
        if (characterName.getText().length() == 0) {
            JOptionPane.showMessageDialog(getFrame(), "You don't have a name!");
            return false;
        } else {
            return true;
        }
    }

    private void noDifficultyChosen() {
        JOptionPane.showMessageDialog(getFrame(), "Choose a difficulty!");
    }

    private void resetPoints() {
        pilotInt = 0;
        merchantInt = 0;
        engineerInt = 0;
        fighterInt = 0;

        pilotValue.setText(pilotInt + "");
        merchantValue.setText(merchantInt + "");
        engineerValue.setText(engineerInt + "");
        fighterValue.setText(fighterInt + "");
    }

    public void toggleVisibility(boolean val) {
        getFrame().setVisible(val);
    }

    //changes the difficulty through clicking on the same button
    class DifficultyToggleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            on = true;
            if (currDifficulty == 12) {
                difficultyToggle.setText("Medium");
                difficulty.setText("Points: " + currDifficulty);
                resetPoints();
                getPlayer().setDifficulty(2);
                currPoints = 12;
                currDifficulty = 8;
            } else if (currDifficulty == 8) {
                difficultyToggle.setText("Hard");
                difficulty.setText("Points: " + currDifficulty);
                resetPoints();
                getPlayer().setDifficulty(3);
                currPoints = 8;
                currDifficulty = 16;
            } else {
                difficultyToggle.setText("Easy");
                difficulty.setText("Points: " + currDifficulty);
                resetPoints();
                getPlayer().setDifficulty(1);
                currPoints = 16;
                currDifficulty = 12;
            }
        }
    }

    //confirm button checks to see if name and point allocation qualifications were met,
    //then adds user modified aspects to their attributes
    class MerchIncrButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (checkSumPoints()) {
                merchantValue.setText(++merchantInt + "");
                difficulty.setText("Points: " + --currPoints);
            }
        }
    }

    class MerchDecButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (merchantInt > 0) {
                merchantValue.setText(--merchantInt + "");
                difficulty.setText("Points: " + ++currPoints);
            }
        }
    }

    class EngiIncrButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (checkSumPoints()) {
                engineerValue.setText(++engineerInt + "");
                difficulty.setText("Points: " + --currPoints);
            }
        }
    }

    class EngiDecButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (engineerInt > 0) {
                engineerValue.setText(--engineerInt + "");
                difficulty.setText("Points: " + ++currPoints);
            }
        }
    }

    class FightIncrButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (checkSumPoints()) {
                fighterValue.setText(++fighterInt + "");
                difficulty.setText("Points: " + --currPoints);
            }
        }
    }

    class FightDecButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (fighterInt > 0) {
                fighterValue.setText(--fighterInt + "");
                difficulty.setText("Points: " + ++currPoints);
            }
        }
    }

    class PilotIncrButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (checkSumPoints()) {
                pilotValue.setText(++pilotInt + "");
                difficulty.setText("Points: " + --currPoints);
            }
        }
    }

    class PilotDecButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!on) {
                noDifficultyChosen();
            } else if (pilotInt > 0) {
                pilotValue.setText(--pilotInt + "");
                difficulty.setText("Points: " + ++currPoints);
            }

        }
    }

    class ConfirmButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (checkPlayerName()) {
                getPlayer().setMerchantPoints(merchantInt);
                getPlayer().setFighterPoints(fighterInt);
                getPlayer().setEngineerPoints(engineerInt);
                getPlayer().setPilotPoints(pilotInt);
                getPlayer().setName(characterName.getText());
                ScreenContainer.getInstance().getEncounterScreen().
                        getEncounterFreq().setPlayerEncFreq(getPlayer());
                toggleVisibility(false);
                getNextScreen().toggleVisibility(true);
            }
        }
    }
}
