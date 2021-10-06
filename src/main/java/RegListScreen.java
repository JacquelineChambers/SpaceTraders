package main.java;

import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;

public class RegListScreen extends Screen {

    private JPanel panelContainer;
    private JPanel confirmPanel;

    private JLabel header;
    private JLabel currRegLabel;

    private Region currRegion;
    private Region prevRegion;
    private CargoDispScreen cargoDispScreen;

    private JButton nextButton;
    private JButton confirmButton;

    private Iterator<Region> it;

    public RegListScreen(Player player) {
        super(player);

        // Create and setup window
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(1000, 800);
        getFrame().setLocationRelativeTo(null);

        // Add components
        nextButton = new JButton("Next");
        confirmButton = new JButton("Confirm");


        // Create text in window
        header = new JLabel();
        header.setText("Regions avaliable to travel to:");


        panelContainer = new JPanel();
        currRegLabel = new JLabel();
        JLabel currFuelLabel =  new JLabel();
        currFuelLabel.setText(String.format("Fuel Left: %.0f",
                player.getShip().getFuelAmount()));

        panelContainer.add(currRegLabel);
        panelContainer.add(nextButton);
        panelContainer.add(confirmButton);
        panelContainer.add(currFuelLabel);

        it = Universe.getInstance().getSet().iterator();

        if (it.hasNext()) {
            currRegion = it.next();
            currRegLabel.setText(textCreator(currRegion));
        }

        nextButton.addActionListener(new NextButtonListener());
        confirmButton.addActionListener(new ConfirmButtonListener());

        getFrame().add(panelContainer);

    }

    private String textCreator(Region region) {
        TravelCalculator travelCalculator = new TravelCalculator(getPlayer());
        int distance = region.manhattanDistance(getPlayer().getCurrentRegion());
        String out = "";
        out = String.format("<html><body> <b> %s </b> <br><br>"
                + "Tech Level: %s,<br>"
                + "Coordinates: (%d, %d),<br> "
                + "Distance: %d <br>",
                region.getName(),
                region.getTechLevel().name(),
                region.getX(),
                region.getY(),
                distance);
        if (getPlayer().getPilotPoints() != 0) {
            out += String.format("Fuel Needed: %.0f<html><body>",
                    travelCalculator.fuelCost(region));
        } else {
            out += "Fuel Needed: Too much for you";
        }
        return out;
    }


    public void toggleVisibility(boolean val) {
        getFrame().setVisible(val);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            toggleVisibility(false);
            getNextScreen().toggleVisibility(true);
        }
    }


    private class ConfirmButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            prevRegion = getPlayer().getCurrentRegion();
            if (new TravelCalculator(getPlayer()).travelAbility(currRegion)) {

                getPlayer().setCurrentRegion(currRegion);
                toggleVisibility(false);
                cargoDispScreen = new CargoDispScreen();
                RegionScreen nextScreen = new RegionScreen(getPlayer(),
                        currRegion, cargoDispScreen);


                System.out.println(prevRegion.getName());
                System.out.println(getPlayer().getCurrentRegion().getName());


                ScreenContainer.getInstance().setRegionScreen(nextScreen, prevRegion);
                ScreenContainer.getInstance().getEncounterScreen().getEncounterFreq()
                        .randEnc(ScreenContainer.getInstance().getEncounterScreen());
                setNextScreen(ScreenContainer.getInstance().getEncounterScreen(), nextScreen,
                        ScreenContainer.getInstance().getEncounterScreen().getToggleEncounter());
                ScreenContainer.getInstance().getEncounterScreen().getEncounterFreq().resetAppear();
                getNextScreen().toggleVisibility(true);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Not enough fuel to travel to this region",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (it.hasNext()) {
                currRegion = it.next();
                currRegLabel.setText(textCreator(currRegion));
            } else {
                it = Universe.getInstance().getSet().iterator();
                currRegion = it.next();
                currRegLabel.setText(textCreator(currRegion));
            }
        }
    }
}
