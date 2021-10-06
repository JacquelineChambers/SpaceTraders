package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegionFuel {
    private int fuel;
    private double fuelPrice;
    private JTextField fuelTextField;
    private Region region;
    private JButton buyFuel;
    private Player player;
    private JFrame frame;
    public RegionFuel(Region region, RegionScreen regionScreen, Player player) {
        this.region = region;
        buyFuel = new JButton();
        this.player = player;
        fuelTextField = new JTextField("0", 3);
        buyFuel.setText("purchase fuel");
        buyFuel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkAmountPurchase()) {
                    player.setCredits(player.getCredits()
                            - (Integer.parseInt(fuelTextField.getText()) * getFuelPrice()));
                    player.getShip().setFuelAmount(player.getShip().getFuelAmount()
                            + (Integer.parseInt(fuelTextField.getText())));
                    regionScreen.updateFrame(player);
                    JOptionPane.showMessageDialog(frame, "You purchased "
                            + (Integer.parseInt(fuelTextField.getText()) + " amount of fuel."));
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Not enough credits to purchase this gasoline.");
                }
            }
        });
    }
    public int getRegionFuel() {
        switch (region.getTechLevel()) {
        case RENAISSANCE:
            fuel = 10;
            fuelPrice = 20.5;
            break;
        case INDUSTRIAL:
            fuel = 100;
            fuelPrice = 50.2;
            break;
        case MODERN:
            fuel = 800;
            fuelPrice = 80.6;
            break;
        case FUTURISTIC:
            fuel = 5000;
            fuelPrice = 82.10;
            break;
        default:
            fuel = 0;
            fuelPrice = 0;
            break;
        }
        return fuel;
    }

    public double getFuelPrice() {
        return fuelPrice + (player.getDifficulty() * 0.5) - player.getMerchantPoints();
    }
    public JTextField getFuelTextField() {
        return fuelTextField;
    }
    public JButton getBuyFuelButton() {
        return buyFuel;
    }
    public boolean checkAmountPurchase() {
        return player.getCredits() - (Integer.parseInt(fuelTextField.getText())
                * getFuelPrice()) > 0;
    }
}
