package models.heroes;

import models.Hero;

public class Dwarf extends Hero {

    public Dwarf(String pseudo) {
        super(pseudo);
        getStats().setEndurance(getStats().getEndurance() + 2);
    }

    @Override
    public String toString() {
        return "Dwarf{" + super.toString() + "}";
    }
}