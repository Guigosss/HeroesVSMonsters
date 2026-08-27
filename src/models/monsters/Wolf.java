package models.monsters;

import enums.Loot;
import models.Monster;

import static utils.Utils.diceRolling;

public class Wolf extends Monster {

    public Wolf(String pseudo) {
        super(pseudo);
        generateLootRewarded();
    }

    @Override
    protected void generateLootRewarded() {
        getLootRewarded().put(Loot.LEATHER, diceRolling(4));
    }

    @Override
    public String toString() {
        return "Wolf{" + super.toString() + "}";
    }
}