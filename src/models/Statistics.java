package models;

import exceptions.InvalidDamageException;

import java.util.List;
import java.util.stream.IntStream;

import static utils.Utils.diceRolling;
import static utils.Utils.statModifier;

public class Statistics {

    private static final int NB_THROWS = 4;

    private int endurance;
    private int strength;
    private int hitPointMax;
    private int hitPoint;

    public Statistics() {
        this.endurance = drawStat();
        this.strength = drawStat();
        recalculateHitPoints();
    }

    private int drawStat() {
        List<Integer> results = IntStream.range(0, NB_THROWS)
                .mapToObj(i -> diceRolling(6))
                .toList();

        return results.stream()
                .sorted()
                .skip(1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void recalculateHitPoints() {
        this.hitPointMax = endurance + statModifier(endurance);
        this.hitPoint = hitPointMax;
    }

    public void takeDamages(int damages) {
        if (damages < 0) {
            throw new InvalidDamageException("Les dégâts ne peuvent pas être négatifs.");
        }

        hitPoint -= damages;

        if (hitPoint < 0) {
            hitPoint = 0;
        }
    }

    public int getEndurance() { return endurance; }

    public int getStrength() { return strength; }

    public int getHitPoint() { return hitPoint; }

    public int getHitPointMax() { return hitPointMax; }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
        recalculateHitPoints();
    }

    public void setStrength(int strength) { this.strength = strength; }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = Math.max(0, Math.min(hitPoint, hitPointMax));
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "endurance=" + endurance +
                ", strength=" + strength +
                ", hitPoint=" + hitPoint +
                ", hitPointMax=" + hitPointMax +
                '}';
    }
}