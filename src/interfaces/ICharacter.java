package interfaces;

import models.Character;

public interface ICharacter {

    void hit(Character target);

    void takeDamages(int damages);

    boolean isAlive();
}