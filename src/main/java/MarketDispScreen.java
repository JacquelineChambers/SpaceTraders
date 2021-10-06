package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;

public class MarketDispScreen {
    private JFrame frame;

    private JPanel panelContainer;
    private JPanel foodContainer;
    private JPanel medicineContainer;
    private JPanel weaponContainer;
    private JPanel technologyContainer;
    private JPanel goldContainer;
    private JPanel woodContainer;
    private JPanel itemDisplayContainer;


    //swing panels
    private JLabel marketLabel;
    private JLabel item1;
    private JLabel item2;
    private JLabel item3;
    private JLabel item4;
    private JLabel item5;
    private JLabel item6;
    private JLabel item7;
    private JLabel item8;
    private JLabel item9;
    private JLabel item10;
    private JLabel food;
    private JLabel medicine;
    private JLabel weapon;
    private JLabel technology;
    private JLabel gold;
    private JLabel wood;

    //button
    private JButton purchase;

    //instantiated objects
    private Player player;
    private Ship ship;
    private Market market;
    private Region region;
    private MarketPrices marketPrices;
    private ItemAmount itemAmount;

    //arrays
    private String[] items;
    private int[] resources;
    private double[] prices;
    private JTextField[] itemPurchaseArr;
    private int[] numItems;
    private double totalCost;
    private int totalCargo;

    private RegionScreen regionScreen;
    private CargoDispScreen cargoDispScreen;

