package main.java;
import java.util.HashSet;


//program driver to instantiate the player as well as the other screen
public class Driver {
    public static void main(String[] args) {
        Player player = new Player(); //instantiate player
        Universe universe = Universe.getInstance();
        Region startRegion = randomizeStartRegion(universe);
        Ship ships = new Ship();
        EncounterFrequency encounterFreq = new EncounterFrequency();
        player.setShip(ships.getStartShip());
        player.setCurrentRegion(startRegion);
        //player.setEncounterFreq(encounterFreq);
        ScreenContainer gameScreens = ScreenContainer.getInstance();
        gameScreens.initializeScreens(player, startRegion, encounterFreq);

        /*RegListScreen regListScreen = new RegListScreen(player);
        RegionScreen regionScreen = new RegionScreen(startRegion, regListScreen, player);
        CurrPlayerDispScreen playerDispScreen = new CurrPlayerDispScreen(player, regionScreen);
        ConfigScreen configScreen = new ConfigScreen(playerDispScreen, player);
        StartScreen starter = new StartScreen(configScreen);
        CargoDispScreen cargoDispScreen = new CargoDispScreen();*/
        gameScreens.getStartScreen().toggleVisibility(true);
    }

    public static void reset() {
        System.out.println("New game");
        Player player = new Player(); //instantiate player
        Universe universe = Universe.getInstance();
        Region startRegion = randomizeStartRegion(universe);
        Ship ships = new Ship();
        EncounterFrequency encounterFreq = new EncounterFrequency();
        player.setShip(ships.getStartShip());
        player.setCurrentRegion(startRegion);
        //player.setEncounterFreq(encounterFreq);
        ScreenContainer gameScreens = ScreenContainer.getInstance();
        gameScreens.initializeScreens(player, startRegion, encounterFreq);
        gameScreens.getStartScreen().toggleVisibility(true);
    }

    public static Region randomizeStartRegion(Universe universe) {
        HashSet<Region> regionSet = universe.getInstance().getSet();
        Region startRegion = null;

        // return first region in set
        // randomized each time since it's a hashset
        for (Region r: regionSet) {
            startRegion = r;
            break;
        }

        return startRegion;
    }
}