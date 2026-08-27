package models;

import exceptions.InvalidCharacterException;
import interfaces.ICharacter;

import static utils.Utils.diceRolling;
import static utils.Utils.statModifier;

public abstract class Character implements ICharacter {

    private final String pseudo;
    private final Statistics stats;

    protected Character(String pseudo) {

        if (pseudo == null || pseudo.isBlank()) {
            throw new InvalidCharacterException("Le pseudo ne peut pas être vide.");
        }

        this.pseudo = pseudo;
        this.stats = new Statistics();
    }

    @Override
    public void hit(Character target) {
        int damages = calculateDamages();
        System.out.println(getPseudo() + " frappe " + target.getPseudo() + " et inflige " + damages + " dégâts.");
        target.takeDamages(damages);
    }

    protected int calculateDamages() {
        return diceRolling(4) + statModifier(stats.getStrength());
    }

    @Override
    public void takeDamages(int damages) {
        stats.takeDamages(damages);
    }

    @Override
    public boolean isAlive() {
        return stats.getHitPoint() > 0;
    }

    public String getPseudo() { return pseudo; }

    public Statistics getStats() { return stats; }
}