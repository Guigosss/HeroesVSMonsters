package models.monsters;

import enums.Loot;
import models.Monster;

import static utils.Utils.diceRolling;

public class Orc extends Monster {

    public Orc(String pseudo) {
        super(pseudo);
        getStats().setStrength(getStats().getStrength() + 1);
        generateLootRewarded();
    }

    @Override
    protected void generateLootRewarded() {
        getLootRewarded().put(Loot.GOLD, diceRolling(6));
    }

    @Override
    public String toString() {
        return "Orc{" + super.toString() + "}";
    }
}