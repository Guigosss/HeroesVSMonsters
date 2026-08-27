package models;

import enums.Loot;

import java.util.EnumMap;
import java.util.Map;

public abstract class Hero extends Character {

    private final int level;
    private final Map<Loot, Integer> inventory;

    protected Hero(String pseudo) {
        super(pseudo);
        this.level = 1;
        this.inventory = new EnumMap<>(Loot.class);
    }

    public void pickUpLoot(Map<Loot, Integer> loot) {
        loot.forEach((l, quantity) ->
                inventory.merge(l, quantity, Integer::sum)
        );
    }

    public void rest() {
        getStats().setHitPoint(getStats().getHitPointMax());
    }

    public Map<Loot, Integer> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "pseudo=" + getPseudo() +
                ", level=" + level +
                ", inventory=" + inventory +
                ", stats=" + getStats() +
                '}';
    }
}