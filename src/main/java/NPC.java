package main.java;

import java.util.Random;
import java.awt.image.BufferedImage;
public class NPC {

    private Random r;
    private double percentDamageToInflict;
    private BufferedImage icon;
    private double priceOrDemand;
    private int numItemsDemand;

    public NPC(double percentDamageToInflict) {
        r = new Random();
        this.percentDamageToInflict = percentDamageToInflict;
        this.priceOrDemand = 0;
    }

    public NPC(double percentDamageToInflict, double priceOrDemand) {
        r = new Random();
        this.percentDamageToInflict = percentDamageToInflict;
        this.priceOrDemand = priceOrDemand;
    }
    public NPC(double percentDamageToInflict, int numItemsDemand) {
        r = new Random();
        this.percentDamageToInflict = percentDamageToInflict;
        this.numItemsDemand = numItemsDemand;
    }
    public void setIcon(BufferedImage icon) {
        this.icon = icon;
    }

    public BufferedImage getIcon() {
        return this.icon;
    }
    public void attackPlayer(Player player) {
        player.getShip().setHealth((int) (player.getShip().getHealth()
                * (1 - percentDamageToInflict)));
    }

    public void takeMoney(Player player) {
        player.setCredits(player.getCredits() - priceOrDemand);
    }

    public void takeAllMoney(Player player) {
        player.setCredits(0);
    }

    public boolean fightPlayer(Player player) {
        boolean playerWin = r.nextDouble() <= player.getFighterPoints() / (16.0);
        return playerWin;
    }

    public boolean fleePlayer(Player player) {
        boolean playerWin = r.nextDouble() <= player.getPilotPoints() / (16.0);
        return playerWin;
    }
}