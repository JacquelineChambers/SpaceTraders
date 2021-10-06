package main.java;

import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Bandit extends NPC {
    private Random r;
    private Frame frame;
    private double demand;

    public Bandit(double percentDamageToInflict, double demand) {
        super(percentDamageToInflict, demand);
        this.demand = demand;
        r = new Random();

    }

    public boolean fight(Player player) {
        if (super.fightPlayer(player)) {
            double creditEarned = 5 * r.nextDouble();
            player.setCredits(player.getCredits() + creditEarned);
            JOptionPane.showMessageDialog(frame, "You won the fight against the Bandit! You earned "
                    + creditEarned + " credits!");
            return true;
        } else {
            super.attackPlayer(player);
            super.takeAllMoney(player);
            JOptionPane.showMessageDialog(frame, "You lost the fight against the Bandit! "
                            + "You lost all credits "
                    + "and your ship took damage!");
            return false;
        }
    }

    public void pay(Player player) {
        if (player.getCredits() >= this.demand) {
            super.takeMoney(player);
            JOptionPane.showMessageDialog(frame, "You lost " + this.demand + " credits!");
        } else if (player.getShip().getCargoList().size() > 0) {
            player.getShip().setCargoList(new LinkedList<Item>());
            JOptionPane.showMessageDialog(frame, "You lost all of your cargo!");
        } else {
            super.attackPlayer(player);
            JOptionPane.showMessageDialog(frame, "Your ship took damage from the bandit!");
        }
    }

    public void flee(Player player) {
        if (!super.fleePlayer(player)) {
            super.takeAllMoney(player);
            super.attackPlayer(player);
            JOptionPane.showMessageDialog(frame, "You failed to flee from the Bandit! "
                    + "You lost the fight against the Bandit! "
                    + "You lost all credits and your ship took damage!");
        } else {
            player.getShip().setFuelAmount(player.getShip().getFuelAmount() - 20);
            JOptionPane.showMessageDialog(frame, "You fled from the Bandit!");
        }
    }

    public double getDemand() {
        return this.demand;
    }
}