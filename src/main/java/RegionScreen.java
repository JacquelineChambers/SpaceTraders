package main.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//sets initial start screen
class RegionScreen extends Screen {
    private CargoDispScreen cargoPanel;
    private RegionFuel regionFuel;
    private RepairShip repairShip;

    private JPanel panelContainer;
    private JPanel mapPanel;
    private JPanel panelContainerMarket;
    private JPanel panelContainerRegion;
    private JPanel panelContainerCargo;
    private JPanel panelContainerSellingMarket;
    private JPanel panelContainerShipSpecs;
    private JPanel winItemContainer;
    private JLabel fuel;
    private JPanel panelContainerPlayerSpecs;
    private JLabel shipHealth;
    private JLabel playerCredits;
    private JLabel playerName;
    private JLabel regionDetails;
    private JLabel purchaseFuel;
    private JLabel purchaseMarket;
    private JLabel sellingMarket;
    private JLabel fuelAvaliable;

    private JLabel winItem;

    private JLabel repairs;


    private JTabbedPane tabbedPane;

    private JButton listOfRegionsButton;
    private JButton purchaseWinItemButton;

    private int[] backgroundColor;

    private MarketDispScreen marketDispScreen;

    public RegionScreen(Player player, Region region, CargoDispScreen cargoPanel) {
        super(player);
        regionFuel = new RegionFuel(region, this, player);
        repairShip = new RepairShip(region, this, player);
        this.cargoPanel = new CargoDispScreen();
        marketDispScreen = new MarketDispScreen(region, player, this);
        RegListScreen nextScreen = new RegListScreen(getPlayer());
        ScreenContainer.getInstance().setRegListScreen(nextScreen);
        setNextScreen(nextScreen);

        // Create and setup window
        getFrame().setSize(1000, 800);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setLocationRelativeTo(null);

        //tabbed pane
        tabbedPane = new JTabbedPane();

        // Add components
        regionDetails = new JLabel();
        purchaseMarket = new JLabel();
        sellingMarket = new JLabel();
        fuelAvaliable = new JLabel();
        purchaseFuel = new JLabel();
        repairs = new JLabel();


        shipHealth = new JLabel(player.getShip().getHealth() + " ship health left.");
        fuel = new JLabel(player.getShip().getFuelAmount() + " fuel left.");
        playerName = new JLabel("Name: " + player.getName());
        playerCredits = new JLabel("Player credits: " + player.getCredits());
        winItem = new JLabel(player.getName() + "'s Universe " + "Price: "
                + (1000 * player.getDifficulty()) + " credits");


        regionDetails.setText("Region: " + region.getName()
                + " Coordinates: (" + region.getX() + ", " + region.getY() + ")");
        purchaseMarket.setText("Items to Buy");
        sellingMarket.setText("Items to Sell");
        purchaseFuel.setText("Purchase Fuel: ");
        repairs.setText("Purchase Repairs: " + repairShip.getRepairPrices()
                + " credits. To repair your ship.");
        listOfRegionsButton = new JButton("Map");
        purchaseWinItemButton = new JButton("Purchase " + player.getName() + "'s Universe Item");
        purchaseWinItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (player.getCredits() >= (1000 * player.getDifficulty())) {
                    JOptionPane.showMessageDialog(getFrame(), "You won the game!!");
                    Screen prevNextScreen = getNextScreen();
                    setNextScreen(ScreenContainer.getInstance().getGameOverScreen());
                    toggleVisibility(false);
                    getNextScreen().toggleVisibility(true);
                    setNextScreen(prevNextScreen);
                } else {
                    JOptionPane.showMessageDialog(getFrame(), "Not enough credits.");
                }
            }
        });
        fuelAvaliable.setText("Amount For Sale: " + regionFuel.getRegionFuel()
                + " Cost: " + regionFuel.getFuelPrice());
        listOfRegionsButton.addActionListener(new ButtonClickListener());

        // Initialize panels
        panelContainer = new JPanel();
        mapPanel = new JPanel();
        panelContainerCargo = new JPanel();
        panelContainerSellingMarket = new JPanel();
        panelContainerRegion = new JPanel();
        panelContainerMarket = new JPanel();
        panelContainerShipSpecs = new JPanel();
        panelContainerPlayerSpecs = new JPanel();
        winItemContainer = new JPanel();


        // Add components to panels
        panelContainerRegion.add(listOfRegionsButton);
        panelContainerRegion.add(regionDetails);
        panelContainerRegion.add(purchaseMarket);

        panelContainerMarket.add(marketDispScreen.getPanelFoodContainer());
        panelContainerMarket.add(marketDispScreen.getPanelMedicineContainer());
        panelContainerMarket.add(marketDispScreen.getPanelWeaponContainer());
        panelContainerMarket.add(marketDispScreen.getPanelTechnologyContainer());
        panelContainerMarket.add(marketDispScreen.getPanelGoldContainer());
        panelContainerMarket.add(marketDispScreen.getPanelWoodContainer());
        panelContainerMarket.add(marketDispScreen.purchaseButton());
        panelContainerSellingMarket.add(sellingMarket);
        panelContainerShipSpecs.add(fuel);
        panelContainerShipSpecs.add(shipHealth);
        panelContainerCargo.add(this.cargoPanel.displayCargo(player));
        panelContainerPlayerSpecs.add(playerName);
        panelContainerPlayerSpecs.add(playerCredits);
        if (regionFuel.getRegionFuel() > 0) {
            panelContainerMarket.add(purchaseFuel);
            panelContainerMarket.add(fuelAvaliable);
            panelContainerMarket.add(regionFuel.getFuelTextField());
            panelContainerMarket.add(regionFuel.getBuyFuelButton());
        }
        System.out.println(player.getRandomRegion() + " player item here");
        if (player.getCurrentRegion().getName().equals(player.getRandomRegion())) {
            panelContainerMarket.add(winItem);
            panelContainerMarket.add(purchaseWinItemButton);
        }

        if (repairShip.getRegionShipRepairs() > 0) {
            panelContainerMarket.add(repairs);
            panelContainerMarket.add(repairShip.getBuyFuelButton());

        }


        // Customize region panel
        backgroundColor = region.getBackgroundColor();
        panelContainer.setBackground(
                    new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));

        tabbedPane.add("Region", panelContainerRegion);
        tabbedPane.add("Market", panelContainerMarket);
        //tabbedPane.add("Selling Market", panelContainerSellingMarket);
        tabbedPane.add("Cargo", panelContainerCargo);
        tabbedPane.add("Ship", panelContainerShipSpecs);
        tabbedPane.add("Player Info", panelContainerPlayerSpecs);
        getFrame().add(tabbedPane);
        // Render screen
        //getFrame().add(panelContainer);

    }

    @Override
    /**
     * Toggles visibility of screen
     *
     * @param val value to activate screen
     */
    public void toggleVisibility(boolean val) {
        getFrame().setVisible(val);
    }

    /*public JFrame getFrame() {
        return getFrame();
    }*/
    /*
    public RegListScreen getRegListScreen() {
        return this.regListScreen;
    }

    public Region getRegion() {
        return this.region;
    }*/
    public void addToFrame() {
        getFrame().add(marketDispScreen.getCargoPanel());
        getFrame().revalidate();
        getFrame().setVisible(false);
        getFrame().setVisible(true);
    }

    public void updateFrame(Player player) {
        this.panelContainerCargo.removeAll();
        this.panelContainerCargo.add(this.cargoPanel.displayCargo(player));
        this.panelContainerShipSpecs.removeAll();
        this.fuel.setText(player.getShip().getFuelAmount() + " fuel left.");
        this.panelContainerShipSpecs.add(this.fuel);
        this.shipHealth.setText(player.getShip().getHealth() + " ship health left.");
        this.panelContainerShipSpecs.add(shipHealth);
    }

    /**
     * Allows button to transfer screen to the map
     */
    /*
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            toggleVisibility(false);
            getNextScreen().toggleVisibility(true);
        }
    }*/
}
