package main.java;

/**
 * Class randomizes frequency of NPC encounters as well as the interactions
 * within those encounters
 */
public class EncounterFrequency {
    private Player player;
    private double encounterFreq;
    private double encounterChance;
    private double npcChance;
    private NPC npc;
    private boolean appear = false;


    /**
     * The class takes in the player attributes and determines frequency
     * and interactions based on the difficulty and skill points
     */
    public EncounterFrequency() {
    }

    public void setPlayerEncFreq(Player player) {
        this.player = player;
        if (player.getDifficulty() == 16) {
            // if easy player has 30% chance of encounter
            // where 30% chance of bandit/police & 70% chance of trader
            this.encounterFreq = 0.3;
        }
        if (player.getDifficulty() == 12) {
            // if medium player has 50% chance of encounter
            // where 50% chance of bandit/police & 50% chance of trader
            this.encounterFreq = 0.5;
        }
        if (player.getDifficulty() == 8) {
            // if easy player has 70% chance of encounter
            // where 70% chance of bandit/police & 30% chance of trader
            this.encounterFreq = 0.70;
        }
    }
    /**@param encounterScreen
    * Randomizes encounter chance and proceeds
    * to specific NPC interaction if necessary
    */
    public void randEnc(EncounterScreen encounterScreen) {
        // randomizes chances between [0,1)
        encounterChance = Math.random();

        if (encounterChance < encounterFreq) {
            appear = true;
            npcChance = Math.random();
            if (player.getDifficulty() == 16) {
                randomizeEasyEnc();
            }
            if (player.getDifficulty() == 12) {
                randomizeMedEnc();
            }
            if (player.getDifficulty() == 8) {
                randomizeHardEnc();
            }
            encounterScreen.setNPC(npc);
        }
    }

    public void resetAppear() {
        appear = false;
    }

    private void randomizeEasyEnc() {
        if (npcChance < 0.15) {
            // bandit interaction 15% chance
            banditInteraction();
        } else if (npcChance > 0.15 && npcChance < 0.3) {
            // police iteraction 15% chance
            policeInteraction();
        } else {
            // trader interaction 70% chance
            traderInteraction();
        }
    }

    private void randomizeMedEnc() {
        if (npcChance < 0.25) {
            // bandit interaction 25% chance
            banditInteraction();
        } else if (npcChance > 0.25 && npcChance < 0.5) {
            // police iteraction 25% chance
            policeInteraction();
        } else {
            // trader interaction 50% chance
            traderInteraction();
        }
    }

    private void randomizeHardEnc() {
        if (npcChance < 0.35) {
            // bandit interaction 35% chance
            banditInteraction();
        } else if (npcChance > 0.35 && npcChance < 0.70) {
            // police iteraction 35% chance
            policeInteraction();
        } else {
            // trader interaction 30% chance
            traderInteraction();
        }
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////// NPC INTERACTIONS //////////////////////////////
    /////////////////////// TEMPORARY STRUCTURE! /////////////////////////////

    private void banditInteraction() {
        Bandit bandit = new Bandit(0.10, 100);
        this.npc = bandit;
    }

    private void policeInteraction() {
        if (player.getShip().getCargoList().size() > 0) {

            Police police = new Police(0.10, 0);
            this.npc = police;
        } else {
            Bandit bandit = new Bandit(0.10, 100);
            this.npc = bandit;
        }
    }

    private void traderInteraction() {
        Trader trader = new Trader(0.10, player.getCurrentRegion(), player);
        this.npc = trader;
    }

    public NPC getNPC() {
        return this.npc;
    }

    public boolean doesAppear() {
        return this.appear;
    }
}
