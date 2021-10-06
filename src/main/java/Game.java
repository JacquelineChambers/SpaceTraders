package main.java;

public class Game {

    /**
     * Starts the game by creating a universe,
     * regions, and at random- assign a skill
     * level and spawns the player.
     *
     * @return Universe The universe that the player will explore
     */
    private Universe startGame() {
        return Universe.getInstance();
    }


}
