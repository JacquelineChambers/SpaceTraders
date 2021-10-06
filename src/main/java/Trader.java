package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Trader extends NPC {
    private Frame frame;
    private Random r;
    private int num;
    private boolean negotiated = false;
    private Item item;
    private MarketDispScreen marketDispScreen;
    private JTextField[] itemArr;

    public Trader(double percentDamageToInflict, Region region, Player player) {
        super(percentDamageToInflict);
        frame = new Frame();
        r = new Random();
        num = (int) (Math.random() * 7);
        marketDispScreen = new MarketDispScreen(region, player);
        itemArr = marketDispScreen.getItemPurchasArr();
        item = new Item(marketDispScreen.getItems()[num], marketDispScreen.getPrices()[num], 1);
    }

    public void negotiateWithTrader(Player player) {
        if (player.getKarma() > (player.getDifficulty() / 2)) {
            JOptionPane.showMessageDialog(frame, "You've accumulated too much bad karma from "
                    + "robbing traders! Now the traders know you're "
                    + "a trouble maker. No negotiations!");
        } else {
            while (!negotiated) {
                negotiated = true;
                double priceDifference = ((player.getMerchantPoints()) / (16.0)) * item.getPrice();
                if (negotiatedSuccessful(player)) {
                    item.setPrice((item.getPrice() - priceDifference));
                } else {
                    item.setPrice((item.getPrice() + priceDifference));
                }
            }
        }
    }

    public void robTrader(Player player) {
        if (super.fightPlayer(player)) {
            player.setKarma(player.getKarma() + 1);
            player.getShip().addCargo(item);
            JOptionPane.showMessageDialog(frame, item.getName()
                    + " stolen, but you received bad karma!");
        } else {
            super.attackPlayer(player);
            JOptionPane.showMessageDialog(frame, "You were unable to steal anything.");
        }
    }

    public void payTrader(Player player, int numOfItems) {
        if (purchaseValid(player, numOfItems)) {
            player.getShip().addCargo(item);
            player.getShip().setCargo(player.getShip().getCargo() - 1);
            if (player.getCredits() > item.getPrice()) {
                player.setCredits(player.getCredits() - item.getPrice());
                JOptionPane.showMessageDialog(frame, item.getName()
                        + " purchased. With " + (player.getCredits() * 100.0)
                        / 100.0 + " credits left");
            } else {
                JOptionPane.showMessageDialog(frame, "The item was too expensive for you.");
            }

        }
    }

    public boolean negotiatedSuccessful(Player player) {
        if (r.nextDouble() <= ((player.getMerchantPoints()) / (16.0))
                && (player.getCredits() > item.getPrice() / r.nextDouble())) {

            player.setCredits(player.getCredits() - item.getPrice());
            JOptionPane.showMessageDialog(frame, item.getName()
                    + " purchased. Costing: " + item.getPrice() + ". Leaving "
                    + (player.getCredits() * 100.0) / 100.0 + " credits left");
            return true;
        } else {
            System.out.println(r.nextDouble());
            JOptionPane.showMessageDialog(frame, "Negotiation Failed");
            return false;
        }

    }

    public boolean purchaseValid(Player player, int numOfItems) {
        double totalCost = numOfItems * item.getPrice();
        if (!(numOfItems <= item.getAmount()) || numOfItems <= 0) {
            return false;
        } else if (totalCost > player.getCredits()) {
            return false;
        } else {
            player.setCredits(player.getCredits() - totalCost);
            return true;
        }

    }

    public Item getItem() {
        return this.item;
    }

}
