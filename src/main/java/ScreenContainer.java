package main.java;
/**
 * Author: Kristen Brown
 * Container for screens
 */
public class ScreenContainer {

    private static final ScreenContainer SCREEN_CONTAINER =
            new ScreenContainer();

    private StartScreen startScreen;
    private ConfigScreen configScreen;
    private CurrPlayerDispScreen currPlayerDispScreen;
    private RegionScreen regionScreen;
    private RegListScreen regListScreen;
    private MapScreen mapScreen;
    private CargoDispScreen cargoDispScreen;
    private MarketDispScreen marketDispScreen;
    private EncounterScreen encounterScreen;
    private GameOverScreen gameOverScreen;
    private Region prevRegion;

    private ScreenContainer() { }

    public static ScreenContainer getInstance() {

        return SCREEN_CONTAINER;
    }

    public void initializeScreens(Player player, Region startRegion,
                                  EncounterFrequency encounterFreq) {
        startScreen = new StartScreen(player);
        configScreen = new ConfigScreen(player);
        currPlayerDispScreen = new CurrPlayerDispScreen(player);
        cargoDispScreen = new CargoDispScreen();
        regionScreen = new RegionScreen(player, startRegion, cargoDispScreen);
        regListScreen = new RegListScreen(player);
        mapScreen = new MapScreen(player);
        cargoDispScreen = new CargoDispScreen();
        encounterScreen = new EncounterScreen(player, encounterFreq);
        gameOverScreen = new GameOverScreen(player);
        setScreenOrder();
    }

    private void setScreenOrder() {
        startScreen.setNextScreen(configScreen);
        configScreen.setNextScreen(currPlayerDispScreen);
        currPlayerDispScreen.setNextScreen(regionScreen);
        regionScreen.setNextScreen(regListScreen);
        encounterScreen.setNextScreen(regionScreen, gameOverScreen, false);
        regListScreen.setNextScreen(encounterScreen, regionScreen,
                encounterScreen.getToggleEncounter());
        System.out.println("SETTING NEXT");
        gameOverScreen.setNextScreen(startScreen);
    }

    //Getters
    public StartScreen getStartScreen() {

        return startScreen;
    }

    public ConfigScreen getConfigScreen() {

        return configScreen;
    }
    public Region getPrevRegion() {
        return this.prevRegion;
    }

    public CurrPlayerDispScreen getCurrPlayerDispScreen() {
        return currPlayerDispScreen;
    }

    public RegionScreen getRegionScreen() {

        return regionScreen;
    }

    public RegListScreen getRegListScreen() {

        return regListScreen;
    }

    public GameOverScreen getGameOverScreen() {
        return gameOverScreen;
    }

    public MapScreen getMapScreen() {
        return mapScreen;
    }

    public CargoDispScreen getCargoDispScreen() {
        return cargoDispScreen;
    }

    public MarketDispScreen getMarketDispScreen() {
        return marketDispScreen;
    }

    public EncounterScreen getEncounterScreen() {
        return encounterScreen;
    }



    //Setters
    public void setStartScreen(StartScreen startScreen) {
        this.startScreen = startScreen;
    }

    public void setConfigScreen(ConfigScreen configScreen) {
        this.configScreen = configScreen;
    }

    public void setCurrPlayerDispScreen(CurrPlayerDispScreen currPlayerDispScreen) {
        this.currPlayerDispScreen = currPlayerDispScreen;
    }

    public void setRegionScreen(RegionScreen regionScreen, Region prevRegion) {
        this.prevRegion = prevRegion;
        this.regionScreen = regionScreen;
    }
    public void setRegionScreen(RegionScreen regionScreen) {
        this.regionScreen = regionScreen;
    }

    public void setRegListScreen(RegListScreen regListScreen) {
        this.regListScreen = regListScreen;
    }

    public void setMapScreen(MapScreen mapScreen) {
        this.mapScreen = mapScreen;
    }

    public void setCargoDispScreen(CargoDispScreen cargoDispScreen) {
        this.cargoDispScreen = cargoDispScreen;
    }

    public void setMarketDispScreen(MarketDispScreen marketDispScreen) {
        this.marketDispScreen = marketDispScreen;
    }

    public void setEncounterScreen(EncounterScreen encounterScreen, Region prevRegion) {
        this.prevRegion = prevRegion;
        this.encounterScreen = encounterScreen;
    }
}