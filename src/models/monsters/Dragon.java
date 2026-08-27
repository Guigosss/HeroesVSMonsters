package models.monsters;

import enums.Loot;
import models.Monster;

import static utils.Utils.diceRolling;

public class Dragon extends Monster {

    public Dragon(String pseudo) {
        super(pseudo);
        getStats().setEndurance(getStats().getEndurance() + 1);
        generateLootRewarded();
    }

    @Override
    protected void generateLootRewarded() {
        getLootRewarded().put(Loot.GOLD, diceRolling(6));
        getLootRewarded().put(Loot.LEATHER, diceRolling(4));
    }

    @Override
    public String toString() {
        return "Dragon{" + super.toString() + "}";
    }
}