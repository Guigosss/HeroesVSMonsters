import combat.Battle;
import exceptions.InvalidCharacterException;
import models.Hero;
import models.Monster;
import models.heroes.Human;
import models.monsters.Dragon;
import models.monsters.Orc;
import models.monsters.Wolf;

import java.util.List;

public static void main(String[] args) {

    Hero hero = new Human("Aragorn");

    try {
        Hero heroFail = new Human("");
    } catch (InvalidCharacterException e) {
        System.out.println("Erreur : " + e.getMessage());
    }

    List<Monster> monsters = List.of(
            new Wolf("Loup"),
            new Orc("Orque"),
            new Dragon("Dragonnet")
    );

    Battle battle = new Battle(hero, monsters);

    battle.start();
}