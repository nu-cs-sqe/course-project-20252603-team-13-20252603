package model;

public class BattleResult {
    private int attackerLosses;
    private int defenderLosses;

    public BattleResult(int attackerLosses, int defenderLosses) {
        if (attackerLosses < 0 || defenderLosses < 0) {
            throw new IllegalArgumentException("Losses cannot be negative");
        }
        this.attackerLosses = attackerLosses;
        this.defenderLosses = defenderLosses;
    }

    public int getAttackerLosses() {
        return attackerLosses;
    }

    public int getDefenderLosses() {
        return defenderLosses;
    }
}
