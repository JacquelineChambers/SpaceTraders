package main.java;

public class Player {
    //player attributes
    private String name;
    private int difficulty;
    private double credits;
    private int karma = 0;
    private int pilotPoints;
    private int fighterPoints;
    private int merchantPoints;
    private int engineerPoints;
    private Region currentRegion;
    private Ship ship;
    private String regionOfSpecialItem;

    public Player() {
        setRandomRegion();
    }

    /**
     * Sets the name of the player
     *
     * @param name of player
     */
    //sets the player's name
    public void setName(String name) {
        this.name = name;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Sets the difficulty of the player
     *
     * @param difficulty of player
     */
    //gives the player a set amount of points to spend
    public void setDifficulty(int difficulty) {
        if (difficulty == 1) {
            this.difficulty = 16;
            setCredits(1000);
        }
        if (difficulty == 2) {
            this.difficulty = 12;
            setCredits(500);
        }
        if (difficulty == 3) {
            this.difficulty = 8;
            setCredits(100);
        }
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public int getKarma() {
        return this.karma;
    }

    /**
     * Accesses the name of the player
     *
     * @return Name of the player
     */
    //gets the player's name
    public String getName() {
        return this.name;
    }

    /**
     * Accesses the difficulty of the player
     *
     * @return difficulty of the player
     */
    //gets the amount of points available to be allocated to each of the 4 skills
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * accesses the points of the player
     *
     * @return points of the player
     */
    //obtains the amount of points the user can spend on skills through the difficulty setting
    public int getPoints() {
        return this.difficulty;
    }

    /**
     * sets the credits of the player
     *
     * @param credits of the player
     */
    //sets the amount of credits the player has
    public void setCredits(double credits) {
        this.credits = credits;
    }

    /**
     * accesses the credits of the player
     *
     * @return credits of the player
     */
    //gets the amount of credits the player has
    public double getCredits() {

        return Math.round(this.credits * 100.0) / 100.0;
    }

    /**
     * Sets the pilot points of the player
     *
     * @param points points of the player
     */
    //adds points to pilot skill
    public void setPilotPoints(int points) {
        if (pointsPullCheck(points)) {
            pilotPoints += points;
        }
    }

    /**
     * sets the flighter points of the player
     *
     * @param points points of the player
     */
    //adds points to fighter skill
    public void setFighterPoints(int points) {
        if (pointsPullCheck(points)) {
            fighterPoints += points;
        }
    }

    /**
     * sets the merchant points of the player
     *
     * @param points points of the player
     */
    //adds points to merchant skill
    public void setMerchantPoints(int points) {
        if (pointsPullCheck(points)) {
            merchantPoints += points;
        }
    }

    /**
     * set the engineer points of the player
     *
     * @param points points of the player
     */
    //adds points to engineer skill
    public void setEngineerPoints(int points) {
        if (pointsPullCheck(points)) {
            engineerPoints += points;
        }
    }

    /**
     * sets the current region of the the player
     * @param currentRegion current region of the player
     */
    public void setCurrentRegion(Region currentRegion) {

        this.currentRegion = currentRegion;
    }

    /**
     * Checks to see if the amount of points being added is valid
     *
     * @param points points of the player
     * @return If valid, will return true and false for otherwise
     */
    //checks if the amount of points added to a stat is valid
    public boolean pointsPullCheck(int points) {

        return !(points > getPoints() || points < 0);
    }

    /**
     * accesses the pilot points of the player
     *
     * @return pilot points of the player
     */
    //get point amounts from pilot, fighter, merchant, and engineer skills
    public int getPilotPoints() {

        return this.pilotPoints;
    }

    /**
     * accesses the fighter points of the player
     *
     * @return fighter points of the player
     */
    public int getFighterPoints() {

        return this.fighterPoints;
    }

    /**
     * accesses the merchant points of the player
     *
     * @return merchant points of the player
     */
    public int getMerchantPoints() {

        return this.merchantPoints;
    }

    /**
     * accesses the engineer points of the player
     *
     * @return engineer points of the player
     */
    public int getEngineerPoints() {

        return this.engineerPoints;
    }

    /**
     * accesses the current of the player
     *
     * @return current region of the player
     */
    public Region getCurrentRegion() {

        return currentRegion;
    }

    public Ship getShip() {
        return ship;
    }

    public void setRandomRegion() {
        int x = (int) (Math.random() * 9);
        if (x == 0) {
            this.regionOfSpecialItem = "Mirzam";
        }
        if (x == 1) {
            this.regionOfSpecialItem = "Hadir";
        }
        if (x == 2) {
            this.regionOfSpecialItem = "Cursa";
        }
        if (x == 3) {
            this.regionOfSpecialItem = "Mirzam";
        }
        if (x == 4) {
            this.regionOfSpecialItem = "Achernar";
        }
        if (x == 5) {
            this.regionOfSpecialItem = "Nunki";
        }
        if (x == 6) {
            this.regionOfSpecialItem = "Menkent";
        }
        if (x == 7) {
            this.regionOfSpecialItem = "Izar";

        }
        if (x == 8) {
            this.regionOfSpecialItem = "Alphekka";
        }
        if (x == 9) {
            this.regionOfSpecialItem = "Yildun";
        }

    }

    public String getRandomRegion() {
        return this.regionOfSpecialItem;
    }



}