    public MarketDispScreen(Region region, Player player, RegionScreen regionScreen) {
        this.player = player;

        this.cargoDispScreen = new CargoDispScreen();
        this.regionScreen = regionScreen;

        frame = new JFrame();
        itemPurchaseArr = new JTextField[10];

        panelContainer = new JPanel();
        foodContainer = new JPanel();
        medicineContainer = new JPanel();
        weaponContainer = new JPanel();
        technologyContainer = new JPanel();
        goldContainer = new JPanel();
        woodContainer = new JPanel();
        itemDisplayContainer = new JPanel();


        item1 = new JLabel();
        item2 = new JLabel();
        item3 = new JLabel();
        item4 = new JLabel();
        item5 = new JLabel();
        item6 = new JLabel();
        item7 = new JLabel();
        item8 = new JLabel();
        item9 = new JLabel();
        item10 = new JLabel();


        purchase = new JButton("Purchase");

        //put in the amount want to purchase

        itemPurchaseArr[0] = new JTextField("0", 3);
        itemPurchaseArr[1] = new JTextField("0", 3);
        itemPurchaseArr[2] = new JTextField("0", 3);
        itemPurchaseArr[3] = new JTextField("0", 3);
        itemPurchaseArr[4] = new JTextField("0", 3);
        itemPurchaseArr[5] = new JTextField("0", 3);
        itemPurchaseArr[6] = new JTextField("0", 3);
        itemPurchaseArr[7] = new JTextField("0", 3);
        itemPurchaseArr[8] = new JTextField("0", 3);
        itemPurchaseArr[9] = new JTextField("0", 3);


        //item labels
        food = new  JLabel("Food: ");
        medicine = new JLabel("Medicine: ");
        weapon = new JLabel("Weapon: ");
        technology = new JLabel("Technology: ");
        gold = new JLabel("Gold: ");
        wood = new JLabel("Wood: ");

        //item labels put in containers
        foodContainer.add(food);
        medicineContainer.add(medicine);
        weaponContainer.add(weapon);
        technologyContainer.add(technology);
        goldContainer.add(gold);
        woodContainer.add(wood);

        this.market = new Market(region);
        this.region = region;
        this.items =  this.market.getItems();
        this.resources = this.market.getResources();
        totalCost = 0;
        purchase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkAmountPurchase() && checkCargoSpace()) {

                    player.setCredits(player.getCredits() - totalCost);
                    player.getShip().setCargo(player.getShip().getCargo() - totalCargo);
                    JOptionPane.showMessageDialog(frame, "You spent " + totalCost
                            + " credits. And now have " + player.getCredits() + " remaining." 
                            + "Having " + player.getShip().getCargo() + " remaining");

                    
                    for (int i = 0; i < items.length; i++) {
                        if (!itemPurchaseArr[i].getText().equals("0") 
                            && itemPurchaseArr[i] != null && items[i] != null) {
                            prices[i] %= .6;
                            double price =  ((prices[i]) * 100.0) / 100.0;
                            //System.out.println(player);
                            player.getShip()
                                .addCargo(items[i], price,
                                    Integer.parseInt(itemPurchaseArr[i].getText()));
                        }
                    }
                        regionScreen.updateFrame(player);
                } else  {
                    if (!checkAmountPurchase()) {
                        JOptionPane.showMessageDialog(frame, "Not enough credits.");
                    }
                    if (!checkCargoSpace()) {
                        JOptionPane.showMessageDialog(frame, "Not enough cargo Space.");
                    }
                }
            }
        });

        marketPrices = new MarketPrices(region, player);
        prices = marketPrices.getPrices();
        itemAmount = new ItemAmount(items, resources, region, player);
        numItems = itemAmount.getItemAmount();
        setItems();

    }
    public MarketDispScreen(Region region, Player player) {

        this.market = new Market(region);
        this.marketPrices = new MarketPrices(region, player);
        this.items =  this.market.getItems();
        this.prices = this.marketPrices.getPrices();
    }
    public String[] getItems() {
        return this.items;
    }
    public double[] getPrices() {
        return this.prices;
    }

    public JTextField[] getItemPurchasArr() {
        return itemPurchaseArr;
    }

    public JPanel getPanelFoodContainer() {
        return foodContainer;
    }
    public JPanel getPanelMedicineContainer() {
        return medicineContainer;
    }
    public JPanel getPanelWeaponContainer() {
        return weaponContainer;
    }
    public JPanel getPanelTechnologyContainer() {
        return technologyContainer;
    }
    public JPanel getPanelGoldContainer() {
        return goldContainer;
    }
    public JPanel getPanelWoodContainer() {
        return woodContainer;
    }
    public JButton purchaseButton() {
        return purchase;
    }

    public void setItems() {

        item1.setText(this.items[0] + ": " + this.prices[0]
                +  " credits " + this.numItems[0] + " available");
        item2.setText(this.items[1] + ": " + this.prices[1]
                + " credits " + this.numItems[1] + " available");
        item3.setText(this.items[2] + ": " + this.prices[2]
                + " credits " + this.numItems[2] + " available");
        item4.setText(this.items[3] + ": " + this.prices[3]
                + " credits " + this.numItems[3] + " available");
        item5.setText(this.items[4] + ": " + this.prices[4]
                + " credits " + this.numItems[4] + " available");
        item6.setText(this.items[5] + ": " + this.prices[5]
                + " credits " + this.numItems[5] + " available");
        item7.setText(this.items[6] + ": " + this.prices[6]
                + " credits " + this.numItems[6] + " available");
        item8.setText(this.items[7] + ": " + this.prices[7]
                + " credits " + this.numItems[7] + " available");


        item9.setText(this.resources[0] + "");
        item10.setText(this.resources[1] + "");
        addToPanel();

    }

    public JPanel getItemDisplayPanel() {
        return itemDisplayContainer;
    }
    public void addToPanel() {
        if (region.getTechLevel() == TechLevel.PREAG) {
            foodContainer.add(item1);
            foodContainer.add(itemPurchaseArr[0]);
            foodContainer.add(item2);
            foodContainer.add(itemPurchaseArr[1]);
            foodContainer.add(item3);
            foodContainer.add(itemPurchaseArr[2]);
            foodContainer.add(item4);
            foodContainer.add(itemPurchaseArr[3]);
            foodContainer.add(item5);
            foodContainer.add(itemPurchaseArr[4]);
            foodContainer.add(item6);
            foodContainer.add(itemPurchaseArr[5]);
            medicineContainer.add(item7);
            medicineContainer.add(itemPurchaseArr[6]);
            weaponContainer.add(item8);
            weaponContainer.add(itemPurchaseArr[7]);
        }
        if (region.getTechLevel() == TechLevel.AGRICULTURE) {
            foodContainer.add(item1);
            foodContainer.add(itemPurchaseArr[0]);
            foodContainer.add(item2);
            foodContainer.add(itemPurchaseArr[1]);
            foodContainer.add(item3);
            foodContainer.add(itemPurchaseArr[2]);
            foodContainer.add(item4);
            foodContainer.add(itemPurchaseArr[3]);
            foodContainer.add(item5);
            foodContainer.add(itemPurchaseArr[4]);
            medicineContainer.add(item6);
            medicineContainer.add(itemPurchaseArr[5]);
            weaponContainer.add(item7);
            weaponContainer.add(itemPurchaseArr[6]);
            weaponContainer.add(item8);
            weaponContainer.add(itemPurchaseArr[7]);
        }
        if (region.getTechLevel() == TechLevel.MEDIEVAL) { //3 food, 1 med, 3 weapon, 1 tech
            foodContainer.add(item1);
            foodContainer.add(itemPurchaseArr[0]);
            foodContainer.add(item2);
            foodContainer.add(itemPurchaseArr[1]);
            foodContainer.add(item3);
            foodContainer.add(itemPurchaseArr[2]);
            medicineContainer.add(item4);
            medicineContainer.add(itemPurchaseArr[3]);
            weaponContainer.add(item5);
            weaponContainer.add(itemPurchaseArr[4]);
            weaponContainer.add(item6);
            weaponContainer.add(itemPurchaseArr[5]);
            weaponContainer.add(item7);
            weaponContainer.add(itemPurchaseArr[6]);
            technologyContainer.add(item8);
            technologyContainer.add(itemPurchaseArr[7]);
        }
        if (region.getTechLevel() == TechLevel.RENAISSANCE) {
            foodContainer.add(item1);
            foodContainer.add(itemPurchaseArr[0]);
            foodContainer.add(item2);
            foodContainer.add(itemPurchaseArr[1]);
            medicineContainer.add(item4);
            medicineContainer.add(itemPurchaseArr[3]);
            medicineContainer.add(item5);
            medicineContainer.add(itemPurchaseArr[4]);
            weaponContainer.add(item6);
            weaponContainer.add(itemPurchaseArr[5]);
            weaponContainer.add(item7);
            weaponContainer.add(itemPurchaseArr[6]);
            technologyContainer.add(item8);
            technologyContainer.add(itemPurchaseArr[7]);
        }
        if (region.getTechLevel() == TechLevel.INDUSTRIAL) {
            foodContainer.add(item1);
            foodContainer.add(itemPurchaseArr[0]);
            medicineContainer.add(item2);
            medicineContainer.add(itemPurchaseArr[1]);
            medicineContainer.add(item3);
            medicineContainer.add(itemPurchaseArr[2]);
            weaponContainer.add(item4);
            weaponContainer.add(itemPurchaseArr[3]);
            technologyContainer.add(item5);
            technologyContainer.add(itemPurchaseArr[4]);
            technologyContainer.add(item6);
            technologyContainer.add(itemPurchaseArr[5]);
            technologyContainer.add(item7);
            technologyContainer.add(itemPurchaseArr[6]);
            technologyContainer.add(item8);
            technologyContainer.add(itemPurchaseArr[7]);
        }
        if (region.getTechLevel() == TechLevel.MODERN) {
            foodContainer.add(item1);
            foodContainer.add(itemPurchaseArr[0]);
            medicineContainer.add(item2);
            medicineContainer.add(itemPurchaseArr[1]);
            medicineContainer.add(item3);
            medicineContainer.add(itemPurchaseArr[2]);
            medicineContainer.add(item4);
            medicineContainer.add(itemPurchaseArr[3]);
            weaponContainer.add(item5);
            weaponContainer.add(itemPurchaseArr[4]);
            weaponContainer.add(item6);
            weaponContainer.add(itemPurchaseArr[5]);
            technologyContainer.add(item7);
            technologyContainer.add(itemPurchaseArr[6]);
            technologyContainer.add(item8);
            technologyContainer.add(itemPurchaseArr[7]);
        }
        if (region.getTechLevel() == TechLevel.FUTURISTIC) {
            foodContainer.add(item1);
            foodContainer.add(itemPurchaseArr[0]);
            medicineContainer.add(item2);
            medicineContainer.add(itemPurchaseArr[1]);
            weaponContainer.add(item3);
            weaponContainer.add(itemPurchaseArr[2]);
            weaponContainer.add(item4);
            weaponContainer.add(itemPurchaseArr[3]);
            technologyContainer.add(item5);
            technologyContainer.add(itemPurchaseArr[4]);
            technologyContainer.add(item6);
            technologyContainer.add(itemPurchaseArr[5]);
            technologyContainer.add(item7);
            technologyContainer.add(itemPurchaseArr[6]);
            technologyContainer.add(item8);
            technologyContainer.add(itemPurchaseArr[7]);
        }
        goldContainer.add(item9);
        goldContainer.add(itemPurchaseArr[8]);
        woodContainer.add(item10);
        woodContainer.add(itemPurchaseArr[9]);
    }

    private boolean checkAmountPurchase() {
        for (int i = 0; i < itemPurchaseArr.length; i++) {
            if (checkIfInt(itemPurchaseArr[i], i) || itemPurchaseArr[i].getText().equals("0")) {
                totalCost += Double.parseDouble(itemPurchaseArr[i].getText()) * prices[i];
            } else  {
                JOptionPane.showMessageDialog(frame, "Not a valid number." + i);
            }
        }
        return totalCost < player.getCredits();
    }
    private boolean checkIfInt(JTextField itemPurchase, int i) {
        try {
            int test = Integer.parseInt(itemPurchase.getText());
            return test <= numItems[i];
        } catch (NumberFormatException e) {
            return false;

        }
    }
    private boolean checkCargoSpace() {
        for (int i = 0; i < itemPurchaseArr.length; i++) {
            totalCargo += Integer.parseInt(itemPurchaseArr[i].getText());
        }
        return totalCargo < player.getShip().getCargo();
    }
    public JPanel getCargoPanel() {
        return this.cargoDispScreen.getCargoPanel();
    }




}
