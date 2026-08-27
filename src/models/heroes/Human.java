package models.heroes;

import models.Hero;

public class Human extends Hero {

    public Human(String pseudo) {
        super(pseudo);
        getStats().setStrength(getStats().getStrength() + 1);
        getStats().setEndurance(getStats().getEndurance() + 1);
    }

    @Override
    public String toString() {
        return "Human{" + super.toString() + "}";
    }
}