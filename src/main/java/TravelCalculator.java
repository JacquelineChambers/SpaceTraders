package main.java;

/**
 * Kristen
 * V1.01
 */
public class TravelCalculator {

    private Player player;
    private Region prevRegion;
    public TravelCalculator(Player player) {
        this.player = player;
    }

    public boolean travelAbility(Region regToTravel) {

        if (player.getShip().getFuelAmount() >= fuelCost(regToTravel)) {
            player.getShip().travel(fuelCost(regToTravel));
            prevRegion = player.getCurrentRegion();
            player.setCurrentRegion(regToTravel);
            return true;
        } else {
            //error popup
            return false;
        }
    }

    public double fuelCost(Region regToTravel) {
        if (player.getPilotPoints() == 0) {
            return Double.MAX_VALUE;
        } else {
            int distance = player.getCurrentRegion().manhattanDistance(regToTravel);
            return Math.floor((distance / player.getPilotPoints()) / (player.getDifficulty() / 4));
        }
    }

    public Player getPlayer() {
        return this.player;
    }
    public Region getPrevRegion() {
        return this.prevRegion;
    }
}
