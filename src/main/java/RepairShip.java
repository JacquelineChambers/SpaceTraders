package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepairShip {
    private int repair;
    private double repairPrices;
    private JTextField fuelTextField;
    private Region region;
    private JButton repairShip;
    private Player player;
    private JFrame frame;
    public RepairShip(Region region, RegionScreen regionScreen, Player player) {
        this.region = region;
        repairShip = new JButton();
        this.player = player;
        fuelTextField = new JTextField("0", 3);
        repairShip.setText("purchase repairs");
        repairShip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkAmountPurchase()) {
                    player.setCredits(player.getCredits()
                            - (Integer.parseInt(fuelTextField.getText()) * getRepairPrices()));
                    player.getShip().setHealth(player.getShip().getHealth()
                            + repair);
                    regionScreen.updateFrame(player);
                    JOptionPane.showMessageDialog(frame, "You completely repaired your ship for "
                            + getRepairPrices() + " credits");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Not enough credits to repair your ship.");
                }
            }
        });
    }
    public int getRegionShipRepairs() {
        switch (region.getTechLevel()) {
        case RENAISSANCE:
            repair = player.getShip().getInitHealth() - player.getShip().getHealth();
            repairPrices = repair * 10;
            break;
        case INDUSTRIAL:
            repair = player.getShip().getInitHealth() - player.getShip().getHealth();
            repairPrices = repair * 15;
            break;
        case MODERN:
            repair = player.getShip().getInitHealth() - player.getShip().getHealth();
            repairPrices = repair * 20;
            break;
        case FUTURISTIC:
            repair = player.getShip().getInitHealth() - player.getShip().getHealth();
            repairPrices = repair * 25;
            break;
        default:
            repair = player.getShip().getInitHealth() - player.getShip().getHealth();
            repairPrices = repair * 30;
            break;
        }
        return repair;
    }

    public double getRepairPrices() {
        return repairPrices + (player.getDifficulty() * 0.5) - player.getEngineerPoints();
    }
    public JTextField getFuelPriceTextField() {
        return fuelTextField;
    }
    public JButton getBuyFuelButton() {
        return repairShip;
    }
    public boolean checkAmountPurchase() {
        return player.getCredits() - (Integer.parseInt(fuelTextField.getText())
                * getRepairPrices()) > 0;
    }
}
