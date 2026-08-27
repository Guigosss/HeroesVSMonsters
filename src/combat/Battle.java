package combat;

import enums.Loot;
import models.Hero;
import models.Monster;

import java.util.List;
import java.util.Map;

public class Battle {

    private final Hero hero;
    private final List<Monster> monsters;

    public Battle(Hero hero, List<Monster> monsters) {
        this.hero = hero;
        this.monsters = monsters;
    }

    public void start(){
        System.out.println("===== DÉBUT DE L'AVENTURE =====");
        System.out.println(hero);

        for (Monster monster : monsters) {
            if (hero.isAlive()) {
                BattleResult result = fight(monster);
                displayBattleResult(result);

                if (hero.isAlive()) {
                    collectLoot(monster);
                    hero.rest();
                }
            }
        }
        end();
    }

    public BattleResult fight(Monster monster){
        System.out.println("\n===== COMBAT CONTRE " + monster.getPseudo() + " =====");
        int damagesDealt = 0;
        int damagesReceived = 0;
        while(hero.isAlive() && monster.isAlive()){
            int monsterHitPointBefore = monster.getStats().getHitPoint();
            hero.hit(monster);
            damagesDealt += monsterHitPointBefore - monster.getStats().getHitPoint();

            if (monster.isAlive()){
                int heroHitPointBefore = hero.getStats().getHitPoint();
                monster.hit(hero);
                damagesReceived += heroHitPointBefore - hero.getStats().getHitPoint();
            }
        }

        boolean victory = hero.isAlive();

        if(!monster.isAlive()){
            System.out.println(monster.getPseudo() + " est mort !");
        }

        return new BattleResult(victory, damagesDealt, damagesReceived);
    }

    private void displayBattleResult(BattleResult result){
        System.out.println("\n===== RÉSULTAT DU COMBAT =====");
        System.out.println("Victoire : " + (result.isVictory() ? "Oui" : "Non"));
        System.out.println("Dégâts infligés : " + result.getDamagesDealt());
        System.out.println("Dégâts reçus : " + result.getDamagesReceived());
        System.out.println("PV restants : " + hero.getStats().getHitPoint() + " / " + hero.getStats().getHitPointMax());
    }

    public  void collectLoot(Monster monster){
        Map<Loot, Integer> loot = monster.getLootRewarded();

        if (loot.isEmpty()) {
            System.out.println("Aucun butin à récupérer.");
            return;
        }

        System.out.println("\nButin récupéré :");
        loot.forEach((type, quantity) -> System.out.println("- " + type + " : " + quantity));
        hero.pickUpLoot(loot);
    }

    public void end(){
        System.out.println("\n===== FIN DE L'AVENTURE =====");

        if (hero.isAlive()) {
            System.out.println(hero.getPseudo() + " a vaincu tous les monstres !");
        }
        else {
            System.out.println(hero.getPseudo() + " est mort...");
        }

        System.out.println("\nÉtat final du héros :");
        System.out.println(hero);
    }

    private static class BattleResult {

        private final boolean victory;
        private final int damagesDealt;
        private final int damagesReceived;

        public BattleResult(boolean victory, int damagesDealt, int damagesReceived) {
            this.victory = victory;
            this.damagesDealt = damagesDealt;
            this.damagesReceived = damagesReceived;
        }

        public boolean isVictory() { return victory; }

        public int getDamagesDealt() { return damagesDealt; }

        public int getDamagesReceived() { return damagesReceived; }
    }
}
