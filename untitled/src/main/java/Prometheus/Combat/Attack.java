package Prometheus.Combat;

public class Attack {

    //params
    private String name;
    private int damage;

    //constructor
    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }


    //G&S
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }


    //methods

}
