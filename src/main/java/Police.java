package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Police extends NPC {
    private Frame frame;
    private Random r;
    private boolean negotiated = false;
    private int items;
    private Item item;
    public Police(double percentDamageToInflict, int items) {
        super(percentDamageToInflict, items);
        r = new Random();
        this.items = items;
    }
    public boolean encounter(Player player) {
        return player.getShip().getCargoList().size() <= 0;
    }

    public void forfeit(Player player) {
        removeItems(player);
        player.setKarma(player.getKarma() - 1);
        JOptionPane.showMessageDialog(frame, "The police confiscated "
                + item.getName() + " from you. You received good karma for "
                + "being a law abiding space explorer.");
    }

    public boolean flee(Player player) {
        if (super.fleePlayer(player)) {
            JOptionPane.showMessageDialog(frame, "You were able "
                    + "to successfully escape the police.");
            player.getShip().setFuelAmount(player.getShip().getFuelAmount() - 20);
            return true;
        } else {
            removeItems(player);
            JOptionPane.showMessageDialog(frame, "The police confiscated "
                    + item.getName() + " from you.");
            player.setCredits(player.getCredits() - 20);
            super.attackPlayer(player);
            return false;
        }
    }
    public boolean fight(Player player) {
        if (super.fightPlayer(player)) {
            JOptionPane.showMessageDialog(frame, "You were able to "
                    + "successfully fight off the police");
            return true;
        } else {
            super.attackPlayer(player);
            removeItems(player);
            JOptionPane.showMessageDialog(frame, "You lost the fight! "
                    + "The police confiscated " + item.getName() + " from you.");
            return false;
        }

    }
    private void removeItems(Player player) {
        this.item = player.getShip().removeSingleItem();
        //items = (int) (Math.random() * player.getShip().getCargoList().size());
        // for (int i = items; i > 0; i--) {
        // int randomItem = (int) (Math.random() * items) + 1;
        //System.out.println(player.getShip().getCargoList().get(randomItem));
        // player.getShip().getCargoList().remove(randomItem);
        // }
    }
}
