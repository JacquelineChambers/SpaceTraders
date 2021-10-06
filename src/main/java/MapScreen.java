package main.java;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Iterator;

public class MapScreen extends Screen {

    private JButton[] regionButtons;
    private JLabel regionDetails;

    private Container mapPanel;

    //private JPanel mapPanel;
    private JPanel regionPanel;
    private JPanel containerPanel;

    private JButton enterRegionButton;

    private int width = 500;
    private int height = 600;

    private Universe universe;
    private HashSet<Region> set;
    private Region currentRegionClicked;

    /*public static void main(String[] args) {
        Player player = new Player();
        Universe universe = Universe.getInstance();
        player.setCurrentRegion(new Region(10, 10, "Chie", TechLevel.AGRICULTURE));

        MapScreen mapScreen = new MapScreen(player);
        mapScreen.toggleVisibility(true);

    }*/


    public MapScreen(Player player) {
        super(player);

        universe = Universe.getInstance();
        set = universe.getSet();


        getFrame().setSize(width, height);
        getFrame().setLocationRelativeTo(null);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //make components
        enterRegionButton = new JButton("Enter Region");
        enterRegionButton.addActionListener(new EnterRegionButtonClickListener());

        //make components
        enterRegionButton = new JButton("Enter Region");
        enterRegionButton.addActionListener(new EnterRegionButtonClickListener());

        regionDetails = new JLabel(textCreator(player.getCurrentRegion()));

        //Initialize panels
        mapPanel = new Container();
        mapPanel.setLayout(null);
        regionPanel();
        containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());

        //initialize buttons and adds buttons to map panel
        initializeRegionButtons();
        //  initializeRegionLabels();

        //add components to panels
        regionPanel.add(enterRegionButton);
        containerPanel.add(regionPanel, BorderLayout.SOUTH);
        containerPanel.add(mapPanel, BorderLayout.CENTER);

        //add panels to frame
        getFrame().add(containerPanel);
    }

    public void toggleVisibility(boolean val) {
        getFrame().setVisible(val);
    }

    private void initializeRegionButtons() {

        Iterator<Region> iterator = set.iterator();
        int regionCount = 0;
        regionButtons = new JButton[set.size()];

        while (iterator.hasNext()) {

            Region region = iterator.next();
            int regionX = region.getX() + 201;
            int regionY = region.getY() + 201;

            //Add buttons to array
            regionButtons[regionCount] = new JButton();

            //Set name of buttons
            regionButtons[regionCount].setName(region.getName());

            //set location of buttons
            regionButtons[regionCount].setLayout(null);
            regionButtons[regionCount].setBounds(regionX, regionY, 10, 10);

            //add button click listeners
            regionButtons[regionCount].addActionListener(new RegionButtonClickListener());

            //add buttons to the map panel
            mapPanel.add(regionButtons[regionCount]);

            regionCount++;

        }

    }

    private String textCreator(Region region) {
        TravelCalculator travelCalculator = new TravelCalculator(getPlayer());
        int distance = region.manhattanDistance(getPlayer().getCurrentRegion());
        String out = "";
        if (getPlayer().getPilotPoints() != 0) {
            out = String.format("<html><body> <b> %s </b> <br><br>"
                            + "Tech Level: %s,<br>"
                            + "Coordinates: (%d, %d),<br> "
                            + "Distance: %d <br>"
                            + "Fuel Needed: %.0f<html><body>",
                    region.getName(),
                    region.getTechLevel().name(),
                    region.getX(),
                    region.getY(),
                    distance,
                    travelCalculator.fuelCost(region));
        } else {
            out = String.format("<html><body> <b> %s </b> <br><br>"
                            + "Tech Level: %s,<br>"
                            + "Coordinates: (%d, %d),<br> "
                            + "Distance: %d <br>"
                            + "Fuel Needed: Too much for you",
                    region.getName(),
                    region.getTechLevel().name(),
                    region.getX(),
                    region.getY(),
                    distance);
        }
        return out;
    }

    private void regionPanel() {

        regionPanel = new JPanel();
        regionPanel.setLayout(new GridLayout(1, 2));
        regionPanel.add(regionDetails);
        regionPanel.add(enterRegionButton);

    }

    private Region getRegionClicked(String string) {

        Boolean regionNotObtained = true;
        Iterator<Region> iterator = set.iterator();

        while (regionNotObtained && iterator.hasNext()) {
            Region region = iterator.next();

            if (region.getName().equals(string)) {
                this.currentRegionClicked = region;
                regionNotObtained = false;
            }
        }
        return currentRegionClicked;
    }

    private class EnterRegionButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            toggleVisibility(false);
            getNextScreen().toggleVisibility(true);
        }

    }

    private class RegionButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // find out which region is clicked on
            String regionName = ((JButton) e.getSource()).getText();
            Region region = getRegionClicked(regionName);

            // get region info and display in regionPanel
            regionDetails.setText(textCreator(region));
        }
    }
}
