package models;

import enums.Loot;

import java.util.EnumMap;
import java.util.Map;

public abstract class Monster extends Character {

    private final Map<Loot, Integer> lootRewarded;

    protected Monster(String pseudo) {
        super(pseudo);
        this.lootRewarded = new EnumMap<>(Loot.class);
    }

    public Map<Loot, Integer> getLootRewarded() {
        return lootRewarded;
    }

    protected abstract void generateLootRewarded();

    @Override
    public String toString() {
        return "Monster{" +
                "pseudo=" + getPseudo() +
                ", lootRewarded=" + lootRewarded +
                ", stats=" + getStats() +
                '}';
    }
}