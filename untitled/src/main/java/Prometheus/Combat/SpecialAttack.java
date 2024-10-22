package Prometheus.Combat;

public class SpecialAttack extends Attack{

    //params
    private boolean isDamageOverTime;
    private boolean isCharged;
    private boolean hasStun;
    private int effectDuration;

    //constructor
    public SpecialAttack(String name, int damage, boolean isDamageOverTime, boolean isCharged, boolean hasStun, int effectDuration) {
        super(name, damage);
        this.isDamageOverTime = isDamageOverTime;
        this.isCharged = isCharged;
        this.hasStun = hasStun;
        this.effectDuration = effectDuration;
    }



}
