package main.java.attributes;

public class WeaponAttribute {
    private int damage = 1;
    private double attackSpeed = 1;
    private double dps = (damage * attackSpeed);

    // region Getters and setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getDps() {
        return dps;
    }

    public void setDps(double dps) {
        this.dps = dps;
    }
    // endregion
}
